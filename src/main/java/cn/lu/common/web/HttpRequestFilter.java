package cn.lu.common.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.base.Strings;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 输出HTTP请求日志的过滤器
 *
 * @author lutiehua
 * @date 2017/03/13
 */
public class HttpRequestFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(HttpRequestFilter.class);

    private final static String SOURCE_IP = "X-Source-IP";

    private final static String TRACE_ID = "X-Trace_ID";

    private final static String CALL_SYSTEM_ID = "X-CallSystem_ID";

    private final static String PARAM_TRACE_ID = "traceID";

    private final static String PARAM_CALL_SYSTEM_ID = "callSystemID";

    private final Map<String, String> actuatorUriMap = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 配置不要输出这些请求的日志，这些都是用来监控的URI
        actuatorUriMap.put("/archaius", "/archaius");
        actuatorUriMap.put("/auditevents", "/auditevents");
        actuatorUriMap.put("/autoconfig", "/autoconfig");
        actuatorUriMap.put("/beans", "/beans");
        actuatorUriMap.put("/dump", "/dump");
        actuatorUriMap.put("/env", "/env");
        actuatorUriMap.put("/features", "/features");
        actuatorUriMap.put("/flyway", "/flyway");
        actuatorUriMap.put("/health", "/health");
        actuatorUriMap.put("/heapdump", "/heapdump");
        actuatorUriMap.put("/hystrix.stream", "/hystrix.stream");
        actuatorUriMap.put("/info", "/info");
        actuatorUriMap.put("/jolokia", "/jolokia");
        actuatorUriMap.put("/logfile", "/logfile");
        actuatorUriMap.put("/liquibase", "/liquibase");
        actuatorUriMap.put("/loggers", "/loggers");
        actuatorUriMap.put("/mappings", "/mappings");
        actuatorUriMap.put("/metrics", "/metrics");
        actuatorUriMap.put("/pause", "/pause");
        actuatorUriMap.put("/refresh", "/refresh");
        actuatorUriMap.put("/restart", "/restart");
        actuatorUriMap.put("/resume", "/resume");
        actuatorUriMap.put("/service-registry/instance-status", "/service-registry/instance-status");
        actuatorUriMap.put("/trace", "/trace");
    }

    /**
     * 输出HTTP请求的访问日志
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            String uri = request.getRequestURI();

            // 如果是监控访问的，不用输出日志
            if (actuatorUriMap.containsKey(uri)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }

            // 复制请求（用于输出POST的参数，否则这里读取了，内部将读取不到参数）
            ServletRequest requestWrapper = new HttpRequestReaderWrapper(request);

            // 来源IP地址
            String ip = request.getHeader(SOURCE_IP);
            if(null == ip){
                ip = request.getRemoteAddr();
            }

            // 获取请求参数
            Map<String, Object> paramMap = getParam(requestWrapper);
            String method = request.getMethod();

            // 解析callSystemID
            String callSystemID = request.getHeader(CALL_SYSTEM_ID);
            if(Strings.isNullOrEmpty(callSystemID)){
                // 从参数中读取
                Object objCallSystemID = paramMap.get(PARAM_CALL_SYSTEM_ID);

                // 判断callSystemID为空的情况
                if (null != objCallSystemID) {
                    callSystemID = objCallSystemID.toString();
                }

                // 默认"0000"
                if (Strings.isNullOrEmpty(callSystemID)) {
                    callSystemID = "0000";
                }
            }

            // 解析traceID
            String traceID = request.getHeader(TRACE_ID);
            if(Strings.isNullOrEmpty(traceID)){
                // 从参数中读取
                Object objTraceID = paramMap.get(PARAM_TRACE_ID);

                // 判断traceID为空的情况
                if (null != objTraceID) {
                    traceID = objTraceID.toString();
                }

                // 默认"none"
                if (Strings.isNullOrEmpty(callSystemID)) {
                    traceID = "none";
                }
            }

            // 执行前输出参数
            logger.info("sourceIP=[{}], callSystemID=[{}], traceID=[{}], uri=[{}], method=[{}], param=[{}]",
                    ip, callSystemID, traceID, uri, method, paramMap);
            ThreadContext.put("callSystemID", callSystemID);
            ThreadContext.put("traceID", traceID);
            long startTime = System.currentTimeMillis();
            filterChain.doFilter(requestWrapper, servletResponse);
            long finishTime = System.currentTimeMillis();
            long time = finishTime - startTime;

            // 执行后输出处理时间
            logger.info("traceID=[{}], uri=[{}], method=[{}], time=[{}ms]", traceID, uri, method, time);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    /**
     * 读取参数
     *
     * @param request
     * @return
     */
    private Map<String, Object> getParam(ServletRequest request) {
        // 参数Map
        Map<String, Object> paramMap = new HashMap(16);

        // 解析URI地址中的参数
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    paramMap.put(paramName, paramValue);
                }
            }
        }

        // 解析Body中的参数
        String requestBody = HttpHelper.getBodyString(request);
        if (Strings.isNullOrEmpty(requestBody)) {
            return paramMap;
        }

        // 要求Body都必须是JSON格式
        Map<String, Object> bodyParamMap = JSON.parseObject(requestBody, new TypeReference<Map<String, Object>>() {});
        paramMap.putAll(bodyParamMap);
        return paramMap;
    }

    @Override
    public void destroy() {
    }

}
package cn.lu.cup;

import cn.lu.common.doc.Swagger2MarkupConverter;
import cn.lu.generator.core.SpringProjectGenerator;
import cn.lu.generator.dto.GeneratorParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * Demo project for Spring Cloud
 *
 * @author waterlu
 * @date 2018-04-03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SimUpApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void contextLoads() {

    }

    /**
     * 自动生成接口文档
     *
     * @throws Exception
     */
    @Test
    public void generateDocTest() throws Exception {
        String outputDir = "doc/";
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        response.setCharacterEncoding("UTF-8");
        String swaggerJson = response.getContentAsString();
        Files.createDirectories(Paths.get(outputDir));
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputDir, "swagger.json"))) {
            writer.write(swaggerJson);
        }
        Swagger2MarkupConverter converter = new Swagger2MarkupConverter(Paths.get(outputDir, "swagger.json"));
        converter.toFile(Paths.get(outputDir));
    }

    /**
     * 重新生成代码
     *
     * @throws Exception
     */
    @Test
    public void generateCode() throws Exception {
        SpringProjectGenerator projectGenerator = new SpringProjectGenerator();
        FileReader fileReader = new FileReader("src/main/resources/generator-config.json");
        JSONReader jsonReader = new JSONReader(fileReader);
        String jsonString = jsonReader.readString();
        GeneratorParam generatorParam = JSON.parseObject(jsonString, GeneratorParam.class);
        projectGenerator.generateCode(generatorParam);
    }
}
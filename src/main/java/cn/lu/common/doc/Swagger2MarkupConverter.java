package cn.lu.common.doc;

import cn.lu.common.doc.model.DataModel;
import io.swagger.models.Model;
import io.swagger.models.Swagger;
import io.swagger.models.properties.Property;
import io.swagger.parser.SwaggerParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author xiaody
 * @description
 * @date create in 17/11/15
 */
@Slf4j
public class Swagger2MarkupConverter {


    private Swagger swagger;


    public Swagger2MarkupConverter(Path swaggerPath) {
        this.swagger = readSwagger(swaggerPath);
    }


    private Swagger readSwagger(Path swaggerPath) {
        Validate.notNull(swaggerPath, "swaggerPath must not be null");
        if (Files.notExists(swaggerPath)) {
            throw new IllegalArgumentException(String.format("swaggerPath does not exist: %s", swaggerPath));
        }
        try {
            if (Files.isHidden(swaggerPath)) {
                throw new IllegalArgumentException("swaggerPath must not be a hidden file");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to check if swaggerPath is a hidden file", e);
        }

        log.info("begin to parse swagger.json");
        Swagger swagger = new SwaggerParser().read(swaggerPath.toString());
        if (swagger == null) {
            throw new IllegalArgumentException("Failed to read the Swagger source");
        }
        return swagger;
    }


    public void toFile(Path outputPath) throws Exception {
        Validate.notNull(outputPath, "outputPath must not be null");
        GeneratedDocFile generatedDocFile = new GeneratedDocFile(outputPath.toString());
        generatedDocFile.generateFile(swagger.getPaths(), buildSwaggerDefinitions(swagger));
        log.info("generate doc file finished!");
    }

    private Map<String, List<DataModel>> buildSwaggerDefinitions(Swagger swagger) {
        log.info("begin to build swagger definitions");
        Map<String, Model> definitions = swagger.getDefinitions();
        Map<String, List<DataModel>> definitionResult = new HashMap<>();
        List<DataModel> dataModelList;
        DataModel dataModel;
        if (definitions != null) {
            for (Map.Entry<String, Model> definition : definitions.entrySet()) {
                dataModelList = new ArrayList<>();
                Map<String, Property> properties = definition.getValue().getProperties();
                if (properties != null) {
                    for (Map.Entry<String, Property> property : properties.entrySet()) {
                        dataModel = new DataModel(property.getKey(), property.getValue().getRequired(),
                                property.getValue().getType(), property.getValue().getDescription());
                        dataModelList.add(dataModel);
                    }
                    definitionResult.put(definition.getKey(), dataModelList);
                    log.info("load definitions:{}", definition.getKey());
                }
            }
        }
        return definitionResult;
    }

}

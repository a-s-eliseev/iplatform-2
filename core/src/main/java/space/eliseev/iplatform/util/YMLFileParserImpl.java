package space.eliseev.iplatform.util;

import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.*;

@Component
public class YMLFileParserImpl implements FileParser {

    @Override
    public List<String> parse(String file) {
        Map<String, List<String>> map = new HashMap<>();
        try (InputStream input = new FileInputStream(file);) {
            Yaml yaml = new Yaml();
            map = yaml.load(input);
            return map.get("non-financial-data");
        } catch(java.io.IOException e ) {
            throw new RuntimeException(e);
        }
    }
}
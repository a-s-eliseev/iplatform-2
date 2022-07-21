package space.eliseev.iplatform.util;

import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Component
public class ApiInfoYMLFileParserImpl implements FileParser {
    public List<String> parse(String file) {
        try (InputStream input = new FileInputStream(file)) {
            Yaml yaml = new Yaml();
            Map<String, List<String>> map = yaml.load(input);
            return map.get("urls");
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
}
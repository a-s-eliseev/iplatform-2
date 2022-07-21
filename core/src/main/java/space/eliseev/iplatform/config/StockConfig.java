package space.eliseev.iplatform.config;

import org.springframework.context.annotation.Configuration;

import java.util.List;
import org.yaml.snakeyaml.Yaml;
import space.eliseev.iplatform.util.YMLFileParserImpl;

@Configuration
public class StockConfig {
    private List<String> urls;
    Yaml yaml = new Yaml();
    public List<String> getApiList() {
        List<String> strings = new YMLFileParserImpl().parse("D:\\IPlatform\\core\\src\\main\\resources\\api-info.yaml");
        System.out.println(strings);
        return strings;
    }
}
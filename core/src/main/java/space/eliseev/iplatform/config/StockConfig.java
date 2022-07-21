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
        List<String> strings = new YMLFileParserImpl().parse("src/main/resourses/api_info.yml");
        System.out.println(strings);
        return strings;
    }
}
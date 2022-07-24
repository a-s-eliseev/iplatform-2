package space.eliseev.iplatform.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "config")
@Getter
@Setter
@PropertySource(value = "file:D:/IPlatform/core/src/main/resources/api-info.yml")
public class StockConfig {
    private List<String> urls;
}



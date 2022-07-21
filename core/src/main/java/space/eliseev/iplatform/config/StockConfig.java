package space.eliseev.iplatform.config;

import space.eliseev.iplatform.util.ApiInfoYMLFileParserImpl;

import java.util.List;

public class StockConfig {
    public static final List<String> urls =
            new ApiInfoYMLFileParserImpl().parse("D:\\IPlatform\\core\\src\\main\\resources\\api-info.yaml");

    private StockConfig() {
    }
}
package space.eliseev.iplatform.service.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import space.eliseev.iplatform.service.FileFormatException;

import java.io.IOException;

@Component
@Slf4j
public class JsonFileParser implements FileParser {
    @Override
    public Object parse(byte[] file) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readTree(file);
        } catch (IOException e) {
            log.error("Error while parsing json-file");
            throw new FileFormatException("Error while parsing json-file");
        }
    }
}

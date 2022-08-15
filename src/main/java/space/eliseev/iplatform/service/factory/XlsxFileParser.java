package space.eliseev.iplatform.service.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import space.eliseev.iplatform.error.FileNotUploadException;

import java.io.IOException;

@Component
@Slf4j
public class XlsxFileParser implements FileParser {
    @Override
    public Object parse(byte[] file) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.reader();
    }
}

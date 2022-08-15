package space.eliseev.iplatform.service.factory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import space.eliseev.iplatform.service.FileType;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

@Slf4j
@Component
@RequiredArgsConstructor
public class FileParserFactory {

    private final XlsxFileParser xlsxFileParser;
    private final Map<FileType, Supplier<FileParser>> map = new EnumMap<>(FileType.class);

    private Object parse(String type, byte[] file) {
        type = type.toUpperCase();

        try {
            FileType fileType = FileType.valueOf(type);
            return map.get(fileType).get().parse(file);
        } catch (IllegalArgumentException e) {
            log.error("Parse not found for " + type);
            throw e;
        }
    }
}

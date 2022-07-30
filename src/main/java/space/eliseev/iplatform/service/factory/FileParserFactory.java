package space.eliseev.iplatform.service.factory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

@Slf4j
@RequiredArgsConstructor
@Component
public class FileParserFactory {
    private final JsonFileParser jsonFileparser;
    private final Map<FileType, Supplier<FileParser>> map = new EnumMap<>(FileType.class);

    public Object parse(String type, byte[] file) {
        type = type.toUpperCase();
        try {
            FileType fileType = FileType.valueOf(type);
            return map.get(fileType).get().parse(file);
        } catch (IllegalArgumentException e) {
            log.error("Parser not found for" + type);
            throw e;
        }
    }

    @PostConstruct
    public void init() {
        map.put(FileType.JSON, () -> jsonFileparser);
    }

    private enum FileType {
        XLS,
        XLSX,
        CSV,
        JSON
    }
}

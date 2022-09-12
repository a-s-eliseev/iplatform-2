package space.eliseev.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class BusinessMessage extends AbstractMessage {

    private final long messageGuid;
    private final Map<Long, Object> payload = new LinkedHashMap<>();
}

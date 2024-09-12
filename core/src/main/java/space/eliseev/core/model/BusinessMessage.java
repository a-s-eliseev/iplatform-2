package space.eliseev.core.model;

import lombok.*;

import java.util.LinkedHashMap;
import java.util.Map;


@Data
public class BusinessMessage extends AbstractMessage {

    /**
     * Identification of the message
     */
    private final long messageGuide;
    /**
     * The body of a message
     */
    private final Map<Long, Object> payload = new LinkedHashMap<>();
}

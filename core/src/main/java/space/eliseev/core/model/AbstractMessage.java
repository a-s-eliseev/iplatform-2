package space.eliseev.core.model;

import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;


@Data
public abstract class AbstractMessage {
    /**
     * Date, time and place where the message was created
     */
    private ZonedDateTime created;
    /**
     * Universally unique identifier for the message
     */
    private UUID uuid;

}

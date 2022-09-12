package space.eliseev.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public abstract class AbstractMessage {

    private ZonedDateTime created;
    private UUID uuid;

}

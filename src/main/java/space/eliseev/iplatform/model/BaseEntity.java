package space.eliseev.iplatform.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/*
сущность для передачи сырых данных
 */
@Getter
@Setter
@ToString
@Document(collection = "base_entities")
public class BaseEntity {

    @Id
    private String id;
    private Long creationTime;
    private Object data;
    private String producerAPI;
}

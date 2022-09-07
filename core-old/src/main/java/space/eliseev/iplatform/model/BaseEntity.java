package space.eliseev.iplatform.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public BaseEntity(Long creationTime, Object data, String producerAPI) {
        this.creationTime = creationTime;
        this.data = data;
        this.producerAPI = producerAPI;
    }
}

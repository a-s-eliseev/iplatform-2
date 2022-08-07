package space.eliseev.iplatform.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

@FeignClient(name = "baseEntityClient", url = "https://")
public interface BaseEntityClient {
    @GetMapping(produces = "application/json; charset=UTF-8")
    ResponseEntity<String> getBaseEntityByUrl(URI baseUrl);
}

package space.eliseev.iplatform.clients;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final TestClient testClient;

    @GetMapping(value = "/all")
    public List<String> getAll() {
        return testClient.printTestResults();
    }
}

package space.eliseev.iplatform.controller;

import liquibase.repackaged.org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import space.eliseev.iplatform.entity.BaseEntity;

@RestController
@RequestMapping("/forms")
public class PrintFormController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public BaseEntity show(@PathVariable Long id) {
        BaseEntity baseEntity = new BaseEntity();

        baseEntity.getId();
        baseEntity.getData();
        baseEntity.getCreationTime();
        baseEntity.getProducerAPI();
        return baseEntity;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BaseEntity create(@RequestBody BaseEntity baseEntity, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Test");
        }
        if (StringUtils.isEmpty(baseEntity.getProducerAPI())) {
            System.out.println("API");
        }
        baseEntity.setId("1");
        return baseEntity;
    }
}

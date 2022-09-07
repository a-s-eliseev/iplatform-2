package space.eliseev.iplatform.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.eliseev.iplatform.model.BaseEntity;
import space.eliseev.iplatform.service.DataService;
import space.eliseev.iplatform.service.BaseEntityService;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(produces = "application/json; charset=UTF-8")
public class BaseEntityController {

    private final DataService dataService;
    private final BaseEntityService baseEntityService;

    @GetMapping("/getFinancial")
    public ResponseEntity<Void> getFinancial() {
        dataService.getFinancialData();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getNonFinancial")
    public ResponseEntity<Void> getNonFinancial() {
        dataService.getNonFinancialData();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/manual/entities/{id}")
    public ResponseEntity<BaseEntity> getData(@PathVariable String id) {
        Optional<BaseEntity> entity = baseEntityService.getDataByStockConfigId(id);
        return entity
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}

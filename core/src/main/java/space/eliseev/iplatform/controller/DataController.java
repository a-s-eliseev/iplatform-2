package space.eliseev.iplatform.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.eliseev.iplatform.model.BaseEntity;
import space.eliseev.iplatform.service.DataService;
import space.eliseev.iplatform.service.ManualDataLoadService;

@RequiredArgsConstructor
@RestController
@RequestMapping(produces = "application/json; charset=UTF-8")
public class DataController {

    private final DataService dataService;
    private final ManualDataLoadService manualDataLoadService;

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

    @GetMapping(value = "/manual/get/{id}")
    public ResponseEntity<BaseEntity> getData(@PathVariable String id) {
        return new ResponseEntity<>(manualDataLoadService.getDataByStockConfigId(Integer.valueOf(id))
                .orElse(null), HttpStatus.OK);
    }
}

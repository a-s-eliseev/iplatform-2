package space.eliseev.iplatform.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.eliseev.iplatform.exception.ProducerApiNotFoundException;
import space.eliseev.iplatform.model.BaseEntity;
import space.eliseev.iplatform.service.DataService;
import space.eliseev.iplatform.service.BaseEntityService;

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

    @GetMapping(value = "/manual/get/{id}")
    public ResponseEntity<BaseEntity> getData(@PathVariable String id) throws JsonProcessingException {
        return new ResponseEntity<>(baseEntityService.getDataByStockConfigId(Integer.valueOf(id))
                .orElse(null), HttpStatus.OK);
    }

    @ExceptionHandler({ProducerApiNotFoundException.class, JsonProcessingException.class})
    public ResponseEntity<Object> getException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

package space.eliseev.iplatform.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.eliseev.iplatform.service.DataService;

@RequiredArgsConstructor
@RestController
@RequestMapping(produces = "application/json; charset=UTF-8")
public class DataController {

    private final DataService dataService;

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
}

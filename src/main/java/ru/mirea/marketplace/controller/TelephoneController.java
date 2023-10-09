package ru.mirea.marketplace.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mirea.marketplace.DTO.Telephone;
import ru.mirea.marketplace.service.TelephoneService;

import java.util.List;

@RestController
@RequestMapping("/api/telephone")
public class TelephoneController {

    private final TelephoneService telephoneService;

    public TelephoneController(TelephoneService telephoneService) {
        this.telephoneService = telephoneService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Telephone> getOne(@PathVariable Integer id) {
        Telephone telephone = telephoneService.getOne(id);
        if (telephone == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(telephone);
    }

    @GetMapping()
    public ResponseEntity<List<Telephone>> getAll() {
        List<Telephone> telephones = telephoneService.getAll();
        return ResponseEntity.ok(telephones);
    }


    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody Telephone telephone) {
        telephoneService.create(telephone);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Telephone telephone) {
        if(telephoneService.update(id, telephone)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        telephoneService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.lab07.internetprovider.controllers;


import com.lab07.internetprovider.services.KlientService;
import com.lab07.internetprovider.tables.Klient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/klienci")
public class KlientController {

    private final KlientService klientService;

    public KlientController(KlientService klientService) {
        this.klientService = klientService;
    }

    @GetMapping
    public ResponseEntity<List<Klient>> getAllKlienci() {
        List<Klient> klienci = klientService.getAllKlienci();
        return ResponseEntity.ok(klienci);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Klient> getKlientById(@PathVariable Long id) {
        Klient klient = klientService.getKlientById(id);
        return ResponseEntity.ok(klient);
    }

    @PostMapping
    public ResponseEntity<Klient> createKlient(@RequestBody Klient klient) {
        Klient createdKlient = klientService.createKlient(klient);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdKlient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Klient> updateKlient(@PathVariable Long id, @RequestBody Klient klient) {
        Klient updatedKlient = klientService.updateKlient(id, klient);
        return ResponseEntity.ok(updatedKlient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKlient(@PathVariable Long id) {
        klientService.deleteKlientById(id);
        return ResponseEntity.noContent().build();
    }
}

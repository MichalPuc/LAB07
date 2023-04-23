package com.lab07.internetprovider.services;


import com.lab07.internetprovider.repositories.KlientRepository;
import com.lab07.internetprovider.tables.Klient;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KlientService {
    @Autowired
    private final KlientRepository klientRepository;

    public KlientService(KlientRepository klientRepository) {
        this.klientRepository = klientRepository;
    }

    public List<Klient> getAllKlienci() {
        return klientRepository.findAll();
    }

    public Klient getKlientById(Long id) {
        Optional<Klient> optionalKlient = klientRepository.findById(id);
        if (optionalKlient.isEmpty()) {
            throw new EntityNotFoundException("Klient with id " + id + " not found");
        }
        return optionalKlient.get();
    }

    public Klient createKlient(Klient klient) {
        return klientRepository.save(klient);
    }

    public Klient updateKlient(Long id, Klient klient) {
        Klient existingKlient = getKlientById(id);
        existingKlient.setImie(klient.getImie());
        existingKlient.setNazwisko(klient.getNazwisko());
        existingKlient.setNumerKlienta(klient.getNumerKlienta());
        return klientRepository.save(existingKlient);
    }

    public void deleteKlientById(Long id) {
        if (klientRepository.existsById(id)) {
            klientRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Klient with id " + id + " not found");
        }
    }

}

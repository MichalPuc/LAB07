package com.lab07.internetprovider.repositories;

import com.lab07.internetprovider.tables.Klient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface KlientRepository extends JpaRepository<Klient, Long> {
    // meatoda pozwalająca na pobranie wszystkich klientów z bazy danych
    List<Klient> findAll();

    // metoda pozwalająca na znalezienie klienta o określonym numerze klienta
    Optional<Klient> findByNumerKlienta(Long numerKlienta);

    // metoda pozwalająca na zapisanie klienta do bazy danych
    Klient save(Klient klient);

    // metoda pozwalająca na usunięcie klienta o określonym numerze klienta z bazy danych
    void deleteByNumerKlienta(Long numerKlienta);
}

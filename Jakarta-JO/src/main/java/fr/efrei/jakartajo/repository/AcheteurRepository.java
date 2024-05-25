package fr.efrei.jakartajo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.efrei.jakartajo.model.Acheteur;

@Repository
public interface AcheteurRepository extends JpaRepository<Acheteur, String> {
    List<Acheteur> findAllByDeletedAtNull();

    Optional<Acheteur> findOneByUuid(String uuid);

    Acheteur save(Acheteur acheteur);

    void deleteByUuid(String uuid);
}

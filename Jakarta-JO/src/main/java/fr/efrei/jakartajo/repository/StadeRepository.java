package fr.efrei.jakartajo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.efrei.jakartajo.model.Stade;

@Repository
public interface StadeRepository extends JpaRepository<Stade, String> {

    List<Stade> findAllByDeletedAtNull();

    Optional<Stade> findOneByUuid(String uuid);

    Stade save(Stade stade);

    void deleteByUuid(String uuid);
}
package fr.efrei.jakartajo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.jakartajo.dto.CreateEpreuve;
import fr.efrei.jakartajo.dto.UpdateEpreuve;
import fr.efrei.jakartajo.model.Epreuve;
import fr.efrei.jakartajo.repository.EpreuveRepository;
import jakarta.transaction.Transactional;

@Service
public class EpreuveService {
    private final EpreuveRepository repository;

    @Autowired
    public EpreuveService(EpreuveRepository repository) {
        this.repository = repository;
    }

    public List<Epreuve> findAllEpreuves() {
        return repository.findAllByDeletedAtNull();
    }

    public Epreuve findEpreuveById(String uuid) {
        return repository.findOneByUuid(uuid).orElse(null);
    }

    public Epreuve create(CreateEpreuve epreuve) {
        Epreuve epreuveACreer = new Epreuve(
                epreuve.getName(),
                epreuve.getDateEpreuve());
        return repository.save(epreuveACreer);
    }

    @Transactional
    public boolean delete(String uuid) {
        Epreuve epreuveASupprimer = findEpreuveById(uuid);
        if (epreuveASupprimer != null && epreuveASupprimer.getDeletedAt() == null) {
            epreuveASupprimer.setDeletedAt(LocalDateTime.now());
            repository.save(epreuveASupprimer);
            return true;
        }
        return false;
    }

    public boolean update(String uuid, UpdateEpreuve epreuve) {
        Epreuve epreuveAModifier = findEpreuveById(uuid);

        if (epreuveAModifier != null) {
            epreuveAModifier.setDateEpreuve(epreuve.getDateEpreuve());
            epreuveAModifier.setName(epreuve.getName());
            repository.save(epreuveAModifier);
            return true;
        }
        return false;
    }

    public boolean updatePartielle(String uuid, UpdateEpreuve epreuve) {
        Epreuve epreuveAModifier = findEpreuveById(uuid);

        if (epreuveAModifier != null) {
            if (epreuve.getDateEpreuve() != null) {
                epreuveAModifier.setDateEpreuve(epreuve.getDateEpreuve());
            }
            if (!epreuve.getName().isEmpty()) {
                epreuveAModifier.setName(epreuve.getName());
            }
            repository.save(epreuveAModifier);
            return true;
        }
        return false;
    }
}

package fr.efrei.jakartajo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.jakartajo.dto.CreateStade;
import fr.efrei.jakartajo.dto.UpdateStade;
import fr.efrei.jakartajo.model.Stade;
import fr.efrei.jakartajo.repository.StadeRepository;
import jakarta.transaction.Transactional;

@Service
public class StadeService {
    private final StadeRepository repository;

    @Autowired
    public StadeService(StadeRepository repository) {
        this.repository = repository;
    }

    public List<Stade> findAllStades() {
        return repository.findAllByDeletedAtNull();
    }

    public Stade findStadeById(String uuid) {
        return repository.findOneByUuid(uuid).orElse(null);
    }

    public Stade create(CreateStade stade) {
        Stade stadeACreer = new Stade(
                stade.getName(),
                stade.getAdresse());
        return repository.save(stadeACreer);
    }

    @Transactional
    public boolean delete(String uuid) {
        Stade stadeASupprimer = findStadeById(uuid);
        if (stadeASupprimer != null && stadeASupprimer.getDeletedAt() == null) {
            stadeASupprimer.setDeletedAt(LocalDateTime.now());
            repository.save(stadeASupprimer);
            return true;
        }
        return false;
    }

    public boolean update(String uuid, UpdateStade stade) {
        Stade stadeAModifier = findStadeById(uuid);

        if (stadeAModifier != null) {
            stadeAModifier.setName(stade.getName());
            stadeAModifier.setAdresse(stade.getAdresse());
            repository.save(stadeAModifier);
            return true;
        }
        return false;
    }

    public boolean updatePartielle(String uuid, UpdateStade stade) {
        Stade stadeAModifier = findStadeById(uuid);

        if (stadeAModifier != null) {
            if (!stade.getName().isEmpty()) {
                stadeAModifier.setName(stade.getName());
            }
            if (!stade.getAdresse().isEmpty()) {
                stadeAModifier.setAdresse(stade.getAdresse());
            }
            repository.save(stadeAModifier);
            return true;
        }
        return false;
    }


}

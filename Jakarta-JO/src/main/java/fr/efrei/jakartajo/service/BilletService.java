package fr.efrei.jakartajo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.jakartajo.dto.CreateBillet;
import fr.efrei.jakartajo.dto.UpdateBillet;
import fr.efrei.jakartajo.model.Billet;
import fr.efrei.jakartajo.repository.BilletRepository;
import jakarta.transaction.Transactional;

@Service
public class BilletService {
    private final BilletRepository repository;

    @Autowired
    public BilletService(BilletRepository repository) {
        this.repository = repository;
    }

    public List<Billet> findAllBillets() {
        return repository.findAllByDeletedAtNull();
    }

    public Billet findBilletById(String uuid) {
        return repository.findOneByUuid(uuid).orElse(null);
    }

    public Billet create(CreateBillet billet) {
        Billet billetACreer = new Billet(
                billet.getName(),
                billet.getPrice());
        return repository.save(billetACreer);
    }

    @Transactional
    public boolean delete(String uuid) {
        Billet billetASupprimer = findBilletById(uuid);
        if (billetASupprimer != null && billetASupprimer.getDeletedAt() == null) {
            billetASupprimer.setDeletedAt(LocalDateTime.now());
            repository.save(billetASupprimer);
            return true;
        }
        return false;
    }

    public boolean update(String uuid, UpdateBillet billet) {
        Billet billetAModifier = findBilletById(uuid);

        if (billetAModifier != null) {
            billetAModifier.setName(billet.getName());
            billetAModifier.setPrice(billet.getPrice());
            repository.save(billetAModifier);
            return true;
        }
        return false;
    }

    public boolean updatePartielle(String uuid, UpdateBillet billet) {
        Billet billetAModifier = findBilletById(uuid);

        if (billetAModifier != null) {
            if (!billet.getName().isEmpty()) {
                billetAModifier.setName(billet.getName());
            }
            if (billet.getPrice() != null) {
                billetAModifier.setPrice(billet.getPrice());
            }
            repository.save(billetAModifier);
            return true;
        }
        return false;
    }

}

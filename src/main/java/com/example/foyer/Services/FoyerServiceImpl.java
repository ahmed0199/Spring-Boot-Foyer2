package com.example.foyer.Services;

import com.example.foyer.Entities.Foyer;
import com.example.foyer.Repositories.FoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerServiceImpl implements IFoyerService {

    @Autowired
    private FoyerRepository foyerRepository;

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyer(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        // La méthode save() gère la mise à jour si l'ID existe.
        return foyerRepository.save(foyer);
    }

    @Override
    public List<Foyer> allFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer getFoyerById(Long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }
}
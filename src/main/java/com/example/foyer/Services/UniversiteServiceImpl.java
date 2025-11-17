package com.example.foyer.Services;

import com.example.foyer.Entities.Universite;
import com.example.foyer.Repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteServiceImpl implements IUniversiteService {

    @Autowired
    private UniversiteRepository universiteRepository;

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void deleteUniversite(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> allUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getUniversiteById(Long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }
}
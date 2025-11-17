package com.example.foyer.Services;

import com.example.foyer.Entities.Etudiant;
import com.example.foyer.Repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImp implements IEtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        // La méthode save() gère la mise à jour si l'ID existe.
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> allEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }
}
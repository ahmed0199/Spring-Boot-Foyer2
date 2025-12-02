package com.example.foyer.Services;

import com.example.foyer.Entities.Foyer;
import com.example.foyer.Entities.Universite;
import com.example.foyer.Repositories.FoyerRepository;
import com.example.foyer.Repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UniversiteServiceImpl implements IUniversiteService {

    @Autowired
    private UniversiteRepository universiteRepository;

    @Autowired
    private FoyerRepository foyerRepository;

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

    @Override
    @Transactional
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer non trouvé avec l'ID: " + idFoyer));

        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        if (universite == null) {
            throw new RuntimeException("Université non trouvée ");
        }

        // Correction 1 : Vérifier l'affectation via le champ 'foyer' au singulier
        if (universite.getFoyer() != null) {
            throw new RuntimeException("Cette université a déjà un foyer affecté");
        }

        // Vérification supplémentaire pour éviter le double mapping
        if (foyer.getUniversite() != null) {
            throw new RuntimeException("Ce foyer est déjà affecté à une autre université");
        }

        // Affecter les deux côtés de la relation
        universite.setFoyer(foyer);
        foyer.setUniversite(universite);

        // Sauvegarder (la transaction gère les deux entités)
        foyerRepository.save(foyer);
        universiteRepository.save(universite);

        return universite;
    }
    @Override
    @Transactional
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Université non trouvée "));

        // Correction 1 : Récupérer le Foyer directement via le champ 'foyer'
        Foyer foyerAssocie = universite.getFoyer();

        if (foyerAssocie == null) {
            throw new RuntimeException("Cette université n'a pas de foyer affecté");
        }

        // Désaffecter les deux côtés
        universite.setFoyer(null); // Retirer la référence de l'université
        foyerAssocie.setUniversite(null); // Retirer la référence du foyer

        // Sauvegarder les changements
        foyerRepository.save(foyerAssocie);
        universiteRepository.save(universite);

        return universite;
    }

}
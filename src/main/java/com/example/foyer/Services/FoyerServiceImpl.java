package com.example.foyer.Services;

import com.example.foyer.Entities.Bloc;
import com.example.foyer.Entities.Foyer;
import com.example.foyer.Entities.Universite;
import com.example.foyer.Repositories.BlocRepository;
import com.example.foyer.Repositories.FoyerRepository;
import com.example.foyer.Repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FoyerServiceImpl implements IFoyerService {

    @Autowired
    private FoyerRepository foyerRepository;

    @Autowired
    private UniversiteRepository universiteRepository;

    @Autowired
    private BlocRepository blocRepository;

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

    @Override
    @Transactional
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Université non trouvée"));

        // **Correction 1 : Utiliser getFoyer() au lieu de getFoyers()**
        // On vérifie si l'attribut OneToOne (qui est de type Foyer) est déjà renseigné.
        if (universite.getFoyer() != null) {
            throw new RuntimeException("Cette université a déjà un foyer affecté");
        }

        // Vérification pour s'assurer que le Foyer n'est pas déjà affecté ailleurs
        if (foyer.getUniversite() != null) {
            throw new RuntimeException("Ce foyer est déjà affecté à une autre université");
        }

        // Affecter les deux côtés de la relation bidirectionnelle
        foyer.setUniversite(universite);
        universite.setFoyer(foyer); // Mise à jour du côté non-propriétaire

        // Sauvegarder le Foyer (côté propriétaire de la clé étrangère)
        Foyer foyerSauvegarde = foyerRepository.save(foyer);

        // Sauvegarder l'Université pour persister la référence bidirectionnelle
        // (même si le cascade pourrait le gérer, c'est plus clair)
        universiteRepository.save(universite);


        if (foyer.getBlocs() != null && !foyer.getBlocs().isEmpty()) {
            for (Bloc bloc : foyer.getBlocs()) {
                bloc.setFoyer(foyerSauvegarde);
                // Si la relation Bloc/Foyer est bidirectionnelle,
                // assurez-vous de mettre à jour le côté Bloc si nécessaire.
                blocRepository.save(bloc);
            }
        }

        return foyerSauvegarde;
    }
}
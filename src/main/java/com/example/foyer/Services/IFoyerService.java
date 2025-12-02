package com.example.foyer.Services;


import com.example.foyer.Entities.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer addFoyer(Foyer foyer);
    void deleteFoyer (Long idFoyer);
    Foyer updateFoyer (Foyer foyer);
    List<Foyer> allFoyers();
    Foyer getFoyerById(Long idFoyer);
    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);
}
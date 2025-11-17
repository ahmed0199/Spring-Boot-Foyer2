package com.example.foyer.Services;


import com.example.foyer.Entities.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addUniversite(Universite universite);
    void deleteUniversite (Long idUniversite);
    Universite updateUniversite (Universite universite);
    List<Universite> allUniversites();
    Universite getUniversiteById(Long idUniversite);
}
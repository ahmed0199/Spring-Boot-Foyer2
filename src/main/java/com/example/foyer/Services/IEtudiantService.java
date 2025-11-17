package com.example.foyer.Services;


import com.example.foyer.Entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant etudiant);
    void deleteEtudiant (Long idEtudiant);
    Etudiant updateEtudiant (Etudiant etudiant);
    List<Etudiant> allEtudiants();
    Etudiant getEtudiantById(Long idEtudiant);
}
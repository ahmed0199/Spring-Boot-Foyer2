package com.example.foyer.Controller;

import com.example.foyer.Entities.Etudiant;
import com.example.foyer.Services.IEtudiantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Etudiant")
@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    private IEtudiantService etudiantService;

    @PostMapping("/ajout")
    public Etudiant ajout(@RequestBody Etudiant etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }

    @Operation(description = "Récupérer tous les étudiants de la base de données")
    @GetMapping("/afficherTout")
    public List<Etudiant> afficherTout() {
        return etudiantService.allEtudiants();
    }

    @GetMapping("/{idEtudiant}")
    public Etudiant getEtudiantById(@PathVariable Long idEtudiant) {
        return etudiantService.getEtudiantById(idEtudiant);
    }

    @PutMapping("/modifier")
    public Etudiant modifier(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    @DeleteMapping("/supprimer/{idEtudiant}")
    public void supprimer(@PathVariable Long idEtudiant) {
        etudiantService.deleteEtudiant(idEtudiant);
    }
}
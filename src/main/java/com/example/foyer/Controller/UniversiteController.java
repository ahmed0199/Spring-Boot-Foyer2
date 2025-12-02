package com.example.foyer.Controller;

import com.example.foyer.Entities.Universite;
import com.example.foyer.Services.IUniversiteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Universite")
@RestController
@RequestMapping("/universite")
public class UniversiteController {

    @Autowired
    private IUniversiteService universiteService;

    @PostMapping("/ajout")
    public Universite ajout(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }

    @Operation(description = "Récupérer toutes les universités de la base de données")
    @GetMapping("/afficherTout")
    public List<Universite> afficherTout() {
        return universiteService.allUniversites();
    }

    @GetMapping("/{idUniversite}")
    public Universite getUniversiteById(@PathVariable Long idUniversite) {
        return universiteService.getUniversiteById(idUniversite);
    }

    @PutMapping("/modifier")
    public Universite modifier(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }

    @DeleteMapping("/supprimer/{idUniversite}")
    public void supprimer(@PathVariable Long idUniversite) {
        universiteService.deleteUniversite(idUniversite);
    }

    @PutMapping("/affecter-foyer/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(
            @PathVariable long idFoyer,
            @PathVariable String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }
    @Operation(description = "Désaffecter le foyer d'une université")
    @PutMapping("/desaffecter-foyer/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable long idUniversite) {
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }
}
package com.example.foyer.Controller;

import com.example.foyer.Entities.Foyer;
import com.example.foyer.Services.IFoyerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Foyer")
@RestController
@RequestMapping("/foyer")
public class FoyerController {

    @Autowired
    private IFoyerService foyerService;

    @PostMapping("/ajout")
    public Foyer ajout(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @Operation(description = "Récupérer tous les foyers de la base de données")
    @GetMapping("/afficherTout")
    public List<Foyer> afficherTout() {
        return foyerService.allFoyers();
    }

    @GetMapping("/{idFoyer}")
    public Foyer getFoyerById(@PathVariable Long idFoyer) {
        return foyerService.getFoyerById(idFoyer);
    }

    @PutMapping("/modifier")
    public Foyer modifier(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }

    @DeleteMapping("/supprimer/{idFoyer}")
    public void supprimer(@PathVariable Long idFoyer) {
        foyerService.deleteFoyer(idFoyer);
    }
}
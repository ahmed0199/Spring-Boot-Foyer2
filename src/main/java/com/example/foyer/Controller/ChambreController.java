package com.example.foyer.Controller;

import com.example.foyer.Entities.Chambre;
import com.example.foyer.Services.IChambreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Gestion Chambre")
@RestController
@RequestMapping("/chambre")
public class ChambreController {

    @Autowired
    private IChambreService chambreService;

    @PostMapping("/ajout")
    public Chambre ajout(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }


    @Operation(description = "récupérer toutes les chambres de la base de données")
    @GetMapping("/afficherTout")
    public List<Chambre> afficherTout() {
        return chambreService.allChambres();
    }


    @GetMapping("/{idChambre}")
    public Chambre getChambreById(@PathVariable Long idChambre) {
        return chambreService.getChambreById(idChambre);
    }

    @PutMapping("/modifier")
    public Chambre modifier(@RequestBody Chambre chambre) {
        // l id fel body (JSON)
        return chambreService.updateChambre(chambre);
    }




    @DeleteMapping("/supprimer/{idChambre}")
    public void supprimer(@PathVariable Long idChambre) {
        chambreService.deleteChambre(idChambre);
    }
}
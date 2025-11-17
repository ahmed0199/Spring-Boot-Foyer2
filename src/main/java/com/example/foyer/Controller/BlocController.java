package com.example.foyer.Controller;

import com.example.foyer.Entities.Bloc;
import com.example.foyer.Services.IBlocService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Bloc")
@RestController
@RequestMapping("/bloc")
public class BlocController {

    @Autowired
    private IBlocService blocService;

    @PostMapping("/ajout")
    public Bloc ajout(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @Operation(description = "récupérer tous les blocs de la base de données")
    @GetMapping("/afficherTout")
    public List<Bloc> afficherTout() {
        return blocService.allBlocs();
    }

    @GetMapping("/{idBloc}")
    public Bloc getBlocById(@PathVariable Long idBloc) {
        return blocService.getBlocById(idBloc);
    }

    @PutMapping("/modifier")
    public Bloc modifier(@RequestBody Bloc bloc) {
        // l id fel body (JSON)
        return blocService.updateBloc(bloc);
    }

    @DeleteMapping("/supprimer/{idBloc}")
    public void supprimer(@PathVariable Long idBloc) {
        blocService.deleteBloc(idBloc);
    }
}
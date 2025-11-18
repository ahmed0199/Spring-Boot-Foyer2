package com.example.foyer.Controller;

import com.example.foyer.DTO.ProjetDTO;
import com.example.foyer.Services.ProjetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Gestion DTO Auto")
@RestController
@RequestMapping("/api/projets")
@AllArgsConstructor
public class ProjetController {

    private final ProjetService projetService;

    @GetMapping("/{id}")
    public ProjetDTO getProjetById(@PathVariable long id) {
        return projetService.getProjet(id);
    }
    @PostMapping
    public ProjetDTO addProjet(@RequestBody ProjetDTO projetDTO) {
        return projetService.addProjet(projetDTO);
    }
}
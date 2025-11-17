package com.example.foyer.Controller;

import com.example.foyer.DTO.ProjetDetailDTO;
import com.example.foyer.Services.DTOService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Gestion DTO")
@RestController
@RequestMapping("/DTO")
public class ProjetDetailController {

    @Autowired
    private DTOService dtoService; // ✅ injection automatique

    @GetMapping("/{id}/details")
    public ProjetDetailDTO getDetails(@PathVariable Long id) {
        return dtoService.getDetailsProjet(id);
    }
}

package com.example.foyer.Controller;

import com.example.foyer.DTO.ProjetDetailDTO;
import com.example.foyer.Services.DTOService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Gestion DTO")
@RestController
@RequestMapping("/DTO")
@RequiredArgsConstructor
@Tag(name = "Gestion DTO")
public class ProjetDetailController {

    private final DTOService dtoService;

    @GetMapping("/{id}/details")
    public ProjetDetailDTO getDetails(@PathVariable Long id) {
        return dtoService.getDetailsProjet(id);
    }
}

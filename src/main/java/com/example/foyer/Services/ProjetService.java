package com.example.foyer.Services;

import com.example.foyer.DTO.ProjetDTO;
import com.example.foyer.Entities.Projet;
import com.example.foyer.Mappers.ProjetMapper;
import com.example.foyer.Repositories.ProjetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjetService {

    private final ProjetRepository projetRepository;
    private final ProjetMapper mapper;

    public ProjetDTO getProjet(long id) {
        Projet projet = projetRepository.findById(id).orElseThrow(() -> new RuntimeException("Projet non trouvé"));
        return mapper.toDto(projet); // Conversion en 1 ligne
    }

    public ProjetDTO addProjet(ProjetDTO projetDTO) {
        // Conversion DTO -> Entité
        Projet projet = mapper.toEntity(projetDTO);

        // Sauvegarde en base
        Projet savedProjet = projetRepository.save(projet);

        // Conversion Entité -> DTO pour la réponse
        return mapper.toDto(savedProjet);
    }
}
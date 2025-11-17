package com.example.foyer.Services;

import com.example.foyer.DTO.ProjetDetailDTO;
import com.example.foyer.Entities.ProjetDetail;
import com.example.foyer.Repositories.ProjetDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class DTOService {

    @Autowired
    private ProjetDetailRepository projetDetailRepository; // ✅ injection automatique

    public ProjetDetailDTO getDetailsProjet(Long id) {
        ProjetDetail detail = projetDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Détails du projet non trouvés"));

        return convertToDto(detail);
    }

    private ProjetDetailDTO convertToDto(ProjetDetail detail) {
        ProjetDetailDTO dto = new ProjetDetailDTO();
        dto.setDescription(detail.getDescription());
        dto.setTechnologie(detail.getTechnologie());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dto.setDateDebut(detail.getDateDebut().format(formatter));

        return dto;
    }
}

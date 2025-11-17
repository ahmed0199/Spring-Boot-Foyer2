package com.example.foyer.Mappers;

import com.example.foyer.DTO.ProjetDTO;
import com.example.foyer.Entities.Projet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjetMapper {

    @Mapping(target = "libelleProjet", source = "nom") // Renommage
    ProjetDTO toDto(Projet projet);
    // MapStruct génère automatiquement l'implementation !
}
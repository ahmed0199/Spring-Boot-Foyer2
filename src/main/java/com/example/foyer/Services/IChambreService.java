package com.example.foyer.Services;


import com.example.foyer.Entities.Chambre;

import java.util.List;

public interface IChambreService {
    Chambre addChambre(Chambre chambre);
    void deleteChambre (Long idChambre);
    Chambre updateChambre (Chambre chambre);
    List<Chambre> allChambres();
    Chambre getChambreById(Long idChambre);

}

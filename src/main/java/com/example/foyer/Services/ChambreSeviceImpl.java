package com.example.foyer.Services;

import com.example.foyer.Entities.Chambre;
import com.example.foyer.Repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreSeviceImpl implements IChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> allChambres() {
        return chambreRepository.findAll();
    }
    @Override
    public Chambre getChambreById(Long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }



   }
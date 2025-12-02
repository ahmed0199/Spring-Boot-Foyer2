package com.example.foyer.Services;

import com.example.foyer.Entities.Bloc;
import com.example.foyer.Entities.Chambre;
import com.example.foyer.Repositories.BlocRepository;
import com.example.foyer.Repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlocServiceImpl implements IBlocService {

    @Autowired
    private BlocRepository blocRepository;

    @Autowired
    private ChambreRepository chambreRepository; // Ajout de cette ligne

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> allBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc getBlocById(Long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    @Transactional
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {

        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc non trouvé "));


        List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambre);

        if (chambres.isEmpty()) {
            throw new RuntimeException("Aucune chambre trouvée avec les numéros: " + numChambre);
        }

        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
            chambreRepository.save(chambre);
        }

        bloc.getChambres().addAll(chambres);

        return blocRepository.save(bloc);
    }
}
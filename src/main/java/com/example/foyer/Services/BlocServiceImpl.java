package com.example.foyer.Services;

import com.example.foyer.Entities.Bloc;
import com.example.foyer.Repositories.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocServiceImpl implements IBlocService {

    @Autowired
    private BlocRepository blocRepository;

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
        // La méthode save() gère à la fois l'ajout (si l'ID est nul)
        // et la mise à jour (si l'ID existe déjà).
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> allBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc getBlocById(Long idBloc) {
        // findById retourne un Optional, .orElse(null) renvoie null si non trouvé.
        // Vous pourriez préférer .orElseThrow() pour gérer les erreurs.
        return blocRepository.findById(idBloc).orElse(null);
    }
}
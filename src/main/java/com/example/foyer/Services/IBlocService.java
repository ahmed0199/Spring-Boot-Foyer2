package com.example.foyer.Services;


import com.example.foyer.Entities.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc addBloc(Bloc bloc);
    void deleteBloc (Long idBloc);
    Bloc updateBloc (Bloc bloc);
    List<Bloc> allBlocs();
    Bloc getBlocById(Long idBloc);
    Bloc affecterChambresABloc(List<Long> numChambre, long idBloc);

}
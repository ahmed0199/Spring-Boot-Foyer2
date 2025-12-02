package com.example.foyer.Repositories;

import com.example.foyer.Entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    List<Chambre> findByNumeroChambreIn(List<Long> numeroChambres);

}
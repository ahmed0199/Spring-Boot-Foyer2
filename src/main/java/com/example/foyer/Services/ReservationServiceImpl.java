package com.example.foyer.Services;

import com.example.foyer.Entities.Reservation;
import com.example.foyer.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    // Ajoutez ici les autres repositories nécessaires (ChambreRepository) si vous utilisez la méthode d'affectation
    // @Autowired
    // private ChambreRepository chambreRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> allReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    // Placeholder pour la logique métier complexe (à implémenter)
    @Override
    public Reservation ajouterReservationEtAffecterAChambre(Long idChambre, Reservation reservation) {

        return null; // À implémenter
    }

}
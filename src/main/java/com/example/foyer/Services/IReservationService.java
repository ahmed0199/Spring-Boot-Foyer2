package com.example.foyer.Services;


import com.example.foyer.Entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addReservation(Reservation reservation);
    void deleteReservation (Long idReservation);
    Reservation updateReservation (Reservation reservation);
    List<Reservation> allReservations();
    Reservation getReservationById(Long idReservation);

    Reservation ajouterReservationEtAffecterAChambre(Long idChambre, Reservation reservation);
}
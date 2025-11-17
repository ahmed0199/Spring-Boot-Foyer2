package com.example.foyer.Controller;

import com.example.foyer.Entities.Reservation;
import com.example.foyer.Services.IReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Reservation")
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    // Ajout simple (nécessite que l'ID de la chambre et l'ID des étudiants soient inclus dans le body)
    @PostMapping("/ajout")
    public Reservation ajout(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @Operation(description = "Récupérer toutes les réservations de la base de données")
    @GetMapping("/afficherTout")
    public List<Reservation> afficherTout() {
        return reservationService.allReservations();
    }

    @GetMapping("/{idReservation}")
    public Reservation getReservationById(@PathVariable Long idReservation) {
        return reservationService.getReservationById(idReservation);
    }

    @PutMapping("/modifier")
    public Reservation modifier(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/supprimer/{idReservation}")
    public void supprimer(@PathVariable Long idReservation) {
        reservationService.deleteReservation(idReservation);
    }

    // Endpoint pour la logique métier (plus clair pour l'affectation)
    /*
    @PostMapping("/affecterChambre/{idChambre}")
    public Reservation affecterChambre(@PathVariable Long idChambre, @RequestBody Reservation reservation) {
        return reservationService.ajouterReservationEtAffecterAChambre(idChambre, reservation);
    }
    */
}
package com.example.foyer.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Reservation {
    @Id
    private long idReservation;

    private LocalDate anneeUniversitaire;

    private boolean estValide;

    @ManyToOne
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;

    @ManyToMany(mappedBy = "reservations")
    @JsonBackReference // <-- LA CORRECTION CLÉ
    private List<Etudiant> etudiants;


}


package com.example.foyer.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    private String nomEt;
    private String prenomEt;
    private Long cin;
    private String ecole;

    private LocalDate dateNaissance;

    @ManyToMany
    @JsonManagedReference // <-- Côté "Parent" : La liste sera sérialisée
    @JoinTable(
            name = "etudiant_reservation",
            joinColumns = @JoinColumn(name = "etudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "reservation_id")
    )
    private List<Reservation> reservations;
}
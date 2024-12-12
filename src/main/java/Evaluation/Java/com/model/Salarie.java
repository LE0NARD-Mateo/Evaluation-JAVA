package Evaluation.Java.com.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Salarie {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        String id;

        @Column(length = 10, nullable = false)
        @Size(min = 3, max = 10, message = "Le matricule doit contenir entre 3 et 10 caractères.")
        private String matricule;

        @Column(nullable = false)
        private String codeBarre;
}

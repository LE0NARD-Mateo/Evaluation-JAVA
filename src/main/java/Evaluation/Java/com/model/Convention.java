package Evaluation.Java.com.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
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
public class Convention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String nom;

    @Column(nullable = false)
    @PositiveOrZero(message = "La subvention ne peut pas être négative.")
    Float subvention;

    @Column(nullable = false)
    @Min(1)
    Integer salarie_Maximum;

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    Entreprise conventionParEntreprise;

    @OneToMany(mappedBy = "salarieParConvention")
    List<Salarie> salaries;
}

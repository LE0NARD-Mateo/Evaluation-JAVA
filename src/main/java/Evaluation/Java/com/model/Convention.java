package Evaluation.Java.com.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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
    private String nom;

    @Column(nullable = false)
    @PositiveOrZero(message = "La subvention ne peut pas être négative.")
    private float subvention;

    @Column(nullable = false)
    @Min(1)
    private int salarie_Maximum;

}

package Evaluation.Java.com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    public @Min(1) Integer getSalarie_Maximum() {
        return salarie_Maximum;
    }

    public void setSalarie_Maximum(@Min(1) Integer salarie_Maximum) {
        this.salarie_Maximum = salarie_Maximum;
    }

    public @PositiveOrZero(message = "La subvention ne peut pas être négative.") Float getSubvention() {
        return subvention;
    }

    public void setSubvention(@PositiveOrZero(message = "La subvention ne peut pas être négative.") Float subvention) {
        this.subvention = subvention;
    }
    @Column(nullable = false)
    @Min(1)
    Integer salarie_Maximum;

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    Entreprise conventionParEntreprise;

    @JsonIgnore
    @OneToMany(mappedBy = "salarieParConvention")
    List<Salarie> salaries;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Entreprise getConventionParEntreprise() {
        return conventionParEntreprise;
    }

    public void setConventionParEntreprise(Entreprise conventionParEntreprise) {
        this.conventionParEntreprise = conventionParEntreprise;
    }

    public List<Salarie> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salarie> salaries) {
        this.salaries = salaries;
    }

}

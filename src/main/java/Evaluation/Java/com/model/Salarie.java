package Evaluation.Java.com.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Salarie {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;

        @Column(length = 10, nullable = false)
        @Size(min = 3, max = 10, message = "Le matricule doit contenir entre 3 et 10 caractères.")
        private String matricule;

        @Column(nullable = false)
        private String codeBarre;

        @ManyToOne
        @JoinColumn(name = "convention_id")
        Convention salarieParConvention;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public @Size(min = 3, max = 10, message = "Le matricule doit contenir entre 3 et 10 caractères.") String getMatricule() {
                return matricule;
        }

        public void setMatricule(@Size(min = 3, max = 10, message = "Le matricule doit contenir entre 3 et 10 caractères.") String matricule) {
                this.matricule = matricule;
        }

        public String getCodeBarre() {
                return codeBarre;
        }

        public void setCodeBarre(String codeBarre) {
                this.codeBarre = codeBarre;
        }

        public Convention getSalarieParConvention() {
                return salarieParConvention;
        }

        public void setSalarieParConvention(Convention salarieParConvention) {
                this.salarieParConvention = salarieParConvention;
        }
}

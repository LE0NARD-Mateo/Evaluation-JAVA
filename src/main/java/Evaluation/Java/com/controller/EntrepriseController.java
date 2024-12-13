package Evaluation.Java.com.controller;

import Evaluation.Java.com.dao.EntrepriseDao;
import Evaluation.Java.com.model.Entreprise;
import Evaluation.Java.com.security.IsAdministateur;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class EntrepriseController {

    @Autowired
    private EntrepriseDao entrepriseDao;

    @GetMapping("/entreprise")
    public List<Entreprise> getAll() {

        return entrepriseDao.findAll();

    }

    @IsAdministateur
    @GetMapping("/entreprise/{id}")
    public ResponseEntity<Entreprise> get(@PathVariable Integer id) {

        //On vérifie que l'Entreprise existe bien dans la base de donnée
        Optional<Entreprise> optionalEntreprise = entrepriseDao.findById(id);

        //si l'Entreprise n'existe pas
        if(optionalEntreprise.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

       return new ResponseEntity<>(optionalEntreprise.get(), HttpStatus.OK);
    }

    @IsAdministateur
    @PostMapping("/entreprise")
    public ResponseEntity<Entreprise> create(@Valid @RequestBody Entreprise entreprise) {

        //on force l'id à null au cas où le client en aurait fourni un
        entreprise.setId(null);
        entrepriseDao.save(entreprise);

        return new ResponseEntity<>(entreprise, HttpStatus.CREATED);
    }

    @IsAdministateur
    @PutMapping("/entreprise/{id}")
    public ResponseEntity<Entreprise> update(@Valid @RequestBody Entreprise entreprise, @PathVariable Integer id) {

        //on force le changement de l'id de l'convention à enregitrer à l'id passé en paramètre
        entreprise.setId(id);

        //On vérifie que l'Entreprise existe bien dans la base de donnée
        Optional<Entreprise> optionalEntreprise = entrepriseDao.findById(id);

        //si l'convention n'existe pas
        if(optionalEntreprise.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        entrepriseDao.save(entreprise);

        return new ResponseEntity<>(entreprise, HttpStatus.OK);
    }

    @IsAdministateur
    @DeleteMapping("/entreprise/{id}")
    public ResponseEntity<Entreprise> delete(@PathVariable Integer id) {

        //On vérifie que l'convention existe bien dans la base de donnée
        Optional<Entreprise> optionalConvention = entrepriseDao.findById(id);

        //si l'convention n'existe pas
        if(optionalConvention.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        entrepriseDao.deleteById(id);

        return new ResponseEntity<>(optionalConvention.get(), HttpStatus.OK);

    }

}

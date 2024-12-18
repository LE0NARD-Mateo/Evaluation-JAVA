package Evaluation.Java.com.controller;

import Evaluation.Java.com.dao.ConventionDao;
import Evaluation.Java.com.dao.SalarieDao;
import Evaluation.Java.com.model.Convention;
import Evaluation.Java.com.model.Salarie;
import Evaluation.Java.com.security.IsEntreprise;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class SalarieController {

    @Autowired
    private SalarieDao salarieDao;

    @Autowired
    private ConventionDao conventionDao;

    @GetMapping("/salarie")
    public List<Salarie> getAll() {

        return salarieDao.findAll();

    }

    @GetMapping("/salarie/{id}")
    public ResponseEntity<Salarie> get(@PathVariable Integer id) {

        //On vérifie que l'salarieexiste bien dans la base de donnée
        Optional<Salarie> optionalSalarie = salarieDao.findById(id);

        //si l'salarien'existe pas
        if(optionalSalarie.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

       return new ResponseEntity<>(optionalSalarie.get(), HttpStatus.OK);
    }

    @IsEntreprise
    @PostMapping("/salarie")
    public ResponseEntity<Salarie> create(@Valid @RequestBody Salarie salarie) {
        Convention convention = salarie.getSalarieParConvention();
        Optional<Convention> optionalConvention = conventionDao.findById(convention.getId());

        if (optionalConvention.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        int currentCount = salarieDao.countSalariesByConventionId(convention.getId());
        if (currentCount >= convention.getSalarie_Maximum()) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        salarie.setId(null);
        salarieDao.save(salarie);

        return new ResponseEntity<>(salarie, HttpStatus.CREATED);
    }

    @IsEntreprise
    @PutMapping("/salarie/{id}")
    public ResponseEntity<Salarie> update(@Valid @RequestBody Salarie salarie, @PathVariable Integer id) {

        //on force le changement de l'id de l'salarieà enregitrer à l'id passé en paramètre
        salarie.setId(id);

        //On vérifie que l'salarieexiste bien dans la base de donnée
        Optional<Salarie> optionalSalarie = salarieDao.findById(id);

        //si l'salarien'existe pas
        if(optionalSalarie.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        salarieDao.save(salarie);

        return new ResponseEntity<>(salarie, HttpStatus.OK);
    }

    @IsEntreprise
    @DeleteMapping("/salarie/{id}")
    public ResponseEntity<Salarie> delete(@PathVariable Integer id) {

        //On vérifie que l'salarieexiste bien dans la base de donnée
        Optional<Salarie> optionalSalarie = salarieDao.findById(id);

        //si l'salarien'existe pas
        if(optionalSalarie.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        salarieDao.deleteById(id);

        return new ResponseEntity<>(optionalSalarie.get(), HttpStatus.OK);

    }

}

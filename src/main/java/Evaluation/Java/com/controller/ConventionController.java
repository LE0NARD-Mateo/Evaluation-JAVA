package Evaluation.Java.com.controller;

import Evaluation.Java.com.dao.ConventionDao;
import Evaluation.Java.com.model.Convention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ConventionController {

    @Autowired
    private ConventionDao conventionDao;

    @GetMapping("/convention")
    public List<Convention> getAll() {

        return conventionDao.findAll();

    }

    @GetMapping("/convention/{id}")
    public ResponseEntity<Convention> get(@PathVariable Integer id) {

        //On vérifie que l'convention existe bien dans la base de donnée
        Optional<Convention> optionalConvention = conventionDao.findById(id);

        //si l'convention n'existe pas
        if(optionalConvention.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

       return new ResponseEntity<>(optionalConvention.get(), HttpStatus.OK);
    }

    @PostMapping("/convention")
    public ResponseEntity<Convention> create(@RequestBody Convention convention) {

        //on force l'id à null au cas où le client en aurait fourni un
        convention.setId(null);
        conventionDao.save(convention);

        return new ResponseEntity<>(convention, HttpStatus.CREATED);
    }

    @PutMapping("/convention/{id}")
    public ResponseEntity<Convention> update(@RequestBody Convention convention, @PathVariable Integer id) {

        //on force le changement de l'id de l'convention à enregitrer à l'id passé en paramètre
        convention.setId(id);

        //On vérifie que l'convention existe bien dans la base de donnée
        Optional<Convention> optionalConvention = conventionDao.findById(id);

        //si l'convention n'existe pas
        if(optionalConvention.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        conventionDao.save(convention);

        return new ResponseEntity<>(convention, HttpStatus.OK);
    }

    @DeleteMapping("/convention/{id}")
    public ResponseEntity<Convention> delete(@PathVariable Integer id) {

        //On vérifie que l'convention existe bien dans la base de donnée
        Optional<Convention> optionalConvention = conventionDao.findById(id);

        //si l'convention n'existe pas
        if(optionalConvention.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        conventionDao.deleteById(id);

        return new ResponseEntity<>(optionalConvention.get(), HttpStatus.OK);

    }

}

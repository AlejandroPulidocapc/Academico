package co.edu.interlemd.academico.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.entidades.Estudiante;
import co.edu.repositorio.EstudianteRepositorio;

@RestController
public class EstudianteController {

    private EstudianteRepositorio repositorio= new EstudianteRepositorio();

    @GetMapping("api/estudiante/prueba")
    public String prueba(@RequestParam(value = "name", defaultValue = "World") String name) {

        Estudiante estudianteNuevo = new Estudiante(0 ,"Cristian", "Pulido", 18);
        repositorio.crear(estudianteNuevo);

        return String.format("Hello %s!", name);
    }

    @GetMapping(path = "api/estudiantes", produces = "application/json")
    public List<Estudiante> getTodos() {
        return repositorio.leerTodos();

    }

    @PostMapping(path = "/api/estudiantes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estudiante> create(@RequestBody Estudiante newEstudiante) {
        Estudiante estudianteNuevo = newEstudiante;
        repositorio.crear(estudianteNuevo);

        if (estudianteNuevo == null) {
            return new ResponseEntity<>(estudianteNuevo, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(estudianteNuevo, HttpStatus.CREATED);
        }
    }

    @PutMapping(path = "/api/estudiantes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estudiante> update(@RequestBody Estudiante newEstudiante) {
        Estudiante estudianteNuevo = newEstudiante;
        repositorio.actualizar(estudianteNuevo);

        if (estudianteNuevo == null) {
            return new ResponseEntity<>(estudianteNuevo, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(estudianteNuevo, HttpStatus.CREATED);
        }
    }

}

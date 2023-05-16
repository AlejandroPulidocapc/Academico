package co.edu.interlemd.academico.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.entidades.Estudiante;

@RestController
public class EstudianteController {

    private static List<Estudiante> lista = new ArrayList<Estudiante>();

    @GetMapping("api/estudiante/prueba")
    public String prueba(@RequestParam(value = "name", defaultValue = "World") String name) {

        Estudiante estudianteNuevo = new Estudiante("Cristian", "Pulido", 18);
        lista.add(estudianteNuevo);

        return String.format("Hello %s!", name);
    }

    @GetMapping(path = "api/estudiantes", produces = "application/json")
    public List<Estudiante> getTodos() {
        return lista;

    }

    @PostMapping(path = "/api/estudiantes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estudiante> create(@RequestBody Estudiante newEstudiante) {
        Estudiante estudianteNuevo = newEstudiante;
        lista.add(estudianteNuevo);

        if (estudianteNuevo == null) {
            return new ResponseEntity<>(estudianteNuevo, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(estudianteNuevo, HttpStatus.CREATED);
        }
    }

}

package co.edu.interlemd.academico.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.entidades.Estudiante;

@RestController
public class EstudianteController {

    private static List<Estudiante> lista = new ArrayList<Estudiante>();

    @GetMapping("api/estudiante/prueba")
    public String prueba(@RequestParam(value = "name", defaultValue = "World") String name) {
        

        Estudiante estudianteNuevo =new Estudiante("Cristian", "Pulido", 18);
        lista.add(estudianteNuevo);

 return String.format("Hello %s!", name);
    }

    @GetMapping(path = "api/estudiante", produces = "application/json")
    public List<Estudiante> getTodos() {
        return lista;

    }

}

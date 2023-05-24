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

import co.edu.interlemd.academico.entidades.Task;
import co.edu.repositorio.TaskRepositorio;






@RestController
public class TaskController {

    private TaskRepositorio repositorio = new TaskRepositorio();


    @GetMapping("api/tasks/prueba")
    public String prueba(@RequestParam(value = "name", defaultValue = "World") String name) {

        Task taskNuevo = new Task(0 ,"Cristian", "Pulido");
        repositorio.crear(taskNuevo);

        return String.format("Hello %s!", name);
    }

    @GetMapping(path = "api/tasks", produces = "application/json")
    public List<Task> getTodos() {
        return repositorio.leerTodos();

    }

    @PostMapping(path = "/api/tasks", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> create(@RequestBody Task newtTask) {
        Task taskNuevo = newtTask;
        repositorio.crear(taskNuevo);

        if (taskNuevo == null) {
            return new ResponseEntity<>(taskNuevo, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(taskNuevo, HttpStatus.CREATED);
        }
    }

    @PutMapping(path = "/api/tasks", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> update(@RequestBody Task newTask) {
        Task taskNuevo = newTask;
        repositorio.actualizar(taskNuevo);

        if (taskNuevo == null) {
            return new ResponseEntity<>(taskNuevo, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(taskNuevo, HttpStatus.CREATED);
        }
    }
}

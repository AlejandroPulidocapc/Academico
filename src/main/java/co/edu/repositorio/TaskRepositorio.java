package co.edu.repositorio;

import java.util.ArrayList;
import java.util.List;

import co.edu.interlemd.academico.entidades.Task;

public class TaskRepositorio {

    private static List<Task> lista = new ArrayList<Task>();


private static int index=0;



    public Task crear(Task Task) {
        Task.setId(index++);
        lista.add(Task);
        return Task;
    }

    public List<Task> leerTodos() {
        return lista;
    }

    public Task buscarPorId(int TaskId){
            Task retorno=null;
        

for(Task Task: lista)
    if(Task.getId()== TaskId){
        retorno=Task;
        break;
    }

return retorno;

}

public Task actualizar(Task Task){ 
if(buscarPorId(Task.getId())!=null){
lista.remove(Task);
lista.add(Task);
}
return Task;


}
}
package co.edu.repositorio;

import java.util.ArrayList;
import java.util.List;

import co.edu.entidades.Estudiante;

public class EstudianteRepositorio {

    private static List<Estudiante> lista = new ArrayList<Estudiante>();


private static int index=0;



    public Estudiante crear(Estudiante estudiante) {
        estudiante.setId(index++);
        lista.add(estudiante);
        return estudiante;
    }

    public List<Estudiante> leerTodos() {
        return lista;
    }

    public Estudiante buscarPorId(int estudianteId){
            Estudiante retorno=null;
        

for(Estudiante estudiante: lista)
    if(estudiante.getId()== estudianteId){
        retorno=estudiante;
        break;
    }

return retorno;

}

public Estudiante actualizar(Estudiante estudiante){ 
if(buscarPorId(estudiante.getId())!=null){
lista.remove(estudiante);
lista.add(estudiante);
}
return estudiante;


}
}
package co.edu.entidades;

public class Estudiante {
    private int id; 
    

private String nombre;
private String apellido;
 private int edad;

 public Estudiante(int id, String nombre, String apellido, int edad) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
}




public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public String getApellido() {
    return apellido;
}
public void setApellido(String apellido) {
    this.apellido = apellido;
}
public int getEdad() {
    return edad;
}
public void setEdad(int edad) {
    this.edad = edad;
}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}


@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Estudiante other = (Estudiante) obj;
    if (id != other.id)
        return false;
    return true;
}

}

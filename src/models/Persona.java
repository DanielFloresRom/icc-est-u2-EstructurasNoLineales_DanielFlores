package models;

public class Persona implements Comparable<Persona> {
    private String name;
    private int edad;

    public Persona(String name, int edad) {
        this.name = name;
        this.edad = edad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int compareTo(Persona otra) {
        int compEdad = Integer.compare(this.edad, otra.edad);
        if (compEdad != 0)
            return compEdad;

        int compNombre = this.name.compareTo(otra.name);
        return compNombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "name='" + name + '\'' + ", edad=" + edad + '}';
    }
}
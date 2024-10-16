
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int cantidadPersona = 10;
        Persona[] personas = new Persona[cantidadPersona];
        Scanner scanner = new Scanner(System.in); 

        // Pedir al usuario que ingrese los datos de las Personas
        for (int i = 0; i < cantidadPersona; i++) {
            System.out.println("Ingrese el nombre de la persona " + (i+1) + ": ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese la edad de la persona " + (i+1) + ": ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            personas[i] = new Persona(nombre, edad);
        }

        // Ordenar personas por edad usando el método de inserción
        ordenarPorEdad(personas);

        // Mostrar la lista ordenada por edad
        System.out.println("\nLista de personas ordenadas por edad:");
        for (Persona p : personas) {
            System.out.println(p.getNombre() + " - " + p.getEdad() + " años");
        }

        // Buscar una persona por nombre
        System.out.println("\nIngrese el nombre de la persona que desea buscar: ");
        String nombreBuscado = scanner.nextLine();
        Persona encontrada = buscarPorNombre(personas, nombreBuscado);

        if (encontrada != null) {
            System.out.println("Persona encontrada: " + encontrada.getNombre() + " - " + encontrada.getEdad() + " años");
        } else {
            System.out.println("Persona no encontrada.");
        }

        scanner.close();
    }

    // Método de ordenamiento por inserción
    public static void ordenarPorEdad(Persona[] personas) {
        for (int i = 1; i < personas.length; i++) {
            Persona key = personas[i];
            int j = i - 1;
            while (j >= 0 && personas[j].getEdad() > key.getEdad()) {
                personas[j + 1] = personas[j];
                j--;
            }
            personas[j + 1] = key;
        }
    }

    // Método de búsqueda por nombre
    public static Persona buscarPorNombre(Persona[] personas, String nombre) {
        for (Persona p : personas) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null; // No se encontró la persona
    }
}

class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}

        
    



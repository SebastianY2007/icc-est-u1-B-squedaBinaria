import controllers.MetodoBinario;
import java.util.Scanner;
import models.Persona;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);

    System.out.print("¿Cuantas personas desea ingresar?: ");
    int cantidad = scanner.nextInt();
    scanner.nextLine();

    if (cantidad < 0) {
      System.out.println("ERROR: La cantidad no puede ser negativa");
      return;
    }
    
    Persona[] personas = new Persona[cantidad];
    
    for (int i = 0; i < cantidad; i++){
      System.out.println("Persona " + (i+1) + ":");

      System.out.print("Nombre: ");
      String nombre = scanner.nextLine();
      
      System.out.print("Edad: ");
      int edad = scanner.nextInt();
      scanner.nextLine();
      
      if (edad < 0) {
        System.out.println("ERROR: La edad no puede ser negativa");
        return;
      }
      personas[i] = new Persona(nombre, edad);
    }

    MetodoBinario mB = new MetodoBinario(personas);
    
    mB.showPersonByEdad();

    scanner.close();
  }
}        
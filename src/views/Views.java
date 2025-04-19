package views;

import java.util.Scanner;

public class Views {
    private Scanner scanner = new Scanner(System.in);

    public int getEdad(){
        System.out.println("Ingrese la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        if (edad < 0) {
            System.out.println("Error: No se permiten edades negativas. Saliendo del programa...");
            System.exit(0);
        }
        return edad;
    }

    public void showMessage(String message){
        System.out.println(message);
    }
}
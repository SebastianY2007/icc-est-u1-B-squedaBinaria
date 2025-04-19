package controllers;

import models.Persona;
import views.Views;

public class MetodoBinario {
  private Persona[] personas;
  private Views views;

  public MetodoBinario(Persona[] personas) {
    this.personas = personas;
    this.views = new Views();

  }




  public int findPersonByEdad(int edad){
    int bajo = 0;
    int alto = personas.length - 1; 

    imprimirArrayCompleto();
    System.out.println();

    while (bajo <= alto){
      int central = bajo + (alto - bajo) / 2; 
      int valorCentral = personas[central].getEdad();

      System.out.printf("bajo:%d    alto:%d    centro:%d    valorCentro:%d   --> ", bajo, alto, central, valorCentral);
      
      if (valorCentral == edad) {
        System.out.println("ENCONTRADO\n");
        imprimirSubArray(bajo, bajo);
        return central;
      } else if (valorCentral < edad) {
        System.out.println("DERECHA");
        bajo = central + 1;
      } else {
        System.out.println("IZQUIERDA");
        alto = central - 1;
      }
      imprimirSubArray(bajo, alto);
    }
      return -1; 
  }
  
  private void imprimirArrayCompleto() {
    for (int i = 0; i < personas.length; i++) {
      System.out.print(personas[i].getEdad());
      if (i < personas.length - 1) System.out.print(" | ");
    }
  } 
  
  private void imprimirSubArray(int inicio, int fin) {
    for (int i = inicio; i <= fin; i++) {
        System.out.print(personas[i].getEdad());
        if (i < fin) System.out.print(" | ");
      }
    System.out.println("\n");
  }

  public void showPersonByEdad(){
    int edad = views.getEdad();
    int indexPerson = findPersonByEdad(edad);
      if (indexPerson == -1){
        views.showMessage("No hay una persona con esa edad.");
      }else{
        Persona encontrada = personas[indexPerson];
        views.showMessage("La persona con la edad " + encontrada.getEdad() + " es " + encontrada.getNombre());
      } 
  }
}
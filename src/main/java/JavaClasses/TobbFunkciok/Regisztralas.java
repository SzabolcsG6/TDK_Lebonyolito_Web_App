/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaClasses.TobbFunkciok;

import JavaClasses.Felhasznalo;

/**
 *
 * @author misim
 */
public class Regisztralas {
      public Felhasznalo registerUser(String nev, String jelszo, String email, String szak, String kar, String Egyetem) {
        
        String titkositottJelszo = JelszoTitkositas.Titkositas(jelszo);
        
      
        Felhasznalo UjFelhasznalo = new Felhasznalo(nev, titkositottJelszo, email, szak, kar, Egyetem);
        
        // Itt kellene az új felhasználót elmenteni az adatbázisba
        
        return UjFelhasznalo;
    }
}

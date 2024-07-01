/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaClasses;

/**
 *
 * @author misim
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DolgozatLista {
    private List<Dolgozat> dolgozatok = new ArrayList<>();

    public boolean addDolgozat(Dolgozat dolgozat) {
        // Ellenőrizzük, hogy az adott dolgozat már szerepel-e a listában
        if (!dolgozatok.contains(dolgozat)) {
            dolgozatok.add(dolgozat);
            return true; // Sikeres hozzáadás
        }
        return false; // A dolgozat már szerepel a listában
    }
    public Dolgozat getDolgozatById(int id) {
        for (Dolgozat dolgozat : dolgozatok) {
            if (dolgozat.getDolgozatId() == id) {
                return dolgozat;
            }
        }
        return null; // Ha nincs megadott ID-jű dolgozat
    }

    public void removeDolgozatById(int id) {
        Dolgozat dolgozatToRemove = null;
        for (Dolgozat dolgozat : dolgozatok) {
            if (dolgozat.getDolgozatId() == id) {
                dolgozatToRemove = dolgozat;
                break;
            }
        }
        if (dolgozatToRemove != null) {
            dolgozatok.remove(dolgozatToRemove);
        }
    }

    public void setDolgozatById(int id, Dolgozat dolgozat) {
        for (int i = 0; i < dolgozatok.size(); i++) {
            if (dolgozatok.get(i).getDolgozatId() == id) {
                dolgozatok.set(i, dolgozat);
                break;
            }
        }
    }

    public List<Dolgozat> getDolgozatok() {
        return dolgozatok;
    }
    public static void rendezCimSzerint(List<Dolgozat> dolgozatok) {
        dolgozatok.sort(Comparator.comparing(Dolgozat::getCim));
    }

    // Rendezés kategória alapján
    public static void rendezKategoriaSzerint(List<Dolgozat> dolgozatok) {
        dolgozatok.sort(Comparator.comparing(Dolgozat::getKategoria));
    }
}



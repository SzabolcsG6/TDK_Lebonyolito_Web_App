/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaClasses.TobbFunkciok;

/**
 *
 * @author misim
 */

import JavaClasses.Dolgozat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DolgozatLista {
    private List<Dolgozat> dolgozatok = new ArrayList<>();

    public boolean addDolgozat(Dolgozat dolgozat) {
        if (!dolgozatok.contains(dolgozat)) {
            dolgozatok.add(dolgozat);
            return true; // Sikeres hozzáadás
        }
        return false; // A dolgozat már szerepel a listában
    }

    public Dolgozat getDolgozatById(int id) {
        return dolgozatok.stream()
                .filter(d -> d.getDolgozatId() == id)
                .findFirst()
                .orElse(null); // Ha nincs megadott ID-jű dolgozat
    }

    public void removeDolgozatById(int id) {
        dolgozatok.removeIf(d -> d.getDolgozatId() == id);
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
        return new ArrayList<>(dolgozatok); // Visszaadjuk a list másolatát
    }

    public static void rendezCimSzerint(List<Dolgozat> dolgozatok) {
        dolgozatok.sort(Comparator.comparing(Dolgozat::getCim));
    }

    public static void rendezKategoriaSzerint(List<Dolgozat> dolgozatok) {
        dolgozatok.sort(Comparator.comparing(Dolgozat::getKategoria));
    }
}

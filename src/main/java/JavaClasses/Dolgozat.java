/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaClasses;

/**
 *
 * @author misim
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dolgozat {
    private List<Diak> szerzok;
    private static int nextDolgozatId = 1; 
    private int DolgozatId;
    private String cim;
    private String kategoria;
    private String kivonat;
    private String vezetoTanarok;
    private File dolgozatFile;
    private boolean elfogadva;
     private Long jegy;

    public Dolgozat(List<Diak> szerzok, String cim, String kategoria, String kivonat, String vezetoTanarok, File dolgozatFile) {
        this.DolgozatId=nextDolgozatId++;
        this.szerzok = szerzok;
        this.cim = cim;
        this.kategoria = kategoria;
        this.kivonat = kivonat;
        this.vezetoTanarok = vezetoTanarok;
        this.dolgozatFile = dolgozatFile;
        this.elfogadva = false; // Alapértelmezetten false
        this.jegy = 1L;//alapertelmezetten 1
    }
     public Dolgozat(List<Diak> szerzok, String cim, String kategoria){
         this.DolgozatId=nextDolgozatId++;
        this.szerzok = szerzok;
        this.cim = cim;
        this.kategoria = kategoria;
    }
    public Dolgozat(){
        this.DolgozatId=nextDolgozatId++;
    }
   
public int getDolgozatId() {
        return DolgozatId;
    }
public void setDolgozatId(int DolgozatId){
    this.DolgozatId=DolgozatId;
}
 public Long getJegy() {
        return jegy;
    }

    public void setJegy(Long jegy) {
        this.jegy = jegy;
    }
    // Getterek és setterek
    public List<Diak> getSzerzok() {
        return szerzok;
    }

    public void setSzerzok(List<Diak> szerzok) {
        this.szerzok = szerzok;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getKivonat() {
        return kivonat;
    }

    public void setKivonat(String kivonat) {
        this.kivonat = kivonat;
    }

    public String getVezetoTanarok() {
        return vezetoTanarok;
    }

    public void setVezetoTanarok(String vezetoTanarok) {
        this.vezetoTanarok = vezetoTanarok;
    }

    public File getDolgozatFile() {
        return dolgozatFile;
    }

    public void setDolgozatFile(File dolgozatFile) {
        this.dolgozatFile = dolgozatFile;
    }

    public boolean isElfogadva() {
        return elfogadva;
    }

    public void setElfogadva(boolean elfogadva) {
        this.elfogadva = elfogadva;
    }
    public static void kiirElfogadottDolgozatok(List<Dolgozat> dolgozatok) {
        for (Dolgozat dolgozat : dolgozatok) {
            if (dolgozat.isElfogadva()) {
                System.out.println(dolgozat);
            }
        }
    }

    // toString metódus felülírása az osztály megfelelő kiírásához
    @Override
    public String toString() {
        return "Dolgozat{" +
                "cim='" + cim + '\'' +
                ", kategoria='" + kategoria + '\'' +
                ", elfogadva=" + elfogadva +
                '}';
    }
}

package JavaClasses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

public class Dolgozat {

    private static int nextDolgozatId = 1;
    private int DolgozatId;
    private String cim;
    private String kategoria;
    private String kivonat;
    private String vezetoTanarok;
    private Blob dolgozatFile;
    private boolean elfogadva;
    private Long jegy;

    public Dolgozat(int dolgozatId, String cim, String kategoria, String kivonat, String vezetoTanarok, Blob dolgozatFile, boolean elfogadva, Long jegy) {
        this.DolgozatId = dolgozatId;
        this.cim = cim;
        this.kategoria = kategoria;
        this.kivonat = kivonat;
        this.vezetoTanarok = vezetoTanarok;
        this.dolgozatFile = dolgozatFile;
        this.elfogadva = elfogadva;
        this.jegy = jegy;
    }

    public Dolgozat(String cim, String kategoria, String kivonat, String vezetoTanarok, Blob dolgozatFile) {
        this.DolgozatId = nextDolgozatId++;
        this.cim = cim;
        this.kategoria = kategoria;
        this.kivonat = kivonat;
        this.vezetoTanarok = vezetoTanarok;
        this.dolgozatFile = dolgozatFile;
        this.elfogadva = false; // Alapértelmezetten false
        this.jegy = 1L; // alapértelmezetten 1
    }

    public Dolgozat(String cim, String kategoria) {
        this.DolgozatId = nextDolgozatId++;
        this.cim = cim;
        this.kategoria = kategoria;
    }

    public Dolgozat() {

    }

    public int getDolgozatId() {
        return DolgozatId;
    }

    public void setDolgozatId(int DolgozatId) {
        this.DolgozatId = DolgozatId;
    }

    public Long getJegy() {
        return jegy;
    }

    public void setJegy(Long jegy) {
        this.jegy = jegy;
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

    public Blob getDolgozatFile() {
        return dolgozatFile;
    }

    public void setDolgozatFile(Blob dolgozatFile) {
        this.dolgozatFile = dolgozatFile;
    }

    private File createFileFromBlob(Blob blob) throws SQLException {
        if (blob == null)
        {
            return null;
        }

        File file = null;
        FileOutputStream outputStream = null;
        try
        {
            file = File.createTempFile("dolgozat", ".tmp");
            outputStream = new FileOutputStream(file);
            outputStream.write(blob.getBytes(1, (int) blob.length()));
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (outputStream != null)
            {
                try
                {
                    outputStream.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

    public boolean isElfogadva() {
        return elfogadva;
    }

    public void setElfogadva(boolean elfogadva) {
        this.elfogadva = elfogadva;
    }

    public static void kiirElfogadottDolgozatok(List<Dolgozat> dolgozatok) {
        for (Dolgozat dolgozat : dolgozatok)
        {
            if (dolgozat.isElfogadva())
            {
                System.out.println(dolgozat);
            }
        }
    }

    @Override
    public String toString() {
        return "Dolgozat{"
                + "cim='" + cim + '\''
                + ", kategoria='" + kategoria + '\''
                + ", elfogadva=" + elfogadva
                + '}';
    }
}

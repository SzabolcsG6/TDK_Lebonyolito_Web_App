package JavaClasses;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FelhasznaloLista implements Serializable {
    private List<Felhasznalo> felhasznalok = new ArrayList<>();

    public void addFelhasznalo(Felhasznalo felhasznalo) {
        felhasznalok.add(felhasznalo);
    }

    public Felhasznalo getFelhasznaloById(int id) {
        for (Felhasznalo felhasznalo : felhasznalok) {
            if (felhasznalo.getId() == id) {
                return felhasznalo;
            }
        }
        return null; // If no Felhasznalo found with the given ID
    }

    public void removeFelhasznaloById(int id) {
        for (int i = 0; i < felhasznalok.size(); i++) {
            if (felhasznalok.get(i).getId() == id) {
                felhasznalok.remove(i);
                return; // Removing only the first occurrence
            }
        }
    }

    public void setFelhasznaloById(int id, Felhasznalo felhasznalo) {
        for (int i = 0; i < felhasznalok.size(); i++) {
            if (felhasznalok.get(i).getId() == id) {
                felhasznalok.set(i, felhasznalo);
                return; // Setting only the first occurrence
            }
        }
    }

    public List<Felhasznalo> getFelhasznalok() {
        return felhasznalok;
    }

    public void writeFelhasznalokToFile(String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Felhasznalo felhasznalo : felhasznalok) {
                outputStream.writeObject(felhasznalo);
            }
            System.out.println("Felhasznalok sikeresen kiírva a fájlba: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFelhasznalokFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Felhasznalo felhasznalo;
            while ((felhasznalo = (Felhasznalo) inputStream.readObject()) != null) {
                felhasznalok.add(felhasznalo);
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void generateXMLFile(String fileName) {
        // Implement XML generation logic here
    }

    public void readXMLFile(String fileName) {
        // Implement XML reading logic here
    }
}

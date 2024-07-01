package JavaClasses;

public class Diak extends Felhasznalo {
    private int evfolyam;

    public Diak(String nev, String jelszo, String email, String szak, String kar, String Egyetem, int evfolyam) {
        super(nev, jelszo, email, szak, kar, Egyetem);
        this.evfolyam = evfolyam;
    }

    // Getter és setter az evfolyam változóhoz
    public int getEvfolyam() {
        return evfolyam;
    }

    public void setEvfolyam(int evfolyam) {
        this.evfolyam = evfolyam;
    }
}

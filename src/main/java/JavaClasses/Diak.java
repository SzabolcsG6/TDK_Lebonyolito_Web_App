package JavaClasses;

public class Diak {
    private static int nextId = 1; 
    private int Diak_id;
    private String nev;
    private String jelszo;
    private String email;
    private String szak;
    private String kar;
    private String egyetem;
    private int evfolyam;

    public Diak(String nev, String jelszo, String email, String szak, String kar, String egyetem, int evfolyam) {
        this.Diak_id = nextId++; // Diak_id inicializálása
        this.nev = nev;
        this.jelszo = jelszo;
        this.email = email;
        this.szak = szak;
        this.kar = kar;
        this.egyetem = egyetem;
        this.evfolyam = evfolyam;
    }
     public Diak(int Diak_id,String nev, String jelszo, String email, String szak, String kar, String egyetem, int evfolyam) {
        this.Diak_id = Diak_id; // Diak_id inicializálása
        this.nev = nev;
        this.jelszo = jelszo;
        this.email = email;
        this.szak = szak;
        this.kar = kar;
        this.egyetem = egyetem;
        this.evfolyam = evfolyam;
    }

    // Getter és setter a Diak_id változóhoz
    public int getDiak_id() {
        return Diak_id;
    }

    public void setDiak_id(int Diak_id) {
        this.Diak_id = Diak_id;
    }

    // Getterek és setterek a nev változóhoz
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    // Getterek és setterek a jelszo változóhoz
    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    // Getterek és setterek az email változóhoz
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getterek és setterek a szak változóhoz
    public String getSzak() {
        return szak;
    }

    public void setSzak(String szak) {
        this.szak = szak;
    }

    // Getterek és setterek a kar változóhoz
    public String getKar() {
        return kar;
    }

    public void setKar(String kar) {
        this.kar = kar;
    }

    // Getterek és setterek az egyetem változóhoz
    public String getEgyetem() {
        return egyetem;
    }

    public void setEgyetem(String egyetem) {
        this.egyetem = egyetem;
    }

    // Getter és setter az evfolyam változóhoz
    public int getEvfolyam() {
        return evfolyam;
    }

    public void setEvfolyam(int evfolyam) {
        this.evfolyam = evfolyam;
    }
}

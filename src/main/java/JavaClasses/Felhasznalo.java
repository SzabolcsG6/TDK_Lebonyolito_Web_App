package JavaClasses;

public class Felhasznalo {
    private static int nextId = 1; 
    private int id;
    private String nev;
    private String jelszo;
    private String email;
    private String szak;
    private String kar;
    private String Egyetem;

    public Felhasznalo(String nev, String jelszo, String email, String szak, String kar, String Egyetem) {
        this.id = nextId++;
        this.nev = nev;
        this.jelszo = jelszo;
        this.email = email;
        this.szak = szak;
        this.kar = kar;
        this.Egyetem = Egyetem;
        
    }

    // Getterek és setterek az id változóhoz
    public int getId() {
        return id;
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

    // Getterek és setterek az Egyetem változóhoz
    public String getEgyetem() {
        return Egyetem;
    }

    public void setEgyetem(String Egyetem) {
        this.Egyetem = Egyetem;
    }
    public void FelhasznaloJelszoTitkositas(Felhasznalo felhasznalo){
          String titkositottJelszo = JelszoTitkositas.Titkositas(felhasznalo.getJelszo());
          felhasznalo.setJelszo(titkositottJelszo);
    }
}

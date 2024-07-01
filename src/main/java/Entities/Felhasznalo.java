/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


/**
 *
 * @author misim
 */
@Entity
@Table(name = "felhasznalo")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Felhasznalo.findAll", query = "SELECT f FROM Felhasznalo f"),
    @NamedQuery(name = "Felhasznalo.findById", query = "SELECT f FROM Felhasznalo f WHERE f.id = :id"),
    @NamedQuery(name = "Felhasznalo.findByNev", query = "SELECT f FROM Felhasznalo f WHERE f.nev = :nev"),
    @NamedQuery(name = "Felhasznalo.findByJelszo", query = "SELECT f FROM Felhasznalo f WHERE f.jelszo = :jelszo"),
    @NamedQuery(name = "Felhasznalo.findByEmail", query = "SELECT f FROM Felhasznalo f WHERE f.email = :email"),
    @NamedQuery(name = "Felhasznalo.findBySzak", query = "SELECT f FROM Felhasznalo f WHERE f.szak = :szak"),
    @NamedQuery(name = "Felhasznalo.findByKar", query = "SELECT f FROM Felhasznalo f WHERE f.kar = :kar"),
    @NamedQuery(name = "Felhasznalo.findByEgyetem", query = "SELECT f FROM Felhasznalo f WHERE f.egyetem = :egyetem")
})
public class Felhasznalo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "nev")
    private String nev;
    @Size(max = 255)
    @Column(name = "jelszo")
    private String jelszo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "szak")
    private String szak;
    @Size(max = 255)
    @Column(name = "kar")
    private String kar;
    @Size(max = 255)
    @Column(name = "Egyetem")
    private String egyetem;

    public Felhasznalo() {
    }

    public Felhasznalo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSzak() {
        return szak;
    }

    public void setSzak(String szak) {
        this.szak = szak;
    }

    public String getKar() {
        return kar;
    }

    public void setKar(String kar) {
        this.kar = kar;
    }

    public String getEgyetem() {
        return egyetem;
    }

    public void setEgyetem(String egyetem) {
        this.egyetem = egyetem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Felhasznalo))
        {
            return false;
        }
        Felhasznalo other = (Felhasznalo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Felhasznalo[ id=" + id + " ]";
    }
    
}

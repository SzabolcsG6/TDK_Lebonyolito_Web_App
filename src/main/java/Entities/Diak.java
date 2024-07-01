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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
/**
 *
 * @author misim
 */
@Entity
@Table(name = "diak")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Diak.findAll", query = "SELECT d FROM Diak d"),
    @NamedQuery(name = "Diak.findById", query = "SELECT d FROM Diak d WHERE d.id = :id"),
    @NamedQuery(name = "Diak.findByNev", query = "SELECT d FROM Diak d WHERE d.nev = :nev"),
    @NamedQuery(name = "Diak.findByJelszo", query = "SELECT d FROM Diak d WHERE d.jelszo = :jelszo"),
    @NamedQuery(name = "Diak.findByEmail", query = "SELECT d FROM Diak d WHERE d.email = :email"),
    @NamedQuery(name = "Diak.findBySzak", query = "SELECT d FROM Diak d WHERE d.szak = :szak"),
    @NamedQuery(name = "Diak.findByKar", query = "SELECT d FROM Diak d WHERE d.kar = :kar"),
    @NamedQuery(name = "Diak.findByEgyetem", query = "SELECT d FROM Diak d WHERE d.egyetem = :egyetem"),
    @NamedQuery(name = "Diak.findByEvfolyam", query = "SELECT d FROM Diak d WHERE d.evfolyam = :evfolyam")
})
public class Diak implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
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
    @Column(name = "evfolyam")
    private Integer evfolyam;

    public Diak() {
    }

    public Diak(Integer id) {
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

    public Integer getEvfolyam() {
        return evfolyam;
    }

    public void setEvfolyam(Integer evfolyam) {
        this.evfolyam = evfolyam;
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
        if (!(object instanceof Diak))
        {
            return false;
        }
        Diak other = (Diak) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Diak[ id=" + id + " ]";
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.math.BigInteger;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "dolgozat")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Dolgozat.findAll", query = "SELECT d FROM Dolgozat d"),
    @NamedQuery(name = "Dolgozat.findByDolgozatId", query = "SELECT d FROM Dolgozat d WHERE d.dolgozatId = :dolgozatId"),
    @NamedQuery(name = "Dolgozat.findByCim", query = "SELECT d FROM Dolgozat d WHERE d.cim = :cim"),
    @NamedQuery(name = "Dolgozat.findByKategoria", query = "SELECT d FROM Dolgozat d WHERE d.kategoria = :kategoria"),
    @NamedQuery(name = "Dolgozat.findByVezetoTanarok", query = "SELECT d FROM Dolgozat d WHERE d.vezetoTanarok = :vezetoTanarok"),
    @NamedQuery(name = "Dolgozat.findByElfogadva", query = "SELECT d FROM Dolgozat d WHERE d.elfogadva = :elfogadva"),
    @NamedQuery(name = "Dolgozat.findByJegy", query = "SELECT d FROM Dolgozat d WHERE d.jegy = :jegy")
})
public class Dolgozat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DolgozatId")
    private Integer dolgozatId;
    @Size(max = 255)
    @Column(name = "cim")
    private String cim;
    @Size(max = 255)
    @Column(name = "kategoria")
    private String kategoria;
    @Lob
    @Size(max = 65535)
    @Column(name = "kivonat")
    private String kivonat;
    @Size(max = 255)
    @Column(name = "vezetoTanarok")
    private String vezetoTanarok;
    @Lob
    @Column(name = "dolgozatFile")
    private byte[] dolgozatFile;
    @Column(name = "elfogadva")
    private Boolean elfogadva;
    @Column(name = "jegy")
    private BigInteger jegy;

    public Dolgozat() {
    }

    public Dolgozat(Integer dolgozatId) {
        this.dolgozatId = dolgozatId;
    }

    public Integer getDolgozatId() {
        return dolgozatId;
    }

    public void setDolgozatId(Integer dolgozatId) {
        this.dolgozatId = dolgozatId;
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

    public byte[] getDolgozatFile() {
        return dolgozatFile;
    }

    public void setDolgozatFile(byte[] dolgozatFile) {
        this.dolgozatFile = dolgozatFile;
    }

    public Boolean getElfogadva() {
        return elfogadva;
    }

    public void setElfogadva(Boolean elfogadva) {
        this.elfogadva = elfogadva;
    }

    public BigInteger getJegy() {
        return jegy;
    }

    public void setJegy(BigInteger jegy) {
        this.jegy = jegy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dolgozatId != null ? dolgozatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dolgozat))
        {
            return false;
        }
        Dolgozat other = (Dolgozat) object;
        if ((this.dolgozatId == null && other.dolgozatId != null) || (this.dolgozatId != null && !this.dolgozatId.equals(other.dolgozatId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Dolgozat[ dolgozatId=" + dolgozatId + " ]";
    }
    
}

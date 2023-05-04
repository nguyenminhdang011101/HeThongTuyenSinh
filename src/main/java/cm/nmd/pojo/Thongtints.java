/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cm.nmd.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LENOVO-E14
 */
@Entity
@Table(name = "thongtints")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thongtints.findAll", query = "SELECT t FROM Thongtints t"),
    @NamedQuery(name = "Thongtints.findById", query = "SELECT t FROM Thongtints t WHERE t.id = :id"),
    @NamedQuery(name = "Thongtints.findByTieude", query = "SELECT t FROM Thongtints t WHERE t.tieude = :tieude"),
    @NamedQuery(name = "Thongtints.findByNoidung", query = "SELECT t FROM Thongtints t WHERE t.noidung = :noidung"),
    @NamedQuery(name = "Thongtints.findByThoigian", query = "SELECT t FROM Thongtints t WHERE t.thoigian = :thoigian"),
    @NamedQuery(name = "Thongtints.findByBanner", query = "SELECT t FROM Thongtints t WHERE t.banner = :banner")})
public class Thongtints implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tieude")
    private String tieude;
    @Size(max = 4000)
    @Column(name = "noidung")
    private String noidung;
    @Size(max = 25)
    @Column(name = "thoigian")
    private String thoigian;
    @Size(max = 255)
    @Column(name = "banner")
    private String banner;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private He he;

    public Thongtints() {
    }

    public Thongtints(Integer id) {
        this.id = id;
    }

    public Thongtints(Integer id, String tieude, String noidung, String thoigian, String banner) {
        this.id = id;
        this.tieude = tieude;
        this.noidung = noidung;
        this.thoigian = thoigian;
        this.banner = banner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public He getHe() {
        return he;
    }

    public void setHe(He he) {
        this.he = he;
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
        if (!(object instanceof Thongtints)) {
            return false;
        }
        Thongtints other = (Thongtints) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.nmd.pojo.Thongtints[ id=" + id + " ]";
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cm.nmd.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "he")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "He.findAll", query = "SELECT h FROM He h"),
    @NamedQuery(name = "He.findById", query = "SELECT h FROM He h WHERE h.id = :id"),
    @NamedQuery(name = "He.findByTen", query = "SELECT h FROM He h WHERE h.ten = :ten"),
    @NamedQuery(name = "He.findByGhiChu", query = "SELECT h FROM He h WHERE h.ghiChu = :ghiChu")})
public class He implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ten")
    private String ten;
    @Size(max = 255)
    @Column(name = "ghiChu")
    private String ghiChu;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "he")
    private Thongtints thongtints;

    public He() {
    }

    public He(Integer id) {
        this.id = id;
    }

    public He(Integer id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Thongtints getThongtints() {
        return thongtints;
    }

    public void setThongtints(Thongtints thongtints) {
        this.thongtints = thongtints;
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
        if (!(object instanceof He)) {
            return false;
        }
        He other = (He) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.nmd.pojo.He[ id=" + id + " ]";
    }
    
}

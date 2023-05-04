/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nmd.pojo;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "livestream")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LivestreamDetail.findAll", query = "SELECT p FROM LivestreamDetail p"),
    @NamedQuery(name = "LivestreamDetail.findById", query = "SELECT p FROM LivestreamDetail p WHERE p.id = :id"),
    @NamedQuery(name = "LivestreamDetail.findByName", query = "SELECT p FROM LivestreamDetail p WHERE p.name = :name"),
    @NamedQuery(name = "LivestreamDetail.findByDescription", query = "SELECT p FROM LivestreamDetail p WHERE p.description = :description"),
    @NamedQuery(name = "LivestreamDetail.findByvideo", query = "SELECT p FROM LivestreamDetail p WHERE p.video = :video"),
    @NamedQuery(name = "LivestreamDetail.findBythumbnail", query = "SELECT p FROM LivestreamDetail p WHERE p.thumbnail = :thumbnail"),
    @NamedQuery(name = "LivestreamDetail.findBypersonInCharge", query = "SELECT p FROM LivestreamDetail p WHERE p.personInCharge = : personInCharge"),
    @NamedQuery(name = "LivestreamDetail.findBycreatedDate", query = "SELECT p FROM LivestreamDetail p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "LivestreamDetail.findByActive", query = "SELECT p FROM LivestreamDetail p WHERE p.active = :active")})
public class LivestreamDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{livestream-detail.name.nullerr}")
    @Size(min = 1, max = 225, message = "{livestream-detail.name.lenerr}")
    @Column(name = "tieude")
    private String name;
    @Size(max = 4000)
    @Column(name = "noidung")
    private String description;
    @Size(max = 100)
    @Column(name = "thumbnail")
    private String thumbnail;
    @Size(max = 100)
    @Column(name = "video")
    private String video;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "active")
    private Boolean active;
    @ManyToOne
    @JoinColumn(name = "person_in_charge")
    private User personInCharge;
    @Transient
    private MultipartFile thumbnailFile;

    public LivestreamDetail() {
    }

    public LivestreamDetail(Integer id) {
        this.id = id;
    }

    public LivestreamDetail(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String image) {
        this.video = image;
    }
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String image) {
        this.thumbnail = image;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof LivestreamDetail)) {
            return false;
        }
        LivestreamDetail other = (LivestreamDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nmd.pojo.Product[ id=" + id + " ]";
    }


    public User getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(User personInCharge) {
        this.personInCharge = personInCharge;
    }

    public MultipartFile getThumbnailFile() {
        return thumbnailFile;
    }

    public void setThumbnailFile(MultipartFile thumbnailFile) {
        this.thumbnailFile = thumbnailFile;
    }
}

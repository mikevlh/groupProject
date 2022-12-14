/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject.projectx.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vaggelis
 */
@Entity
@Table(name = "pilot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pilot.findAll", query = "SELECT p FROM Pilot p"),
    @NamedQuery(name = "Pilot.findByPilotId", query = "SELECT p FROM Pilot p WHERE p.pilotId = :pilotId"),
    @NamedQuery(name = "Pilot.findByLicenceNumber", query = "SELECT p FROM Pilot p WHERE p.licenceNumber = :licenceNumber"),
    @NamedQuery(name = "Pilot.findByFname", query = "SELECT p FROM Pilot p WHERE p.fname = :fname"),
    @NamedQuery(name = "Pilot.findByLname", query = "SELECT p FROM Pilot p WHERE p.lname = :lname"),
    @NamedQuery(name = "Pilot.findByContactNumber", query = "SELECT p FROM Pilot p WHERE p.contactNumber = :contactNumber")})
public class Pilot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pilot_id")
    private Integer pilotId;
    @Column(name = "licence_number")
    private Integer licenceNumber;
    @Size(max = 45)
    @Column(name = "fname")
    private String fname;
    @Size(max = 45)
    @Column(name = "lname")
    private String lname;
    @Size(max = 45)
    @Column(name = "contact_number")
    private String contactNumber;
    @OneToMany(mappedBy = "pilot")
    private Set<PilotFlight> pilotFlightSet;

    public Pilot() {
    }

    public Pilot(Integer pilotId) {
        this.pilotId = pilotId;
    }

    public Integer getPilotId() {
        return pilotId;
    }

    public void setPilotId(Integer pilotId) {
        this.pilotId = pilotId;
    }

    public Integer getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(Integer licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @XmlTransient
    public Set<PilotFlight> getPilotFlightSet() {
        return pilotFlightSet;
    }

    public void setPilotFlightSet(Set<PilotFlight> pilotFlightSet) {
        this.pilotFlightSet = pilotFlightSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pilotId != null ? pilotId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pilot)) {
            return false;
        }
        Pilot other = (Pilot) object;
        if ((this.pilotId == null && other.pilotId != null) || (this.pilotId != null && !this.pilotId.equals(other.pilotId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pilot{pilotId=").append(pilotId);
        sb.append(", licenceNumber=").append(licenceNumber);
        sb.append(", fname=").append(fname);
        sb.append(", lname=").append(lname);
        sb.append(", contactNumber=").append(contactNumber);
        sb.append(", pilotFlightSet=").append(pilotFlightSet);
        sb.append('}');
        return sb.toString();
    }

   
    
}

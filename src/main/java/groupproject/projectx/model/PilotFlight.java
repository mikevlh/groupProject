/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject.projectx.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vaggelis
 */
@Entity
@Table(name = "pilot_flight")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PilotFlight.findAll", query = "SELECT p FROM PilotFlight p"),
    @NamedQuery(name = "PilotFlight.findByPilotFlightId", query = "SELECT p FROM PilotFlight p WHERE p.pilotFlightId = :pilotFlightId")})
public class PilotFlight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pilot_flight_id")
    private Integer pilotFlightId;
    @JoinColumn(name = "flight", referencedColumnName = "flight_id")
    @ManyToOne
    private Flight flight;
    @JoinColumn(name = "pilot", referencedColumnName = "pilot_id")
    @ManyToOne
    private Pilot pilot;

    public PilotFlight() {
    }

    public PilotFlight(Integer pilotFlightId) {
        this.pilotFlightId = pilotFlightId;
    }

    public Integer getPilotFlightId() {
        return pilotFlightId;
    }

    public void setPilotFlightId(Integer pilotFlightId) {
        this.pilotFlightId = pilotFlightId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pilotFlightId != null ? pilotFlightId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PilotFlight)) {
            return false;
        }
        PilotFlight other = (PilotFlight) object;
        if ((this.pilotFlightId == null && other.pilotFlightId != null) || (this.pilotFlightId != null && !this.pilotFlightId.equals(other.pilotFlightId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PilotFlight{pilotFlightId=").append(pilotFlightId);
        sb.append(", flight=").append(flight);
        sb.append(", pilot=").append(pilot);
        sb.append('}');
        return sb.toString();
    }

  
    
}

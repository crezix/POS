/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iresh
 */
@Entity
@Table(name = "balancing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Balancing.findAll", query = "SELECT b FROM Balancing b"),
    @NamedQuery(name = "Balancing.findById", query = "SELECT b FROM Balancing b WHERE b.id = :id"),
    @NamedQuery(name = "Balancing.findByTime", query = "SELECT b FROM Balancing b WHERE b.time = :time"),
    @NamedQuery(name = "Balancing.findByClientName", query = "SELECT b FROM Balancing b WHERE b.clientName = :clientName"),
    @NamedQuery(name = "Balancing.findByGive", query = "SELECT b FROM Balancing b WHERE b.give = :give"),
    @NamedQuery(name = "Balancing.findByTake", query = "SELECT b FROM Balancing b WHERE b.take = :take"),
    @NamedQuery(name = "Balancing.findByToPay", query = "SELECT b FROM Balancing b WHERE b.toPay = :toPay")})
public class Balancing implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Column(name = "client_name")
    private String clientName;
    @Column(name = "give")
    private String give;
    @Column(name = "take")
    private String take;
    @Column(name = "to_pay")
    private String toPay;

    public Balancing() {
    }

    public Balancing(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        String oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        Date oldTime = this.time;
        this.time = time;
        changeSupport.firePropertyChange("time", oldTime, time);
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        String oldClientName = this.clientName;
        this.clientName = clientName;
        changeSupport.firePropertyChange("clientName", oldClientName, clientName);
    }

    public String getGive() {
        return give;
    }

    public void setGive(String give) {
        String oldGive = this.give;
        this.give = give;
        changeSupport.firePropertyChange("give", oldGive, give);
    }

    public String getTake() {
        return take;
    }

    public void setTake(String take) {
        String oldTake = this.take;
        this.take = take;
        changeSupport.firePropertyChange("take", oldTake, take);
    }

    public String getToPay() {
        return toPay;
    }

    public void setToPay(String toPay) {
        String oldToPay = this.toPay;
        this.toPay = toPay;
        changeSupport.firePropertyChange("toPay", oldToPay, toPay);
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
        if (!(object instanceof Balancing)) {
            return false;
        }
        Balancing other = (Balancing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Balancing[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

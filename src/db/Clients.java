/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iresh
 */
@Entity
@Table(name = "clients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findByClientName", query = "SELECT c FROM Clients c WHERE c.clientName = :clientName"),
    @NamedQuery(name = "Clients.findByToPay", query = "SELECT c FROM Clients c WHERE c.toPay = :toPay")})
public class Clients implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "client_name")
    private String clientName;
    @Column(name = "to_pay")
    private String toPay;

    public Clients() {
    }

    public Clients(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        String oldClientName = this.clientName;
        this.clientName = clientName;
        changeSupport.firePropertyChange("clientName", oldClientName, clientName);
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
        hash += (clientName != null ? clientName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.clientName == null && other.clientName != null) || (this.clientName != null && !this.clientName.equals(other.clientName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Clients[ clientName=" + clientName + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

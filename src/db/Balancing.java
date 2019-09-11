/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Balancing.findByClientId", query = "SELECT b FROM Balancing b WHERE b.clientId = :clientId"),
    @NamedQuery(name = "Balancing.findByGive", query = "SELECT b FROM Balancing b WHERE b.give = :give"),
    @NamedQuery(name = "Balancing.findByTake", query = "SELECT b FROM Balancing b WHERE b.take = :take"),
    @NamedQuery(name = "Balancing.findByToPay", query = "SELECT b FROM Balancing b WHERE b.toPay = :toPay")})
public class Balancing implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Column(name = "client_id")
    private String clientId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "give")
    private Float give;
    @Column(name = "take")
    private Float take;
    @Column(name = "to_pay")
    private Float toPay;

    public Balancing() {
    }

    public Balancing(Integer id) {
        this.id = id;
    }

    public Balancing(Integer id, Date time) {
        this.id = id;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Float getGive() {
        return give;
    }

    public void setGive(Float give) {
        this.give = give;
    }

    public Float getTake() {
        return take;
    }

    public void setTake(Float take) {
        this.take = take;
    }

    public Float getToPay() {
        return toPay;
    }

    public void setToPay(Float toPay) {
        this.toPay = toPay;
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
    
}

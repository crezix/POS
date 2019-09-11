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
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByTime", query = "SELECT a FROM Account a WHERE a.time = :time"),
    @NamedQuery(name = "Account.findByStOrBill", query = "SELECT a FROM Account a WHERE a.stOrBill = :stOrBill"),
    @NamedQuery(name = "Account.findByCost", query = "SELECT a FROM Account a WHERE a.cost = :cost"),
    @NamedQuery(name = "Account.findByPrice", query = "SELECT a FROM Account a WHERE a.price = :price")})
public class Account implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private Float cost;
    @Column(name = "price")
    private Float price;
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Id
    @Basic(optional = false)
    @Column(name = "st_or_bill")
    private String stOrBill;

    public Account() {
    }

    public Account(String stOrBill) {
        this.stOrBill = stOrBill;
    }

    public Account(String stOrBill, Date time) {
        this.stOrBill = stOrBill;
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStOrBill() {
        return stOrBill;
    }

    public void setStOrBill(String stOrBill) {
        this.stOrBill = stOrBill;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stOrBill != null ? stOrBill.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.stOrBill == null && other.stOrBill != null) || (this.stOrBill != null && !this.stOrBill.equals(other.stOrBill))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Account[ stOrBill=" + stOrBill + " ]";
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    
}

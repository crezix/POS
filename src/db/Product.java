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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByBarcode", query = "SELECT p FROM Product p WHERE p.barcode = :barcode"),
    @NamedQuery(name = "Product.findByBrandId", query = "SELECT p FROM Product p WHERE p.brandId = :brandId"),
    @NamedQuery(name = "Product.findByCatId", query = "SELECT p FROM Product p WHERE p.catId = :catId"),
    @NamedQuery(name = "Product.findByCostPrice", query = "SELECT p FROM Product p WHERE p.costPrice = :costPrice"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description"),
    @NamedQuery(name = "Product.findByProduct", query = "SELECT p FROM Product p WHERE p.product = :product"),
    @NamedQuery(name = "Product.findByQty", query = "SELECT p FROM Product p WHERE p.qty = :qty"),
    @NamedQuery(name = "Product.findByRetailPrice", query = "SELECT p FROM Product p WHERE p.retailPrice = :retailPrice"),
    @NamedQuery(name = "Product.findByStatus", query = "SELECT p FROM Product p WHERE p.status = :status")})
public class Product implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "barcode")
    private String barcode;
    @Column(name = "brand_id")
    private String brandId;
    @Column(name = "cat_id")
    private String catId;
    @Column(name = "cost_price")
    private String costPrice;
    @Column(name = "description")
    private String description;
    @Column(name = "product")
    private String product;
    @Column(name = "qty")
    private String qty;
    @Column(name = "retail_price")
    private String retailPrice;
    @Column(name = "status")
    private String status;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        String oldBarcode = this.barcode;
        this.barcode = barcode;
        changeSupport.firePropertyChange("barcode", oldBarcode, barcode);
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        String oldBrandId = this.brandId;
        this.brandId = brandId;
        changeSupport.firePropertyChange("brandId", oldBrandId, brandId);
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        String oldCatId = this.catId;
        this.catId = catId;
        changeSupport.firePropertyChange("catId", oldCatId, catId);
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        String oldCostPrice = this.costPrice;
        this.costPrice = costPrice;
        changeSupport.firePropertyChange("costPrice", oldCostPrice, costPrice);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldDescription, description);
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        String oldProduct = this.product;
        this.product = product;
        changeSupport.firePropertyChange("product", oldProduct, product);
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        String oldQty = this.qty;
        this.qty = qty;
        changeSupport.firePropertyChange("qty", oldQty, qty);
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        String oldRetailPrice = this.retailPrice;
        this.retailPrice = retailPrice;
        changeSupport.firePropertyChange("retailPrice", oldRetailPrice, retailPrice);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Product[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

package ecopopHackaton.ecopop_back.products;

import com.fasterxml.jackson.annotation.JsonProperty;

import ecopopHackaton.ecopop_back.sellers.Seller;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id;
    
    @Column
    private String product_name;

    @Column
    private String descrip;

    @Column
    private Long price;

    @Column
    private String img;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String sellerName;

    public Product() {
    }

    public Product(String product_name, String descrip, Long price, String img, Seller seller) {
        this.product_name = product_name;
        this.descrip = descrip;
        this.price = price;
        this.img = img;
        this.seller = seller;
        // this.sellerName = sellerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
    
}

package sy.amjad.sales.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;


@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)//, columnDefinition = "BINARY(16)"
    @Type(type = "uuid-char")
    private UUID id = UUID.randomUUID();

    private String name, lastName, mobile;

    // client products
    @JsonIgnore
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Product> products;

    // client bought
    @JsonIgnore
    @OneToMany(mappedBy = "sold_to", cascade = CascadeType.ALL)
    private Set<Sale> boughtSales;

    public Client() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Sale> getBoughtSales() {
        return boughtSales;
    }

    public void setBoughtSales(Set<Sale> boughtSales) {
        this.boughtSales = boughtSales;
    }
}

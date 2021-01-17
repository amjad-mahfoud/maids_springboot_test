package sy.amjad.sales.domain;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table
public class Sale extends SaleTransaction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)//, columnDefinition = "BINARY(16)"
    @Type(type = "uuid-char")
    private UUID id = UUID.randomUUID();

    private Long total;
    private LocalDate creationDate;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private Set<SaleTransaction> transactionSet;

    @ManyToOne
    @JoinColumn(name = "sold_to_client_id", nullable = false)
    private Client sold_to;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Set<SaleTransaction> getTransactionSet() {
        return transactionSet;
    }

    public void setTransactionSet(Set<SaleTransaction> transactionSet) {
        this.transactionSet = transactionSet;
    }

    public Client getSold_to() {
        return sold_to;
    }

    public void setSold_to(Client sold_to) {
        this.sold_to = sold_to;
    }
}

package tech.gomes.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_invoice_items")
public class InvoiceItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "productId", nullable = false)
    private UUID productId;

    @Column(name = "unitPrice", nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "invoiceId", nullable = false)
    private UUID invoiceId;

    @Transient
    private BigDecimal totalItemValue;

    public InvoiceItemEntity() {
    }

    // Getters
    public Long getId() {
        return id;
    }

    public UUID getProductId() {
        return productId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public UUID getInvoiceId() {
        return invoiceId;
    }

    public BigDecimal getTotalItemValue() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setInvoiceId(UUID invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setTotalItemValue(BigDecimal totalItemValue) {
        this.totalItemValue = totalItemValue;
    }
}

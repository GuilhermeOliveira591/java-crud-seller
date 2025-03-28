package tech.gomes.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_invoice_entries")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "invoiceNumber", nullable = false)
    private String invoiceNumber;

    @Column(name = "issueDateTime", nullable = false)
    private LocalDateTime issueDateTime;

    @ManyToOne
    @JoinColumn(name = "supplierId", nullable = false)
    private UUID supplierId;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "total_value", nullable = false)
    private Double totalValue;

    public InvoiceEntity() {
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public LocalDateTime getIssueDateTime() {
        return issueDateTime;
    }

    public UUID getSupplierId() {
        return supplierId;
    }

    public String getAddress() {
        return address;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    // Setters
    public void setId(UUID id) {
        this.id = id;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    
    public void setIssueDateTime(LocalDateTime issueDateTime) {
        this.issueDateTime = issueDateTime;
    }

    public void setSupplierId(UUID supplierId) {
        this.supplierId = supplierId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
    
    
}

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
    private Long id;

    @Column(name = "invoiceNumber", nullable = false)
    private String invoiceNumber;

    @Column(name = "issueDateTime", nullable = false)
    private LocalDateTime issueDateTime;

    @Column(name = "supplierId", nullable = false)
    private UUID supplierId;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "totalValue", nullable = false)
    private Double totalValue;
    
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    
    @Embedded
    private AuditableFields auditableFields;
    
    @PrePersist
    public void onCreate() {
        if (auditableFields == null) {
            auditableFields = new AuditableFields();
        }
        auditableFields.setInclusionDate(LocalDateTime.now());
        this.isActive = true;
    }
    
    @PreUpdate
    public void onUpdate() {
        if (auditableFields == null) {
            auditableFields = new AuditableFields();
        }
        auditableFields.setModificationDate(LocalDateTime.now());
    }

    public InvoiceEntity() {
    }

    // Getters

    public Long getId() {
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

    public boolean isIsActive() {
        return isActive;
    }

    public AuditableFields getAuditableFields() {
        return auditableFields;
    }

    // Setters

    public void setId(Long id) {
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

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setAuditableFields(AuditableFields auditableFields) {
        this.auditableFields = auditableFields;
    }
    
}

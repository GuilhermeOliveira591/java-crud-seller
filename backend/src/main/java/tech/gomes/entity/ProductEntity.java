
package tech.gomes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_products")

public class ProductEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "code", nullable = false)
    private UUID productId;
    
    @Column(name = "description", nullable = false)
    private String description;
    
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
    
    public ProductEntity() {
    }
    
    // getters
    public UUID getProductId() {
        return productId;
    }   

    public String getDescription() {
        return description;
    }
    
    public boolean isIsActive() {
        return isActive;
    }
    
    public AuditableFields getAuditableFields() {
        return auditableFields;
    }
    
    // setters
    public void setProductId(UUID productId) {
        this.productId = productId;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }   

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }  

    public void setAuditableFields(AuditableFields auditableFields) {
        this.auditableFields = auditableFields;
    }
    
    
    
    
    

}


package tech.gomes.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_products")

public class ProductEntity extends PanacheEntityBase{
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "code", nullable = false)
    public UUID productId;
    
    @Column(name = "description", nullable = false)
    public String description;
    
    @Column(name = "isActive", nullable = false)
    public boolean isActive;
    
    @Embedded
    public AuditableFields auditableFields;
    
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
    
    @PreRemove
    public void onDelete() {
        if (auditableFields == null) {
            auditableFields = new AuditableFields();
        }
        
        if(this.auditableFields.getModificationDate() == null && this.isActive == true){
            this.isActive = false;
            auditableFields.setModificationDate(LocalDateTime.now());
        }   
    }

}

package tech.gomes.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_suppliers")
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "code", nullable = false)
    private UUID supplierId;

    @Column(name = "razaoSocial", nullable = false)
    private String businessName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;
    
    @Column(name = "isActive", nullable = false)
    private boolean isActive;

    @Column(name = "cnpj", nullable = false, unique = true)
    private String cnpj;

    @Column(name = "situation", nullable = false)
    private String situation; 

    @Column(name = "cnpjDeactivationDate", nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate cnpjDeactivationDate;

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

    public SupplierEntity() {
    }
    
    public SupplierEntity(UUID supplierId) {
        this.supplierId = supplierId;
    }

    // Getters
    public UUID getSupplierId() {
        return supplierId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getSituation() {
        return situation;
    }
    
    public boolean isIsActive() {
        return isActive;
    }

    public LocalDate getCnpjDeactivationDate() {
        return cnpjDeactivationDate;
    }

    public AuditableFields getAuditableFields() {
        return auditableFields;
    }
    
    // Setters
    public void setSupplierId(UUID supplierId) {
        this.supplierId = supplierId;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public void setCnpjDeactivationDate(LocalDate cnpjDeactivationDate) {
        this.cnpjDeactivationDate = cnpjDeactivationDate;
    }

    public void setAuditableFields(AuditableFields auditableFields) {
        this.auditableFields = auditableFields;
    }
    
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}

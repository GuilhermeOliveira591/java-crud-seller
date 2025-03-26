package tech.gomes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class AuditableFields {

    @Column(name = "inclusion_date", nullable = false, updatable = false)
    private LocalDateTime inclusionDate;

    @Column(name = "modification_date", nullable = true, updatable = true)
    private LocalDateTime modificationDate;

    // Getters e Setters
    public LocalDateTime getInclusionDate() {
        return inclusionDate;
    }

    public void setInclusionDate(LocalDateTime inclusionDate) {
        this.inclusionDate = inclusionDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }
}

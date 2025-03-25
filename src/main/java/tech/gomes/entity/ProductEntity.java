
package tech.gomes.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    
    
}

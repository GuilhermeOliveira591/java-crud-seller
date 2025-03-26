package tech.gomes.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;
import tech.gomes.entity.ProductEntity;
import tech.gomes.exception.ProductCouldNotBeDeletedException;
import tech.gomes.exception.ProductNotFoundException;

@ApplicationScoped
public class ProductService {
    
    public ProductEntity createProduct(ProductEntity productEntity){
        ProductEntity.persist(productEntity);
        return productEntity;
    }
    
    public ProductEntity findById(UUID productId){
        return (ProductEntity) ProductEntity.findByIdOptional(productId)
            .orElseThrow(() -> new ProductNotFoundException("Product with ID " + productId + " not found"));
    }
    
    public List<ProductEntity> findAll(Integer page, Integer pageSize){
        return ProductEntity.findAll()
                .page(page, pageSize)
                .list();
    }

    public ProductEntity updateProduct(UUID productId, ProductEntity productEntity) {
        var product = findById(productId);
        
        product.description = productEntity.description;
        
        ProductEntity.persist(product);
        
        return product;
    }

    public void deleteById(UUID productId) {
        var product = findById(productId);
        
        if(product.auditableFields.getModificationDate() == null){
            ProductEntity.deleteById(product.productId);
        } else{
            throw new ProductCouldNotBeDeletedException("Product cannot be deleted because it has been modified before");
        }    
    }
    
}

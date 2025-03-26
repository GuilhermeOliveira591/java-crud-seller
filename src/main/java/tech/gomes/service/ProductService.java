package tech.gomes.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;
import tech.gomes.entity.ProductEntity;
import tech.gomes.exception.ProductNotFoundException;

@ApplicationScoped
public class ProductService {
    
    public ProductEntity createProduct(ProductEntity productEntity){
        ProductEntity.persist(productEntity);
        return productEntity;
    }
    
    public ProductEntity findById(UUID productId){
        return (ProductEntity) ProductEntity.findByIdOptional(productId)
                .orElseThrow(ProductNotFoundException::new);
    }
    
    public List<ProductEntity> findAll(Integer page, Integer pageSize){
        return ProductEntity.findAll()
                .page(page, pageSize)
                .list();
    }
    
}

package tech.gomes.service;

import jakarta.enterprise.context.ApplicationScoped;
import tech.gomes.entity.ProductEntity;

@ApplicationScoped
public class ProductService {
    
    public ProductEntity createProduct(ProductEntity productEntity){
        ProductEntity.persist(productEntity);
        return productEntity;
    }
    
}

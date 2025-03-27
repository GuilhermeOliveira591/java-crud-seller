package tech.gomes.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;
import tech.gomes.entity.ProductEntity;
import tech.gomes.exception.ProductCouldNotBeDeletedException;
import tech.gomes.exception.ProductNotFoundException;
import tech.gomes.repository.ProductRepository;

@ApplicationScoped
public class ProductService {
    
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public ProductEntity createProduct(ProductEntity productEntity){
        productRepository.persist(productEntity);
        return productEntity;
    }
    
    public ProductEntity findById(UUID productId){
        return (ProductEntity) productRepository.findByIdOptional(productId)
            .orElseThrow(() -> new ProductNotFoundException("Product with ID " + productId + " not found"));
    }
    
    public List<ProductEntity> findAll(Integer page, Integer pageSize){
        return productRepository.findAll()
                .page(page, pageSize)
                .list();
    }

    public ProductEntity updateProduct(UUID productId, ProductEntity productEntity) {
        var product = findById(productId);
        
        product.setDescription(productEntity.getDescription());
        
        productRepository.persist(product);
        
        return product;
    }

    public void deleteById(UUID productId) {
        var product = findById(productId);
        
        if(product.getAuditableFields().getModificationDate() == null){
            productRepository.deleteById(product.getProductId());
        } else{
            throw new ProductCouldNotBeDeletedException("Product cannot be deleted because it has been modified before");
        }    
    }
    
}

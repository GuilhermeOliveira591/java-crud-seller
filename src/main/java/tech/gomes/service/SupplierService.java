package tech.gomes.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;
import tech.gomes.entity.SupplierEntity;
import tech.gomes.exception.SupplierCouldNotBeCreatedException;
import tech.gomes.exception.SupplierCouldNotBeDeletedException;
import tech.gomes.exception.SupplierNotFoundException;
import tech.gomes.repository.SupplierRepository;

@ApplicationScoped
public class SupplierService {
    
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
    
    public SupplierEntity createSupplier(SupplierEntity supplierEntity){
        if(findByCnpj(supplierEntity.getCnpj()) != null){
            throw new SupplierCouldNotBeCreatedException("Supplier with CNPJ " + supplierEntity.getCnpj() + " already exists in the database");
        }
        
        supplierRepository.persist(supplierEntity);
        return supplierEntity;
    }
    
    public SupplierEntity findById(UUID supplierId){
        return (SupplierEntity) supplierRepository.findByIdOptional(supplierId)
            .orElseThrow(() -> new SupplierNotFoundException("Supplier with ID " + supplierId + " not found"));
    }
    
    public SupplierEntity findByCnpj(String cnpj){
        return supplierRepository.find("cnpj = ?1", cnpj)
                .firstResultOptional()
                .orElse(null);
    }
    
    public List<SupplierEntity> findAll(Integer page, Integer pageSize){
        return supplierRepository.findAll()
                .page(page, pageSize)
                .list();
    }

    public SupplierEntity updateSupplier(UUID supplierId, SupplierEntity supplierEntity) {
        var supplier = findById(supplierId);
        
        supplier.setBusinessName(supplierEntity.getBusinessName());
        supplier.setEmail(supplierEntity.getEmail());
        supplier.setPhone(supplierEntity.getPhone());
        supplier.setCnpj(supplierEntity.getCnpj());
        supplier.setSituation(supplierEntity.getSituation());
        supplier.setCnpjDeactivationDate(supplierEntity.getCnpjDeactivationDate());
        
        supplierRepository.persist(supplier);
        
        return supplier;
    }

    public void deleteById(UUID supplierId) {
        var supplier = findById(supplierId);
        
        if(supplier.getAuditableFields().getModificationDate() == null){
            supplierRepository.deleteById(supplier.getSupplierId());
        } else{
            throw new SupplierCouldNotBeDeletedException("Supplier cannot be deleted because it has been modified before");
        }    
    }
    
}

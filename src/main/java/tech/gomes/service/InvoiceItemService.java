package tech.gomes.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import tech.gomes.entity.InvoiceEntity;
import tech.gomes.entity.InvoiceItemEntity;
import tech.gomes.exception.NotFoundException;
import tech.gomes.repository.InvoiceItemRepository;
import tech.gomes.repository.InvoiceRepository;

@ApplicationScoped
public class InvoiceItemService {
    
    private final InvoiceItemRepository invoiceItemRepository;

    public InvoiceItemService(InvoiceItemRepository invoiceItemRepository) {
        this.invoiceItemRepository = invoiceItemRepository;
    }
    
    public InvoiceItemEntity createInvoiceItem(InvoiceItemEntity invoiceItemEntity){
        invoiceItemRepository.persist(invoiceItemEntity);
        return invoiceItemEntity;
    }
    
    public InvoiceItemEntity findById(Long id){
        return (InvoiceItemEntity) invoiceItemRepository.findByIdOptional(id)
            .orElseThrow(() -> new NotFoundException("Supplier with ID " + id + " not found"));
    }
    
    public List<InvoiceItemEntity> findAll(Integer page, Integer pageSize){
        return invoiceItemRepository.findAll()
                .page(page, pageSize)
                .list();
    }

    public InvoiceItemEntity updateInvoiceItem(Long id, InvoiceItemEntity invoiceItemEntity){
        var invoiceItem = findById(id);
        
        invoiceItem.setProductId(invoiceItemEntity.getProductId());
        invoiceItem.setUnitPrice(invoiceItemEntity.getUnitPrice());
        invoiceItem.setQuantity(invoiceItemEntity.getQuantity());
        
        invoiceItemRepository.persist(invoiceItem);
        
        return invoiceItem;
    }

    public void deleteById(Long id) {
        var invoice = findById(id);
        
        invoiceItemRepository.deleteById(invoice.getId()); 
    }
    
}

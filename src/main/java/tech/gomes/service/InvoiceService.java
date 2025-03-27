package tech.gomes.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;
import tech.gomes.entity.InvoiceEntity;
import tech.gomes.entity.SupplierEntity;
import tech.gomes.exception.NotFoundException;
import tech.gomes.repository.InvoiceRepository;

@ApplicationScoped
public class InvoiceService {
    
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
    
    public InvoiceEntity createInvoice(InvoiceEntity invoiceEntity){
        invoiceRepository.persist(invoiceEntity);
        return invoiceEntity;
    }
    
    public InvoiceEntity findById(UUID invoiceId){
        return (InvoiceEntity) invoiceRepository.findByIdOptional(invoiceId)
                .orElseThrow(() -> new NotFoundException("Invoice with ID " + invoiceId + " not found"));
    }
    
    public List<InvoiceEntity> findAll(Integer page, Integer pageSize){
        return invoiceRepository.findAll()
                .page(page, pageSize)
                .list();
    }

    public InvoiceEntity updateInvoice(UUID invoiceId, InvoiceEntity invoiceEntity){
        var invoice = findById(invoiceEntity.getId());
        
        invoice.setInvoiceNumber(invoiceEntity.getInvoiceNumber());
        invoice.setIssueDateTime(invoiceEntity.getIssueDateTime());        
        invoice.setSupplier(new SupplierEntity(invoiceId));
        invoice.setAddress(invoiceEntity.getAddress());
        invoice.setTotalValue(invoiceEntity.getTotalValue());
        
        invoiceRepository.persist(invoice);
        
        return invoice;
    }

    public void deleteById(UUID invoiceId) {
        var invoice = findById(invoiceId);
        
        invoiceRepository.deleteById(invoice.getId()); 
    }
    
}

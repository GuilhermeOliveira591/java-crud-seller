package tech.gomes.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import tech.gomes.entity.InvoiceEntity;
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
    
    public InvoiceEntity findById(Long id){
        return (InvoiceEntity) invoiceRepository.findByIdOptional(id)
            .orElseThrow(() -> new NotFoundException("Invoice with ID " + id + " not found"));
    }
    
    public List<InvoiceEntity> findAll(Integer page, Integer pageSize){
        return invoiceRepository.findAll()
                .page(page, pageSize)
                .list();
    }

    public InvoiceEntity updateInvoice(Long id, InvoiceEntity invoiceEntity){
        var invoice = findById(id);
        
        invoice.setInvoiceNumber(invoiceEntity.getInvoiceNumber());
        invoice.setIssueDateTime(invoiceEntity.getIssueDateTime());  
        invoice.setSupplierId(invoiceEntity.getSupplierId());      
        invoice.setAddress(invoiceEntity.getAddress());
        invoice.setTotalValue(invoiceEntity.getTotalValue());
        
        invoiceRepository.persist(invoice);
        
        return invoice;
    }

    public void deleteById(Long id) {
        var invoice = findById(id);
        
        invoiceRepository.deleteById(invoice.getId()); 
    }
    
}


package tech.gomes.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import tech.gomes.entity.InvoiceItemEntity;

@ApplicationScoped
public class InvoiceItemRepository implements PanacheRepositoryBase<InvoiceItemEntity, Long> {
}


package tech.gomes.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.UUID;
import tech.gomes.entity.InvoiceEntity;

@ApplicationScoped
public class InvoiceRepository implements PanacheRepositoryBase<InvoiceEntity, UUID> {
}

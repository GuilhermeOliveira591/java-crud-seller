package tech.gomes.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import tech.gomes.entity.SupplierEntity;
import java.util.UUID;


@ApplicationScoped
public class SupplierRepository implements PanacheRepositoryBase<SupplierEntity, UUID> {
}
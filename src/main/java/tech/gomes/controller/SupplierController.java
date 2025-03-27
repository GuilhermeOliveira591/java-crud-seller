
package tech.gomes.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.UUID;
import tech.gomes.entity.SupplierEntity;
import tech.gomes.service.SupplierService;

@Path("suppliers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class SupplierController {  
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    } 
    
    // GET ENDPOINTS
    
    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page
            ,@QueryParam("pageSize") @DefaultValue("10") Integer pageSize
    ){
        var suppliers = supplierService.findAll(page, pageSize);
        return Response.ok(suppliers).build();
    }
    
    @GET
    @Path("/{id}")
    public Response findById (@PathParam("id") UUID supplierId){
        return Response.ok(supplierService.findById(supplierId)).build();
    }

    // POST ENDPOINT
    @POST
    @Transactional
    public Response createSupplier(SupplierEntity supplierEntity){
        return Response.ok(supplierService.createSupplier(supplierEntity)).build();
    }
    
    // PUT ENDPOINT
    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateSupplier(@PathParam("id") UUID supplierId, SupplierEntity supplierEntity){
        return Response.ok(supplierService.updateSupplier(supplierId, supplierEntity)).build();
    }
   
    // DELETE ENDPOINT
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") UUID supplierId){
        supplierService.deleteById(supplierId);
        return Response.noContent().build();
    }
    
}

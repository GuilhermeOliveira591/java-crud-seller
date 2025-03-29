
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
import tech.gomes.entity.InvoiceItemEntity;
import tech.gomes.service.InvoiceItemService;

@Path("invoiceItems")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class InvoiceItemController {  
    private final InvoiceItemService invoiceItemService;

    public InvoiceItemController(InvoiceItemService invoiceItemService) {
        this.invoiceItemService = invoiceItemService;
    }

    // GET ENDPOINTS
    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page
            ,@QueryParam("pageSize") @DefaultValue("10") Integer pageSize
    ){
        var invoices = invoiceItemService.findAll(page, pageSize);
        return Response.ok(invoices).build();
    }
    
    @GET
    @Path("/{id}")
    public Response findById (@PathParam("id") Long id){
        return Response.ok(invoiceItemService.findById(id)).build();
    }

    // POST ENDPOINT
    @POST
    @Transactional
    public Response createInvoiceItem(InvoiceItemEntity invoiceItemEntity){
        return Response.ok(invoiceItemService.createInvoiceItem(invoiceItemEntity)).build();
    }
    
    // PUT ENDPOINT
    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateInvoiceItem(@PathParam("id") Long id, InvoiceItemEntity invoiceItemEntity){
        return Response.ok(invoiceItemService.updateInvoiceItem(id, invoiceItemEntity)).build();
    }
   
    // DELETE ENDPOINT
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Long id){
        invoiceItemService.deleteById(id);
        return Response.noContent().build();
    }
    
}


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
import tech.gomes.entity.InvoiceEntity;
import tech.gomes.service.InvoiceService;

@Path("invoices")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class InvoiceController {  
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    // GET ENDPOINTS
    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page
            ,@QueryParam("pageSize") @DefaultValue("10") Integer pageSize
    ){
        var invoices = invoiceService.findAll(page, pageSize);
        return Response.ok(invoices).build();
    }
    
    @GET
    @Path("/{id}")
    public Response findById (@PathParam("id") Long id){
        return Response.ok(invoiceService.findById(id)).build();
    }

    // POST ENDPOINT
    @POST
    @Transactional
    public Response createInvoice(InvoiceEntity invoiceEntity){
        return Response.ok(invoiceService.createInvoice(invoiceEntity)).build();
    }
    
    // PUT ENDPOINT
    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateInvoice(@PathParam("id") Long id, InvoiceEntity invoiceEntity){
        return Response.ok(invoiceService.updateInvoice(id, invoiceEntity)).build();
    }
   
    // DELETE ENDPOINT
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") Long id){
        invoiceService.deleteById(id);
        return Response.noContent().build();
    }
    
}

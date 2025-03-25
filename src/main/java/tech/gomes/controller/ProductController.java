
package tech.gomes.controller;

import jakarta.transaction.Transactional;
import tech.gomes.entity.ProductEntity;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import tech.gomes.service.ProductService;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ProductController {  
    private final ProductService productService;
    
    public ProductController(ProductService productService){
        this.productService = productService;
    }   
    
    @POST
    @Transactional
    public Response createProduct(ProductEntity productEntity){
        return Response.ok(productService.createProduct(productEntity)).build();
    }
}

package tech.gomes.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


@Provider
public class ProductNotFoundMapper implements ExceptionMapper<ProductNotFoundException>{

    @Override
    public Response toResponse(ProductNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND.getStatusCode(), "Product Not Found").build();
    }
    
}

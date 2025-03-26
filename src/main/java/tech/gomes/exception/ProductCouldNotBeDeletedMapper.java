package tech.gomes.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.Map;


@Provider
public class ProductCouldNotBeDeletedMapper implements ExceptionMapper<ProductCouldNotBeDeletedException>{

    @Override
    public Response toResponse(ProductCouldNotBeDeletedException exception) {
         return Response.status(Response.Status.CONFLICT)
                       .entity(Map.of("message", exception.getMessage()))
                       .build();
    }
    
}

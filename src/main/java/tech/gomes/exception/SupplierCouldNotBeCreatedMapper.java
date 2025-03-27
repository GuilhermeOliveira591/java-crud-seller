package tech.gomes.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.Map;


@Provider
public class SupplierCouldNotBeCreatedMapper implements ExceptionMapper<SupplierCouldNotBeCreatedException>{

    @Override
    public Response toResponse(SupplierCouldNotBeCreatedException exception) {
         return Response.status(Response.Status.CONFLICT)
                       .entity(Map.of("message", exception.getMessage()))
                       .build();
    }
    
}

package tech.gomes.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.Map;


@Provider
public class SupplierNotFoundMapper implements ExceptionMapper<SupplierNotFoundException>{

    @Override
    public Response toResponse(SupplierNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(Map.of("message", exception.getMessage()))
                .build();
    }
    
}

package test.io.smallrye.openapi.runtime.scanner.javax;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@APIResponse(responseCode = "500", description = "Default Exception Handler Internal Server Error")
public class DefaultExceptionHandler implements ExceptionMapper<WebApplicationException> {
    @Override
    public Response toResponse(WebApplicationException exception) {
        return null;
    }
}

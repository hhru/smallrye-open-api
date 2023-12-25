package test.io.smallrye.openapi.runtime.scanner.javax;

import javax.annotation.Priority;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Priority(1)
@APIResponse(responseCode = "500", description = "Priority 1 Internal Server Error")
public class PriorityOneExceptionHandler implements ExceptionMapper<WebApplicationException> {
    @Override
    public Response toResponse(WebApplicationException exception) {
        return null;
    }
}
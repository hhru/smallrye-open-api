package test.io.smallrye.openapi.runtime.scanner.javax;

import javax.annotation.Priority;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@APIResponse(responseCode = "500", description = "Low Priority Exception Handler Internal Server Error")
@Priority(Integer.MAX_VALUE)
public class LowPriorityExceptionHandler implements ExceptionMapper<WebApplicationException> {
    @Override
    public Response toResponse(WebApplicationException exception) {
        return null;
    }
}

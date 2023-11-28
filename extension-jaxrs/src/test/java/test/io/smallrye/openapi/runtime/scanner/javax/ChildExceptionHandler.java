package test.io.smallrye.openapi.runtime.scanner.javax;

import javax.annotation.Priority;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@APIResponse(responseCode = "500", description = "Child Exception Mapper Internal Server Error")
@Priority(1)
public class ChildExceptionHandler extends ParentExceptionHandler {

    @Override
    public Response toResponse(WebApplicationException exception) {
        return super.toResponse(exception);
    }
}

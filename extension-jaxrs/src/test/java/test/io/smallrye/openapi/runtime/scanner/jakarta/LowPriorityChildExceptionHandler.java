package test.io.smallrye.openapi.runtime.scanner.jakarta;

import jakarta.annotation.Priority;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@APIResponse(responseCode = "500", description = "Low Priority Child Exception Handler Internal Server Error")
@Priority(Integer.MAX_VALUE)
public class LowPriorityChildExceptionHandler extends HighPriorityParentExceptionHandler {
}

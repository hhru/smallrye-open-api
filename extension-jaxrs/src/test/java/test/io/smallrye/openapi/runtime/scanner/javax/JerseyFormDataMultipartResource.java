package test.io.smallrye.openapi.runtime.scanner.javax;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path(value = "/jersey-form-data-multi-part")
@Produces(MediaType.TEXT_PLAIN)
public class JerseyFormDataMultipartResource {

    @POST
    @Consumes("multipart/form-data")
    public String receiveMultipart(@FormDataParam("multipartView") FormDataMultiPart multipartView)
            throws WebApplicationException {
        return "OK";
    }
}

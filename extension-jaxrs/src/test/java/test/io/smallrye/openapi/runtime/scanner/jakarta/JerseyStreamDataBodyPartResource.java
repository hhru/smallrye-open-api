package test.io.smallrye.openapi.runtime.scanner.jakarta;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.media.multipart.file.StreamDataBodyPart;

@Path(value = "/jersey-stream-data-body-part")
@Produces(MediaType.TEXT_PLAIN)
public class JerseyStreamDataBodyPartResource {

    @POST
    @Consumes("multipart/form-data")
    public String receiveFileStream(@FormDataParam("file") StreamDataBodyPart streamDataBodyPart)
            throws WebApplicationException {
        return "OK";
    }
}

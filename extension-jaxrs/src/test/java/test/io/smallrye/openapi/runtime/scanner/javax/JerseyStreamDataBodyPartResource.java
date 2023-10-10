package test.io.smallrye.openapi.runtime.scanner.javax;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

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

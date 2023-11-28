package test.io.smallrye.openapi.runtime.scanner.javax;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

@Path(value = "/jersey-file-data-body-part")
@Produces(MediaType.TEXT_PLAIN)
public class JerseyFileDataBodyPartResource {

    @POST
    @Consumes("multipart/form-data")
    public String receiveFile(@FormDataParam("file") FileDataBodyPart fileDataBodyPart) throws WebApplicationException {
        return "OK";
    }
}

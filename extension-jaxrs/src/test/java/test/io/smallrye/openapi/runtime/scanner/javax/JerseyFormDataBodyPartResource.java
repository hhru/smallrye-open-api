package test.io.smallrye.openapi.runtime.scanner.javax;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path(value = "/jersey-form-data-body-part")
@Produces(MediaType.TEXT_PLAIN)
public class JerseyFormDataBodyPartResource {

    @POST
    @Consumes("multipart/form-data")
    public String receiveBodyParts(@FormDataParam("collectionOfBodyParts") Collection<FormDataBodyPart> bodyParts)
            throws WebApplicationException {
        return "OK";
    }
}

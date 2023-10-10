package test.io.smallrye.openapi.runtime.scanner.javax;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path(value = "/jersey-form-data-content-disposition")
@Produces(MediaType.TEXT_PLAIN)
public class JerseyFormDataContentDispositionResource {

    @POST
    @Consumes("multipart/form-data")
    public String receiveFileAndContentDisposition(
            @FormDataParam("file") InputStream file,
            @FormDataParam("file") FormDataContentDisposition fileContentDispositionHeader) throws WebApplicationException {
        return "OK";
    }
}

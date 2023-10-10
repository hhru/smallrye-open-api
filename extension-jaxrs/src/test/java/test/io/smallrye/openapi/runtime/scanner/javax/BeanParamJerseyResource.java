package test.io.smallrye.openapi.runtime.scanner.javax;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/bean-param-jersey")
@Produces(MediaType.APPLICATION_JSON)
public class BeanParamJerseyResource {

    public static class JerseyBean {

        @FormDataParam("primitiveString")
        String string;

        @FormDataParam("primitiveInteger")
        Integer integer;

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }

        public Integer getInteger() {
            return integer;
        }

        public void setInteger(Integer integer) {
            this.integer = integer;
        }
    }

    @POST
    @Consumes("multipart/form-data")
    public String receiveMultipart(@BeanParam JerseyBean jerseyBean) throws WebApplicationException {
        return "OK";
    }
}

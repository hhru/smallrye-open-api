package test.io.smallrye.openapi.runtime.scanner.javax;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(value = "/bean-param-enum-default-value-for-endpoint")
public class BeanParamEnumDefaultValueForEndpointResource {

    public static class SimpleBeanParam {
        @FormParam("petEnum")
        @DefaultValue("LIZARD")
        private PetEnum petEnum;

        public SimpleBeanParam() {
        }

        public PetEnum getPetEnum() {
            return petEnum;
        }

        public void setPetEnum(PetEnum petEnum) {
            this.petEnum = petEnum;
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response create(@BeanParam SimpleBeanParam beanParam) {
        return Response.ok(beanParam.getPetEnum().name()).build();
    }
}

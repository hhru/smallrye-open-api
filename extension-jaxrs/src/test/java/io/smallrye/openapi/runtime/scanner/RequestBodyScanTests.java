package io.smallrye.openapi.runtime.scanner;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.jboss.jandex.Index;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

class RequestBodyScanTests extends IndexScannerTestBase {

    private static void test(String expectedResource, Class<?>... classes) throws IOException, JSONException {
        Index index = indexOf(classes);
        OpenApiAnnotationScanner scanner = new OpenApiAnnotationScanner(dynamicConfig(new HashMap<String, String>()), index);
        OpenAPI result = scanner.scan();
        printToConsole(result);
        assertJsonEquals(expectedResource, result);
    }

    @Test
    void testJavaxResteasyMultipartInput() throws IOException, JSONException {
        test("params.resteasy-multipart-mixed.json",
                test.io.smallrye.openapi.runtime.scanner.javax.ResteasyMultipartInputTestResource.class);
    }

    @Test
    void testJakartaResteasyMultipartInput() throws IOException, JSONException {
        test("params.resteasy-multipart-mixed.json",
                test.io.smallrye.openapi.runtime.scanner.jakarta.ResteasyMultipartInputTestResource.class);
    }

    @Test
    void testJavaxResteasyMultipartInputList() throws IOException, JSONException {
        test("params.resteasy-multipart-mixed-array.json",
                test.io.smallrye.openapi.runtime.scanner.javax.ResteasyMultipartMixedListTestResource.class,
                test.io.smallrye.openapi.runtime.scanner.RequestBodyWidget.class);
    }

    @Test
    void testJakartaResteasyMultipartInputList() throws IOException, JSONException {
        test("params.resteasy-multipart-mixed-array.json",
                test.io.smallrye.openapi.runtime.scanner.jakarta.ResteasyMultipartMixedListTestResource.class,
                test.io.smallrye.openapi.runtime.scanner.RequestBodyWidget.class);
    }

    @Test
    void testJavaxResteasyMultipartFormDataInput() throws IOException, JSONException {
        test("params.resteasy-multipart-form-data-input.json",
                javax.ws.rs.core.HttpHeaders.class,
                test.io.smallrye.openapi.runtime.scanner.javax.ResteasyMultipartFormDataInputTestResource.class);
    }

    @Test
    void testJakartaResteasyMultipartFormDataInput() throws IOException, JSONException {
        test("params.resteasy-multipart-form-data-input.json",
                jakarta.ws.rs.core.HttpHeaders.class,
                test.io.smallrye.openapi.runtime.scanner.jakarta.ResteasyMultipartFormDataInputTestResource.class);
    }

    @Test
    void testJavaxResteasyMultipartFormDataMap() throws IOException, JSONException {
        test("params.resteasy-multipart-form-data-map.json",
                test.io.smallrye.openapi.runtime.scanner.javax.ResteasyMultipartFormDataMapTestResource.class,
                test.io.smallrye.openapi.runtime.scanner.RequestBodyWidget.class);
    }

    @Test
    void testJakartaResteasyMultipartFormDataMap() throws IOException, JSONException {
        test("params.resteasy-multipart-form-data-map.json",
                test.io.smallrye.openapi.runtime.scanner.jakarta.ResteasyMultipartFormDataMapTestResource.class,
                test.io.smallrye.openapi.runtime.scanner.RequestBodyWidget.class);
    }

    @Test
    void testJavaxResteasyMultipartRelatedInput() throws IOException, JSONException {
        test("params.resteasy-multipart-related-input.json",
                test.io.smallrye.openapi.runtime.scanner.javax.ResteasyMultipartRelatedInputTestResource.class);
    }

    @Test
    void testJakartaResteasyMultipartRelatedInput() throws IOException, JSONException {
        test("params.resteasy-multipart-related-input.json",
                test.io.smallrye.openapi.runtime.scanner.jakarta.ResteasyMultipartRelatedInputTestResource.class);
    }

    @Test
    void testRequestBodyMethodParameterConstraints() throws Exception {
        @jakarta.ws.rs.Path("/")
        class Resource {
            @jakarta.ws.rs.POST
            @jakarta.ws.rs.Consumes("text/plain")
            @jakarta.ws.rs.Path("foos")
            public void addFoo(@jakarta.validation.constraints.NotEmpty String foo) {
            }

            @jakarta.ws.rs.POST
            @jakarta.ws.rs.Consumes("text/plain")
            @jakarta.ws.rs.Path("bars")
            @RequestBody(required = false)
            public void addBar(@jakarta.validation.constraints.NotEmpty String foo) {
            }
        }
        test("params.request-body-constraints.json", Resource.class);
    }

    @Test
    void testJavaxJerseyFormDataMultiPart() throws IOException, JSONException {
        test("params.jersey-form-data-multipart.json",
                test.io.smallrye.openapi.runtime.scanner.javax.JerseyFormDataMultipartResource.class);
    }

    @Test
    void testJavaxJerseyFormDataBodyPart() throws IOException, JSONException {
        test("params.jersey-form-data-body-part.json",
                test.io.smallrye.openapi.runtime.scanner.javax.JerseyFormDataBodyPartResource.class);
    }

    @Test
    void testJavaxJerseyFileDataBodyPart() throws IOException, JSONException {
        test("params.jersey-file-data-body-part.json",
                test.io.smallrye.openapi.runtime.scanner.javax.JerseyFileDataBodyPartResource.class);
    }

    @Test
    void testJavaxJerseyStreamDataBodyPart() throws IOException, JSONException {
        test("params.jersey-stream-data-body-part.json",
                test.io.smallrye.openapi.runtime.scanner.javax.JerseyStreamDataBodyPartResource.class);
    }

    @Test
    void testJavaxJerseyFormDataContentDisposition() throws IOException, JSONException {
        test("params.jersey-form-data-content-disposition.json",
                test.io.smallrye.openapi.runtime.scanner.javax.JerseyFormDataContentDispositionResource.class);
    }

    @Test
    void testJakartaJerseyFormDataMultiPart() throws IOException, JSONException {
        test("params.jersey-form-data-multipart.json",
                test.io.smallrye.openapi.runtime.scanner.jakarta.JerseyFormDataMultipartResource.class);
    }

    @Test
    void testJakartaJerseyFormDataBodyPart() throws IOException, JSONException {
        test("params.jersey-form-data-body-part.json",
                test.io.smallrye.openapi.runtime.scanner.jakarta.JerseyFormDataBodyPartResource.class);
    }

    @Test
    void testJakartaJerseyFileDataBodyPart() throws IOException, JSONException {
        test("params.jersey-file-data-body-part.json",
                test.io.smallrye.openapi.runtime.scanner.jakarta.JerseyFileDataBodyPartResource.class);
    }

    @Test
    void testJakartaJerseyStreamDataBodyPart() throws IOException, JSONException {
        test("params.jersey-stream-data-body-part.json",
                test.io.smallrye.openapi.runtime.scanner.jakarta.JerseyStreamDataBodyPartResource.class);
    }

    @Test
    void testJakartaJerseyFormDataContentDisposition() throws IOException, JSONException {
        test("params.jersey-form-data-content-disposition.json",
                test.io.smallrye.openapi.runtime.scanner.jakarta.JerseyFormDataContentDispositionResource.class);
    }
}

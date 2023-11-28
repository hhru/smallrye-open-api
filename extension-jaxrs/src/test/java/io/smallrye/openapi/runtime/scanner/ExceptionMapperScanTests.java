package io.smallrye.openapi.runtime.scanner;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.jboss.jandex.Index;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

import test.io.smallrye.openapi.runtime.scanner.jakarta.PriorityOneExceptionHandler;
import test.io.smallrye.openapi.runtime.scanner.jakarta.PriorityTwoExceptionHandler;

class ExceptionMapperScanTests extends IndexScannerTestBase {

    private static void test(String expectedResource, Class<?>... classes) throws IOException, JSONException {
        Index index = indexOf(classes);
        OpenApiAnnotationScanner scanner = new OpenApiAnnotationScanner(dynamicConfig(new HashMap<String, String>()), index);
        OpenAPI result = scanner.scan();
        printToConsole(result);
        assertJsonEquals(expectedResource, result);
    }

    @Test
    void testJavaxExceptionMapper() throws IOException, JSONException {
        test("responses.exception-mapper-generation.json",
                test.io.smallrye.openapi.runtime.scanner.javax.TestResource.class,
                test.io.smallrye.openapi.runtime.scanner.javax.ExceptionHandler1.class,
                test.io.smallrye.openapi.runtime.scanner.javax.ExceptionHandler2.class,
                test.io.smallrye.openapi.runtime.scanner.javax.ResteasyReactiveExceptionMapper.class);
    }

    @Test
    void testJakartaExceptionMapper() throws IOException, JSONException {
        test("responses.exception-mapper-generation.json",
                test.io.smallrye.openapi.runtime.scanner.jakarta.TestResource.class,
                test.io.smallrye.openapi.runtime.scanner.jakarta.ExceptionHandler1.class,
                test.io.smallrye.openapi.runtime.scanner.jakarta.ExceptionHandler2.class,
                test.io.smallrye.openapi.runtime.scanner.jakarta.ResteasyReactiveExceptionMapper.class);
    }

    @Test
    void testJavaxDefaultExceptionMapper() throws IOException, JSONException {
        test("responses.exception-mapper-with-low-priority-overridden-by-default-exception-mapper.json",
                test.io.smallrye.openapi.runtime.scanner.javax.TestResource.class,
                test.io.smallrye.openapi.runtime.scanner.javax.LowPriorityExceptionHandler.class,
                test.io.smallrye.openapi.runtime.scanner.javax.DefaultExceptionHandler.class);
    }

    @Test
    void testJakartaDefaultExceptionMapper() throws IOException, JSONException {
        test("responses.exception-mapper-with-low-priority-overridden-by-default-exception-mapper.json",
                test.io.smallrye.openapi.runtime.scanner.jakarta.TestResource.class,
                test.io.smallrye.openapi.runtime.scanner.jakarta.LowPriorityExceptionHandler.class,
                test.io.smallrye.openapi.runtime.scanner.jakarta.DefaultExceptionHandler.class);
    }

    @Test
    void testJavaxHighPriorityParentExceptionMapper() throws IOException, JSONException {
        test("responses.child-exception-mapper-with-low-priority-overridden-by-parent-exception-mapper-with-high-priority.json",
                test.io.smallrye.openapi.runtime.scanner.javax.TestResource.class,
                test.io.smallrye.openapi.runtime.scanner.javax.HighPriorityParentExceptionHandler.class,
                test.io.smallrye.openapi.runtime.scanner.javax.LowPriorityChildExceptionHandler.class);
    }

    @Test
    void testJakartaHighPriorityParentExceptionMapper() throws IOException, JSONException {
        test("responses.child-exception-mapper-with-low-priority-overridden-by-parent-exception-mapper-with-high-priority.json",
                test.io.smallrye.openapi.runtime.scanner.jakarta.TestResource.class,
                test.io.smallrye.openapi.runtime.scanner.jakarta.HighPriorityParentExceptionHandler.class,
                test.io.smallrye.openapi.runtime.scanner.jakarta.LowPriorityChildExceptionHandler.class);
    }

    @Test
    void testJavaxMethodAnnotationOverrideExceptionMapper() throws IOException, JSONException {
        test("responses.exception-mapper-overridden-by-method-annotation-generation.json",
                test.io.smallrye.openapi.runtime.scanner.javax.TestResource2.class,
                test.io.smallrye.openapi.runtime.scanner.javax.ExceptionHandler1.class,
                test.io.smallrye.openapi.runtime.scanner.javax.ExceptionHandler2.class,
                test.io.smallrye.openapi.runtime.scanner.javax.ResteasyReactiveExceptionMapper.class);
    }

    @Test
    void testJakartaMethodAnnotationOverrideExceptionMapper() throws IOException, JSONException {
        test("responses.exception-mapper-overridden-by-method-annotation-generation.json",
                test.io.smallrye.openapi.runtime.scanner.jakarta.TestResource2.class,
                test.io.smallrye.openapi.runtime.scanner.jakarta.ExceptionHandler1.class,
                test.io.smallrye.openapi.runtime.scanner.jakarta.ExceptionHandler2.class,
                test.io.smallrye.openapi.runtime.scanner.jakarta.ResteasyReactiveExceptionMapper.class);
    }

    @Test
    void testJakartaExceptionMapperMultipleResponse() throws IOException, JSONException {
        test("responses.exception-mapper-multiple-response-generation.json",
                test.io.smallrye.openapi.runtime.scanner.jakarta.TestResource.class,
                test.io.smallrye.openapi.runtime.scanner.jakarta.ExceptionHandler3.class);
    }

    @Test
    void testJavaxChildExceptionMapperOverridesParentExceptionMapper() throws IOException, JSONException {
        test("responses.exception-mapper-parent-overridden-by-exception-mapper-child.json",
                test.io.smallrye.openapi.runtime.scanner.javax.TestResource.class,
                test.io.smallrye.openapi.runtime.scanner.javax.ParentExceptionHandler.class,
                test.io.smallrye.openapi.runtime.scanner.javax.ChildExceptionHandler.class);
    }

    @Test
    void testJavaxPriorityOverrideExceptionMapper() throws IOException, JSONException {
        test("responses.exception-mapper-priority-overridden.json",
                test.io.smallrye.openapi.runtime.scanner.javax.TestResource.class,
                test.io.smallrye.openapi.runtime.scanner.javax.PriorityOneExceptionHandler.class,
                test.io.smallrye.openapi.runtime.scanner.javax.PriorityTwoExceptionHandler.class);
    }

    @Test
    void testJakartaChildExceptionMapperOverridesParentExceptionMapper() throws IOException, JSONException {
        test("responses.exception-mapper-parent-overridden-by-exception-mapper-child.json",
                test.io.smallrye.openapi.runtime.scanner.jakarta.TestResource.class,
                test.io.smallrye.openapi.runtime.scanner.jakarta.ParentExceptionHandler.class,
                test.io.smallrye.openapi.runtime.scanner.jakarta.ChildExceptionHandler.class);
    }

    @Test
    void testJakartaPriorityOverrideExceptionMapper() throws IOException, JSONException {
        test("responses.exception-mapper-priority-overridden.json",
                test.io.smallrye.openapi.runtime.scanner.jakarta.TestResource.class,
                PriorityOneExceptionHandler.class,
                PriorityTwoExceptionHandler.class);
    }
}

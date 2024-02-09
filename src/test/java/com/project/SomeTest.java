package com.project;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.AnnotationUtils;

public class SomeTest implements TestCaseInterface {
    @Test
    void test() {
        AnnotationUtils.isAnnotated(getClass(), RemoteOnly.class);
        Assertions.fail("""
                this should not be executed with maxRemoteExecutors = 0
                getClass().getAnnotations(): %s
                AnnotationUtils.isAnnotated(getClass(), RemoteOnly.class): %s
                """.formatted(Arrays.toString(getClass().getAnnotations()),
                AnnotationUtils.isAnnotated(getClass(), RemoteOnly.class)));
    }
}

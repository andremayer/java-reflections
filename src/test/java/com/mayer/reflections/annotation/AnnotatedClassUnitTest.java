package com.mayer.reflections.annotation;

import org.junit.jupiter.api.Test;
import java.lang.annotation.Annotation;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class AnnotatedClassUnitTest {

    @Test
    public void checkIfClassIsDeprecated() {
        AnnotatedClass anAnnotatedClass = new AnnotatedClass();
        Annotation[] annotations = anAnnotatedClass.getClass().getAnnotations();
        assertThat(annotations, notNullValue());
        assertThat(annotations.length, is(2));
        assertThat(annotations[0].annotationType(), is(java.lang.Deprecated.class));
    }

    @Test
    public void checkClassAnnotationField() {
        AnnotatedClass anAnnotatedClass = new AnnotatedClass();
        Annotation[] annotations = anAnnotatedClass.getClass().getAnnotations();
        assertThat(annotations, notNullValue());
        assertThat(annotations.length, is(2));
        assertThat(annotations[1].annotationType().getDeclaredFields(), notNullValue());
        assertThat(((MyAnnotation)annotations[1]).customClassName(), is("MyCustomName"));
    }

}
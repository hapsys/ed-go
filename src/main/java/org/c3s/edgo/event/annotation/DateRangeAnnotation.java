package org.c3s.edgo.event.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface DateRangeAnnotation {
	String start() default "2000-01-01T00:00:00Z";
	String end() default "3000-01-01T00:00:00Z";
}

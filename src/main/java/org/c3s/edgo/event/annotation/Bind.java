/**
 * 
 */
package org.c3s.edgo.event.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
/**
 * @author admin
 *
 */
public @interface Bind {
	String[] value() default {};
}

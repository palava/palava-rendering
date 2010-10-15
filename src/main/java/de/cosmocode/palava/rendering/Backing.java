package de.cosmocode.palava.rendering;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;

/**
 * A binding annotation for the backing implementation of {@link InjectableRenderer}.
 *
 * @since 1.1
 * @author Willi Schoenborn
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@BindingAnnotation
@interface Backing {

}

package com.dsbundle.binarytree;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to denote the key which has to be considered for the node comparision.
 * Currently only one field can be set as the identifier. TODO for more than one field. 
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Identifier {

}

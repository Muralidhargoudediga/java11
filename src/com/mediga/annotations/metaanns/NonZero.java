package com.mediga.annotations.metaanns;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/*
The NonZero(and Fatal) annotation types can be used wherever a type is used. Their uses in the following contexts are valid:
 */
@Target(ElementType.TYPE_USE)
public @interface NonZero {
}

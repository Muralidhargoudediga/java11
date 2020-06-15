package com.mediga.annotations.metaanns;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface TargetAnnTest {
}

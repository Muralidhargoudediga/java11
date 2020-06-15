package com.mediga.annotations;

//An Annotation Type Using Other Annotation Types as Its Elements
public @interface Description {
    Name name();
    Version version();
    String comments() default "";
}

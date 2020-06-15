package com.mediga.annotations;

public @interface Name {
    String firstName();
    String lastName() default "";
}

package com.mediga.annotations;

public @interface Version {
    int major();
    int minor() default 0;
}

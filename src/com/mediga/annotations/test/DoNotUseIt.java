package com.mediga.annotations.test;

import com.mediga.annotations.Version;
/*
Like an interface, you can also implement an annotation type in a class.
However, you are never supposed to do that, as it will defeat the purpose of having an annotation type as a new construct.
You should always implement an interface in a class, not an annotation type
 */
import java.lang.annotation.Annotation;

public class DoNotUseIt implements Version {
    // Implemented method from the Version annotation type
    @Override
    public int major() {
        return 0;
    }

    // Implemented method from the Version annotation type
    @Override
    public int minor() {
        return 0;
    }

    // Implemented method from the Annotation annotation type,
    // which is the supertype of the Version annotation type
    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}

package com.mediga.annotations.metaanns;

import java.lang.annotation.Inherited;

public class InheritedAnnTest {
}

@interface Ann1 {
    int id();
}

@Inherited
@interface Ann2 {
    int id();
}

@Ann1(id=101)
@Ann2(id = 202)
class A {

}

//// Class B inherits Ann2(id=202) annotation from the class A
class B extends A {

}

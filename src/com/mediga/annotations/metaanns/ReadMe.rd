Meta-annotation types are used to annotate other annotation type declarations. The following are meta-annotation types:
• Target
• Retention
• Inherited :: The Inherited annotation type is a marker meta-annotation type. If an annotation type is annotated with an Inherited meta-annotation, its instances are inherited by a subclass declaration. It has no effect if an annotation type is used to annotate any program elements other than a class declaration
• Documented
• Repeatable

the java.lang.annotation package contains a Native annotation type, which is not a meta- annotation.
it is used to annotate fields indicating that the field may be referenced from native code. it is a marker annotation.
typically, it is used by tools that generate some code based on this annotation.
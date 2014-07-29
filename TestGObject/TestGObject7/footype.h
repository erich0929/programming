#ifndef FOO_TYPE_H_
#define FOO_TYPE_H_

#include <glib-object.h>

/* Foo type class struct */
typedef struct _FooTypeClass {
    GObjectClass parent;
} FooTypeClass;

/* Foo type object struct */
typedef struct _FooType {
    GObject parent;
} FooType;

/* type function */
GType foo_type_get_type();

/* register type */
void foo_type_register_type(GTypeModule *type_module);


#endif /* FOO_TYPE_H_ */

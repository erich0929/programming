/* A fundamental type. It has a class structure, and is instantiable. */

#include <stdio.h>
#include <glib-object.h>

/* Foo class struct */
typedef struct _FooClass {
    /*
     * Official document:
     * All class structures must contain as first member a GTypeClass structure.
     */
    GTypeClass parent;
} FooClass;

/* static field of Foo class */
int foo_class_i;

/* static method of Foo class */
void foo_class_set_i(int i) {
    foo_class_i = i;
    printf("Invoking foo_class_set_i(): foo_class_i=%d\n", foo_class_i);
}

/* Foo object struct */
typedef struct _Foo {
    /*
     * Official document:
     * All instance structures must contain as first member a TypeInstance structure.
     */
    GTypeInstance parent;
    /* instance variable */
    int foo_instance_i;
} Foo;

void foo_instance_set_i(Foo *instance, int i) {
    instance->foo_instance_i = i;
    printf("Invoking foo_instance_set_i(): foo_instance_i=%d\n", instance->foo_instance_i);
}

void foo_class_init(FooClass* klass, gpointer data) {
    foo_class_i = 100;
    printf("Calling foo_class_init(): foo_class_i=%d\n", foo_class_i);
}

void foo_instance_init(Foo *instance, gpointer data) {
    instance->foo_instance_i = 200;
    printf("Calling foo_instance_init(): foo_instance_i=%d\n", instance->foo_instance_i);
}

GType foo_get_type() {
    static GType foo_type = 0;
    if (foo_type == 0) {
        static const GTypeInfo foo_type_info = {
            sizeof(FooClass),   /* class_size */
            NULL,               /* base_init */
            NULL,               /* base_finalize */
            (GClassInitFunc)foo_class_init, /* class_init */
            NULL,               /* class_finalize */
            NULL,               /* class_data */
            sizeof(Foo),        /* instance_size */
            0,                  /* n_preallocs */
            (GInstanceInitFunc)foo_instance_init, /* instance_init */
            NULL                /* value_table */
        };
        /* G_TYPE_FLAG_INSTANTIATABLE: Indicates an instantiable type (implies classed) */
        GTypeFundamentalInfo foo_type_fundamental_info = {
            G_TYPE_FLAG_CLASSED | G_TYPE_FLAG_INSTANTIATABLE
        };
        foo_type = g_type_register_fundamental(g_type_fundamental_next(),
            "FooClassedFundamentalType", &foo_type_info, &foo_type_fundamental_info, 0);
    }
    return foo_type;
}

void my_dump_type(GType type_id) {
    printf("Type id: %d\n", type_id);
    printf("Type name: %s\n", g_type_name(type_id));
    printf("Is fundamental? %s\n", G_TYPE_IS_FUNDAMENTAL(type_id) ? "yes" : "no");
    printf("Is derived? %s\n", G_TYPE_IS_DERIVED(type_id) ? "yes" : "no");
    printf("Is interface? %s\n", G_TYPE_IS_INTERFACE(type_id) ? "yes" : "no");
    printf("Is classed? %s\n", G_TYPE_IS_CLASSED(type_id) ? "yes" : "no");
    printf("Is instantiatable? %s\n", G_TYPE_IS_INSTANTIATABLE(type_id) ? "yes" : "no");
    printf("Is derivable? %s\n", G_TYPE_IS_DERIVABLE(type_id) ? "yes" : "no");
    printf("Is deep derivable? %s\n", G_TYPE_IS_DEEP_DERIVABLE(type_id) ? "yes" : "no");
    printf("Is abstract? %s\n", G_TYPE_IS_ABSTRACT(type_id) ? "yes" : "no");
    printf("Is value abstract? %s\n", G_TYPE_IS_VALUE_ABSTRACT(type_id) ? "yes" : "no");
    printf("Is value type: %s\n", G_TYPE_IS_VALUE_TYPE(type_id) ? "yes" : "no");
    printf("Has value table: %s\n", G_TYPE_HAS_VALUE_TABLE(type_id) ? "yes" : "no");
}

int main() {
    g_type_init();
    my_dump_type(foo_get_type());

    /* Use g_type_create_instance if implement a fundamental class */
    Foo *foo = (Foo *)g_type_create_instance(foo_get_type());
    foo_class_set_i(101);
    foo_instance_set_i(foo, 201);

    printf("Is instance of int? %s\n",
        G_TYPE_CHECK_INSTANCE_TYPE(foo, G_TYPE_INT) ? "yes" : "no");
    printf("Is instance of FooClassedFundamentalType? %s\n",
        G_TYPE_CHECK_INSTANCE_TYPE(foo, foo_get_type()) ? "yes" : "no");

    return 0;
}

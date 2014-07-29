/* A fundamental type. It has a class structure, but is not instantiable. */

#include <stdio.h>
#include <glib-object.h>

typedef struct _FooClass {
    /*
     * Official document:
     * All class structures must contain as first member a GTypeClass structure.
     */
    GTypeClass parent;
    /*
     * Since glib 2.24, there're new functions to keep privacy.
     */
    int i;
    void (*bar)();
} FooClass;

void foo_class_bar();

void foo_class_init(FooClass *klass, gpointer data) {
    klass->i = 129;
    klass->bar = foo_class_bar;
    printf("Calling foo_class_init(): i=%d\n", klass->i);
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
            0,                  /* instance_size */
            0,                  /* n_preallocs */
            NULL,               /* instance_init */
            NULL                /* value_table */
        };
        /* G_TYPE_FLAG_CLASSED: Indicates a classed type */
        GTypeFundamentalInfo foo_type_fundamental_info = { G_TYPE_FLAG_CLASSED };
        foo_type = g_type_register_fundamental(g_type_fundamental_next(),
            "FooClassedFundamentalType", &foo_type_info, &foo_type_fundamental_info, 0);
    }
    return foo_type;
}

void foo_class_bar() {
    printf("Invoking foo_class_bar()\n");
}

/* Help function to dump a GType */
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

    FooClass *klass = (FooClass *)g_type_class_ref(foo_get_type());
    klass->bar();
    g_type_class_unref(klass);

    return 0;
}

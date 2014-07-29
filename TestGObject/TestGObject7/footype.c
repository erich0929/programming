#include "footype.h"

static gpointer parent_klass = NULL;
static GType foo_type_type_id = 0;

static void foo_type_instance_init(FooType *self) {
    g_print("Calling foo_type_instance_init()\n");
}

static void foo_type_instance_finalize(GObject *object) {
    /* do some finalize, maybe release some dynamically allocated memory */
    g_print("Calling foo_type_instance_finalize()\n");
    /* chain to parent's finalize */
    G_OBJECT_CLASS(parent_klass)->finalize(object);
}

static void foo_type_class_init(FooTypeClass *klass) {
    g_print("Calling foo_type_class_init()\n");
    parent_klass = g_type_class_peek_parent(klass);
    G_OBJECT_CLASS(klass)->finalize = foo_type_instance_finalize;
}

static void foo_type_class_finalize(FooTypeClass *klass) {
    g_print("Calling foo_type_class_finalize()\n");
}

GType foo_type_get_type() {
    return foo_type_type_id;
}

void foo_type_register_type(GTypeModule *type_module) {
    const GTypeInfo type_info = {
        sizeof(FooTypeClass), /* class_size */
        NULL,                   /* base_init */
        NULL,                   /* base_finalize */
        (GClassInitFunc)foo_type_class_init, /* class_init */
        (GClassFinalizeFunc)foo_type_class_finalize, /* class_finalize */
        NULL,                   /* class_data */
        sizeof(FooType),        /* instance_size */
        0,                      /* n_preallocs */
        (GInstanceInitFunc)foo_type_instance_init, /* instance_init */
        NULL                    /* value_table */
    };
    foo_type_type_id = g_type_module_register_type(
        type_module, G_TYPE_OBJECT, "FooTypeDynamicClass", &type_info, 0);
}

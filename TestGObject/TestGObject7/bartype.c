#include "bartype.h"

static gpointer parent_klass = NULL;
static GType bar_type_type_id = 0;

static void bar_type_instance_init(BarType *self) {
    g_print("Calling bar_type_instance_init()\n");
}

static void bar_type_instance_finalize(GObject *object) {
    /* do some finalize, maybe release some dynamically allocated memory */
    g_print("Calling bar_type_instance_finalize()\n");
    /* chain to parent's finalize */
    G_OBJECT_CLASS(parent_klass)->finalize(object);
}

static void bar_type_class_init(BarTypeClass *klass) {
    g_print("Calling bar_type_class_init()\n");
    parent_klass = g_type_class_peek_parent(klass);
    G_OBJECT_CLASS(klass)->finalize = bar_type_instance_finalize;
}

static void bar_type_class_finalize(BarTypeClass *klass) {
    g_print("Calling bar_type_class_finalize()\n");
}

GType bar_type_get_type() {
    return bar_type_type_id;
}

void bar_type_register_type(GTypeModule *type_module) {
    const GTypeInfo type_info = {
        sizeof(BarTypeClass), /* class_size */
        NULL,                   /* base_init */
        NULL,                   /* base_finalize */
        (GClassInitFunc)bar_type_class_init, /* class_init */
        (GClassFinalizeFunc)bar_type_class_finalize, /* class_finalize */
        NULL,                   /* class_data */
        sizeof(BarType),        /* instance_size */
        0,                      /* n_preallocs */
        (GInstanceInitFunc)bar_type_instance_init, /* instance_init */
        NULL                    /* value_table */
    };
    bar_type_type_id = g_type_module_register_type(
        type_module, G_TYPE_OBJECT, "BarTypeDynamicClass", &type_info, 0);
}

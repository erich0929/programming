#include "fakemodule.h"

/*
 * If you implement a real shared library module, you
 * can init module variables, assign virtual function here.
 */
gboolean fake_module_load(GTypeModule *module) {
    g_print("Invoking fake_module_load()\n");
    /* successfully loaded */
    return TRUE;
}

/*
 * If you implement a real shared library module, you
 * can uninit module variables, and make all cleanups here.
 */
void fake_module_unload(GTypeModule *module) {
    /* noop */
    g_print("Invoking fake_module_unload()\n");
}

static void fake_module_class_init(FakeModuleClass *klass, gpointer data) {
    g_print("Calling fake_module_class_init()\n");
    GTypeModuleClass *module_class = G_TYPE_MODULE_CLASS(klass);
    module_class->load = fake_module_load;
    module_class->unload = fake_module_unload;
}

static void fake_module_instance_init(FakeModule *instance, gpointer data) {
    g_print("Calling fake_module_instance_init()\n");
}

GType fake_module_get_type() {
    static GType type_id = 0;
    if (type_id == 0) {
        static const GTypeInfo type_info = {
            sizeof(FakeModuleClass), /* class_size */
            NULL,                   /* base_init */
            NULL,                   /* base_finalize */
            (GClassInitFunc)fake_module_class_init, /* class_init */
            NULL,                   /* class_finalize */
            NULL,                   /* class_data */
            sizeof(FakeModule),     /* instance_size */
            0,                      /* n_preallocs */
            (GInstanceInitFunc)fake_module_instance_init, /* instance_init */
            NULL                    /* value_table */
        };
        type_id = g_type_register_static(
            G_TYPE_TYPE_MODULE, "FakeModuleStaticClass", &type_info, 0);
    }
    return type_id;
}

#include "fakelaptop.h"
#include "fakeiface.h"

void fake_laptop_request(FakeIClient *instance) {
    g_print("Invoking fake_laptop_request()\n");
}

static void fake_laptop_class_init(FakeLaptopClass *klass, gpointer data) {
}

static void fake_laptop_instance_init(FakeLaptop *instance, gpointer data) {
}

static void fake_laptop_interface_init_iclient(FakeIClientInterface* iface, gpointer iface_data) {
    iface->request = fake_laptop_request;
}

GType fake_laptop_get_type() {
    static GType type_id = 0;
    if (type_id == 0) {
        static const GTypeInfo type_info = {
            sizeof(FakeLaptopClass),  /* class_size */
            NULL,                   /* base_init */
            NULL,                   /* base_finalize */
            (GClassInitFunc)fake_laptop_class_init, /* class_init */
            NULL,                   /* class_finalize */
            NULL,                   /* class_data */
            sizeof(FakeLaptop),     /* instance_size */
            0,                      /* n_preallocs */
            (GInstanceInitFunc)fake_laptop_instance_init, /* instance_init */
            NULL                    /* value_table */
        };
        type_id = g_type_register_static(G_TYPE_OBJECT, "FakeLaptopClass", &type_info, 0);

        /* add interface */
        GInterfaceInfo interface_info_iclient = {
            (GInterfaceInitFunc)fake_laptop_interface_init_iclient, /* interface_init */
            NULL,   /* interface_finalize */
            NULL,   /* interface_data */
        };
        g_type_add_interface_static(type_id, FAKE_TYPE_ICLIENT, &interface_info_iclient);
    }

    return type_id;
}

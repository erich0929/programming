#include "fakedesktop.h"
#include "fakeiface.h"

void fake_desktop_request(FakeIClient *instance) {
    g_print("Invoking fake_desktop_request()\n");
}

void fake_desktop_response(FakeIServer *instance) {
    g_print("Invoking fake_desktop_response()\n");
}

static void fake_desktop_class_init(FakeDesktopClass *klass, gpointer data) {
}

static void fake_desktop_instance_init(FakeDesktop *instance, gpointer data) {
}

static void fake_desktop_interface_init_iclient(FakeIClientInterface* iface, gpointer iface_data) {
    iface->request = fake_desktop_request;
}

static void fake_desktop_interface_init_iserver(FakeIServerInterface* iface, gpointer iface_data) {
    iface->response = fake_desktop_response;
}

GType fake_desktop_get_type() {
    static GType type_id = 0;
    if (type_id == 0) {
        static const GTypeInfo type_info = {
            sizeof(FakeDesktopClass),  /* class_size */
            NULL,                   /* base_init */
            NULL,                   /* base_finalize */
            (GClassInitFunc)fake_desktop_class_init, /* class_init */
            NULL,                   /* class_finalize */
            NULL,                   /* class_data */
            sizeof(FakeDesktop),    /* instance_size */
            0,                      /* n_preallocs */
            (GInstanceInitFunc)fake_desktop_instance_init, /* instance_init */
            NULL                    /* value_table */
        };
        type_id = g_type_register_static(G_TYPE_OBJECT, "FakeDesktopClass", &type_info, 0);

        /* add interface */
        GInterfaceInfo interface_info_iclient = {
            (GInterfaceInitFunc)fake_desktop_interface_init_iclient, /* interface_init */
            NULL,   /* interface_finalize */
            NULL,   /* interface_data */
        };
        GInterfaceInfo interface_info_iserver = {
            (GInterfaceInitFunc)fake_desktop_interface_init_iserver, /* interface_init */
            NULL,   /* interface_finalize */
            NULL,   /* interface_data */
        };
        g_type_add_interface_static(type_id, FAKE_TYPE_ICLIENT, &interface_info_iclient);
        g_type_add_interface_static(type_id, FAKE_TYPE_ISERVER, &interface_info_iserver);
    }

    return type_id;
}

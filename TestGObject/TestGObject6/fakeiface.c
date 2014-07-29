#include "fakeiface.h"

static void fake_iclient_base_init(gpointer g_class) {
    static gboolean is_initialized = FALSE;
    if (!is_initialized) {
        /* add properties and signals to the interface here */
        is_initialized = TRUE;
    }
}

GType fake_iclient_get_type() {
    static GType type_id = 0;
    if (type_id == 0) {
        static const GTypeInfo interface_info = {
            sizeof(FakeIClientInterface),   /* class_size */
            fake_iclient_base_init,         /* base_init */
            NULL,                           /* base_finalize */
        };
        type_id = g_type_register_static(
            G_TYPE_INTERFACE, "FakeIClientInterface", &interface_info, 0);
    }
    return type_id;
}

static void fake_iserver_base_init(gpointer g_class) {
    static gboolean is_initialized = FALSE;
    if (!is_initialized) {
        /* add properties and signals to the interface here */
        is_initialized = TRUE;
    }
}

GType fake_iserver_get_type() {
    static GType type_id = 0;
    if (type_id == 0) {
        static const GTypeInfo interface_info = {
            sizeof(FakeIServerInterface),   /* class_size */
            fake_iserver_base_init,         /* base_init */
            NULL,                           /* base_finalize */
        };
        type_id = g_type_register_static(
            G_TYPE_INTERFACE, "FakeIServerInterface", &interface_info, 0);
    }
    return type_id;
}

void fake_iclient_request(FakeIClient *instance) {
    g_return_if_fail(FAKE_IS_ICLIENT(instance));
    FAKE_ICLIENT_GET_INTERFACE(instance)->request(instance);
}

void fake_iserver_response(FakeIServer *instance) {
    g_return_if_fail(FAKE_IS_ISERVER(instance));
    FAKE_ISERVER_GET_INTERFACE(instance)->response(instance);
}

/* A fundamental type. With property and signal support. */

#include "fakeiface.h"
#include "fakedesktop.h"
#include "fakelaptop.h"
#include <glib-object.h>

void my_dump_type(GType type_id) {
    g_print("Type id: %d\n", type_id);
    g_print("Type name: %s\n", g_type_name(type_id));
    g_print("Is fundamental? %s\n", G_TYPE_IS_FUNDAMENTAL(type_id) ? "yes" : "no");
    g_print("Is derived? %s\n", G_TYPE_IS_DERIVED(type_id) ? "yes" : "no");
    g_print("Is interface? %s\n", G_TYPE_IS_INTERFACE(type_id) ? "yes" : "no");
    g_print("Is classed? %s\n", G_TYPE_IS_CLASSED(type_id) ? "yes" : "no");
    g_print("Is instantiatable? %s\n", G_TYPE_IS_INSTANTIATABLE(type_id) ? "yes" : "no");
    g_print("Is derivable? %s\n", G_TYPE_IS_DERIVABLE(type_id) ? "yes" : "no");
    g_print("Is deep derivable? %s\n", G_TYPE_IS_DEEP_DERIVABLE(type_id) ? "yes" : "no");
    g_print("Is abstract? %s\n", G_TYPE_IS_ABSTRACT(type_id) ? "yes" : "no");
    g_print("Is value abstract? %s\n", G_TYPE_IS_VALUE_ABSTRACT(type_id) ? "yes" : "no");
    g_print("Is value type: %s\n", G_TYPE_IS_VALUE_TYPE(type_id) ? "yes" : "no");
    g_print("Has value table: %s\n", G_TYPE_HAS_VALUE_TABLE(type_id) ? "yes" : "no");
}

int main() {
    g_type_init();
    my_dump_type(FAKE_TYPE_ICLIENT);
    my_dump_type(FAKE_TYPE_ISERVER);
    my_dump_type(FAKE_TYPE_LAPTOP);
    my_dump_type(FAKE_TYPE_DESKTOP);

    FakeLaptop *laptop = (FakeLaptop *)g_object_new(FAKE_TYPE_LAPTOP, NULL);
    FakeDesktop *desktop = (FakeDesktop *)g_object_new(FAKE_TYPE_DESKTOP, NULL);
    g_print("laptop is FakeIServer? %s\n", FAKE_IS_ISERVER(laptop) ? "yes" : "no");
    g_print("laptop is FakeIClient? %s\n", FAKE_IS_ICLIENT(laptop) ? "yes" : "no");
    g_print("desktop is FakeIServer? %s\n", FAKE_IS_ISERVER(desktop) ? "yes" : "no");
    g_print("desktop is FakeIClient? %s\n", FAKE_IS_ICLIENT(desktop) ? "yes" : "no");

    /* Polynophysm */
    int i;
    FakeIServer *servers[2] = { (FakeIServer *)laptop, (FakeIServer *)desktop };
    for (i = 0; i < 2; i++) {
        FakeIServer *inst = servers[i];
        FakeIServerInterface *iface = FAKE_ISERVER_GET_INTERFACE(inst);
        if (iface) {
            iface->response(inst);
        }
    }
    FakeIClient *clients[2] = { (FakeIClient *)laptop, (FakeIClient *)desktop };
    for (i = 0; i < 2; i++) {
        FakeIClient *inst = clients[i];
        FakeIClientInterface *iface = FAKE_ICLIENT_GET_INTERFACE(inst);
        if (iface) {
            iface->request(inst);
        }
    }

    return 0;
}

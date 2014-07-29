#include "footype.h"
#include "bartype.h"
#include "fakemodule.h"
#include <glib-object.h>

/*
 * Module entry point. If you implement a real shared library module,
 * you can use dlopen()/dlsym() or g_module_open()/g_module_symbol() to
 * load this module dynamically.
 */
void module_init(GTypeModule *type_module) {
    foo_type_register_type(type_module);
    bar_type_register_type(type_module);
}

int main() {
    g_type_init();

    FakeModule *module = (FakeModule *)g_object_new(fake_module_get_type(), NULL);
    module_init((GTypeModule *)module);

    /*
     * Add a reference to foo type class here. Otherwise, the fake module
     * will be unloaded right after the free() of foo type object and cause error.
     */
    FooTypeClass *foo_type_class = (FooTypeClass *)g_type_class_ref(foo_type_get_type());

    FooType *foo_type = (FooType *)g_object_new(foo_type_get_type(), NULL);
    BarType *bar_type = (BarType *)g_object_new(bar_type_get_type(), NULL);

    /* Test for override finalize() */
    g_object_unref(foo_type);
    g_object_unref(bar_type);

    g_type_class_unref(foo_type_class);

    return 0;
}

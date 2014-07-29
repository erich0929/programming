/* A fundamental type. With property and signal support. */

#include "fakebase.h"
#include "fakederived.h"
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

void print_int1(GObject *sender, int i, gpointer data) {
    if (FAKE_IS_DERIVED(sender)) {
        g_print("Invoking print_int1(): derived.i=%d\n", i);
    } else if (FAKE_IS_BASE(sender)) {
        g_print("Invoking print_int1(): base.i=%d\n", i);
    }
}

void print_int2(GObject *sender, int i, gpointer data) {
    if (FAKE_IS_DERIVED(sender)) {
        g_print("Invoking print_int2(): derived.i=%d\n", i);
    } else if (FAKE_IS_BASE(sender)) {
        g_print("Invoking print_int2(): base.i=%d\n", i);
    }
}

void print_string1(GObject *sender, gchar* str, gpointer data) {
    if (FAKE_IS_DERIVED(sender)) {
        g_print("Invoking print_string1(): derived.str=\"%s\"\n", str);
    } else if (FAKE_IS_BASE(sender)) {
        g_print("Invoking print_string1(): base.str=\"%s\"\n", str);
    }
}

void print_string2(GObject *sender, gchar* str, gpointer data) {
    if (FAKE_IS_DERIVED(sender)) {
        g_print("Invoking print_string2(): derived.str=\"%s\"\n", str);
    } else if (FAKE_IS_BASE(sender)) {
        g_print("Invoking print_string2(): base.str=\"%s\"\n", str);
    }
}

int main() {
    g_type_init();
    my_dump_type(FAKE_TYPE_BASE);
    my_dump_type(FAKE_TYPE_DERIVED);

    /*
     * Official document:
     * Use of g_type_create_instance() is reserved for implementators of
     * fundamental types only. E.g. instances of the GObject hierarchy should
     * be created via g_object_new() and never directly through
     * g_type_create_instance() which doesn't handle things like singleton
     * objects or object construction.
     */
    /* Base object */
    FakeBase *base = (FakeBase *)g_object_new(FAKE_TYPE_BASE, "base-id", 111, NULL);
    GValue base_name = { 0 };
    g_value_init(&base_name, G_TYPE_STRING);
    g_value_set_static_string(&base_name, "aaa");
    g_object_set_property(G_OBJECT(base), "base-name", &base_name);
    g_value_unset(&base_name);
    /* Derived object */
    FakeDerived *derived = (FakeDerived *)g_object_new(
        FAKE_TYPE_DERIVED, "base-id", 222, "derived-age", 333, NULL);
    g_object_set(derived, "base-name", "bbb", "derived-hash", "ccc", NULL);

    /* Dump (non-virtual) */
    fake_base_nonvirtual_dump(base);
    fake_derived_nonvirtual_dump(derived);
    /* Polymorphism dump (virtual) */
    FakeBase *instances[2] = { base, (FakeBase *)derived };
    int i;
    for (i = 0; i < 2; i++) {
        FakeBase *inst = instances[i];
        FakeBaseClass *klass = FAKE_BASE_GET_CLASS(inst);
        klass->virtual_dump(inst);
    }

    /* Test for signals */
    /* 1 <-> 1 */
    g_signal_connect(base, "base-signal-int", G_CALLBACK(print_int1), NULL);
    g_signal_connect(base, "base-signal-string", G_CALLBACK(print_string1), NULL);
    g_signal_emit_by_name(base, "base-signal-int", 12345);
    g_signal_emit_by_name(base, "base-signal-string", "abcde");
    /* 1 <-> 1+ */
    g_signal_connect(base, "base-signal-int", G_CALLBACK(print_int2), NULL);
    g_signal_emit_by_name(base, "base-signal-int", 123456);
    /* signal inheritance */
    g_signal_connect(derived, "base-signal-int", G_CALLBACK(print_int1), NULL);
    g_signal_connect(derived, "base-signal-string", G_CALLBACK(print_string1), NULL);
    g_signal_connect(derived, "derived-signal-int", G_CALLBACK(print_int2), NULL);
    g_signal_connect(derived, "derived-signal-string", G_CALLBACK(print_string2), NULL);
    g_signal_emit_by_name(derived, "base-signal-int", 1234567);
    g_signal_emit_by_name(derived, "base-signal-string", "abcdefg");
    g_signal_emit_by_name(derived, "derived-signal-int", 1234567);
    g_signal_emit_by_name(derived, "derived-signal-string", "abcdefg");

    /* Test for base_init() */
    FakeBaseClass *base_class1 = FAKE_BASE_GET_CLASS(base);
    FakeBaseClass *base_class2 = FAKE_BASE_GET_CLASS(FAKE_BASE(derived));
    fake_base_class_set_value(base_class2, 2, "another string");
    g_print("base_class1: version=%d, author=\"%s\"\n", base_class1->version, base_class1->author);
    g_print("base_class2: version=%d, author=\"%s\"\n", base_class2->version, base_class2->author);

    /* Test for override finalize() */
    g_object_unref(base);
    g_object_unref(derived);

    return 0;
}

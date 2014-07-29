#include "fakederived.h"

enum {
    PROP_0,
    PROP_DERIVED_AGE,
    PROP_DERIVED_HASH
};

struct _FakeDerivedPrivate {
    gint age;
    gchar *hash;
};

/* pointer to parent's class struct */
FakeBaseClass *parent_class;

void fake_derived_virtual_dump(FakeBase *instance) {
    FakeDerived *derived = FAKE_DERIVED(instance);
    gint base_id;
    gchar *base_name;
    g_object_get(instance, "base-id", &base_id, "base-name", &base_name, NULL);
    g_print("Derived(virtual): id=%d, name=\"%s\", age=%d, hash=\"%s\"\n",
        base_id, base_name, derived->priv->age, derived->priv->hash);
    g_free(base_name);
}

void fake_derived_nonvirtual_dump(FakeDerived *instance) {
    FakeDerived *derived = FAKE_DERIVED(instance);
    gint base_id;
    gchar *base_name;
    g_object_get(instance, "base-id", &base_id, "base-name", &base_name, NULL);
    g_print("Derived(nonvirtual): id=%d, name=\"%s\", age=%d, hash=\"%s\"\n",
        base_id, base_name, derived->priv->age, derived->priv->hash);
    g_free(base_name);
}

static void fake_derived_set_property(GObject *object,
    guint property_id, const GValue *value, GParamSpec *pspec) {
    FakeDerived *self = FAKE_DERIVED(object);
    switch (property_id) {
        case PROP_DERIVED_AGE:
            self->priv->age = g_value_get_int(value);
            break;
        case PROP_DERIVED_HASH:
            g_free(self->priv->hash);
            self->priv->hash = g_value_dup_string(value);
            break;
        default:
            /* We don't have any other property... */
            G_OBJECT_WARN_INVALID_PROPERTY_ID(object, property_id, pspec);
            break;
    }
}

static void fake_derived_get_property(GObject *object,
    guint property_id, GValue *value, GParamSpec *pspec) {
    FakeDerived *self = FAKE_DERIVED(object);
    switch (property_id) {
        case PROP_DERIVED_AGE:
            g_value_set_int(value, self->priv->age);
            break;
        case PROP_DERIVED_HASH:
            g_value_set_string(value, self->priv->hash);
            break;
        default:
            /* We don't have any other property... */
            G_OBJECT_WARN_INVALID_PROPERTY_ID(object, property_id, pspec);
            break;
    }
}

static void derived_instance_init(FakeDerived *instance, gpointer data) {
    g_print("Calling derived_instance_init()\n");
    instance->priv = G_TYPE_INSTANCE_GET_PRIVATE(instance, FAKE_TYPE_DERIVED, FakeDerivedPrivate);
}

static void fake_derived_instance_finalize(GObject *object) {
    /* do some finalize, maybe release some dynamically allocated memory */
    g_print("Calling fake_derived_instance_finalize()\n");
    /* chain to parent's finalize */
    G_OBJECT_CLASS(parent_class)->finalize(object);
}

static void derived_class_init(FakeDerivedClass *klass, gpointer data) {
    g_print("Calling derived_class_init()\n");
    /* Override the object's finalize method with our own */
    parent_class = (FakeBaseClass *)g_type_class_peek_parent(klass);
    G_OBJECT_CLASS(klass)->finalize = fake_derived_instance_finalize;
    /* Override virtual functions */
    FakeBaseClass *base_klass = FAKE_BASE_CLASS(klass);
    base_klass->virtual_dump = fake_derived_virtual_dump;

    /* Registers a private structure for an instantiable type. */
    g_type_class_add_private(klass, sizeof(FakeDerivedPrivate));
    /* properties */
    GObjectClass *gobject_klass = G_OBJECT_CLASS(klass);
    gobject_klass->set_property = fake_derived_set_property;
    gobject_klass->get_property = fake_derived_get_property;
    GParamSpec *pspec;
    pspec = g_param_spec_int("derived-age",
        "Derived Age", "Set/Get Derived Age", -1000, 1000, 0, G_PARAM_CONSTRUCT_ONLY | G_PARAM_READWRITE);
    g_object_class_install_property(gobject_klass, PROP_DERIVED_AGE, pspec);
    pspec = g_param_spec_string("derived-hash",
        "Derived Hash", "Set/Get Derived Hash ", NULL, G_PARAM_READWRITE);
    g_object_class_install_property(gobject_klass, PROP_DERIVED_HASH, pspec);
    /* signals */
    g_signal_new("derived-signal-int", FAKE_TYPE_BASE, G_SIGNAL_RUN_LAST,
        0, NULL, NULL, g_cclosure_marshal_VOID__INT, G_TYPE_NONE, 1, G_TYPE_INT, NULL);
    g_signal_new("derived-signal-string", FAKE_TYPE_BASE, G_SIGNAL_RUN_LAST,
        0, NULL, NULL, g_cclosure_marshal_VOID__STRING, G_TYPE_NONE, 1, G_TYPE_STRING, NULL);
}

GType fake_derived_get_type() {
    static GType derived_type = 0;
    if(derived_type == 0) {
        static const GTypeInfo derived_type_info = {
            sizeof(FakeDerivedClass),   /* class_size */
            NULL,                       /* base_init */
            NULL,                       /* base_finalize */
            (GClassInitFunc)derived_class_init, /* class_init */
            NULL,                       /* class_finalize */
            NULL,                       /* class_data */
            sizeof(FakeDerived),        /* instance_size */
            0,                          /* n_preallocs */
            (GInstanceInitFunc)derived_instance_init, /* instance_init */
            NULL                        /* value_table */
        };
        derived_type = g_type_register_static(
            FAKE_TYPE_BASE, "FakeDerivedStaticClass", &derived_type_info, 0);
    }
    return derived_type;
}

FakeDerived *fake_derived_new() {
    return (FakeDerived *)g_object_new(FAKE_TYPE_DERIVED, NULL);
}

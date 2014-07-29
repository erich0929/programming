#include "fakebase.h"

enum {
    PROP_0,
    PROP_BASE_ID,
    PROP_BASE_NAME
};

struct _FakeBasePrivate {
    gint id;
    gchar *name;
};

/* pointer to parent's class struct */
GObjectClass *parent_klass;

void fake_base_class_set_value(FakeBaseClass *klass, gint v, gchar* auth) {
    klass->version = v;
    g_free(klass->author);
    klass->author = g_strdup(auth);
}

void fake_base_virtual_dump(FakeBase *instance) {
    g_print("Base(virtual): id=%d, name=\"%s\"\n", instance->priv->id, instance->priv->name);
}

void fake_base_nonvirtual_dump(FakeBase *instance) {
    g_print("Base(nonvirtual): id=%d, name=\"%s\"\n", instance->priv->id, instance->priv->name);
}

static void fake_base_set_property(GObject *object,
    guint property_id, const GValue *value, GParamSpec *pspec) {
    FakeBase *self = FAKE_BASE(object);
    switch (property_id) {
        case PROP_BASE_ID:
            self->priv->id = g_value_get_int(value);
            break;
        case PROP_BASE_NAME:
            g_free(self->priv->name);
            self->priv->name = g_value_dup_string(value);
            break;
        default:
            /* We don't have any other property... */
            G_OBJECT_WARN_INVALID_PROPERTY_ID(object, property_id, pspec);
            break;
    }
}

static void fake_base_get_property(GObject *object,
    guint property_id, GValue *value, GParamSpec *pspec) {
    FakeBase *self = FAKE_BASE(object);
    switch (property_id) {
        case PROP_BASE_ID:
            g_value_set_int(value, self->priv->id);
            break;
        case PROP_BASE_NAME:
            g_value_set_string(value, self->priv->name);
            break;
        default:
            /* We don't have any other property... */
            G_OBJECT_WARN_INVALID_PROPERTY_ID(object, property_id, pspec);
            break;
    }
}

static void fake_base_instance_init(FakeBase *instance, gpointer data) {
    g_print("Calling fake_base_instance_init()\n");
    instance->priv = G_TYPE_INSTANCE_GET_PRIVATE(instance, FAKE_TYPE_BASE, FakeBasePrivate);
}

static void fake_base_instance_finalize(GObject *object) {
    /* do some finalize, maybe release some dynamically allocated memory */
    g_print("Calling fake_base_instance_finalize()\n");
    /* chain to parent's finalize */
    G_OBJECT_CLASS(parent_klass)->finalize(object);
}

static void fake_base_class_init(FakeBaseClass *klass, gpointer data) {
    klass->version = 1;
    g_print("Calling fake_base_class_init(): version=%d, author=\"%s\"\n", klass->version, klass->author);
    klass->virtual_dump = fake_base_virtual_dump;
    /* Override the object's finalize method with our own */
    parent_klass = (GObjectClass *)g_type_class_peek_parent(klass);
    G_OBJECT_CLASS(klass)->finalize = fake_base_instance_finalize;
    /* Registers a private structure for an instantiable type. */
    g_type_class_add_private(klass, sizeof(FakeBasePrivate));

    /* properties */
    GObjectClass *gobject_klass = G_OBJECT_CLASS(klass);
    gobject_klass->set_property = fake_base_set_property;
    gobject_klass->get_property = fake_base_get_property;
    GParamSpec *pspec;
    pspec = g_param_spec_int("base-id",
        "Base ID", "Set/Get Base ID", -1000, 1000, 0, G_PARAM_CONSTRUCT_ONLY | G_PARAM_READWRITE);
    g_object_class_install_property(gobject_klass, PROP_BASE_ID, pspec);
    pspec = g_param_spec_string("base-name",
        "Base Name", "Set/Get Base Name ", NULL, G_PARAM_READWRITE);
    g_object_class_install_property(gobject_klass, PROP_BASE_NAME, pspec);
    /* signals */
    g_signal_new("base-signal-int", FAKE_TYPE_BASE, G_SIGNAL_RUN_LAST,
        0, NULL, NULL, g_cclosure_marshal_VOID__INT, G_TYPE_NONE, 1, G_TYPE_INT, NULL);
    g_signal_new("base-signal-string", FAKE_TYPE_BASE, G_SIGNAL_RUN_LAST,
        0, NULL, NULL, g_cclosure_marshal_VOID__STRING, G_TYPE_NONE, 1, G_TYPE_STRING, NULL);
}

static void fake_base_base_init(FakeBaseClass *klass) {
    g_print("Calling fake_base_base_init()\n");
    klass->author = g_strdup("a string");
}

static void fake_base_base_finalize(FakeBaseClass *klass) {
    g_print("Calling fake_base_base_finalize()\n");
    g_free(klass->author);
}

GType fake_base_get_type() {
    static GType type_id = 0;
    if (type_id == 0) {
        static const GTypeInfo type_info = {
            sizeof(FakeBaseClass),  /* class_size */
            (GBaseInitFunc)fake_base_base_init, /* base_init */
            (GBaseFinalizeFunc)fake_base_base_finalize, /* base_finalize */
            (GClassInitFunc)fake_base_class_init, /* class_init */
            NULL,                   /* class_finalize */
            NULL,                   /* class_data */
            sizeof(FakeBase),       /* instance_size */
            0,                      /* n_preallocs */
            (GInstanceInitFunc)fake_base_instance_init, /* instance_init */
            NULL                    /* value_table */
        };
        type_id = g_type_register_static(
            G_TYPE_OBJECT, "FakeBaseStaticClass", &type_info, 0);
    }
    return type_id;
}

FakeBase *fake_base_new() {
    return (FakeBase *)g_object_new(FAKE_TYPE_BASE, NULL);
}

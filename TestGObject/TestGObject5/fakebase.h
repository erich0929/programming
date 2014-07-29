#ifndef FAKE_BASE_H_
#define FAKE_BASE_H_

#include <glib-object.h>

#define FAKE_TYPE_BASE              ( fake_base_get_type() )
#define FAKE_BASE(obj)              ( G_TYPE_CHECK_INSTANCE_CAST((obj), FAKE_TYPE_BASE, FakeBase) )
#define FAKE_IS_BASE(obj)           ( G_TYPE_CHECK_INSTANCE_TYPE((obj), FAKE_TYPE_BASE) )
#define FAKE_BASE_CLASS(cls)        ( G_TYPE_CHECK_CLASS_CAST((cls), FAKE_TYPE_BASE, FakeBaseClass) )
#define FAKE_IS_BASE_CLASS(cls)     ( G_TYPE_CHECK_CLASS_TYPE((cls), FAKE_TYPE_BASE) )
#define FAKE_BASE_GET_CLASS(obj)    ( G_TYPE_INSTANCE_GET_CLASS((obj), FAKE_TYPE_BASE, FakeBaseClass ) )

/* private data of Base object */
typedef struct _FakeBasePrivate FakeBasePrivate;

/* Base object struct */
typedef struct _FakeBase {
    /* GObject as the first field */
    GObject parent;
    /* private data */
    FakeBasePrivate *priv;
} FakeBase;

/* Base class struct */
typedef struct _FakeBaseClass {
    /*
     * The type GObject is supposed to be the base class of other user-defined classes.
     *   - Reference count support.
     *   - Support adding properties to GObject subclasses.
     *   - Support signals for asynchronized event handling like "event" in C#.
     */
    /* GObjectClass as the first field */
    GObjectClass parent;
    /*
     * Since glib 2.24, there're new functions to keep privacy:
     *   - g_type_add_class_private()
     *   - g_type_class_get_private()
     */
    /* private static field */
    gint version;
    /* private dynamic field */
    gchar *author;
    /* instance method, used as a virtual method */
    void (*virtual_dump)(struct _FakeBase *instance);
} FakeBaseClass;

/* static method of Base class */
void fake_base_class_set_value(FakeBaseClass *klass, gint v, gchar* auth);

/* virtual public method for Base object, both version are supported */
void fake_base_virtual_dump(FakeBase *instance);

/* non-virtual public method for Base object */
void fake_base_nonvirtual_dump(FakeBase *instance);

/* type method */
GType fake_base_get_type();

/* instantiate */
FakeBase *fake_base_new();


#endif /* FAKE_BASE_H_ */

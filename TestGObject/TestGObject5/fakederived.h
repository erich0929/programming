#ifndef FAKE_DERIVED_H_
#define FAKE_DERIVED_H_

#include "fakebase.h"
#include <glib-object.h>

#define FAKE_TYPE_DERIVED           ( fake_derived_get_type() )
#define FAKE_DERIVED(obj)           ( G_TYPE_CHECK_INSTANCE_CAST((obj), FAKE_TYPE_DERIVED, FakeDerived) )
#define FAKE_IS_DERIVED(obj)        ( G_TYPE_CHECK_INSTANCE_TYPE((obj), FAKE_TYPE_DERIVED) )
#define FAKE_DERIVED_CLASS(cls)     ( G_TYPE_CHECK_CLASS_CAST((cls), FAKE_TYPE_DERIVED, FakeDerivedClass) )
#define FAKE_IS_DERIVED_CLASS(cls)  ( G_TYPE_CHECK_CLASS_TYPE((cls), FAKE_TYPE_DERIVED) )
#define FAKE_DERIVED_GET_CLASS(obj) ( G_TYPE_INSTANCE_GET_CLASS((obj), FAKE_TYPE_DERIVED, FakeDerivedClass ) )

/* private data of Derived object */
typedef struct _FakeDerivedPrivate FakeDerivedPrivate;

/* Derived object struct */
typedef struct _FakeDerived {
    /* The GObject structure is still the first member of the class structure */
    FakeBase parent;
    /* private data */
    FakeDerivedPrivate *priv;
} FakeDerived;

/* Derived class struct */
typedef struct _FakeDerivedClass {
    /* The GObjectClass structure is still the first member of the instance structure */
    FakeBaseClass parent;
} FakeDerivedClass;

/* (Overwrite) virtual public method for Derived object, both version are supported */
void fake_derived_virtual_dump(FakeBase *instance);

/* non-virtual public method for Derived object */
void fake_derived_nonvirtual_dump(FakeDerived *instance);

/* type method */
GType fake_derived_get_type();

/* instantiate */
FakeDerived *fake_derived_new();


#endif /* FAKE_DERIVED_H_ */

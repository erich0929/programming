#ifndef FAKE_LAPTOP_H_
#define FAKE_LAPTOP_H_

#include <glib-object.h>

#define FAKE_TYPE_LAPTOP              ( fake_laptop_get_type() )
#define FAKE_LAPTOP(obj)              ( G_TYPE_CHECK_INSTANCE_CAST((obj), FAKE_TYPE_LAPTOP, FakeLaptop) )
#define FAKE_IS_LAPTOP(obj)           ( G_TYPE_CHECK_INSTANCE_TYPE((obj), FAKE_TYPE_LAPTOP) )
#define FAKE_LAPTOP_CLASS(cls)        ( G_TYPE_CHECK_CLASS_CAST((cls), FAKE_TYPE_LAPTOP, FakeLaptopClass) )
#define FAKE_IS_LAPTOP_CLASS(cls)     ( G_TYPE_CHECK_CLASS_TYPE((cls), FAKE_TYPE_LAPTOP) )
#define FAKE_LAPTOP_GET_CLASS(obj)    ( G_TYPE_INSTANCE_GET_CLASS((obj), FAKE_TYPE_LAPTOP, FakeLaptopClass ) )

/* Base object struct */
typedef struct _FakeLaptop {
    /* GObject as the first field */
    GObject parent;
} FakeLaptop;

/* Base class struct */
typedef struct _FakeLaptopClass {
    /* GObjectClass as the first field */
    GObjectClass parent;
} FakeLaptopClass;

/* type method */
GType fake_laptop_get_type();


#endif /* FAKE_LAPTOP_H_ */

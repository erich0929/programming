#ifndef FAKE_DESKTOP_H_
#define FAKE_DESKTOP_H_

#include <glib-object.h>

#define FAKE_TYPE_DESKTOP              ( fake_desktop_get_type() )
#define FAKE_DESKTOP(obj)              ( G_TYPE_CHECK_INSTANCE_CAST((obj), FAKE_TYPE_DESKTOP, FakeDesktop) )
#define FAKE_IS_DESKTOP(obj)           ( G_TYPE_CHECK_INSTANCE_TYPE((obj), FAKE_TYPE_DESKTOP) )
#define FAKE_DESKTOP_CLASS(cls)        ( G_TYPE_CHECK_CLASS_CAST((cls), FAKE_TYPE_DESKTOP, FakeDesktopClass) )
#define FAKE_IS_DESKTOP_CLASS(cls)     ( G_TYPE_CHECK_CLASS_TYPE((cls), FAKE_TYPE_DESKTOP) )
#define FAKE_DESKTOP_GET_CLASS(obj)    ( G_TYPE_INSTANCE_GET_CLASS((obj), FAKE_TYPE_DESKTOP, FakeDesktopClass ) )

/* Base object struct */
typedef struct _FakeDesktop {
    /* GObject as the first field */
    GObject parent;
} FakeDesktop;

/* Base class struct */
typedef struct _FakeDesktopClass {
    /* GObjectClass as the first field */
    GObjectClass parent;
} FakeDesktopClass;

/* type method */
GType fake_desktop_get_type();


#endif /* FAKE_DESKTOP_H_ */

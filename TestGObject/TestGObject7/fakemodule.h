#ifndef FAKE_MODULE_H_
#define FAKE_MODULE_H_

#include <glib-object.h>

/* module object struct */
typedef struct _FakeModule {
    GTypeModule parent;
} FakeModule;

/* module class struct */
typedef struct _FakeModuleClass {
    GTypeModuleClass parent;
} FakeModuleClass;

/* type method */
GType fake_module_get_type();


#endif /* FAKE_MODULE_H_ */

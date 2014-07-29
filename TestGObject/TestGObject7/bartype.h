#ifndef BAR_TYPE_H_
#define BAR_TYPE_H_

#include <glib-object.h>

/* Bar type class struct */
typedef struct _BarTypeClass {
    GObjectClass parent;
} BarTypeClass;

/* Far type object struct */
typedef struct _BarType {
    GObject parent;
} BarType;

/* type function */
GType bar_type_get_type();

/* register type */
void bar_type_register_type(GTypeModule *type_module);


#endif /* BAR_TYPE_H_ */

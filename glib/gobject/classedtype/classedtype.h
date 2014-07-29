#include <glib-object.h>

typedef struct _FooClass
{
		GTypeClass parent;
		int i;
		void (*bar) ();
} FooClass;

void foo_class_init (FooClass *, gpointer);

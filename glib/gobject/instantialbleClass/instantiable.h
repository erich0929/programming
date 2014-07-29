#ifndef _INSTANTIALBE_H_
#define _INSTANTIABLE_H_

#include <glib-object.h>

typedef struct _Foo
{
	GTypeInstance parent;
	int foo_instance_i;
} Foo;

typedef struct _FooClass
{
	GTypeClass parent;
} FooClass;

int foo_class_i;

void foo_class_set_i (int i)
{
	foo_class_i = i;
	printf ("Invoking foo_class_set_i () : foo_class_i = %d\n", foo_class_i);
}

void foo_instance_set_i (Foo *instance, int i)
{
	instance -> foo_instance_i = i;
	printf ("Invoking foo_instance_set_i () : foo_instance_i = %d\n", instance -> foo_instance_i);
}

void foo_class_init (FooClass *klass, gpointer data)
{
	foo_class_i = 100;
	printf ("Calling foo_instance_init () : foo_class_i = %d\n", foo_class_i);
}

void foo_instance_init (Foo *instance, gpointer data)
{
	instance -> foo_instance_i = 200;
	printf ("Calling foo_instance_init () : foo_instance_i = %d\n", instance -> foo_instance_i);

}

GType foo_get_type ()
{
	static GType foo_type = 0;
	if (foo_type == 0)
	{
		static const GTypeInfo foo_type_info =
	   	{
				sizeof (FooClass),
				NULL,
				NULL,
				(GClassInitFunc) foo_class_init,
				NULL,
				NULL,
				sizeof (Foo),
				0,
				(GInstanceInitFunc) foo_instance_init,
				NULL
		};

		GTypeFundamentalInfo foo_type_fundamental_info = 
		{
			G_TYPE_FLAG_CLASSED | G_TYPE_FLAG_INSTANTIATABLE
		};

		foo_type = g_type_register_fundamental (g_type_fundamental_next (),
			 "FooClassFundamentalType", &foo_type_info, &foo_type_fundamental_info, 0);
	}
	return foo_type;
}
		
#endif /* _INSTANTIABLE_H_ */


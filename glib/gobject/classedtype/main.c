#include "classedtype.h"
#include <stdio.h>
#include <glib-object.h>

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
			0,
			0,
			NULL,
			NULL
		};

		GTypeFundamentalInfo foo_type_fundamental_info = { G_TYPE_FLAG_CLASSED };
		foo_type = g_type_register_fundamental (g_type_fundamental_next (), 
						"FooClassedFundamentalType", &foo_type_info, &foo_type_fundamental_info, 0);
	}
	return foo_type;
}

void foo_class_bar ();

void foo_class_init (FooClass *klass, gpointer data)
{
		klass -> i = 929;
		klass -> bar = foo_class_bar;
		printf ("Calling foo_class_init () : i = %d\n", klass -> i);
}

void foo_class_bar ()
{
	printf ("Invoking foo_class_bar ()\n");
}

int main ()
{
	g_type_init ();

	FooClass *klass = (FooClass *) g_type_class_ref (foo_get_type ());
	klass -> bar();
	printf ("klass pointer value : %p\n", klass);
	g_type_class_unref (klass);

	FooClass *klass1 = (FooClass *) g_type_class_ref (foo_get_type ());
	klass1 -> bar ();
	printf ("klass1 pointer value : %p\n", klass1);
	g_type_class_unref (klass1);

	return 0;
}

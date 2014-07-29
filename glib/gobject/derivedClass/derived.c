#include "derived.h"

void derived_instance_set_i (Derived *instance, gint i)
{
	instance -> derived_instance_i = i;
	printf ("derived constructor, derived_instance_i : %d\n", instance -> derived_instance_i);
}

void derived_instance_dump (Base *instance)
{
	Derived *derived = G_TYPE_CHECK_INSTANCE_CAST (instance, derived_get_type (), Derived);
	printf ("derived virtual function overrided!!\n");
	printf ("Invoking derived_instance_dump () : base_instance_i = %d, derived_instance_i = %d\n",
					instance -> base_instance_i, derived -> derived_instance_i);
}

static void derived_class_init (DerivedClass *klass, gpointer data)
{
	printf ("Calling derived_class_init ()\n");
	base_class_set_i (300);

	/* Override virtual function */
	BaseClass *base_klass = G_TYPE_CHECK_CLASS_CAST (klass, base_get_type (), BaseClass);
	base_klass -> base_instance_dump = derived_instance_dump;
}

static void derived_instance_init (Derived *instance, gpointer data)
{
	instance -> derived_instance_i = 400;
	printf ("Calling derived_instance_init () : derived_instance_i = %d\n", instance -> derived_instance_i);
}

GType derived_get_type ()
{
	static GType derived_type = 0;
	if (derived_type == 0)
	{
		static const GTypeInfo derived_type_info = 
		{
			sizeof (DerivedClass),
			NULL,
			NULL,
			(GClassInitFunc) derived_class_init,
			NULL,
			NULL,
			sizeof (Derived),
			0,
			(GInstanceInitFunc) derived_instance_init,
			NULL
		};

		derived_type = g_type_register_static (
					base_get_type (), "DerivedStaticClass", &derived_type_info, 0);
	}
	return derived_type;
}


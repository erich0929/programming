#include "base.h"

/* static field of base class */
gint base_class_i;

void base_class_set_i (gint i)
{
	base_class_i = i;
	printf ("Invoking base_class_set_i () : %d\n", base_class_i);	
}

void base_instance_set_i (Base *instance, gint i)
{
	instance -> base_instance_i = i;
	printf ("constructor worked, base_instance_i : %d\n", instance -> base_instance_i);
}

void base_instance_dump (Base *instance)
{
	printf ("base virtual function worked!\n");
}

static void base_class_init (BaseClass *klass, gpointer data)
{
	base_class_i = 100;
	printf ("Calling base_class_init () : base_class_i = %d\n", base_class_i);
	klass -> base_instance_dump = base_instance_dump;
}

static void base_instance_init (Base *instance, gpointer date)
{
	instance -> base_instance_i = 200;
	printf ("Calling base_instance_init () : base_instance_i = :%d\n", instance -> base_instance_i);
}

GType base_get_type ()
{
	static GType base_type = 0;
	if (base_type == 0)
	{
		static const GTypeInfo base_type_info =
		{
			sizeof (BaseClass), /* class size */
			NULL,				/* base_init */
			NULL,				/* base_finalize */
			(GClassInitFunc) base_class_init, /* class init */
			NULL, 				/* class finalize */
			NULL, 				/* class data */
			sizeof (Base),		/* instance size */
			NULL,				/* n_preallocs */
			(GInstanceInitFunc) base_instance_init, /* instance init */
			NULL
		};

		GTypeFundamentalInfo foo_type_fundamental_info =
		{
			G_TYPE_FLAG_CLASSED		/* indicate a class type */
			| G_TYPE_FLAG_INSTANTIATABLE 	/* indicate an instantiable type */
			| G_TYPE_FLAG_DERIVABLE 		/* indicate a flat derivable type */
			| G_TYPE_FLAG_DEEP_DERIVABLE	/* indicate a deep derivable type */
		};
		
		base_type = g_type_register_fundamental (g_type_fundamental_next (),
						"BaseFundamentalType", &base_type_info, &foo_type_fundamental_info, 0);
	}
		return base_type;
}

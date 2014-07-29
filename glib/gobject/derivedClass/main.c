#include "base.h"
#include "derived.h"
#include <glib-object.h>

int main ()
{
	g_type_init ();

	Base *base = (Base *) g_type_create_instance (base_get_type ());
	base_class_set_i (101);
	base_instance_set_i (base, 201);
	Derived *derived = (Derived *) g_type_create_instance (derived_get_type ());
	derived_instance_set_i (derived, 401);

	/* test polymorphism */
	Base *instance [2] = { base, (Base *) derived};
	int i;
	for (i = 0; i < 2; i++)
	{
		Base *inst = instance [i];
		BaseClass *klass = G_TYPE_INSTANCE_GET_CLASS (inst, base_get_type (), BaseClass);
		klass -> base_instance_dump (inst);
	}
	
	return 0;
}

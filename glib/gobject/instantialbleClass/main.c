#include <stdio.h>
#include "instantiable.h"

int main ()
{
	g_type_init ();

	Foo *foo = (Foo *) g_type_create_instance (foo_get_type ());
	foo_class_set_i (101);
	foo_instance_set_i (foo, 201);
	printf ("foo pointer value : %p\n", foo);

	Foo *foo1 = (Foo *) g_type_create_instance (foo_get_type ());
	foo_instance_set_i (foo1, 20001);
	printf ("foo1 pointer value : %p\n", foo1);

	return 0;
}

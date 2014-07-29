#include <stdio.h>
#include <glib-object.h>

int main ()
{
		g_type_init ();

		GTypeInfo my_type_info = 
		{0, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL};

		GTypeFundamentalInfo my_type_fundamental_info = {0};

		GType my_type_id = g_type_register_fundamental 
				(g_type_fundamental_next (),
				 "MyFundamentalType", &my_type_info,
				 &my_type_fundamental_info, 0);

		printf ("Type name of int : %s\n", g_type_name (G_TYPE_INT));
		printf ("Type name of my fundamental type : %s\n",
				g_type_name (my_type_id));

		return 0;
}

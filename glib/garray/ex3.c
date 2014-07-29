#include <glib.h>

int main(void)
{
	int i;
	GArray* a = g_array_new (FALSE, FALSE, sizeof (int));
	printf ("Array is empty, so appending some values\n");
	int x[2] = {4, 5};
	g_array_append_vals (a, &x, 2);
	for (i = 0; i < a->len; i++) {
		printf ("%d\n", g_array_index (a, int, i));
	}
	printf ("Now to prepend some values\n");
	int y[2] = {11, 12};
	g_array_prepend_vals (a, &y, 2);
	for (i = 0; i < a->len; i++) {
		printf ("%d\n", g_array_index (a, int, i));
	}
	printf ("And one more prepend\n");
	int z = 1;
	g_array_prepend_val (a, z);
	for (i = 0; i < a->len; i++) {
		printf ("%d\n", g_array_index (a, int, i));
	}

	return 0;
}

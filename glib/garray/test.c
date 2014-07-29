#include <stdio.h>
#include <glib.h>

typedef struct _DATA {
		int item;
		char* name;
		int price;
		double value;
} DATA;

int compare_items (gpointer, gpointer);
void printAll (gpointer, gpointer);

DATA data [] = {{7143, "삼성전자", 1231234, 235.5},
				{5231, "LG전자", 532458, 238.75},
				{8751, "효광전자", 872654, 125.47},
				{2354, "sktelecom", 87542, 564.4}};

int main(void)
{
	GPtrArray* a = g_ptr_array_new ();
	g_ptr_array_add (a, &data[0]);
	g_ptr_array_add (a, &data[1]);
	g_ptr_array_add (a, &data[2]);
	g_ptr_array_add (a, &data[3]);

	g_ptr_array_sort (a, (GCompareFunc) compare_items);
	
	g_ptr_array_foreach (a, printAll, (gpointer) NULL);

	return 0;
}

gint compare_items (gpointer a, gpointer b) {
		
		DATA* alpha = *(DATA **) a;
		DATA* beta = *(DATA **) b;

		return (gint) (alpha->item - beta->item);
}

void printAll (gpointer a, gpointer b) {
		DATA* alpha = (DATA*) a;
		printf ("item : %d, name : %s, price : %d, value : %lf\n", alpha -> item, alpha -> name, alpha -> price, alpha -> value);
		return;
}

#include <stdio.h>
#include <glib.h>

typedef	struct _WIDGET {
	GPtrArray* table;
	int row;
	int col;
} WIDGET;

WIDGET* new_widget (WIDGET* widget, int row, int col) {
	widget = (WIDGET *) malloc (sizeof (WIDGET));
	widget -> table = g_ptr_array_new ();
	widget -> row = row;
	widget -> col = col;
	return widget;
}

void del_widget (WIDGET* widget) {
		g_ptr_array_free (widget -> table, TRUE);
		free (widget);
}

int main(int argc, const char *argv[])
{
	WIDGET* widget = new_widget (widget, 3 , 3);
	printf ("widget info\ntable : %p\nrow : %d\ncol: %d\n",
					widget -> table,
					widget -> row,
					widget -> col);
	del_widget (widget);

	return 0;
}

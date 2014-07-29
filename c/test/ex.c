#include <stdio.h>

typedef struct _foo {
	int a;
} foo;

int main(int argc, const char *argv[])
{
	foo a, b;
	a.a = 1;
	b = a;
	if (&a == &b) {
		printf ("it' equal\n");
	}
	else {
		printf ("sorry\n");
	}

	return 0;
}

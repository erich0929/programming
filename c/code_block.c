#include <stdio.h>

typedef void func ();

void caller (func);
static void print ();

int main(int argc, const char *argv[])
{
	caller (print);
	return 0;
}

void caller (func f) {
	f ();
}


	static void print () {
		printf ("do it now\n");
	}


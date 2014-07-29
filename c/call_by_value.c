#include <stdio.h>
#include <string.h>

int add (int a, int b);

typedef struct local_t {
	char id [20];
}local;

local get_local (char []);

int main(int argc, const char *argv[])
{
	int total;
	total = add (1, 5);
	printf ("%d\n", total);	
	local data;
	data = get_local ("erich0929");
	printf ("%s\n", data.id);
	return 0;
}

int add (int a, int b) {
	int sum;
	sum  = a + b;
	return sum;
}

local get_local (char name []) {
	local var;
	strncpy (var.id, name, 20);
	return var;
}

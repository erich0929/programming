#include <stdio.h>

int main(int argc, const char *argv[])
{
	char* arr[] = {
					"hello",
					"world",
					"EXIT"
	};
	
	printf ("sizeof (arr) : %d\n \
			sizeof (arr[1]) : %d\n \
			sizeof (arr) / sizeof (arr[1]) : %d\n",
			sizeof (arr), sizeof (arr[1]), sizeof (arr) / sizeof (arr[1]));

	return 0;
}

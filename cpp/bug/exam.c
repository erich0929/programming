#include <stdio.h>

int first (void) {
	int i = 0;
	return (i++);
}

int second (void) {
	static int i = 0; //정적변수
	return i++;
}

int main () {
	int counter; 

	for (counter = 0; counter < 3; counter ++) 
		printf ("First %d\n", first ());

	for (counter = 0; counter < 3; counter ++) 
		printf ("Second %d\n", second ());

	return 0;
}

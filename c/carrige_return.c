#include <stdio.h>
#include <unistd.h>

int main(int argc, const char *argv[])
{
	int i;
	volatile int j;
	char* wating [] = {	"Calculating     ",
						"Calculating .   ",
						"Calculating ..  ",
						"Calculating ... ",
						"Calculating ...."
	};

	for (i = 0; i < 5; ++i) {
		for (j = 0; j < 6; ++j) {
			fprintf (stdout, "\r%s", wating [j%5]);
			fflush (stdout);
			usleep (100000);
		}		
		fprintf (stdout, "\rcomplete ... !!          \n");
	}
	return 0;
}

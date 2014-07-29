#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

int main(void)
{
	int fd[2];
	int i, myint;

	pipe (fd);
	dup2 (fd[0], STDIN_FILENO);
	dup2 (fd[1], STDOUT_FILENO);
	close (fd[0]);
	close (fd[1]);

	for (i=0;i<10;i++) {
			printf ("%d ", i);
			fflush (stdout);
			scanf ("%d", &myint);
			fprintf (stderr, "%d\n", myint);
	}

	return 0;
}

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

int main(int argc, const char *argv[])
{
	int fd[2];
	int i, myint;
	pid_t childpid;

	pipe (fd);
	dup2 (fd[0], STDIN_FILENO);
	dup2 (fd[1], STDOUT_FILENO);
	close (fd[0]);
	close (fd[1]);

	pipe (fd);
	
	childpid = fork ();
	if (childpid > 0)
			dup2 (fd[1], STDOUT_FILENO);
	else if (childpid == 0)
			dup2 (fd[0], STDIN_FILENO);
	close (fd[0]);
	close (fd[1]);

	if (childpid > 0) {
		i=1;
		while (myint < 10) {
			read (STDIN_FILENO, &i, sizeof (myint));
			myint += i;
			write (STDOUT_FILENO, &myint, sizeof (myint));
			fprintf (stderr, "%d\n", myint);
		}
	}
	else if (childpid == 0) {
		myint=1;
		while (myint < 10) {
			write (STDOUT_FILENO, &myint, sizeof (myint));
			read (STDIN_FILENO, &myint, sizeof (myint));
		}
	}
	return 0;
}

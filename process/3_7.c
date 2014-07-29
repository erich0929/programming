#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main(void)
{
	pid_t childpid;
	pid_t mypid;

	mypid = getpid ();
	childpid = fork ();

	if (childpid == -1) {
		/* code */
		perror ("Failed to fork");
		return 1;
	}
	if (childpid == 0) {
		/* code */
		printf ("I am child %ld, ID = %ld\n", (long) getpid (), mypid);
	}
	else {
		printf ("I am parent %ld, ID = %ld\n", (long) getpid (), mypid);
	}

	return 0;
}

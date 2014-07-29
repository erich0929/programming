#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <errno.h>

#define SEMKEY 0x100

union semun {
	int val;
	struct semid_ds *buf;
	ushort *array;
};

int main(int argc, const char *argv[])
{
	pid_t childpid = 0;
	int i, n;

	int semid;

	union semun arg;
	
	typedef struct _foo
	{
		int i;
		pid_t pid;
	} foo;
	
	struct sembuf semopen = {0, -1, SEM_UNDO};
	struct sembuf semclose = {0, 1, SEM_UNDO};

	/* init sem */
	if ((semid = semget (SEMKEY, 1, 0666|IPC_CREAT|IPC_EXCL)) == -1) {
		if (errno == EEXIST) {
				semid = semget (SEMKEY, 1, 0);
		}
	}
	else {
		arg.val = 1;
		semctl (semid, 0, SETVAL, arg);	
	}
	
	foo info; 

	if (argc != 2)
	{
		fprintf (stderr, "Usage : %s processes\n", argv[0]);
		return 1;
	}
	n = atoi (argv[1]);
	for (i = 1; i < n; i++) 
	{
		/* code */
		if (childpid = fork ())
			break;
	}
	
	info.i = i;
	info.pid = getpid ();

	i=0;
	
	/* critical section */
	if (semop (semid, &semopen, 1) == -1)
	{
		return 1;
	}

	while (i < 2)
	{

			fprintf (stderr, "No. %d : my pid : %ld, i : %d\n",i, (long) info.pid, info.i);
			i ++;
	}
	
	semop (semid, &semclose, 1);

	return 0;
}

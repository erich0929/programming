#include <pthread.h>
#include <stdio.h>
#include <time.h>

void *pthread_func (void* arg) {
		int i = 0;
		printf ("thread starting ...\n");
		while (1) {
				if (i%10 == 1)
					printf ("I'am working well : %d\n", pthread_self ());	
			   	i++; 
		}
}

int main(void)
{
	pthread_t tid[3];
	int error;
	int data;
	int i;
	for (i=0;i<3;i++)
	if (error = pthread_create (&tid, NULL, pthread_func, (void *)data)) {
			fprintf (stderr, "Failed to create thread!: %s\n", strerror (error));
			return 1;
	}

	sleep (10);
	return 0;
}

#include<stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <signal.h>
#include <stdlib.h>

unsigned long nr_total = 0, nr_caractere = 0, moment[7];
int pipe1[2],pipe2[2];
pid_t pid;
int j=0,secunde=0;

void semnal1(){
	printf("%d.SIGUSR1.\n",j+1);
	moment[j] = nr_caractere;
	j++;
	nr_total+=nr_caractere;
	nr_caractere=0;
}

void semnal2(){
	int i;
	write(pipe2[1], &nr_total, sizeof(unsigned long));
	for (i = 0; i < 7; i++)
		write(pipe2[1], &moment[i], sizeof(unsigned long));
	close(pipe2[1]);
	exit(0);
}

void alarma(){
    	int i=0;
	if (secunde == 7){
		kill(pid, SIGUSR2);
		read(pipe2[0], &nr_total, sizeof(unsigned long));
		printf("Child process reached end.\nStatistica:\n");
		while (read(pipe2[0], &moment[i], sizeof(unsigned long)) > 0){
			printf("In secunda %d s-au transmis %ld caractere.\n",i+1, moment[i]);
			i++;
		}
		printf("Numarul total de caractere: %ld\n", nr_total);
		close(pipe2[0]);
		exit(0);

	}
	else{
		kill(pid, SIGUSR1);
		secunde++;
		alarm(1);
	}
}

int main(){
	char buffer;
	pipe(pipe1);
	pipe(pipe2);
	pid = fork();
	if (pid != 0){
		close(pipe1[0]);
		close(pipe2[1]);
		signal(SIGALRM, alarma);
		alarm(1);
		while(1)
			write(pipe1[1], "e", 1);
		close(pipe1[0]);
		close(pipe2[1]);
	}
	else{	
		close(pipe1[1]);
		close(pipe2[0]);
		signal(SIGUSR1, semnal1);
		signal(SIGUSR2, semnal2);
		while(read(pipe1[0], &buffer, 1) > 0)
			nr_caractere++;
		close(pipe1[0]);	
		close(pipe2[0]);
		exit(0);
	}
	return 0;
}

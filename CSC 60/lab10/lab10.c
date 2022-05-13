/* Author(s): Youser Alalusi                    	
 * This is csc60mshell.c
 * This is lab10.c the csc60mshell
 * This program serves as the base for doing labs 9 and 10.
 * Student is required to use this program to build a mini shell
 * using the specification as documented in the directions.
 * Date: Spring 2021
 */

#include "lab9_10.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>

#define MAXLINE 80
#define MARARGS 20
#define MAX_PATH_LENGTH 50
#define TRUE 1

/* ----------------------------------------------------------------- */
/*                  The main program starts here                     */
/* ----------------------------------------------------------------- */
int main(void){
char cmdline[MAXLINE];
char *argv[MAXARGS];
int argc;

while(TRUE){
	printf("\ncsc60msh >");
	fgets(cmdline, MAXLINE, stdin);
	argc = ParseLine(cmdline, argv);

	printf("Agc = %i \n", argc);
	int i;
	for(i = 0; i < argc; i++){
	printf("Argv %i = %s\n",i,argv[i]);
	}

	if(argc == 0)continue;
	if(strcmp("exit",argv[0])==0)exit(0);
	else if(strcmp("pwd",argv[0])==0){
	char path[MAX_PATH_LENGTH];
	getcwd(path,MAX_PATH_LENGTH);
	printf("%s\n",path);
	}
	
	else if(strcmp("cd",argv[0])==0){
	char *dir;
	if(argc==1){
	dir = getenv("HOME");
	}
	else{
	dir = getenv(argv[1]);
	int check = chdir(argv[1]);
	if(check <0)
	printf("\n error changing directory \n");
	
	RunExternalCommand(argc, argv);
	}
	}
	}
	}


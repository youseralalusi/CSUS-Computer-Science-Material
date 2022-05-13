/* Author(s): Youser Alalusi                    	
 * This is csc60mshell.c
 * This is lab9.c the csc60mshell
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
int parsing(char *cmdlline, char **argv);
int main(void)
{
	char cmdline[MAXLINE];
	char *argv[MAXARGS];
  	char * path1 = (char*)malloc(50);	
	int argc;
    	int status;
	pid_t pid;

    // Loop forever to wait and process commands 
    while (TRUE) 
    {
	printf("\ncsc60msh>");

	/* read the command the user types in */
	fgets(cmdline, MAXLINE, stdin);

	/* Call ParseLine to build argc/argv; their limits declared above */
        // You write this call
   
    
	// REQUIRED: Just-to-make-sure printfs 
      	argc = ParseLine(cmdline,argv);

	if(argc == 0)
	continue;

	if(strcmp(argv[0], "exit") == 0){
	exit(0);

	}
	else if(strcmp(argv[0], "pwd") == 0){
	if(getcwd(path1, MAX_PATH_LENGTH) == NULL){
	printf("%s %s\n", strerror(errno), path1);
	

	}
	printf("%s\n", path1);

	}
	else if(strcmp(argv[0], "cd") == 0){
	if(argc ==1){
	path1 = getenv("HOME");
	if(path1!= NULL){
	if(chdir(path1)!= 0){
	printf("%s %s\n", strerror(errno), path1);
		
	}
	}
	}
	else{
	if(chdir(argv[1])!= 0){
	printf("%s%s\n", strerror(errno), argv[1]);
	
	}
	}
	}
	}
	}
	int parsing(char *cmdline, char **argv){
	int count = 0;
	char *separator = "\n\t";
	argv[count] = strtok(cmdline, separator);
	while ((argv[count] != NULL) && (count + 1 < MAXARGS))
	argv[++count] = strtok((char *)0, separator);
	return count;
	
	}

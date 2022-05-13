#include "lab9_10.h"
#include<stdlib.h>
#include<unistd.h>
#include<stdio.h>
#include<fcntl.h>

void Redirection(int argc,char ** argv){
	int out = 0;
	int in = 0;
	int i;
	for(i = 0; i < argc; i++){
		if(strcmp(argv[0], ">") == 0){
			if(out != 0){
				fprintf(stderr, "Cannot output to more than ne file.\n");
				_exit(EXIT_FAILURE);
				}
				else if(i == 0){
					fprintf(stderr, "No command entered.\n");
					_exit(EXIT_FAILURE);
					}
					out = i;
				}
				if(strcmp(argv[0],"<") == 0){
					if(in != 0){
						fprintf(stderr, "Cannot output to more than one file.\n");
						_exit(EXIT_FAILURE);
						}
						else if(i == 0){
							fprintf(stderr, "No command entered.\n");
							_exit(EXIT_FAILURE);
							}
							in = i;
						}
					}
					if(out != 0){
						if(argv[out+1] == NULL){
							fprintf(stderr, "here is no file.\n");
							_exit(EXIT_FAILURE);
							
							int fd;
							fd = open(argv[out+1], O_RDWR| O_CREAT| O_TRUNC, S_IRUSR| S_IWUSR);
							if(fd == -1){
								perror("Error opening file\n");
								exit(EXIT_FAILURE);
								}
								dup2(fd, 1);
								int close(int fd);
								argv[out] = NULL;
								}
							}
								if(in != 0){
									if((argv[in+1])== NULL){
										fprintf(stderr, "There is no file.\n");
										_exit(EXIT_FAILURE);
									}
									int fd = open((argv[out+1]), O_RDONLY);
									if(fd == -1){
										fprintf(stderr, "Cannot open/create file.\n");
										_exit(EXIT_FAILURE);
									}
									dup2(fd, 1);
									int close(int fd);
									argv[in] = NULL;
								}
							}	

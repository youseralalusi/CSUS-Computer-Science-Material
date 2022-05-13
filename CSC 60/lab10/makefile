#Youser Alalusi Lab10
lab10: lab10.o ParseLine.o ProcessInput.o Redirection.o RunExternalCommand.o
	gcc lab10.o ParseLine.o ProcessInput.o Redirection.o RunExternalCommand.o  -o lab10

lab10.o: lab10.c lab9_10.h
	gcc -c lab10.c -Wall

ParseLine.o: ParseLine.c lab9_10.h
	gcc -c ParseLine.c -Wall

ProcessInput.o: ParseLine.c lab9_10.h
	gcc -c ProcessInput.c -Wall

Redirection.o: Redirection.c lab9_10.h
	gcc -c Redirection.c -Wall

RunExternalCommand.o: RunExternalCommand.c lab9_10.h
	gcc -c RunExternalCommand.c -Wall

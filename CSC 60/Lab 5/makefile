#Youser Alalusi Lab 5

labfive: lab5.o open_in_file.o open_out_file.o print_headers.o find_box_values.o
	gcc lab5.o open_in_file.o open_out_file.o print_headers.o find_box_values.o -o labfive 

lab5.o: lab5.c lab5.h
	gcc -c lab5.c 

open_in_file.o: open_in_file.c lab5.h
	gcc -c open_in_file.c

open_out_file.o: open_out_file.c lab5.h
	gcc -c open_out_file.c 

open_headers.o: print_headers.c lab5.h
	gcc -c print_headers.c 

find_box_values.o: find_box_values.c lab5.h
	gcc -c find_box_values.c


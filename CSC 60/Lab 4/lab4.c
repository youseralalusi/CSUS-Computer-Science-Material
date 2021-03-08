/*--------------------------------------------*/
/* Youser Alalusi                                  */
/* CSC 60-5 Lab 4                             */
/* Figure the area of a parabola using files  */

#include <stdio.h>
#include <stdlib.h>

#define IN_FILE_NAME "lab4.dat"
#define OUT_FILE_NAME "lab4.txt"

int main(void)
{
    double length, depth, area;
    FILE *infile = fopen(IN_FILE_NAME, "r");
    FILE *outfile = fopen(OUT_FILE_NAME, "w+");

    fprintf(outfile, "\nYouser Alalusi.  Lab 4. \n\n");
    fprintf(outfile, "Data on Parabolas \n\n");
    fprintf(outfile, " Length      Depth        Area   \n");
    fprintf(outfile, "--------   ---------   --------- \n");
	
	while((fscanf(infile, "%lf%lf", &length, &depth)) == 2) {
		area = 2 * length * depth / 3;
		fprintf(outfile, "%7.2lf%11.2lf%13.3lf\n",length, depth, area);
	}

    fprintf(outfile, "\n\n");

	fclose(infile);
	fclose(outfile);

    return EXIT_SUCCESS;
}
/*---------------------------------------------------*/

#include "lab5.h"

void find_box_values(FILE *data_out, FILE *data_in, double l, double h, double w, double *vol, double *s_area)
{
	while((fscanf(data_in, "%lf%lf%lf", &l, &w, &h)) ==3)
	{
	
	*vol = l*w*h;
	*s_area = 2.0*(l*w + h*w + h*l);
	fprintf(data_out, "%7.2lf%7.2lf%7.2lf%9.2lf%10.2lf\n", l,w,h,*vol,*s_area);
	}
	fprintf(data_out, "\n\n");
	return;


} 

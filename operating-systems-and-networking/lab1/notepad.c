//Egemen Balli 16 Oct 2023

#include <stdio.h>

int main() 
{ 
	FILE *fp; 
	fp = fopen("Test.txt", "w"); 
	int i;
	for(i = 0; i < 10; i++){
		fprintf(fp, "%s\n", "Egemen Balli   20070006005");	
	} 
	fclose(fp); 
	system("pause"); 
	return 0; 
} 

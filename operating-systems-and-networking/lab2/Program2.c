//Egemen Balli 23 Oct 2023
#include<stdio.h>
#include<pthread.h>
int num = 0;
pthread_mutex_t lock;
FILE *fp; 
void thread1()
{
 while(1)
 {
 	if(num < 5){
 		pthread_mutex_lock(&lock);
 		fprintf(fp, "%s%d\n", "Thread 1 - ", num);
 		num++;
 		sleep(1);	
 		pthread_mutex_unlock(&lock);	
	}
 }
}
void thread2()
{
 while(1)
 {
 	if(num > 4 && num < 10){
		pthread_mutex_lock(&lock);
 		fprintf(fp, "%s%d\n", "Thread 2 - ", num);
 		num++;
 		sleep(1);
	 	pthread_mutex_unlock(&lock); 		
	}
 }
}
void main()
{
	fp = fopen("Program2.txt", "w");
 	pthread_t t1,t2;
 	pthread_mutex_init(&lock, NULL);
 	pthread_create(&t1,NULL,thread1,NULL);
 	pthread_create(&t2,NULL,thread2,NULL);
 	pthread_join(t1,NULL);
 	pthread_join(t2,NULL);
 	fclose(fp); 
 	system("pause");
}


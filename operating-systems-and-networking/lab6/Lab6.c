//Egemen BALLI 27 Nov 2023

#include <stdio.h>

void swap(int *a,int *b)
{
    int temp=*a;
    *a=*b;
    *b=temp;
}

int main()
{
    int n;
    printf("Enter Number of Processes: ");
    scanf("%d",&n);

    int b[n],p[n],index[n];
    for(int i=0;i<n;i++)
    {
        printf("Enter the process no, burst time and priority\n");
        scanf("%d",&index[i]);
        scanf("%d",&b[i]);
        scanf("%d",&p[i]);
    }

    for(int i=0;i<n;i++)
    {
        int a=p[i], m = i;

        for(int j=i; j<n; j++)
        {
            if(p[j] > a)
            {
                a=p[j];
                m=j;
            }
        }

        swap(&p[i], &p[m]);
        swap(&b[i], &b[m]);
        swap(&index[i],&index[m]);
    }

    printf("pno     btime   atime    wtime    ttime\n");
    int wait_time=0;
    int totalwtime=0;
    int totalttime=0;
    for(int i=n-1;i>=0;i--)
    {
        printf("%d          %d          %d          %d\n",index[i],b[i],wait_time,wait_time + b[i]);
        wait_time += b[i];
        totalwtime += wait_time;
        totalttime += wait_time + b[i];
    }
    printf("The average waiting time is:%f",totalwtime/n);
    printf("The average turn around time is:%f",totalttime/n);
    return 0;
}
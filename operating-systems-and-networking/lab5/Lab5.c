//Egemen Balli 20 Nov 2023
#include<stdio.h>
#include<conio.h> 
void main()
{
    int i,j,k,l,m=3,n,p=15,c=0;
    int a[20],b[20],q,min=50;
    printf("Enter the Number of Pages:");
    scanf("%d",&n);
    printf("Enter %d Page Numbers:",n);
    for(i=0; i<n; i++)
        scanf("%d",&a[i]);
    for(j=0; j<m; j++)
        b[j]=-1;
    for(i=0; i<n; i++)
    {
        for(j=0; j<m; j++)
        {
            if(a[i]==b[j])
                break;
            else
                continue;
        }
        if(j==m)
        {
            for(k=0; k<m; k++)
                if(b[k]==-1)
                {
                    b[k]=a[i];
                    break;
                }
            if(k==m)
            {
                min=50;
                for(j=0; j<m; j++)
                {
                    l=i-1;
                    while(l>=0)
                    {
                        if(a[l]==b[j])
                        {
                            if(l<min)
                            {
                                min=l;
                                p=j;
                            }
                            break;
                        }
                        l--;
                    }
                }
            }
            b[p]=a[i];
            c++;
        }   
            
        printf("\n%d",a[i]); printf("\t");
		for(k=0;k<m;k++){
			if(b[k] != -1){
				printf("%d",b[k]);
			}
		}

    }
    printf("\nNo of faults:%d",c); getch();
}

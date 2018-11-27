#include <stdio.h>
#include <stdlib.h>
char a[3][3];
int count=1,cr,cc,ut=1,ct=1;
int check();
void res();
void cturn();
void uturn();
void disp();
void pos();
int full();
int main()
{
    int i;
    time_t t;
    srand((unsigned) time(&t));
    if((rand()%50)%2==0)
    {
        uturn();
    }
    else
    {
        cturn();
    }
return 0;
}
void disp()
{
    int i,j;
    printf("\n");
    for(i=0;i<3;i++)
    {
        printf("---------------\n");
        for(j=0;j<3;j++)
        {

            printf("| %c |",a[i][j]);
        }
        printf("\n");
    }
    printf("---------------\n");

}
void uturn()
{
    int r,c;
    printf("User turn:\n");
    here:
    printf("Enter row and column:");
    scanf("%d%d",&r,&c);
    if(a[r-1][c-1]!=0)
    {
        printf("Ivalid move\n");
        goto here;
    }
    a[r-1][c-1]='x';
    disp();
    res();
    if(!full())
    cturn();
}
void cturn()
{
    printf("Computer turn:");
    if(ut==1)
        ct++;
    if(ct==1)
    {
        int i,j;
        i=rand()%3;
        j=rand()%3;
        a[i][j]='o';
        ct++;
    }
    else if(ct==2)
    {
        int i,j;
        i=rand()%3;
        j=rand()%3;
        while(a[i][j]!='x'&&a[i][j]!='o')
        {
            a[i][j]='o';
        }
        ct++;
    }
    else
    {
        pos();
        a[cr][cc]='o';
    }
    disp();
    res();
    if(!full())
    uturn();

}
int check()
{
    int i;
    for(i=0;i<3;i++)
    {
        if(a[i][0]=='x'&&a[i][1]=='x'&&a[i][2]=='x')
            return 1;
        else if(a[i][0]=='o'&&a[i][1]=='o'&&a[i][2]=='o')
            return 2;
    }
    for(i=0;i<3;i++)
    {
        if(a[0][i]=='x'&&a[1][i]=='x'&&a[2][i]=='x')
            return 1;
        else if(a[0][i]=='o'&&a[1][i]=='o'&&a[2][i]=='o')
            return 2;
    }
    if(a[0][0]=='x'&&a[1][1]=='x'&&a[2][2]=='x')
            return 1;
    else if(a[0][0]=='o'&&a[1][1]=='o'&&a[2][2]=='o')
        return 2;
    else if(a[0][2]=='x'&&a[1][1]=='x'&&a[2][0]=='x')
            return 1;
    else if(a[0][2]=='o'&&a[1][1]=='o'&&a[2][0]=='o')
            return 2;
    else
        return 0;
}
void pos()
{
    int i,j,r,c,n=0;
    //row for o
    for(i=0;i<3;i++)
    {
        if(a[i][0]==0&&a[i][1]=='o'&&a[i][2]=='o')
        {
            cr=i;
            cc=0;
            return ;
        }
        else if(a[i][0]=='o'&&a[i][1]==0&&a[i][2]=='o')
        {
            cr=i;
            cc=1;
            return ;
        }
        else if(a[i][0]=='o'&&a[i][1]=='o'&&a[i][2]==0)
        {
            cr=i;
            cc=2;
            return ;
        }
    }
    //col for o
    for(i=0;i<3;i++)
    {
        if(a[0][i]==0&&a[1][i]=='o'&&a[2][i]=='o')
        {
            cr=0;
            cc=i;
            return ;
        }
        else if(a[0][i]=='o'&&a[1][i]==0&&a[2][i]=='o')
        {
            cr=1;
            cc=i;
            return ;
        }
        else if(a[0][i]=='o'&&a[1][i]=='o'&&a[2][i]==0)
        {
            cr=2;
            cc=i;
            return ;
        }

    }
    //row for x
    for(i=0;i<3;i++)
    {
        if(a[i][0]==0&&a[i][1]=='x'&&a[i][2]=='x')
        {
            cr=i;
            cc=0;
            return ;
        }
        else if(a[i][0]=='x'&&a[i][1]==0&&a[i][2]=='x')
        {
            cr=i;
            cc=1;
            return ;
        }
        else if(a[i][0]=='x'&&a[i][1]=='x'&&a[i][2]==0)
        {
            cr=i;
            cc=2;
            return ;
        }
    }
    //col for x
    for(i=0;i<3;i++)
    {
        if(a[0][i]==0&&a[1][i]=='x'&&a[2][i]=='x')
        {
            cr=0;
            cc=i;
            return ;
        }
        else if(a[0][i]=='x'&&a[1][i]==0&&a[2][i]=='x')
        {
            cr=1;
            cc=i;
            return ;
        }
        else if(a[0][i]=='x'&&a[1][i]=='x'&&a[2][i]==0)
        {
            cr=2;
            cc=i;
            return ;
        }

    }
    //dia
    if(a[0][0]==0&&a[1][1]=='x'&&a[2][2]=='x')
    {
        cr=0;
        cc=0;
        return ;
    }
    else if(a[0][0]=='x'&&a[1][1]==0&&a[2][2]=='x')
    {
        cr=1;
        cc=1;
        return ;
    }
    else if(a[0][0]=='x'&&a[1][1]=='x'&&a[2][2]==0)
    {
        cr=2;
        cc=2;
        return ;
    }
    else if(a[2][0]==0&&a[1][1]=='x'&&a[0][2]=='x')
    {
        cr=2;
        cc=0;
        return ;
    }
    else if(a[2][0]=='x'&&a[1][1]==0&&a[0][2]=='x')
    {
        cr=1;
        cc=1;
        return ;
    }
    else if(a[2][0]=='x'&&a[1][1]=='x'&&a[0][2]==0)
    {
        cr=0;
        cc=2;
        return ;
    }
    //sup
    for(i=0;i<3;i++)
    {
        if(a[i][0]==0&&a[i][1]==0&&a[i][2]=='o')
        {
            if(rand()%2==0)
                cc=0;
            else
                cc=1;
            cr=i;
            return ;
        }
        else if(a[i][0]=='o'&&a[i][1]==0&&a[i][2]==0)
        {
           if(rand()%2==0)
                cc=1;
            else
                cc=2;
            cr=i;
            return ;
        }
        else if(a[i][0]==0&&a[i][1]=='o'&&a[i][2]==0)
        {
            if(rand()%2==0)
                cc=0;
            else
                cc=2;
            cr=i;
            return ;
        }
    }
    //col for o
    for(i=0;i<3;i++)
    {
        if(a[0][i]==0&&a[1][i]==0&&a[2][i]=='o')
        {
            if(rand()%2==0)
                cr=0;
            else
                cr=1;
            cc=i;
            return ;
        }
        else if(a[0][i]=='o'&&a[1][i]==0&&a[2][i]==0)
        {
            if(rand()%2==0)
                cr=1;
            else
                cr=2;
            cc=i;
            return ;
        }
        else if(a[0][i]==0&&a[1][i]=='o'&&a[2][i]==0)
        {
            if(rand()%2==0)
                cr=0;
            else
                cr=1;
            cc=i;
            return ;
        }

    }
    for(i=0;i<3;i++)
    {
        for(j=0;j<3;j++)
        {
            if(a[i][j]==0)
            {
                cr=i;
                cc=j;
            }
        }
    }
}
void res()
{
    char ch;
    if(check()==1)
    {
        printf("User wins\n");
        scanf("%c",&ch);
        exit(1);
    }
    else if(check()==2)
    {
        printf("Computer wins\n");
        scanf("%c",&ch);
        exit(1);
    }
    /*else
    {
        if(full())
        {
        printf("The Match is Draw!! Play Again....");
        exit(1);
        }
    }*/
}
int full()
{
    int i,j;
    for(i=0;i<3;i++)
    {
        for(j=0;j<3;j++)
        {
            if(a[i][j]==0)
                return 0;
        }
    }
    return 1;
}

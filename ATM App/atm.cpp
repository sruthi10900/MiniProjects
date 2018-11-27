#include <iostream>
#include <cmath>
#include <cstdlib>
#include <iomanip>
#include<fstream>
 float amount;

using namespace std;
class account
{
public:
        int acountnum;
        char pass;
        float cash;
        //public:
        bool getdata()
        {
                cout<<"\n Enter accout number :";
                cin>>acountnum;
		if(searchn(acountnum)!=false)
		{
                cout<<"\n enter password:";
                cin>>pass;
                cout<<"\n Enter initial cash:";
		cin>>cash;
                cin>>cash;
		return false;
		}
		cout<<"account already exists\n";
		return true;
        }
        void display()
        {
                cout<<"\n account number:"<<acountnum;
                
                cout<<"\n remaining amount:"<<cash;
        }
       void writedata()
        {
                ofstream fos;
                fos.open("details.dat",ios::binary|ios::app);
                account s;
                cout<<"\n enter account info:";
                if(s.getdata()==false)
                fos.write((char*)&s,sizeof(s));
        }
       void readdata()
        {
                ifstream fis;
                fis.open("details.dat",ios::binary);
                account s;
                while(fis.read((char*)&s,sizeof(s)))
                {
			s.display();
                }
                fis.close();
        }
	bool searchn(int n)
        {

                ifstream fis;
                fis.open("details.dat",ios::binary);
                account s;
                while(fis.read((char*)&s,sizeof(s)))
                {
                        if(s.acountnum==n)
                        return false;
                }
		return true;
        }
	float searchc(int n)
        {

                ifstream fis;
                fis.open("details.dat",ios::binary);
                account s;
                while(fis.read((char*)&s,sizeof(s)))
                {
                        if(s.acountnum==n)
                        return s.cash;
                }
		
        }
	bool searchpas(int n,int p)
        {

                ifstream fis;
                fis.open("details.dat",ios::binary);
                account s;
                while(fis.read((char*)&s,sizeof(s)))
                {
                        if(s.acountnum==n&&s.pass==p)
			{
			amount=s.cash;
                        return false;
			
			
			}
                }
		return true;
        }
        void search(int n)
        {

                ifstream fis;
                fis.open("details.dat",ios::binary);
                account s;
                while(fis.read((char*)&s,sizeof(s)))
                {
                        if(s.acountnum==n)
			{
                        s.display();
			}
			
                }
        }
        void deleterecord(int n)
        {
                ifstream ifs;
                ifs.open("details.dat",ios::binary);
                account s;
                ofstream ofs;
                ofs.open("temp.dat",ios::binary);
                while(ifs.read((char*)&s,sizeof(s)))
                {
                        if(!(s.acountnum==n))
			{
				
                                ofs.write((char*)&s,sizeof(s));
				cout<<"account deleted\n";
			}
			
                }
                remove("details.dat");
                rename("temp.dat","details.dat");
		
        }
void modifyrecord(int n)
        {
                fstream fs;
                fs.open("details.dat",ios::in|ios::out);
                account s;
                int found=0;
                while(fs.read((char*)&s,sizeof(s))&&found==0)
                {
                        cout<<"size is"<<sizeof(s);
                        if(s.acountnum==n)
                        {
                        s.display();
                        cout<<"Enter the  new details of account";
                        s.getdata();
                        int pos;
                        pos=-1*sizeof(s);
                        fs.seekp(pos,ios::cur);
                        fs.write((char*)&s,sizeof(s));
                        found=1;
                        }

                }
        }
void modifywithdraw(int x,int n)
        {
                fstream fs;
                fs.open("details.dat",ios::in|ios::out);
                account s;
                int found=0;
                while(fs.read((char*)&s,sizeof(s))&&found==0)
                {
                        cout<<"size is"<<sizeof(s);
                        if(s.acountnum==x)
                        {
                        s.cash=n;
                        int pos;
                        pos=-1*sizeof(s);
                        fs.seekp(pos,ios::cur);
                        fs.write((char*)&s,sizeof(s));
                        found=1;
                        }

                }
        }
void modifypin(int x,int n)
        {
                fstream fs;
                fs.open("details.dat",ios::in|ios::out);
                account s;
                int found=0;
                while(fs.read((char*)&s,sizeof(s))&&found==0)
                {
                        cout<<"size is"<<sizeof(s);
                        if(s.acountnum==x)
                        {
                        s.pass=n;
                        int pos;
                        pos=-1*sizeof(s);
                        fs.seekp(pos,ios::cur);
                        fs.write((char*)&s,sizeof(s));
                        found=1;
                        }

                }
        }





}main1;
 
int mainMenu();
int mainmenuadmin();
int menu();
int menuadmin();
void displayBalance();
void withdrawFunds();
void depositFunds();
void changepasword();
 
 
  float balance= 250000.00;

 
 
int main()
{
 
 cout << fixed << showpoint << setprecision(2); 
 
 account a;
int n;
    int ac_number= 258647;
    int pin= 33284;
 
        cout <<"\t**********************************************************\n" << endl
            <<" \t\t    THE INTERNATIONAL BANK\n\n\t\t\t ------* WELCOME *------\n" << endl
             <<"\t**********************************************************\n\n"
	<<"\t\t        PRESS 1 TO CONTINUE AS ADMIN \n\n";
	cin>>n;
	if(n==1)
	{
			cout<<"\t\t\t\tADMIN LOGIN" << endl;
			cout<<"\t\t\t\tENTER PASSWORD"<<endl;
			cin>>pin;
			if(pin==1000)
			{

			cout<<"\t\t\t IN ADMIN MODE\n";
			
			mainmenuadmin();
			}
			else
			{
				cout<<"\n\t\tWRONG PIN ENTERED..CHECK YOUR PIN\n"<<endl;
				return 0;
			}
			

}
	else
	{
             cout<<"\t\t\t\tUSER LOGIN" << endl
             << "\n\t\t\t------ Enter Account Number: ";
           cin  >> ac_number;
        cout << "\n\t\t\t------ Enter PIN: ";
           cin  >> pin;
        cout << "\n";
	account s;
	/*if(s.searchpas(ac_number,pin)!=false)
	{
		cout<<"\t\t USER LOGGED IN SUCCESFULLY";
	}*/
		
 
      while (s.searchpas(ac_number,pin)==false)
  {    
                    system ("CLS"); // Clears screen
              
          cout <<"\t**********************************************************\n" << endl
     <<" \t\t    THE INTERNATIONAL BANK\n\n\t\t\t ------* WELCOME *------\n" << endl
             <<"\t**********************************************************\n\n"
             <<"\t\t\t\tUSER LOGIN\n" << endl
             <<"\t\tINVALID ACCOUNT NUMBER OR PIN WAS ENTERED\n" << endl
             << "\n\t\t\t------ Enter Account Number: ";
           cin  >> ac_number;
        cout << "\n\t\t\t------ Enter PIN: ";
           cin  >> pin;
        cout << "\n";
  }
 
 main1.acountnum=ac_number;
main1.pass=pin;

            system ("CLS");
            menu(); //function call

 }
}
int menuadmin()
{

    cout<<"\n1. Add new account";
    cout<<"\n2. View all accounts";
    cout<<"\n3. Search accounts";
cout<<"\n4. modify accounts";
    cout<<"\n5. delete account";
    cout<<"\n6. Exit";
    cout<<"\n\nEnter your choice";
    int ch;
    cin>>ch;
    return(ch);
}
int mainmenuadmin()
{
     	account s;
        int ch;
        ch=menuadmin();
        while(1)
        {

                switch(ch)
                {
                        case 1:s.writedata();
                                break;
                        case 2:s.readdata();
                                break;
                        case 3:cout<<"enter acountnum to be searched";
                                int n;
				cin>>n;
                                s.search(n);
                                break;
			case 4:cout<<"enter acountnum to be modified";
				int p;
				cin>>p;
				s.modifyrecord(p);
				break;
                        case 5:cout<<"enter acountnum to be deleted";
                                int g;
                                cin>>g;
                                s.deleterecord(g);
                                break;
				
                        case 6:exit(1);
                }

                ch=menuadmin();
        }
}
 
 
  int menu(){
 
         switch(mainMenu()){
          
  case 1:
 system("cls");
     displayBalance();
     menu(); 
  break;
          
  case 2:
 system("cls");
     withdrawFunds();
     menu(); 
  break;
 
 
  case 3:
 system("cls");
     depositFunds();
     menu(); 
  break;
 
 case 4:
	changepasword();
	menu();
break;
  case 5:
     exit(0);
  break;
 
 
   default:   
     cout <<"\nINVALID ENTRY.... Please Select numbers 1 - 5\n" <<endl <<endl;
     system("pause");
     menu(); 
  break;     
          
}
 
 
system("pause");  
return 0;   
 
 
}
 
 
int mainMenu(){
   
        system("cls");
 
 
    int input;
     
  cout <<"\t____________________________________________\n" << endl    
             <<"\t"<<"*************  MENU  *************" << endl   
            <<"\t____________________________________________\n\n" << endl;
 
  cout <<"\tPlease Enter the number for the Transaction\n" << endl
             << "\t\tPress 1. ----->> Balance Inquiry\n" << endl
             << "\t\tPress 2. ----->> Withdrawal\n" << endl
             << "\t\tPress 3. ----->> Deposit\n" << endl
	     << "\t\tPress 4. ----->>Change password\n"<<endl
             << "\t\tPress 5. ----->> Exit\n" << endl;
 
  cout <<"\t_________________________________________\n" << endl
             << "\t ENTER TRANSACTION NUMBER:- ";           
  cin >> input;
 
 
  return input;
} 
 
  void displayBalance(){
             
		account s;
		
cout<<"pp";
			balance=s.searchc(main1.acountnum);
		
                cout << "\nAccount Balance is: $" << balance  <<"\n" << endl;
 
 
                system ("PAUSE");
                system ("CLS");
  }
  
  void withdrawFunds(){
 
       double withdraw = 0.0;
 
         cout << "\tYou have opted to withdraw money\n" << endl           
             << " Please Enter amount you with to withdraw --Type 0 to return to menu: $";
        cin  >> withdraw;
        cout <<"\n";
  
       system ("cls");                
            if (withdraw == 0){
         
                    system("cls");
                    menu();
             	}
             else if (withdraw != 0){      
             		if ( withdraw > balance){         
                        system ("CLS"); 
        cout << "Value Exceeds Current balance Please enter smaller amount\n" << endl
             << "Please Enter Amount you Wish to Withdraw: $";
        cin >> withdraw;
                         system ("CLS"); 
            if (withdraw == 0){
         
                    system("cls");
                  
                    menu();
             }
 
 
        cout << "\nYou Have Withdrawn: $" << withdraw << " From your Accout" <<"\n"<< endl;
              balance = balance - withdraw;
		
        cout << "Balance is now: $" << balance <<"\n" << endl;
	main1.modifywithdraw(main1.acountnum,balance);
	
         
                        system ("PAUSE");
                        system ("CLS"); 
             }
              else {
         
        cout << "\nYou Have Withdrawn: $" << withdraw << " From your Accout" << endl;
            balance = balance - withdraw;
        cout << "\nBalance is now: $" << balance <<"\n" << endl;   
	main1.modifywithdraw(main1.acountnum,balance);
	     
                        system ("PAUSE");
                        system ("CLS");
      } 
    }
  }
 
 

    void depositFunds(){ 
        double deposit = 0.0;
 
 
        cout << "\tYou Have Opted to Deposit Money\n" << endl
             << " Please Enter Amount You Wish to Deposit --Type 0 to return to Menu: $";
        cin  >> deposit;
        cout <<"\n"; 
                    system ("cls");           
                     
             if (deposit == 0){
         
                    system("cls");
                  
                    menu();
             }        
             else if (deposit != 0){
                    balance= balance + deposit;
                    
        cout << "You Have Successfully added $" << deposit << " to your Account\n" << endl;
        cout << "Balance is Now $" << balance << "\n" <<endl;   
	main1.modifywithdraw(main1.acountnum,balance);
                    system("pause");
                    system ("cls");
    }
  }

void changepasword()
{
	int pin;
	 cout << "\tYou Have Opted to Change Password\n" << endl
             << " Please Enter New Password --Type 0 to return to Menu: $";
        cin  >> pin;
        cout <<"\n"; 
                    system ("cls");           
                     
             if (pin == 0){
         
                    system("cls");
                  
                    menu();
             }    
else if (pin != 0){
    main1.modifypin(main1.acountnum,pin);
                    system("pause");
                    system ("cls");
    }
cout<<"PASSWORD CHANGE SUCCESS\n";
			
}

import java.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/*<applet code="java" width=500 height=500>
</applet>*/
class Book
{
	String bname;
	int bcost;
	Book(String name, int cost)
	{
		bname=name;
		bcost=cost;
	}
	public String toString()
	{
		return " book name      "+bname+"             cost:"+bcost;
	}
}
public class java extends Applet implements ActionListener,ItemListener
{

	Panel main;
	Panel p1,p2,p3,p4,p5,p6,panel1,panel2,panel3,panel4,panel5,panel6,panel7,temp1;
	CardLayout cl;
	Button Admin,User,ok,addbook,delete,ok1,ok3,ok4,ok5,ok100,ok99,ok98,ok97,cancel99,paymentb1,paymentb2,other;
	GridBagLayout gbl;
	GridBagConstraints gbc0,gbc,gbc1,gbc2,gbc3,grid1,grid2,grid3;
	TextField pass,name,cost,dname;
	Label a18,a19,a20,a21,g3,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	TextField tx,cardnum,password;
	TextArea tx1;
	Frame f;
	Font f0=new Font("Times new Roman",Font.BOLD,18);
	Checkbox CSE,ECE,EEE,MECH,IT,comp,elect,eloct,mechanical,information;
	CheckboxGroup cbg;
	Dimension d2= new Dimension(500,500);
	ArrayList<Checkbox> alcomp= new ArrayList<Checkbox>();
	ArrayList<Checkbox> alelect= new ArrayList<Checkbox>();
	ArrayList<Checkbox> aleloct= new ArrayList<Checkbox>();
	ArrayList<Checkbox> almechanical= new ArrayList<Checkbox>();
	ArrayList<Checkbox> alinformation = new ArrayList<Checkbox>();
	ArrayList<Book> cse=new ArrayList<Book>();
	ArrayList<Book> ece=new ArrayList<Book>();
	ArrayList<Book> eee=new ArrayList<Book>();
	ArrayList<Book> mech=new ArrayList<Book>();
	ArrayList<Book> it=new ArrayList<Book>();
	int total=0;
	String p;
	int j;
	Frame f1,j1,f2;
	Dialog d;
	Book b;
    int k;



public void init()
{
	main=new Panel();

	main.setLayout(cl=new CardLayout());
	p1=new Panel();
	p2=new Panel();
	p3=new Panel();
	p4=new Panel();
	p5=new Panel();
	p6=new Panel();
	panel1=new Panel();
	panel2=new Panel();
	panel3=new Panel();
	panel4=new Panel();
	panel5=new Panel();
	panel6=new Panel();
	panel7=new Panel();
	f=new Frame();
	f1=new Frame();
	p1.setLayout(gbl=new GridBagLayout());
	p1.setLayout(gbl=new GridBagLayout());
	gbc=new GridBagConstraints();
	gbc1=new GridBagConstraints();
	gbc.fill=GridBagConstraints.BOTH;
	gbc1.fill=GridBagConstraints.BOTH;
	gbc2=new GridBagConstraints();
	gbc2.fill=GridBagConstraints.BOTH;
	gbc3=new GridBagConstraints();
	gbc3.fill=GridBagConstraints.BOTH;
	grid1=new GridBagConstraints();
	grid1.fill=GridBagConstraints.BOTH;
	grid2=new GridBagConstraints();
	grid2.fill=GridBagConstraints.BOTH;
    grid3=new GridBagConstraints();
	grid3.fill=GridBagConstraints.BOTH;
	gbc0=new GridBagConstraints();
	gbc0.fill=GridBagConstraints.BOTH;
	gbc.gridx=50;
	gbc.gridy=0;
	p1.add(Admin=new Button("Admin"),gbc);
	Admin.setFont(f0);
	gbc.gridy=100;
	p1.add(User=new Button("User"),gbc);
	User.setFont(f0);
	Admin.addActionListener(this);
	User.addActionListener(this);






	gbc1.gridx=20;
	gbc1.gridy=0;
	p2.add(l1=new Label("enter password"),gbc1);
	l1.setFont(f0);
	gbc1.gridx=50;
	
	p2.add(pass=new TextField(30),gbc1);
	pass.setEchoChar('*');
	gbc.gridy=5;
	p2.add(ok=new Button("OK"),gbc1);
	ok.setFont(f0);
	ok.addActionListener(this);

	gbc2.gridy=10;
	p3.add(addbook=new Button("add books"),gbc2);
	addbook.setFont(f0);
	gbc2.gridy=20;
	p3.add(delete=new Button("delete books"),gbc2);
	delete.setFont(f0);
	addbook.addActionListener(this);
	delete.addActionListener(this);

	cbg=new CheckboxGroup();

	gbc3.gridx=10;
	gbc3.gridy=10;
	p4.add(l2=new Label("Enter book name"));
	l2.setFont(f0);
	gbc.gridx=50;
	p4.add(name=new TextField(30),gbc3);
	gbc3.gridx=10;
	gbc3.gridy=30;
	p4.add(l3=new Label("Enter book cost"));
	l3.setFont(f0);
	gbc.gridx=50;
	p4.add(cost=new TextField(10),gbc3);
	gbc.gridy=60;
	p4.add(ok5=new Button("OK"));
	ok5.setFont(f0);
	ok5.addActionListener(this);

	gbc3.gridx=10;
	gbc3.gridy=10;
	p5.add(CSE=new Checkbox("cse",cbg,false),gbc3);
	CSE.setFont(f0);
	gbc3.gridy=20;
	p5.add(ECE=new Checkbox("ece",cbg,false),gbc3);
	ECE.setFont(f0);
	gbc3.gridy=30;
	p5.add(EEE=new Checkbox("eee",cbg,false),gbc3);
	EEE.setFont(f0);
	gbc3.gridy=40;
	p5.add(MECH=new Checkbox("mech",cbg,false),gbc3);
	MECH.setFont(f0);
	gbc3.gridy=50;
	p5.add(IT=new Checkbox("it",cbg,false),gbc3);
	IT.setFont(f0);
	gbc3.gridy=60;
	p5.add(ok3=new Button("OK"),gbc3);
	ok3.setFont(f0);
	ok3.addActionListener(this);
	CSE.addItemListener(this);
	ECE.addItemListener(this);
	EEE.addItemListener(this);
	MECH.addItemListener(this);
	IT.addItemListener(this);

	gbc3.gridx=10;
	gbc.gridy=10;
	p6.add(l4=new Label("give the name of book to be deleted"),gbc3);
	l4.setFont(f0);
	gbc.gridy=20;
	p6.add(dname=new TextField(30));
	p6.add(ok4=new Button("ok"));
	ok4.setFont(f0);
	ok4.addActionListener(this);

	grid1.gridx=50;
	grid1.gridy=1;
	panel1.add(l5=new Label("SELECT CATEGORY"));
	l5.setFont(f0);
	grid1.gridx=10;
	grid1.gridy=10;
	panel1.add(comp=new Checkbox("CSE"),grid1);
	comp.setFont(f0);
	grid1.gridy=20;
	panel1.add(elect=new Checkbox("ECE"),grid1);
	elect.setFont(f0);
	grid1.gridy=30;
	panel1.add(eloct=new Checkbox("EEE"),grid1);
	eloct.setFont(f0);
	grid1.gridy=40;
	panel1.add(mechanical=new Checkbox("MEC"),grid1);
	mechanical.setFont(f0);
	grid1.gridy=50;
	panel1.add(information=new Checkbox("IT"),grid1);
	information.setFont(f0);
	grid1.gridy=60;
	panel1.add(ok100=new Button("ok"),grid1);
	ok100.setFont(f0);
	 ok100.addActionListener(this);
	 comp.addItemListener(this);
	 elect.addItemListener(this);
	 eloct.addItemListener(this);
	 mechanical.addItemListener(this);
	information.addItemListener(this);
	grid2.gridx=10;
	grid2.gridy=10;

	panel3=new Panel();
	panel3.add(ok99=new Button("ok"));
	ok99.setFont(f0);
	ok99.addActionListener(this);
	temp1=new Panel();

	main.add(p1,"user or admin");
	add(main);
}


public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==Admin)
	{
		main.add(p2,"admin");
		cl.show(main,"admin");
	}

	if(ae.getSource()==User)
	{
		main.add(panel1,"user");
		cl.show(main,"user");
	}

	if(ae.getSource()==ok)
	{
		if(pass.getText().equals("1234"))
		{
		main.add(p3,"password");
		cl.show(main,"password");

		}

	else
	{
		Dialog d=new Dialog(f,"Password incorrect"	);
		d.add(new Label("incorrect password"));
		d.setVisible(true);
		d.setSize(300,150);

	}
	}
	if(ae.getSource()==ok3)
	{
		Panel temp =new Panel();
		temp.add(l6=new Label("BOOK ADDED"));
		l6.setFont(f0);
		temp.add(other=new Button("Back"));
		other.setFont(f0);
		main.add(temp,"last");
		cl.show(main,"last");
		other.addActionListener(this);

	}
	if(ae.getSource()==other)
	{
		pass.setText("");
		name.setText("");
		cost.setText("");
		cl.first(main);
	}
	if(ae.getSource()==addbook)
	{
		main.add(p4,"addbook");
		cl.show(main,"addbook");
	}

	if(ae.getSource()==delete)
	{
		main.add(p6,"delete");
		cl.show(main,"delete");


	}
	if(ae.getSource()==ok4)
	{

		Iterator<Book> itr=cse.iterator();
		while(itr.hasNext())
		{
			b=itr.next();
			if(b.bname==dname.getText())
			{
				cse.remove(b);

			}
		}
		 itr=ece.iterator();
		while(itr.hasNext())
		{
			b=itr.next();
			if(b.bname==dname.getText())
			{
				ece.remove(b);

			}
		}

		 itr=eee.iterator();
		while(itr.hasNext())
		{
			b=itr.next();
			if(b.bname==dname.getText())
			{
				eee.remove(b);

			}
		}
	 itr=mech.iterator();
		while(itr.hasNext())
		{
			b=itr.next();
			if(b.bname==dname.getText())
			{
				mech.remove(b);

			}
		}
		itr=it.iterator();
		while(itr.hasNext())
		{
			b=itr.next();
			if(b.bname==dname.getText())
			{
				it.remove(b);

			}
		}
	}
	if(ae.getSource()==ok5)
	{

	main.add(p5,"1");
	cl.show(main,"1");

	}
	if(ae.getSource()==ok100)
	{
		main.add(panel3,"list of books");
		cl.show(main,"list of books");
	}
	if(ae.getSource()==ok99)
	{
		Dialog x=new Dialog(f1,"PaymentConfirmation");
        x.add(new Label("The total cost is :"+total));
		x.add(new Label("Confirm payment?"));
		x.setSize(300,150);
		x.setVisible(true);
		x.setLayout(new FlowLayout());
		x.add(paymentb1=new Button("yes"));
		x.add(paymentb2=new Button("cancel"));
		paymentb1.addActionListener(this);
		paymentb2.addActionListener(this);
	}


	if(ae.getSource()==paymentb2)
	{
		f1.dispose();
	}
	if(ae.getSource()==paymentb1)
	{
		j1=new Frame();
	    j1.addWindowListener(new MyAdapter(j1));
            j1.setLayout(new GridBagLayout());
            grid3.gridx=20;
            grid3.gridy=20;
            j1.setSize(500,500);
            j1.setVisible(true);
            j1.add( a18=new Label("Enter Your Name"),grid3);
            a18.setFont(f0);
            grid3.gridx=60;
            j1.add(tx=new TextField(30),grid3);
		grid3.gridy=25;
            grid3.gridx=20;
            j1.add(a19=new Label("Enter Card Number"),grid3);
            a19.setFont(f0);
            grid3.gridx=60;
            j1.add(cardnum=new TextField(30),grid3);
             grid3.gridy=30;
            grid3.gridx=20;
		j1.add(a20=new Label("Enter password"),grid3);
		a20.setFont(f0);
		grid3.gridx=60;
		  j1.add(password=new TextField(30),grid3);
		grid3.gridy=35;
          grid3.gridx=20;
            j1.add(a21=new Label("Enter Address"),grid3);
            a21.setFont(f0);
            grid3.gridx=60;
            j1.add(tx1=new TextArea(5,5),grid3);
           // f1.add(j);
		grid3.gridx=40;grid3.gridy=50;
		j1.add(ok98=new Button("OK"),grid3);
		ok98.addActionListener(this);
		f1.add(j1);
	}

	if(ae.getSource()==ok98)
	{
		if(cardnum.getText().equals("8728637371902678")&&password.getText().equals("Itsmypassword")||cardnum.getText().equals("8481029319930291")&&password.getText().equals("Available")||cardnum.getText().equals("4495402229404195")&&password.getText().equals("Mypassword123")||cardnum.getText().equals("2647100748910290")&&password.getText().equals("Mypersonalpass")||cardnum.getText().equals("1093839930293008")&&password.getText().equals("Raju12345")||cardnum.getText().equals("9082838738391802")&&password.getText().equals("Priya1997")||cardnum.getText().equals("7267104332892314")&&password.getText().equals("Surya8989"))
		{
			j1.dispose();
			f1.dispose();
			Dialog d2=new Dialog(f2,"Order placed");
			d2.setSize(380,150);
			d2.setVisible(true);
			d2.add(g3=new Label("Order Successfully placed"));
			g3.setFont(f0);
		}
		else
		{
			j1.dispose();
			f1.dispose();
			Dialog d2=new Dialog(f2,"Order not placed");
			d2.setSize(380,150);
			d2.setVisible(true);
			d2.add(new Label("INVALID CARD NUMBER OR PASSWORD..!!PLEASE TRY AGAIN.."));
		}
	}
}
public void itemStateChanged(ItemEvent ie)
{
	if(ie.getSource()==comp)
	{
		if(comp.getState()==true)
	{
		k=2;
		grid2.gridx=20;
		panel3.add(l7=new Label("CSE Books"));
		l7.setFont(f0);
		Iterator<Book> i=cse.iterator();
		while(i.hasNext())
		{
			String l=i.next().toString();
			Checkbox b=new Checkbox(l);
			alcomp.add(b);
			b.setFont(f0);
			panel3.add(b,grid2);
			grid2.gridy+=10;
		}
	}
	}

	if(ie.getSource()==elect)
	{
		if(elect.getState()==true)
	{
		k=2;
		grid2.gridx=40;
		panel3.add(l8=new Label("ECE Books"));	
		l8.setFont(f0);
		Iterator<Book> i=ece.iterator();
		while(i.hasNext())
		{

			String l=i.next().toString();
			Checkbox b=new Checkbox(l);
			b.setFont(f0);
			alelect.add(b);
			panel3.add(b,grid2);
			grid2.gridy+=10;

		}
	}
	}
	if(ie.getSource()==eloct)
	{
		if(eloct.getState()==true)
		{
		k=2;
		panel3.add(l9=new Label("EEE Books"));
		Iterator<Book> i=eee.iterator();
		l9.setFont(f0);
		while(i.hasNext())
		{
			String l=i.next().toString();
			Checkbox b=new Checkbox(l);
			b.setFont(f0);
			aleloct.add(b);
			panel3.add(b,grid2);
			grid2.gridy+=10;

		}
		}
	}

	if(ie.getSource()==mechanical)
	{
		if(mechanical.getState()==true)
		{
			k=2;
			panel3.add(l10=new Label("MEC Books"));
			l10.setFont(f0);
			Iterator<Book> i=mech.iterator();
			while(i.hasNext())
			{
				String l=i.next().toString();
				Checkbox b=new Checkbox(l);
				b.setFont(f0);
				almechanical.add(b);
				panel3.add(b,grid2);
				grid2.gridy+=10;
			}
		}
	}
	if(ie.getSource()==information)
	{
		if(information.getState()==true)
		{
			k=2;
			panel3.add(l11=new Label("IT Books"));
			l11.setFont(f0);
			Iterator<Book> i=it.iterator();
			while(i.hasNext())
			{
				String l=i.next().toString();
				Checkbox b=new Checkbox(l);
				b.setFont(f0);
				alinformation.add(b);
				panel3.add(b,grid2);
				grid2.gridy+=10;
			}
		}

	}
	

	if(k==2)
	{
        k=3;
	    Iterator<Checkbox> m=alcomp.iterator();
		while(m.hasNext())
        {

            m.next().addItemListener(this);
        }
        m=alelect.iterator();
        while(m.hasNext())
        {

            m.next().addItemListener(this);
        }
        m=aleloct.iterator();
         while(m.hasNext())
        {

            m.next().addItemListener(this);
        }
        m=almechanical.iterator();
        while(m.hasNext())
        {

            m.next().addItemListener(this);
        }
        m=alinformation.iterator();
         while(m.hasNext())
        {
            m.next().addItemListener(this);
        }
	}
    if(k==3)
    {

        int i=0;
        Iterator<Checkbox> l=alcomp.iterator();
        while(l.hasNext())
        {
            Checkbox b=(Checkbox)l.next();
            if(ie.getSource()==b)
            {
               if(b.getState()==true)
               {
                   int j=0;
                   String p="";
                   String k=b.getLabel();
                    while(j<=k.length()-1)
    				{
        				if(k.charAt(j)==(':')){break;}
						j++;
    				}
                    j++;

		        	while(j<=k.length()-1)
        			{
           			 	p+=k.charAt(j);
            			 	j++;
       				 }


				total+=Integer.parseInt(p);
                System.out.println(total);
               }

            }
        }
        l=alelect.iterator();
        while(l.hasNext())
        {
            Checkbox b=(Checkbox)l.next();
            if(ie.getSource()==b)
            {
               if(b.getState()==true)
               {
                   int j=0;
                   String p="";
                   String k=b.getLabel();
                    while(j<=k.length()-1)
    				{
        				if(k.charAt(j)==(':')){break;}
						j++;
    				}
                    j++;

		        	while(j<=k.length()-1)
        			{
           			 	p+=k.charAt(j);
            			 	j++;
       				 }


				total+=Integer.parseInt(p);
                System.out.println(total);
               }

            }
        }
         l=aleloct.iterator();
        while(l.hasNext())
        {
            Checkbox b=(Checkbox)l.next();
            if(ie.getSource()==b)
            {
               if(b.getState()==true)
               {
                   int j=0;
                   String p="";
                   String k=b.getLabel();
                    while(j<=k.length()-1)
    				{
        				if(k.charAt(j)==(':')){break;}
						j++;
    				}
                    j++;

		        	while(j<=k.length()-1)
        			{
           			 	p+=k.charAt(j);
            			 	j++;
       				 }


				total+=Integer.parseInt(p);
                System.out.println(total);
               }

            }
        }
         l=almechanical.iterator();
        while(l.hasNext())
        {
            Checkbox b=(Checkbox)l.next();
            if(ie.getSource()==b)
            {
               if(b.getState()==true)
               {
                   int j=0;
                   String p="";
                   String k=b.getLabel();
                    while(j<=k.length()-1)
    				{
        				if(k.charAt(j)==(':')){break;}
						j++;
    				}
                    j++;

		        	while(j<=k.length()-1)
        			{
           			 	p+=k.charAt(j);
            			 	j++;
       				 }


				total+=Integer.parseInt(p);
                System.out.println(total);
               }

            }
        }
         l=alinformation.iterator();
        while(l.hasNext())
        {
            Checkbox b=(Checkbox)l.next();
            if(ie.getSource()==b)
            {
               if(b.getState()==true)
               {
                   int j=0;
                   String p="";
                   String k=b.getLabel();
                    while(j<=k.length()-1)
    				{
        				if(k.charAt(j)==(':')){break;}
						j++;
    				}
                    j++;

		        	while(j<=k.length()-1)
        			{
           			 	p+=k.charAt(j);
            			 	j++;
       				 }


				total+=Integer.parseInt(p);
                System.out.println(total);
               }

            }
        }
    }

	if(ie.getSource()==CSE)
	{
		if(CSE.getState()==true)
		{

			int r=Integer.parseInt(cost.getText());
			String nam=name.getText();
			cse.add(new Book(nam,r));

		}
	}
	if(ie.getSource()==ECE)
	{
		if(ECE.getState()==true)
		{

			int r=Integer.parseInt(cost.getText());
			String nam=name.getText();
			ece.add(new Book(nam,r));

		}
	}
	if(ie.getSource()==EEE)
	{
		if(EEE.getState()==true)
		{

			int r=Integer.parseInt(cost.getText());
			String nam=name.getText();
			eee.add(new Book(nam,r));

		}
	}
	if(ie.getSource()==MECH)
	{
		if(MECH.getState()==true)
		{


			int r=Integer.parseInt(cost.getText());
			String nam=name.getText();
			mech.add(new Book(nam,r));

		}
	}
	if(ie.getSource()==IT)
	{
		if(IT.getState()==true)
		{

			int r=Integer.parseInt(cost.getText());
			String nam=name.getText();
			it.add(new Book(nam,r));

		}
	}
}
}
class MyAdapter extends WindowAdapter
{

 Frame t;
 MyAdapter(Frame f)
 {
    t=f;
 }
 public void windowClosing(WindowEvent w)
 {
     t.setVisible(false);
 }
};


import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Marksheet extends Applet implements ActionListener
{
	Label lblTitle,lblExam,lblName,lblJava,lblSEN,lblCSE,lblOSY;
	TextField txtExam,txtName,txtJava,txtSEN,txtCSE,txtOSY;      
	Button cmdReport;
	int total,resultStatus;      
	float avg;
	Font f1;
	public void init()
	{
		f1 = new Font("Times New Roman",Font.BOLD,18);    
		setLayout(null);
		lblTitle=new Label("Enter Students Details");
		lblExam=new Label("Examination:         ");
		lblName=new Label("Name:                ");
		lblJava=new Label("JAVA:                ");
		lblSEN=new Label("SOFTWARE ENGINEERING: ");
		lblCSE=new Label("COMPUTER SECURITY:    ");
		lblOSY=new Label("OPERATING SYSTEM:     ");
		
		txtExam=new TextField(20);
		txtName=new TextField(25);
		txtJava=new TextField(3);
		txtSEN=new TextField(3);
		txtCSE=new TextField(3);
		txtOSY=new TextField(3);
		
		cmdReport=new Button("View Student Result");
		lblTitle.setBounds(100,0,200,20);
		lblExam.setBounds(0,50,170,20);
		txtExam.setBounds(190,50,100,20);
		lblName.setBounds(0,75,170,20);
		txtName.setBounds(190,75,190,20);
		lblJava.setBounds(0,100,170,20);
		txtJava.setBounds(190,100,40,20);
		lblSEN.setBounds(0,125,170,20);
		txtSEN.setBounds(190,125,40,20);
		lblCSE.setBounds(0,150,170,20);
		txtCSE.setBounds(190,150,40,20);
		lblOSY.setBounds(0,175,170,20);
		txtOSY.setBounds(190,175,40,20);
		
		cmdReport.setBounds(100,225,150,30);
		add(lblTitle);
		add(lblExam);add(txtExam);
		add(lblName);add(txtName);
		add(lblJava);add(txtJava);
		add(lblSEN);add(txtSEN);
		add(lblCSE);add(txtCSE);
		add(lblOSY);add(txtOSY);
		
		add(cmdReport);
		cmdReport.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			int java=Integer.parseInt(txtJava.getText());
			int SEN=Integer.parseInt(txtSEN.getText());
			int CSE=Integer.parseInt(txtCSE.getText());
			int OSY=Integer.parseInt(txtOSY.getText());
			if((java>40 && SEN>40) && (CSE>40 && OSY>40))
			{
				resultStatus=1;
				total=(java+SEN+CSE+OSY);
				avg=total/4;
			}
			else{
				resultStatus=0;
				total=(java+SEN+CSE+OSY);
				avg=total/4;
			}
			
		}
		catch(NumberFormatException e)
		{
		}
		repaint();
	}
	public void paint(Graphics g)
	{	
		g.setFont(f1);
		setBackground(Color.gray);
		g.setColor(Color.BLACK);
		g.fillRect(15,279,360,5);
		g.setColor(Color.BLACK);
		g.drawString("STUDENT MARKSHEET",100,275);
		g.drawString("Examination.: "+txtExam.getText(),0,300);
		g.drawString("Name of the Student : "+txtName.getText(),0,325);
		g.drawString("Java Programming:  "+txtJava.getText(),0,350);
		g.drawString("Software Engineering : "+txtSEN.getText(),0,375);
		g.drawString("Computer Security : "+txtCSE.getText(),0,400);
		g.drawString("Operating System : "+txtOSY.getText(),0,425);
		
		g.setColor(Color.BLACK);
		g.fillRect(15,440,360,5);
		g.setColor(Color.BLACK);		
		
		if(resultStatus==1)
		{
			g.setColor(Color.green);
			g.drawString("Result: PASS"+0,475);
			g.setColor(Color.BLACK);
		}
		else{
			g.setColor(Color.red);
			g.drawString("Result: FAIL"+0,475);
			g.setColor(Color.BLACK);
		}
		g.drawString("Total:      "+total,0,505);
		g.drawString("Percentage: "+avg,0,525);

		g.setColor(Color.BLACK);
		g.fillRect(15,535,360,5);
		
		}
}

//HTML Code
/*
<html>

<Body><Applet code="Marksheet.class" height=550 width=400></applet>
</body>
</html>
*/

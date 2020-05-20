import java.lang.*;
import java.util.Scanner;
class input
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
	        int num1,num2,choice;
		while(true)
		{	
			System.out.println("Enter the first number");
			num1=sc.nextInt();
			System.out.println("Enter the second number");
			num2=sc.nextInt();
			System.out.println("ENTER 1 TO ADD \nENTER 2 TO SUBTRACT\nENTER 3 TO MULTIPLY\nENTER 4 TO DIVISION\nENTER 5 TO EXIT");
			choice=sc.nextInt();
			if(choice==1)
				System.out.println("ADDITION IS "+(num1+num2));
			else if(choice==2)
				System.out.println("SUBTRACTION IS "+(num1-num2));
			else if(choice==3)
        	                System.out.println("MULTIPLICATION IS "+(num1*num2));
			else if(choice==4)
        	                System.out.println("DIVISION IS "+(num1/num2));
			else if(choice==5)
        	                System.exit(0);
			else
				System.out.println("Invalid Input.....");
		}
	}
}

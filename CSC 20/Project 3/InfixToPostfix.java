/**
 * Youser Alalusi
 * 6 / 14 / 2020
 * Gita Faroughi - CSC 20
 */
import java.util.Scanner;
import java.util.Stack;

//InfixToPostfix class
public class InfixToPostfix
{
	//Run method
	public static void Run(Scanner sc)
	{
		//While loop
		while(true)
		{
			System.out.println ("Enter an infix expression (quit to exit): ");
			String infix = sc.nextLine();
			if(infix.equalsIgnoreCase("quit"))
				break;
			String postfix = infixToPostfix(infix);
			int result = postfixEval(postfix);
			System.out.println (infix + " -> " + postfix + " -> " + result);
		}
	}

	//Method to return priority of a operator
	private static int getPriority(char c)
	{
		switch(c)
		{
		case '(': return 0;
		case '/': return 4;
		case '*': return 3;
		case '+': return 2;
		case '-': return 1;
		default: return 999;
		}
	}
	//Method to convert infix expression to postfix expression
	public static String infixToPostfix(String infix)
	{
		infix = infix + " )";
		//Tokenized the infix expression
		String []tokens = infix.split(" ");

		//Create an object of Stack class
		Stack<Character> stk = new Stack<Character>();

		stk.push('(');

		String output = "";

		//Convert from infix to postfix
		for(int i=0; i<tokens.length; i++)
		{
			char ch = tokens[i].charAt(0);

			//Check for number/digit
			if(Character.isDigit(ch))
			{
				output = output + ch + " ";
			}
			//Check for left parenthesis
			else if(ch=='(')
			{
				stk.push(ch);
			}
			//Check for right parenthesis
			else if(ch==')')
			{
				while(stk.peek()!='(')
				{
					output = output + stk.pop() + " ";
				}
				stk.pop();
			}
			//Operator
			else
			{
				int p1 = getPriority(ch);
				int p2 = getPriority(stk.peek());

				while(p1<=p2)
				{
					output = output + stk.pop() + " ";
					p2 = getPriority(stk.peek());
				}
				stk.push(ch);
			}
		}

		//Check for error  
		if(!stk.isEmpty())
			System.out.println("Invalid Expression!");

		//Return postfix expression
		return output.trim();
	}
	//Method to evaluate postfix expression
	public static int postfixEval(String postFix)
	{
		//Create an object of Stack class
		Stack<Integer> stk = new Stack<Integer>();

		//Tokenized the postfix expression
		String []tokens = postFix.split(" ");

		for(int i=0; i<tokens.length; i++)
		{
			char c = tokens[i].charAt(0);

			//Check for digit
			if(Character.isDigit(c))
			{
				int val = Integer.parseInt(tokens[i].trim());
				stk.push(val);
			}
			else
			{
				int x = stk.pop();
				int y = stk.pop();
				
				switch(c)
				{
				case '+':
					stk.push(y+x);
					break;
				case '-':
					stk.push(y-x);
					break;
				case '*':
					stk.push(y*x);
					break;
				case '/':
					stk.push(y/x);
					break;
				case '^':
					stk.push((int)Math.pow(y,x));
					break;
				}
			}
		}
		//Return the value
		return stk.pop();
	}

	//Main method
	public static void main (String[] args)
	{
		//Create a Scanner object
		Scanner sc = new Scanner(System.in);
		//Call the Run method
		Run(sc);
	}
}
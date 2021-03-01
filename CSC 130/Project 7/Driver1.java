import java.util.*;
  
class Solve
{
// A utility function to return precedence of a given operator
// Higher returned value means higher precedence
static int Prec(char ch)
{
switch (ch)
{
case '+':
case '-':
return 1;

case '*':
case '/':
return 2;
}
return -1;
}

// The main method that converts given infix expression
// to postfix expression.
static String infixToPostfix(String exp)
{
// initializing empty String for result
String result = new String("");
  
// initializing empty stack
Stack<Character> stack = new Stack<>();
  
for (int i = 0; i<exp.length(); ++i)
{
char c = exp.charAt(i);
  
// If the scanned character is an operand, add it to output.
if (Character.isLetterOrDigit(c))
result += c;

// If the scanned character is an '(', push it to the stack.
else if (c == '(')
stack.push(c);
  
// If the scanned character is an ')', pop and output from the stack
// until an '(' is encountered.
else if (c == ')')
{
while (!stack.isEmpty() && stack.peek() != '(')
result += stack.pop();
  
if (!stack.isEmpty() && stack.peek() != '(')
return "Invalid Expression"; // invalid expression   
else
stack.pop();
}
else // an operator is encountered
{
while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){
if(stack.peek() == '(')
return "Invalid Expression";
result += stack.pop();
}
stack.push(c);
}

}

// pop all the operators from the stack
while (!stack.isEmpty()){
if(stack.peek() == '(')
return "Invalid Expression";
result += stack.pop();
}
return result;
}
static int evaluatePostfix(String exp)
{
//create a stack
Stack<Integer> stack=new Stack<>();
  
// Scan all characters one by one
for(int i=0;i<exp.length();i++)
{
char c=exp.charAt(i);
  
// If the scanned character is an operand (number here),
// push it to the stack.
if(Character.isDigit(c))
stack.push(c - '0');
  
// If the scanned character is an operator, pop two
// elements from stack apply the operator
else
{
int val1 = stack.pop();
int val2 = stack.pop();
  
switch(c)
{
case '+':
stack.push(val2+val1);
break;
  
case '-':
stack.push(val2- val1);
break;
  
case '/':
stack.push(val2/val1);
break;
  
case '*':
stack.push(val2*val1);
break;
}
}
}
return stack.pop();   
}
// Driver method
public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);
System.out.println("Enter expression");
String PfE, exp = sc.nextLine();
Solve ob=new Solve();
PfE=ob.infixToPostfix(exp);
System.out.println("Postfix expression: "+PfE);
System.out.println("Answer: "+ob.evaluatePostfix(PfE));
  
}
}
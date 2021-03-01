public class Postfix {

	static int Precedence(char ch) {

		switch (ch) {

		case '+':

		case '-':

			return 1;

		case '*':

		case '/':

			return 2;

		case '^':

			return 3;

		}

		return -1;

	}

	static String infixToPostfix(String exp) throws StackEmptyException,QueueEmptyException {

		Stack<Character> stack = new Stack<>();

		Queue<Character> queue = new Queue<>();



		for (int i = 0; i<exp.length(); ++i)

		{

			char c = exp.charAt(i);

			if (Character.isLetterOrDigit(c))

				queue.enqueue(c);

			else if (c == '(')

				stack.push(c);

			else if (c == ')') {

				while (!stack.isEmpty() && stack.top() != '(')

					queue.enqueue(stack.pop());



				if (!stack.isEmpty() && stack.top() != '(')

					return "Invalid Expression";

				else

					stack.pop();

			}else{

				while (!stack.isEmpty() && Precedence(c) <= Precedence(stack.top())){

					if(stack.top() == '(')

						return "Invalid Expression";

					queue.enqueue(stack.pop());

				}

				stack.push(c);

			}

		}

		while (!stack.isEmpty()){

			if(stack.top() == '(')

				return "Invalid Expression";

			queue.enqueue(stack.pop());

		}



		String res = "";

		while(!queue.isEmpty()) {

			res += queue.dequeue();

		}



		return res;

	}

	private static boolean isOperator(char ch){

		if(ch=='*' || ch == '+' || ch =='/' || ch=='-'){

			return true;

		}else{

			return false;

		}

	}

	private static int solve(int a,int b,char op){

		int res;

		if(op=='+'){

			res = a+b;

		}else if(op=='-'){

			res = a-b;

		}else if(op=='*'){

			res = a*b;

		}else{

			res = a/b;

		}

		return res;

	}

	public static int evaluate(String exp) throws StackEmptyException{

		Stack<Integer> st = new Stack<>();

		for(int i=0;i<exp.length();i++){

			char curr = exp.charAt(i);

			if(!isOperator(curr)){

				int num = curr-'0';

				st.push(num);

			}else{

				if(st.size()>1){

					int op2 = st.pop();

					int op1 = st.pop();

					int res = solve(op1,op2,curr);

					st.push(res);

				}

			}

		}

		if(!st.isEmpty())

			return st.pop();



		else

			return Integer.MIN_VALUE;

	}

}
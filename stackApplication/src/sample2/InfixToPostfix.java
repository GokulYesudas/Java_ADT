package sample2;

import java.util.Stack;

public class InfixToPostfix {
	
	static int Operation(char ch)
	{
		switch (ch)
		{
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
	static String infixPostfix(String exp) {
	
		String result = new String("");

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i<exp.length(); ++i)
		{
			char c = exp.charAt(i);
	
			if (Character.isLetterOrDigit(c)) result += c;
			else if (c == '(') stack.push(c);
			else if (c == ')')
			{
				while (!stack.isEmpty() && stack.peek() != '(') 
					result += stack.pop();
				stack.pop();
			}
			else
			{
				while (!stack.isEmpty() && Operation(c) <= Operation(stack.peek()))
					result += stack.pop();
				stack.push(c);
			}
		}
	
		while (!stack.isEmpty()){ 
			if(stack.peek() == '(') 
				return "Invalid Expression"; 
			result += stack.pop();
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "AB+CD-*E+FG+/"; 
		System.out.println(infixPostfix(exp));
	}
}



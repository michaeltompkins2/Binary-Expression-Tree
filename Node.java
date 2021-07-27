package binaryexpressiontree;

import java.util.Scanner;
import java.util.Stack;

public class Node {
	Node left;
	Node right;
	char data;
	int key;
	
	Node(char c){
		this.left = null;
		this.right = null;
		data = c;
	}
	public void BuildTree(String s) {

		
	}
	public static boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^' || c == '('|| c == ')') {
            return true;
        }
        return false;
    }
	static int getPriority(char C) 
	{ 
	    if (C == '-' || C == '+') 
	        return 1; 
	    else if (C == '*' || C == '/') 
	        return 2; 
	    else if (C == '^') 
	        return 3; 
	    return 0; 
	} 
	


	public static void main(String[] args) {
		Node x, n, l, r;
		Stack<Character> Stack1 = new Stack<>();
		Stack<Node> Stack2 = new Stack<>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input an arithmetic expression in the format ((a+b)*c-e*f)");
		String userexpression = scan.nextLine();

		for (int i = 0; i <= userexpression.length() - 1; i++) {
			
			
			
			if(userexpression.charAt(i) == '('){
				Stack1.push(userexpression.charAt(i));
				
			}
			
			else if(!isOperator(userexpression.charAt(i))) {
				x = new Node(userexpression.charAt(i));
				Stack2.push(x);
			}
			
			
			
			
			else if (isOperator(userexpression.charAt(i)) && getPriority(Stack1.peek()) >= getPriority(userexpression.charAt(i))) {
				while(!Stack1.isEmpty() && Stack1.peek() != '(') {
				n = new Node(Stack1.peek());
				Stack1.pop();
				r = Stack2.pop();
				l = Stack2.pop();
				n.left = l;
				n.right = r;;
				Stack2.push(n);
				Stack1.push(userexpression.charAt(i));
				
						
			}}
			
			else if(isOperator(userexpression.charAt(i))) {
				Stack1.push(userexpression.charAt(i));
				
			}
			
			else if(userexpression.charAt(i) == ')') {
				while (!Stack1.empty() && Stack1.peek() != '(')
				{
					
				n = new Node(Stack1.peek());
				Stack1.pop();
				r = Stack2.pop();
				l = Stack2.pop();
				n.left = l;
				n.right = r;
				Stack2.push(n);
				}
				Stack1.pop();}
				
			}
			
			scan.close();
			System.out.println(Stack1.peek());
			
		
			
	


	}

}

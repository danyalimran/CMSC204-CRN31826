/**
 * @author Mohammad Danyal
 */
public class Notation extends java.lang.Object {

	/**
	 * Constructor with no return
	 */
	public Notation() {
		
	}
	
	public static int higherPrecedence(char operator) {
		
		final char ADDITION = '+';
		final char SUBTRACTION = '-';
		final char MULTIPLICATION = '*';
		final char DIVISION = '/';
		
		int returnValue = 0;
		
		if (operator == ADDITION || operator == SUBTRACTION || operator == MULTIPLICATION || operator == DIVISION) {
			
			if (operator == ADDITION || operator == SUBTRACTION) {
				
				returnValue = 1; 
			}
			else if (operator == MULTIPLICATION || operator == DIVISION) {
				
				returnValue = 2;
			}
			
			
		}
		
		return returnValue;
	}
	
	/**
	 * 
	 * @param postfixExpr, the expression to check
	 * @return resultingValue, the value after evaluating the postfix expression
	 * @throws InvalidNotationFormatException is thrown if stack size is below 2
	 */
	public static double evaluatePostfixExpression(java.lang.String postfixExpr) throws InvalidNotationFormatException {
		
		MyStack<String> stack = new MyStack<String>();
		
		String element = "";
		String pop = "";
		String pop2 = "";
		double popElement1 = 0;
		double popElement2 = 0;
		double resultingValue = 0.0;
		
		for (int i = 0; i < postfixExpr.length(); i++) {
			
			if (postfixExpr.charAt(i) == ' ') {
				
				continue;
			}
			// Checks if character at 'i' is a digit
			else if(Character.isDigit(postfixExpr.charAt(i))) {
				
					stack.push(Character.toString(postfixExpr.charAt(i)));
			}
			
			// Checks if character at 'i' is an operand (+)
			else if(postfixExpr.charAt(i) == '+') 
			{
				
				if (stack.size() < 2) 
				{
					
					throw new InvalidNotationFormatException();
					
				}
						pop = stack.pop();
					
						
						
						popElement1 = Double.parseDouble(pop);
					
							pop2 = stack.pop();
					
							
						
							popElement2 = Double.parseDouble(pop2);

							
					
							resultingValue = popElement2 + popElement1;
					
							stack.push(Double.toString(resultingValue));
						}
			
			// Checks if character at 'i' is an operand (-)
						else if(postfixExpr.charAt(i) == '-') 
						{
				
							if (stack.size() < 2) 
							{
                	
								throw new InvalidNotationFormatException();
					
							}
							pop = stack.pop();
					
							
						
							popElement1 = Double.parseDouble(pop);
						
							
					
							pop2 = stack.pop();
					
							
						
							popElement2 = Double.parseDouble(pop2);
						
							
					
							resultingValue = popElement2 - popElement1;
					
							stack.push(Double.toString(resultingValue));
						}
			
						// Checks if character at 'i' is an operand (*)
						else if(postfixExpr.charAt(i) == '*') 
						{
				
							if (stack.size() < 2) 
							{
					
								throw new InvalidNotationFormatException();
					
							}
							pop = stack.pop();
					
							
						
								popElement1 = Double.parseDouble(pop);
						
							
					
							pop2 = stack.pop();
					
							
						
								popElement2 = Double.parseDouble(pop2);

							
					
							resultingValue = popElement2 * popElement1;
					
							stack.push(Double.toString(resultingValue));
						}
			
						// Checks if character at 'i' is an operand (/)
						else if (postfixExpr.charAt(i) == '/') 
						{
				
							if (stack.size() < 2) 
							{
								
					
								throw new InvalidNotationFormatException();
					
							}
							pop = stack.pop();
					
							
						
							popElement1 = Double.parseDouble(pop);
						
							
					
							pop2 = stack.pop();
					
							
						
							popElement2 = Double.parseDouble(pop2);

							
						
							resultingValue = popElement2 / popElement1;
					
							stack.push(Double.toString(resultingValue));
						}
		
	}
		
        if (stack.size() != 1) {
			
			throw new InvalidNotationFormatException();
		}
		
		return resultingValue;
}
	
	/**
	 * 
	 * @param postfix, the expression to convert
	 * @return resultingString, the string after converting postfix to infix
	 * @throws InvalidNotationFormatException is thrown if stack size is below 2
	 */
	public static java.lang.String convertPostfixToInfix(java.lang.String postfix) throws InvalidNotationFormatException {
		
		MyStack<String> stack = new MyStack<String>();
		
		String element = "";
		String pop = "";
		String resultingString = "";
		
		for (int i = 0; i < postfix.length(); i++) {
			
			if (postfix.charAt(i) == ' ') {
				
				
			}
			// Checks if character at 'i' is a digit
		   else if(Character.isDigit(postfix.charAt(i))) {
							
				try {
					stack.push(Character.toString(postfix.charAt(i)));
				} catch (StackOverflowException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				}
			}
			 
            else if(postfix.charAt(i) == '+') {
				
                if (stack.size() < 2) {
					
					throw new InvalidNotationFormatException();
					
				}
					try {
						pop = stack.pop();
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					}
					
					String popElement1 = String.valueOf(pop);
					
					try {
						pop = stack.pop();
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					}
					
					String popElement2 = String.valueOf(pop);
					
					resultingString = "(" + popElement2 + "+" + popElement1 + ")";
					
					try {
						stack.push(resultingString);
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					}
            	
			}
			else if(postfix.charAt(i) == '-') {
				
                if (stack.size() < 2) {
					
					throw new InvalidNotationFormatException();
					
				}
					try {
						pop = stack.pop();
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					}
					
					String popElement1 = String.valueOf(pop);
					
					try {
						pop = stack.pop();
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					}
					
					String popElement2 = String.valueOf(pop);
					
					resultingString = "(" + popElement2 + "-" + popElement1 + ")";
					
					try {
						stack.push(resultingString);
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					}
            	
				
			}
			else if(postfix.charAt(i) == '*') {
				
                if (stack.size() < 2) {
					
					throw new InvalidNotationFormatException();
					
				}
					try {
						pop = stack.pop();
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					}
					
					String popElement1 = String.valueOf(pop);
					
					try {
						pop = stack.pop();
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					}
					
					String popElement2 = String.valueOf(pop);
					
					resultingString = "(" + popElement2 + "*" + popElement1 + ")";
					
					try {
						stack.push(resultingString);
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					}
            	
				
			}
			else if(postfix.charAt(i) == '/') {
				
                if (stack.size() < 2) {
					
					throw new InvalidNotationFormatException();
					
				}
					try {
						pop = stack.pop();
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					}
					
					String popElement1 = String.valueOf(pop);
					
					try {
						pop = stack.pop();
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					}
					
					String popElement2 = String.valueOf(pop);
					
					resultingString = "(" + popElement2 + "/" + popElement1 + ")";
					
					try {
						stack.push(resultingString);
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
					}
			}
		}
		
		return resultingString;
	}
	
	/**
	 * 
	 * @param infix, the expression to convert
	 * @return queue, with
	 * @throws InvalidNotationFormatException is thrown if the top of the stack has no left parenthesis 
	 */
	public static java.lang.String convertInfixToPostfix(java.lang.String infix) throws InvalidNotationFormatException {
		
		MyStack<String> stack = new MyStack<String>();
		MyQueue<String> queue = new MyQueue<String>();
		
		for (int i = 0; i < infix.length(); i++) {
			
			if (infix.charAt(i) == ' ') {
				
			}
			else if (Character.isDigit(infix.charAt(i))) {
				
				try {
					queue.enqueue(Character.toString(infix.charAt(i)));
				} catch (QueueOverflowException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				}
			}
			else if (infix.charAt(i) == '(') {
				
				try {
					stack.push(Character.toString(infix.charAt(i)));
				} catch (StackOverflowException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				}
			}
			else if (infix.charAt(i) == '+' || infix.charAt(i) == '-' || infix.charAt(i) == '*' || infix.charAt(i) == '/') {
				
				try {
					
					// (!stack.top().equals("(") && !stack.top().equals(")")) && (stack.top().equals(Character.toString(infix.charAt(i))) || stack.top().compareTo(Character.toString(infix.charAt(i))) > 0)
					
					while (higherPrecedence(stack.top().charAt(0)) >= higherPrecedence(infix.charAt(i))) {
						
						try {
							queue.enqueue(stack.pop());
						} catch (QueueOverflowException e) {
							// TODO Auto-generated catch block
						//	e.printStackTrace();
						}
					}
					
				} catch (StackUnderflowException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				}
				
				try {
					stack.push(Character.toString(infix.charAt(i)));
				} catch (StackOverflowException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				}
				
//				if (!stack.top().equals("(") && !stack.top().equals(")")) {
//				
//			if (stack.top().equals(Character.toString(infix.charAt(i))) || stack.top().compareTo(Character.toString(infix.charAt(i))) > 0) {
//					
//					stack.pop
//				}
//			 }
				
//			try {
//				stack.pop();
//			} catch (StackUnderflowException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//				
//			}
			
			}
			else if (infix.charAt(i) == ')') {
				
				try {
					while ((!stack.top().equals("("))) {
						
						queue.enqueue(stack.pop());
					}
				} catch (StackUnderflowException e) {
					// TODO Auto-generated catch block
					
					throw new InvalidNotationFormatException();
					
				} catch (QueueOverflowException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				}
				
//				try {
//					if ((!stack.top().equals("("))) {
//						
//						throw new InvalidNotationFormatException();
//					}
//				} catch (StackUnderflowException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
				try {
					stack.pop();
				} catch (StackUnderflowException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				}
		}
			
	}
		
		try {
			while ((!stack.top().equals("(") && !stack.top().equals(")"))) {
				
				try {
					queue.enqueue(stack.pop());
				} catch (QueueOverflowException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				}
			}
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		}
		
		
		return queue.toString();
	}
	
  }

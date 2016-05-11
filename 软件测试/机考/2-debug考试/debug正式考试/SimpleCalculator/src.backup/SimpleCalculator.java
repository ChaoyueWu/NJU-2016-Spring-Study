import java.util.ArrayList;
import java.util.Stack;

/**
 * Specification in https://leetcode.com/problems/basic-calculator/
 * 
 * @author Yun Lin
 *
 */
public class SimpleCalculator {

	public int calculate(String expression) {
		//没处理空字符串 没处理负数
		expression = expression.replaceAll(" ", "");
		Stack<StackElement> parenthesisStack = new Stack<StackElement>();

		while (expression.contains("+") || expression.contains("-") || expression.contains("(")) {

			if (!expression.contains("(")) {
				int value = evaluateSimpleFormula(expression);
				return value;
			} else {
				/**
				 * iteratively remove the parenthesis from the expression.
				 */
				char[] charList = expression.toCharArray();
				for (int i = 0; i < charList.length; i++) {
					char ch = charList[i];
					if (ch == '(') {
						StackElement element = new StackElement(ch, i);
						parenthesisStack.push(element);
					} else if (ch == ')') {
						StackElement element = parenthesisStack.pop();

						String simpleExpression = expression.substring(element.index + 1, i);
						int value = evaluateSimpleFormula(simpleExpression);

						String beforeExpression = expression.substring(0, element.index);
						String afterExpression = (i >= expression.length()) ? ""
								: expression.substring(i + 1, expression.length());

						expression = beforeExpression + value + afterExpression;
						break;
					}
				}
			}

		}

		return Integer.valueOf(expression);

	}

	/**
	 * parse the expression with no parenthesis.u
	 * @param simpleExpression
	 * @return
	 */
	public int evaluateSimpleFormula(String simpleExpression) {
		if(simpleExpression.charAt(0)=='-'){
			simpleExpression = "0"+simpleExpression;
		}
		simpleExpression = simpleExpression.replaceAll("--","+" );
		simpleExpression = simpleExpression.replaceAll("\\+-","-" );
		String[] operators = parseOperators(simpleExpression);
		String[] numberStrings = simpleExpression.split("\\+|-");

		String numString1 = numberStrings[0];
		Integer num1 = Integer.valueOf(numString1);

		for (int i = 0; i < operators.length; i++) {
			String operator = operators[i];

			String numString2 = retrieveNumString(numberStrings, i+1); 
			
			Integer num2 = Integer.valueOf(numString2);

			if (operator.equals("+")) {
				num1 = num1 + num2;
			} else if (operator.equals("-")) {
				num1 = num1 - num2;
			}
		}

		return num1;
	}
	
	public String retrieveNumString(String[] numberStrings, int index){
		String str = "";
		try{
			str = numberStrings[index];
			Integer.valueOf(str);
		}
		catch(Exception e){
			str = Number.DEFAULT;
		}
		
		return str;
	}

	public String[] parseOperators(String simpleExpression) {
		ArrayList<String> operatorList = new ArrayList<String>();
		char[] charList = simpleExpression.toCharArray();
		for (char ch : charList) {
			if (ch == '+' || ch == '-') {
				operatorList.add(String.valueOf(ch));
			}
		}

		return operatorList.toArray(new String[0]);
	}
}

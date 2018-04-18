package core;

import java.math.*;
import java.util.*;
import com.beust.jcommander.*;

public class CLO_Calc {
	
	// Operator
	@Parameter(names = { "-o", "--operator" }, description = "Operator")
	static String operator = null;
	
	// Operands
	@Parameter(names = { "-l", "--operands"}, variableArity = true, description = "List of operands")
	static List<Double> operands = new ArrayList<Double>();
	
	public static void main(String[] args) {
		for(String a: args) {if(a.matches("[@#&]")) { 
			System.err.println("Invalid characters"); System.exit(0);}}
		
		JCommander.newBuilder().addObject(new CLO_Calc()).build().parse(args);
		
		if (operator == null || !operator.matches("[+-/*/]")) {
		System.err.println("Please specify the operator + - * /");}
        else if (operands.size() == 0) {System.err.println("List of operands is empty");}
		else { 
			Double result = operands.get(0);
			for (int i = 1; i < operands.size(); i++) {
				if (operator.matches("[+]")) result += operands.get(i);
				else if (operator.matches("[-]")) result -= operands.get(i);
				else if (operator.matches("[*]")) result *= operands.get(i);
				else if (operator.matches("[/]")) result /= operands.get(i);
			}
			System.out.println(new BigDecimal(result).setScale(2, RoundingMode.HALF_UP));
			//}
				
			//switch (operator) {
			//case "+": result += operands.get(i); break;
			//case "-": result -= operands.get(i); break;
			//case "*": result *= operands.get(i); break;
			//case "/": result /= operands.get(i); break;
			}
		}
	}

package com.mz.expGen;

import java.math.BigDecimal;
import java.math.MathContext;

import com.udojava.evalex.Expression.ExpressionException;

public class Expression {

	private BigDecimal solution;
	private String expression;

	/**
	 * Creates a new Expression object and calculates it
	 * 
	 * @param expression
	 *            expression to calculate
	 * @throws ExpressionException
	 *             if expression couldn't be parsed
	 */
	public Expression(String expression) throws ExpressionException {
		this.expression = expression;

		com.udojava.evalex.Expression exp = new com.udojava.evalex.Expression(
				getScientificExpression().replaceAll(" ", "").replaceAll("=", ""), MathContext.DECIMAL128);

		this.solution = exp.eval();
	}

	/**
	 * Retrieves solution as double. The result might be imprecise due to double's limitations
	 * 
	 * @return solution as double
	 */
	public double getSolutionDouble() {
		return solution.doubleValue();
	}

	/**
	 * Retrieves solution as BigDecimal
	 * 
	 * @return solution as BigDecimal
	 */
	public BigDecimal getSolution() {
		return solution;
	}
	
	public String getExpression() {
		return expression;
	}

	public String getScientificExpression() {
		return expression.replaceAll("÷", "/").replaceAll("×", "*");
	}

}

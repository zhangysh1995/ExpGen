package com.mz.expGen;

import java.math.BigDecimal;
import java.math.MathContext;
import java.lang.String;

import com.udojava.evalex.Expression.ExpressionException;

public class Expression {

	private BigDecimal solution;
	private String expression;

	/**
	 * Print the literal expression
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return getExpression();
	}

	/**
	 * Convert the expression to be computer readable
	 *
	 * @return String
	 */
	public String convertToCom() {
		return getExpression().strip().replace('÷','/').
				replace('x','*');
	}

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
	}

	/**
	 * Evaluate the expression
	 *
	 * @return void
	 */
	public void evalExp() {
		com.udojava.evalex.Expression exp = new com.udojava.evalex.Expression(
				getScientificExpression().replaceAll(" ", "").
						replaceAll("=", ""), MathContext.DECIMAL128);

		this.solution = exp.eval();
	}

	public BigDecimal getEval() { return this.solution;}

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
		return expression.replaceAll("÷", "/")
				.replaceAll("×", "*");
	}

}

package com.mz.expGen.operator;

import com.mz.expGen.Operator;

public class OperatorDiv implements Operator {

	@Override
	public int calculate(int a, int b) {
		return a / b;
	}

	@Override
	public String getCharacter() {
		return "÷";
	}

}

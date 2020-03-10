package com.mz.expGen.test;

import com.mz.expGen.Expression;
import org.junit.Test;
import com.mz.expGen.ExpressionGenerator;
import static org.junit.Assert.assertNotEquals;

public class ExpressionGeneratorTest {
    @Test
    public void test1() {
        ExpressionGenerator generator = new ExpressionGenerator();
        Expression expression = generator.generate();
        assertNotEquals("", expression.convertToCom());
    }
}

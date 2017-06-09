package test;

import main.MathExpression;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExpressionTest {

    @Test
    public void expressionValidWhenSingleOpenAndCloseParenthesis()
    {
        MathExpression mathExpression = new MathExpression("(1+2)");
        assertThat(mathExpression.isValid(),is(true));
    }

    @Test
    public void expressionValidWhenMultipleOpenAndCloseParenthesis()
    {
        MathExpression mathExpression = new MathExpression("(1+2*(6/2)+(7+10))");
        assertThat(mathExpression.isValid(),is(true));
    }

    @Test
    public void expressionInvalidWhenAdditionalOpenParenthesis()
    {
        MathExpression mathExpression = new MathExpression("(1+(3*2)");
        assertThat(mathExpression.isValid(),is(false));
    }

    @Test
    public void expressionInvalidWhenAdditionalClosingParenthesis()
    {
        MathExpression mathExpression = new MathExpression("(1+(3*2)))");
        assertThat(mathExpression.isValid(),is(false));
    }

    @Test
    public void expressionInvalidWhenAdditionalClosingParenthesisInComplexExpression()
    {
        MathExpression mathExpression = new MathExpression("(1+(3*2)(2+3)+4(*2)))");
        assertThat(mathExpression.isValid(),is(false));
    }

    @Test
    public void expressionValidWhenNoParenthesis()
    {
        MathExpression mathExpression = new MathExpression("10+2");
        assertThat(mathExpression.isValid(),is(true));
    }

    @Test
    public void expressionInvalidWhenClosingBraceBeforeOpeningBrace()
    {
        MathExpression mathExpression = new MathExpression(")10+2(");
        assertThat(mathExpression.isValid(),is(false));
    }

    @Test
    public void expressionInvalidForDifferentTypeOfImbalacedBraces()
    {
        MathExpression mathExpression = new MathExpression("(10+2*[3+2[)");
        assertThat(mathExpression.isValid(),is(false));
    }

    @Test
    public void expressionValidForDifferentTypeOfBalacedBraces()
    {
        MathExpression mathExpression = new MathExpression("(10+2*[3+2]+100)");
        assertThat(mathExpression.isValid(),is(true));
    }

    @Test
    public void expressionInvalidBraceClosedWithDifferentBrace()
    {
        MathExpression mathExpression = new MathExpression("(10+2*[3+20)+100]");
        assertThat(mathExpression.isValid(),is(false));
    }

    @Test
    public void expressionValidThreeTypeOfBalancedBraces()
    {
        MathExpression mathExpression = new MathExpression("{(10+2)*[3+20]+100}");
        assertThat(mathExpression.isValid(),is(true));
    }
}

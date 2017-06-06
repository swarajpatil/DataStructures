package main;

import java.util.Stack;

public class MathExpression {
    public static final char ROUND_CLOSING_BRACE = ')';
    public static final char ROUND_OPENING_BRACE = '(';
    private String expression;

    public MathExpression(String expression) {
        this.expression = expression;
    }

    public boolean isValid() {
        return isParenthesisBalancedWithoutStack();
    }

    private boolean isParenthesisBalanced() {
        Stack<Character> parenthesisStack = new Stack<>();
        for (Character character : expression.toCharArray()) {
            if(isOpeningBrace(character)) parenthesisStack.push(character);
            if(parenthesisStack.isEmpty() && isClosingBrace(character)) return false;
            if(isClosingBrace(character)) parenthesisStack.pop();
        }
        return parenthesisStack.empty();
    }

    private boolean isParenthesisBalancedWithoutStack() {
        int parenthesisCount = 0;
        for (Character character : expression.toCharArray()) {
            if(isOpeningBrace(character)) ++parenthesisCount;
            if(isClosingBrace(character)) --parenthesisCount;
        }
        return  parenthesisCount == 0;
    }

    private boolean isClosingBrace(Character character) {
        return character == ROUND_CLOSING_BRACE;
    }

    private boolean isOpeningBrace(Character character) {
        return character == ROUND_OPENING_BRACE;
    }
}

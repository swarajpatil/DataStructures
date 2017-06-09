package main;

import java.util.HashMap;
import java.util.Stack;

public class MathExpression {
    public static final char ROUND_CLOSING_BRACE = ')';
    public static final char ROUND_OPENING_BRACE = '(';
    public static final char SQUARE_OPENING_BRACE = '[';
    public static final char SQUARE_CLOSING_BRACE = ']';
    private HashMap<Character,Character> braceMap = new HashMap<>();
    private String expression;

    public MathExpression(String expression) {
        this.expression = expression;
        initBracesMapping();
    }

    private void initBracesMapping() {
        braceMap.put(')','(');
        braceMap.put(']','[');
        braceMap.put('}','{');
    }

    public boolean isValid() {
        return isParenthesisBalanced();
    }

    private boolean isParenthesisBalanced() {
        Stack<Character> parenthesisStack = new Stack<>();
        for (Character character : expression.toCharArray()) {
            if(isOpeningBrace(character))
                parenthesisStack.push(character);
            if(parenthesisStack.isEmpty() && isClosingBrace(character))
                return false;
            if(isClosingBrace(character) && !isaBracesMatching(character,parenthesisStack.pop()))
                return false;
        }
        return parenthesisStack.empty();
    }

    private boolean isaBracesMatching(Character currentBrace,Character previousBrace) {
        Character openingBrace = braceMap.get(currentBrace);
        return previousBrace == openingBrace;
    }

    private boolean isParenthesisBalancedWithoutStack() {
        int remainingParenthesis = 0;
        for (Character character : expression.toCharArray()) {
            if(isOpeningBrace(character)) ++remainingParenthesis;
            if(remainingParenthesis == 0 && isClosingBrace(character)) return false;
            if(isClosingBrace(character)) --remainingParenthesis;
        }
        return  remainingParenthesis == 0;
    }

    private boolean isClosingBrace(Character character) {
        return character == ROUND_CLOSING_BRACE || character == SQUARE_CLOSING_BRACE;
    }

    private boolean isOpeningBrace(Character character)
    {
        return character == ROUND_OPENING_BRACE || character == SQUARE_OPENING_BRACE;
    }
}

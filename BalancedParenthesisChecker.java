import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesisChecker {
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '{' && closing == '}') ||
               (opening == '[' && closing == ']');
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Enter an expression to check for balanced parentheses (or 'exit' to quit):");
            String expression = scanner.nextLine();
            
            if (expression.equalsIgnoreCase("exit")) {
                break;
            }
            
            boolean balanced = isBalanced(expression);
            System.out.println("Expression: " + expression);
            System.out.println("Is balanced: " + balanced);
            System.out.println();
        }
        
        scanner.close();
    }
}

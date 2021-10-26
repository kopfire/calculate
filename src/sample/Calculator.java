package sample;

public class Calculator {

    public static String calculate(String expression) {
        StringBuilder result = new StringBuilder(expression);
        int indParenthesesR = result.indexOf(")");
        int indParenthesesL;
        while (indParenthesesR != -1) {
            indParenthesesL = result.substring(0, indParenthesesR).lastIndexOf("(");
            result.replace(indParenthesesL, indParenthesesR+1, check(result.substring(indParenthesesL+1, indParenthesesR)));
            indParenthesesR = result.indexOf(")");
        }
        result = new StringBuilder(check(result.toString()));
        return result.toString();
    }

    private static String check(String expression) {
        System.out.println(expression);
        StringBuilder result = new StringBuilder(expression);
        int indMulti = result.indexOf("*");
        int indDiv = result.indexOf("/");
        int indPlus = result.indexOf("+");
        int indMinus = result.indexOf("-");

        while (indMulti != -1 || indDiv != -1) {
            if (indDiv == -1) {
                result = new StringBuilder(action(indMulti, result, 0));
            } else if (indMulti == -1) {
                result = new StringBuilder(action(indDiv, result, 1));
            } else if (indDiv < indMulti) {
                result = new StringBuilder(action(indDiv, result, 1));
            } else {
                result = new StringBuilder(action(indMulti, result, 0));
            }
            indMulti = result.indexOf("*");
            indDiv = result.indexOf("/");
            System.out.println("1");
            System.out.println(result);
        }

        while (indPlus != -1 || indMinus != -1 && indMinus != 0) {
            if (indMinus == -1) {
                result = new StringBuilder(action(indPlus, result, 2));
            } else if (indPlus == -1) {
                result = new StringBuilder(action(indMinus, result, 3));
            } else if (indMinus < indPlus) {
                result = new StringBuilder(action(indMinus, result, 3));
            } else {
                result = new StringBuilder(action(indPlus, result, 2));
            }
            indPlus = result.indexOf("+");
            indMinus = result.indexOf("-");
            System.out.println("2");
            System.out.println(result);
        }
        System.out.println("fsf");
        System.out.println(result);
        return result.toString();
    }

    private static StringBuilder action(int check, StringBuilder result, int action) {
        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();
        int res = 0;
        int left = 0;
        int right = result.length();
        for (int i = check - 1; i >= 0; i--) {
            if (!Character.isDigit(result.charAt(i))) {
                left = i + 1;
                break;
            }
            one.append(result.charAt(i));
        }
        for (int i = check + 1; i < result.length(); i++) {
            if (!Character.isDigit(result.charAt(i))) {
                right = i;
                break;
            }
            two.append(result.charAt(i));
        }
        System.out.println(one);
        System.out.println(two);
        if (action == 0) {
            res = Integer.parseInt(one.reverse().toString()) * Integer.parseInt(two.toString());
        } else if (action == 1) {
            res = Integer.parseInt(one.reverse().toString()) / Integer.parseInt(two.toString());
        } else if (action == 2) {
            res = Integer.parseInt(one.reverse().toString()) + Integer.parseInt(two.toString());
        } else if (action == 3) {
            res = Integer.parseInt(one.reverse().toString()) - Integer.parseInt(two.toString());
        }
        System.out.println(left);
        System.out.println(right);
        System.out.println(res);
        return result.replace(left, right, String.valueOf(res));
    }
}

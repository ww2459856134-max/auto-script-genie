package i.b;

import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* loaded from: classes.dex */
public abstract class m7 {
    private static BigDecimal a(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        try {
            return bigDecimal.divide(bigDecimal2);
        } catch (ArithmeticException unused) {
            return bigDecimal.divide(bigDecimal2, d(bigDecimal, bigDecimal2), RoundingMode.HALF_UP);
        }
    }

    public static BigDecimal b(String str) {
        return c(f(str));
    }

    private static BigDecimal c(List<String> list) {
        Stack stack = new Stack();
        for (String str : list) {
            if (g(str)) {
                stack.push(new BigDecimal(str.trim()));
            } else if (h(str)) {
                stack.push(k((BigDecimal) stack.pop(), (BigDecimal) stack.pop(), str));
            }
        }
        return (BigDecimal) stack.pop();
    }

    private static int d(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return Math.max(Math.max(bigDecimal.scale(), bigDecimal2.scale()), 10);
    }

    private static int e(String str) {
        str.hashCode();
        switch (str) {
            case "*":
            case "/":
            case "×":
            case "÷":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return 0;
        }
    }

    private static List<String> f(String str) {
        ArrayList arrayList = new ArrayList();
        Stack stack = new Stack();
        for (String str2 : l(str)) {
            if (g(str2)) {
                arrayList.add(str2);
            } else if (h(str2)) {
                while (!stack.isEmpty() && h((String) stack.peek()) && e((String) stack.peek()) >= e(str2)) {
                    arrayList.add((String) stack.pop());
                }
                stack.push(str2);
            } else if (str2.equals("(")) {
                stack.push(str2);
            } else if (str2.equals(")")) {
                while (!stack.isEmpty() && !((String) stack.peek()).equals("(")) {
                    arrayList.add((String) stack.pop());
                }
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
                stack.pop();
            } else {
                continue;
            }
        }
        while (!stack.isEmpty()) {
            if (((String) stack.peek()).equals("(") || ((String) stack.peek()).equals(")")) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            arrayList.add((String) stack.pop());
        }
        return arrayList;
    }

    private static boolean g(String str) {
        return str.matches("-?(\\d+(\\.\\d+)?|\\.\\d+)");
    }

    private static boolean h(String str) {
        return str.equals("+") || str.equals(ProcessIdUtil.DEFAULT_PROCESSID) || str.equals("*") || str.equals("/") || str.equals("×") || str.equals("÷");
    }

    private static boolean i(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == 215 || c == 247;
    }

    private static boolean j(String str) {
        return str == null || h(str) || str.equals("(");
    }

    private static BigDecimal k(BigDecimal bigDecimal, BigDecimal bigDecimal2, String str) {
        str.hashCode();
        switch (str) {
            case "*":
            case "×":
                return bigDecimal.multiply(bigDecimal2);
            case "+":
                return bigDecimal.add(bigDecimal2);
            case "-":
                return bigDecimal.subtract(bigDecimal2);
            case "/":
            case "÷":
                if (bigDecimal2.compareTo(BigDecimal.ZERO) != 0) {
                    return a(bigDecimal, bigDecimal2);
                }
                throw new ArithmeticException("Division by zero");
            default:
                throw new IllegalArgumentException("Unknown operator: " + str);
        }
    }

    private static List<String> l(String str) {
        int i2;
        if (str == null) {
            throw new IllegalArgumentException("Expression is null");
        }
        ArrayList arrayList = new ArrayList();
        String strReplace = str.replace(",", "");
        String strValueOf = null;
        int i3 = 0;
        while (i3 < strReplace.length()) {
            char cCharAt = strReplace.charAt(i3);
            if (!Character.isWhitespace(cCharAt)) {
                boolean z = cCharAt == '-' && j(strValueOf) && (i2 = i3 + 1) < strReplace.length() && (Character.isDigit(strReplace.charAt(i2)) || strReplace.charAt(i2) == '.');
                if (z || Character.isDigit(cCharAt) || cCharAt == '.') {
                    int i4 = z ? i3 + 1 : i3;
                    boolean z2 = false;
                    boolean z3 = false;
                    while (i4 < strReplace.length()) {
                        char cCharAt2 = strReplace.charAt(i4);
                        if (Character.isDigit(cCharAt2)) {
                            i4++;
                            z3 = true;
                        } else {
                            if (cCharAt2 != '.' || z2) {
                                break;
                            }
                            i4++;
                            z2 = true;
                        }
                    }
                    if (!z3) {
                        throw new IllegalArgumentException("Invalid number: " + strReplace.substring(i3, i4));
                    }
                    String strSubstring = strReplace.substring(i3, i4);
                    arrayList.add(strSubstring);
                    i3 = i4;
                    strValueOf = strSubstring;
                } else if (cCharAt == '-' && j(strValueOf)) {
                    arrayList.add("0");
                    arrayList.add(ProcessIdUtil.DEFAULT_PROCESSID);
                    i3++;
                    strValueOf = ProcessIdUtil.DEFAULT_PROCESSID;
                } else {
                    if (!i(cCharAt) && cCharAt != '(' && cCharAt != ')') {
                        throw new IllegalArgumentException("Invalid character: " + cCharAt);
                    }
                    strValueOf = String.valueOf(cCharAt);
                    arrayList.add(strValueOf);
                }
            }
            i3++;
        }
        return arrayList;
    }
}

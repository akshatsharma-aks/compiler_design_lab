import java.util.Scanner; 

  

public class RecursiveDescentParser { 

  

    static String expression; 

    static int count = 0; 

    static boolean flag = false; 

  

    public static void main(String[] args) { 

  

        Scanner sc = new Scanner(System.in); 

  

        System.out.print("Enter an Algebraic Expression: "); 

        expression = sc.next(); 

  

        count = 0; 

        flag = false; 

  

        E(); 

  

        if (count == expression.length() && !flag) { 

            System.out.println("The Expression " + expression + " is Valid"); 

        } else { 

            System.out.println("The Expression " + expression + " is Invalid"); 

        } 

  

        sc.close(); 

    } 

  

    static void E() { 

        T(); 

        Eprime(); 

    } 

  

    static void T() { 

        check(); 

        Tprime(); 

    } 

  

    static void Tprime() { 

        if (count < expression.length() && expression.charAt(count) == '*') { 

            count++; 

            check(); 

            Tprime(); 

        } 

    } 

  

    static void Eprime() { 

        if (count < expression.length() && expression.charAt(count) == '+') { 

            count++; 

            T(); 

            Eprime(); 

        } 

    } 

  

    static void check() { 

  

        if (count < expression.length() && Character.isLetterOrDigit(expression.charAt(count))) { 

            count++; 

        } 

        else if (count < expression.length() && expression.charAt(count) == '(') { 

            count++; 

            E(); 

  

            if (count < expression.length() && expression.charAt(count) == ')') { 

                count++; 

            } else { 

                flag = true; 

            } 

        } 

        else { 

            flag = true; 

        } 

    } 

} 
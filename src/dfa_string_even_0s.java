import java.util.Scanner; 

public class Main { 

    public static void main(String[] args) { 

        Scanner sc = new Scanner(System.in); 

        int state = 0; 

        int zeroCount = 0; 

        System.out.print("Enter the string: "); 

        String str = sc.next(); 

        for (int i = 0; i < str.length(); i++) { 

            char ch = str.charAt(i); 

            if (ch == '0') { 

                state = 1 - state; 

                zeroCount++; 

            }  

            else if (ch == '1') { 

                // do nothing 

            }  

            else { 

                System.out.println("Invalid symbol!"); 

                return; 

            } 

        } 

        if (state == 0 && zeroCount > 0) 

            System.out.println("String is Accepted"); 

        else 

            System.out.println("String is Rejected"); 

        sc.close(); 

    } 

} 

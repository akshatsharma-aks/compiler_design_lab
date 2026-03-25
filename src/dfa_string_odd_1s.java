import java.util.Scanner; 

public class Main { 

    public static void main(String[] args) { 

        Scanner sc = new Scanner(System.in); 

        System.out.print("Enter the binary string: "); 

        String str = sc.next(); 

        int state = 0; 

        for (int i = 0; i < str.length(); i++) { 

            char ch = str.charAt(i); 

            if (ch == '1') { 

                state = 1 - state;  

            }  

            else if (ch == '0') { 

            }  

            else { 

                System.out.println("Invalid input symbol!"); 

                return; 

            } 

        } 

        if (state == 1) 

            System.out.println("String is Accepted (Odd number of 1's)"); 

        else 

            System.out.println("String is Rejected (Even number of 1's)"); 

        sc.close(); 

    } 

} 
import java.util.Scanner; 

  

public class Mod3ZerosDFA { 

    public static void main(String[] args) { 

  

        Scanner sc = new Scanner(System.in); 

        String str; 

        int state = 0; // q0 = 0, q1 = 1, q2 = 2 

  

        System.out.print("Enter the string: "); 

        str = sc.next(); 

  

        for (int i = 0; i < str.length(); i++) { 

            char ch = str.charAt(i); 

  

            switch (state) { 

                case 0: 

                    if (ch == '0') state = 1; 

                    else if (ch == '1') state = 0; 

                    else { 

                        System.out.println("Invalid input symbol"); 

                        return; 

                    } 

                    break; 

  

                case 1: 

                    if (ch == '0') state = 2; 

                    else if (ch == '1') state = 1; 

                    else { 

                        System.out.println("Invalid input symbol"); 

                        return; 

                    } 

                    break; 

  

                case 2: 

                    if (ch == '0') state = 0; 

                    else if (ch == '1') state = 2; 

                    else { 

                        System.out.println("Invalid input symbol"); 

                        return; 

                    } 

                    break; 

            } 

        } 

  

        if (state == 0) 

            System.out.println("String is ACCEPTED (0's divisible by 3)"); 

        else 

            System.out.println("String is REJECTED (0's not divisible by 3)"); 

  

        sc.close(); 

    } 

} 
import java.util.Scanner; 

public class Main { 

    public static void main(String[] args) { 

        Scanner sc = new Scanner(System.in); 

        char f = 'a';   // initial state 

        String str; 

        System.out.print("Enter the string to be checked: "); 

        str = sc.next(); 

        for (int i = 0; i < str.length(); i++) { 

            char ch = str.charAt(i); 

            switch (f) { 

                case 'a': 

                    if (ch == '0') 

                        f = 'b'; 

                    else if (ch == '1') 

                        f = 'a'; 

                    break; 

                case 'b': 

                    if (ch == '0') 

                        f = 'c'; 

                    else if (ch == '1') 

                        f = 'd'; 

                    break; 

                case 'c': 

                    if (ch == '0') 

                        f = 'c'; 

                    else if (ch == '1') 

                        f = 'd'; 

                    break; 

                case 'd': 

                    if (ch == '0') 

                        f = 'b'; 

                    else if (ch == '1') 

                        f = 'd'; 

                    break; 

                default: 

                    System.out.println("Invalid State"); 

                    return; 

            } 

        } 

        if (f == 'c') 

            System.out.println("\nString is accepted as it reached the final state " + f + " at the end."); 

        else 

            System.out.println("\nString is not accepted as it reached " + f + " which is not the final state."); 

        sc.close(); 

    } 

} 
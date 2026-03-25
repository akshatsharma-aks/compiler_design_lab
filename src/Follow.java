import java.util.*; 

  

public class FollowSet { 

  

    static int n; 

    static String productions[] = new String[10]; 

    static Set<Character> followSet = new HashSet<>(); 

  

    static void follow(char c) { 

  

        // If start symbol, add $ 

        if (productions[0].charAt(0) == c) { 

            followSet.add('$'); 

        } 

  

        for (int i = 0; i < n; i++) { 

  

            for (int j = 2; j < productions[i].length(); j++) { 

  

                if (productions[i].charAt(j) == c) { 

  

                    // If not last symbol 

                    if (j + 1 < productions[i].length()) { 

                        first(productions[i].charAt(j + 1)); 

                    } 

  

                    // If last symbol 

                    if (j + 1 == productions[i].length() && c != productions[i].charAt(0)) { 

                        follow(productions[i].charAt(0)); 

                    } 

                } 

            } 

        } 

    } 

  

    static void first(char c) { 

  

        // If terminal 

        if (!Character.isUpperCase(c)) { 

            followSet.add(c); 

            return; 

        } 

  

        for (int k = 0; k < n; k++) { 

  

            if (productions[k].charAt(0) == c) { 

  

                // If epsilon 

                if (productions[k].charAt(2) == '$') { 

                    follow(productions[k].charAt(0)); 

                } 

  

                // If terminal 

                else if (!Character.isUpperCase(productions[k].charAt(2))) { 

                    followSet.add(productions[k].charAt(2)); 

                } 

  

                // If non-terminal 

                else { 

                    first(productions[k].charAt(2)); 

                } 

            } 

        } 

    } 

  

    public static void main(String[] args) { 

  

        Scanner sc = new Scanner(System.in); 

  

        System.out.print("Enter number of productions: "); 

        n = sc.nextInt(); 

        sc.nextLine(); 

  

        System.out.println("Enter productions (epsilon = $):"); 

  

        for (int i = 0; i < n; i++) { 

            productions[i] = sc.nextLine(); 

        } 

  

        int choice; 

  

        do { 

            followSet.clear(); 

  

            System.out.print("Enter non-terminal to find FOLLOW: "); 

            char c = sc.next().charAt(0); 

  

            follow(c); 

  

            System.out.print("FOLLOW(" + c + ") = { "); 

            for (char ch : followSet) 

                System.out.print(ch + " "); 

            System.out.println("}"); 

  

            System.out.print("Continue? (1/0): "); 

            choice = sc.nextInt(); 

  

        } while (choice == 1); 

  

        sc.close(); 

    } 

} 
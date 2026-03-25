import java.util.Scanner; 

  

public class Main { 

  

    static int numOfProductions; 

    static String[] productionSet = new String[10]; 

  

    public static void main(String[] args) { 

  

        Scanner sc = new Scanner(System.in); 

        char choice; 

        char c; 

        String result; 

  

        System.out.print("How many number of productions? : "); 

        numOfProductions = sc.nextInt(); 

  

        for (int i = 0; i < numOfProductions; i++) { 

            System.out.print("Enter production Number " + (i + 1) + " : "); 

            productionSet[i] = sc.next(); 

        } 

  

        do { 

            System.out.print("\nFind the FIRST of : "); 

            c = sc.next().charAt(0); 

  

            result = FIRST(c); 

  

            System.out.print("FIRST(" + explained(c) + ") = { "); 

            for (int i = 0; i < result.length(); i++) 

                System.out.print(explained(result.charAt(i)) + " "); 

            System.out.println("}"); 

  

            System.out.print("Press 'y' to continue : "); 

            choice = sc.next().charAt(0); 

  

        } while (choice == 'y' || choice == 'Y'); 

  

        sc.close(); 

    } 

  

    static String FIRST(char c) { 

  

        String result = ""; 

        String subResult; 

        boolean foundEpsilon = false; 

  

        // If terminal 

        if (!Character.isUpperCase(c)) { 

            return result + c; 

        } 

  

        // If non-terminal 

        for (int i = 0; i < numOfProductions; i++) { 

  

            if (productionSet[i].charAt(0) == c) { 

  

                // X -> ε 

                if (productionSet[i].charAt(2) == '#') { 

                    result = addToResultSet(result, '#'); 

                } else { 

  

                    int j = 2; 

                    while (j < productionSet[i].length()) { 

  

                        foundEpsilon = false; 

                        subResult = FIRST(productionSet[i].charAt(j)); 

  

                        for (int k = 0; k < subResult.length(); k++) 

                            result = addToResultSet(result, subResult.charAt(k)); 

  

                        for (int k = 0; k < subResult.length(); k++) { 

                            if (subResult.charAt(k) == '#') { 

                                foundEpsilon = true; 

                                break; 

                            } 

                        } 

  

                        if (!foundEpsilon) 

                            break; 

  

                        j++; 

                    } 

  

                    if (!foundEpsilon) 

                        result = removeFromResultSet(result, '#'); 

                } 

            } 

        } 

        return result; 

    } 

  

    static String addToResultSet(String result, char val) { 

        if (result.indexOf(val) == -1) 

            result += val; 

        return result; 

    } 

  

    static String removeFromResultSet(String result, char val) { 

        return result.replace(String.valueOf(val), ""); 

    } 

  

    // Optional: prints ε instead of # 

    static String explained(char c) { 

        return (c == '#') ? "ε" : String.valueOf(c); 

    } 

} 
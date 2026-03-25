import java.util.Scanner; 

 public class LL1Parser { 

     public static void main(String[] args) { 

        char[][][] m = { 

                { {'t','b'}, {}, {}, {'t','b'}, {}, {} }, 

                { {}, {'+','t','b'}, {}, {}, {'n'}, {'n'} }, 

                { {'f','c'}, {}, {}, {'f','c'}, {}, {} }, 

                { {}, {'n'}, {'*','f','c'}, {}, {'n'}, {'n'} }, 

                { {'i'}, {}, {}, {'(','e',')'}, {}, {} } 

        }; 

       int[][] size = { 

                {2,0,0,2,0,0}, 

                {0,3,0,0,1,1}, 

                {2,0,0,2,0,0}, 

                {0,1,3,0,1,1}, 

                {1,0,0,3,0,0} 

        }; 

       char[] stack = new char[20]; 

        Scanner sc = new Scanner(System.in); 

        System.out.print("Enter the input string: "); 

        String s = sc.next(); 

        s = s + "$"; 

       int n = s.length(); 

        stack[0] = '$'; 

        stack[1] = 'e'; 

        int i = 1; 

        int j = 0; 

        System.out.println("\nStack\tInput"); 

        System.out.println("--------------------"); 

        while (stack[i] != '$' && s.charAt(j) != '$') { 

            if (stack[i] == s.charAt(j)) { 

                i--; 

                j++; 

            } 

            int str1 = 0, str2 = 0; 

            switch (stack[i]) { 

                case 'e': str1 = 0; break; 

                case 'b': str1 = 1; break; 

                case 't': str1 = 2; break; 

                case 'c': str1 = 3; break; 

                case 'f': str1 = 4; break; 

            } 

            switch (s.charAt(j)) { 

                case 'i': str2 = 0; break; 

                case '+': str2 = 1; break; 

                case '*': str2 = 2; break; 

                case '(': str2 = 3; break; 

                case ')': str2 = 4; break; 

                case '$': str2 = 5; break; 

            } 

             if (m[str1][str2].length == 0) { 

                System.out.println("ERROR"); 

                return; 

            } 

            else if (m[str1][str2][0] == 'n') { 

                i--; 

            } 

            else { 

  

                for (int k = size[str1][str2] - 1; k >= 0; k--) { 

                    stack[i] = m[str1][str2][k]; 

                    i++; 

                } 

                i--; 

            } 

  

            for (int k = 0; k <= i; k++) 

                System.out.print(stack[k]); 

            System.out.print("\t"); 

            for (int k = j; k < n; k++) 

                System.out.print(s.charAt(k)); 

  

            System.out.println(); 

        } 

        System.out.println("\nSUCCESS"); 

    } 

} 
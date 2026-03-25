import java.util.Scanner; 

import java.util.Stack; 

  

public class LRParser { 

  

    static char[] terminals = {'i','+','*','(',')','$'}; 

    static char[] nonTerminals = {'E','T','F'}; 

  

    static String[][] action = { 

            {"s5","","","s4","",""}, 

            {"","s6","","","","acc"}, 

            {"","r2","s7","","r2","r2"}, 

            {"","r4","r4","","r4","r4"}, 

            {"s5","","","s4","",""}, 

            {"","r6","r6","","r6","r6"}, 

            {"s5","","","s4","",""}, 

            {"s5","","","s4","",""}, 

            {"","s6","","","s11",""}, 

            {"","r1","s7","","r1","r1"}, 

            {"","r3","r3","","r3","r3"}, 

            {"","r5","r5","","r5","r5"} 

    }; 

  

    static int[][] goTo = { 

            {1,2,3}, 

            {-1,-1,-1}, 

            {-1,-1,-1}, 

            {-1,-1,-1}, 

            {8,2,3}, 

            {-1,-1,-1}, 

            {-1,9,3}, 

            {-1,-1,10}, 

            {-1,-1,-1}, 

            {-1,-1,-1}, 

            {-1,-1,-1}, 

            {-1,-1,-1} 

    }; 

  

    static String[] productions = { 

            "", 

            "E->E+T", 

            "E->T", 

            "T->T*F", 

            "T->F", 

            "F->(E)", 

            "F->i" 

    }; 

  

    static int terminalIndex(char c){ 

        for(int i=0;i<terminals.length;i++) 

            if(terminals[i]==c) return i; 

        return -1; 

    } 

  

    static int nonTerminalIndex(char c){ 

        for(int i=0;i<nonTerminals.length;i++) 

            if(nonTerminals[i]==c) return i; 

        return -1; 

    } 

  

    static void printStack(Stack<Object> stack,String input,int pos){ 

        for(Object s:stack) 

            System.out.print(s); 

        System.out.print(" "); 

        System.out.println(input.substring(pos)); 

    } 

  

    public static void main(String[] args){ 

  

        Scanner sc = new Scanner(System.in); 

  

        System.out.print("Enter input string: "); 

        String input = sc.next()+"$"; 

  

        Stack<Object> stack = new Stack<>(); 

        stack.push(0); 

  

        int pointer = 0; 

  

        System.out.println("\nStack input"); 

        printStack(stack,input,pointer); 

  

        while(true){ 

  

            int state = (int)stack.peek(); 

            char symbol = input.charAt(pointer); 

  

            int col = terminalIndex(symbol); 

  

            if(col==-1){ 

                System.out.println("ERROR!"); 

                return; 

            } 

  

            String act = action[state][col]; 

  

            if(act.equals("")){ 

                System.out.println("ERROR!"); 

                return; 

            } 

  

            if(act.equals("acc")){ 

                System.out.println("accept the input"); 

                break; 

            } 

  

            if(act.startsWith("s")){ 

  

                int next = Integer.parseInt(act.substring(1)); 

  

                stack.push(symbol); 

                stack.push(next); 

  

                pointer++; 

  

            } 

  

            else if(act.startsWith("r")){ 

  

                int prod = Integer.parseInt(act.substring(1)); 

  

                String rule = productions[prod]; 

  

                String rhs = rule.split("->")[1]; 

  

                for(int i=0;i<rhs.length()*2;i++) 

                    stack.pop(); 

  

                int stateAfterPop = (int)stack.peek(); 

                char lhs = rule.charAt(0); 

  

                stack.push(lhs); 

  

                int gotoState = goTo[stateAfterPop][nonTerminalIndex(lhs)]; 

  

                stack.push(gotoState); 

            } 

  

            printStack(stack,input,pointer); 

        } 

    } 

} 
package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();++i){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                int n = s.charAt(i) - '0';
                ++i;
                while(i + 1 < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    n *= 10;
                    n += s.charAt(i) - '0';
                    ++i;
                }
                --i;
                System.out.print(n + " ");
            }
            else if(s.charAt(i) == ')'){
                while(st.peek() != '('){
                    System.out.print(st.pop() + " ");
                }
                st.pop();
            }
            else if(s.charAt(i) == '*' || s.charAt(i) == '/'){
                while(!st.empty() && ( st.peek() == '^' || st.peek() == '*' || st.peek() == '/')){
                    System.out.print(st.pop() + " ");
                }
                st.push(s.charAt(i));
            }
            else if(s.charAt(i) == '^' || s.charAt(i) == '('){
                st.push(s.charAt(i));
            }
            else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                while (!st.empty() && (st.peek() != '(')){
                    System.out.print(st.pop() + " ");
                }
                st.push(s.charAt(i));
            }
        }
        while (!st.empty()){
            if(st.peek() == '(') st.pop();
            else System.out.print(st.pop() + " ");
        }
    }
}

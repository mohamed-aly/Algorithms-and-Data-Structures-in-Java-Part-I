package com.ds.dijkstra;

import java.util.Stack;

public class Algorithm {
    private Stack<Double> valuesStack;
    private Stack<String> operationsStack;

    public Algorithm() {
        this.operationsStack = new Stack<>();
        this.valuesStack = new Stack<>();
    }

    public void interpret(String expression) {
        String[] expressionsArray = expression.split(" ");
        for (String s : expressionsArray) {
            if(s.equals("(")){
                //Do nothing
            }else if (s.equals("*") || s.equals("+") || s.equals("-") || s.equals("/")) {
                this.operationsStack.push(s);
            } else if (s.equals(")")) {
                String operation = this.operationsStack.pop();

                switch (operation) {
                    case "+":
                        this.valuesStack.push(this.valuesStack.pop() + this.valuesStack.pop());
                        break;
                    case "*":
                        this.valuesStack.push(this.valuesStack.pop() * this.valuesStack.pop());
                        break;
                    case "-":
                        this.valuesStack.push(this.valuesStack.pop() - this.valuesStack.pop());
                        break;
                    case "/":
                        this.valuesStack.push(this.valuesStack.pop() / this.valuesStack.pop());
                        break;
                }
            }else{
                this.valuesStack.push(Double.parseDouble(s));
            }
        }
    }

    public double result(){
        return this.valuesStack.pop();
    }
}

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
            switch (s) {
                case "(":
                    //Do nothing
                    break;
                case "*":
                case "+":
                case "-":
                case "/":
                    this.operationsStack.push(s);
                    break;
                case ")":
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
                    break;
                default:
                    this.valuesStack.push(Double.parseDouble(s));
                    break;
            }
        }
    }

    public double result(){
        return this.valuesStack.pop();
    }
}

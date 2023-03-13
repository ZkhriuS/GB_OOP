package model;

import java.util.*;

public class ComplexExpression implements Expression{
    private ComplexNumber operand;
    private String operation;

    public ComplexExpression(ComplexNumber operand){
        this.operand=operand;
        this.operation=null;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setOperand(ComplexNumber operand) {
        this.operand = operand;
    }

    public String getOperation() {
        return operation;
    }

    public ComplexNumber getOperand() {
        return operand;
    }
}

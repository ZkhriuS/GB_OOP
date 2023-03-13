package controller;

import model.*;
import validation.Validator;
import validation.ValidatorComplexNumber;
import validation.ValidatorExpression;
import validation.ValidatorOperation;

import java.util.ArrayDeque;
import java.util.Deque;

public class ComplexController implements Controller{
    private Deque<ComplexExpression> expression;
    private ComplexOperation calculator;
    private Validator validator;
    public ComplexController(ComplexOperation calculator){
        this.calculator = calculator;
        expression  = new ArrayDeque<>();
    }

    public String addComplexNumber(String data) throws Exception{
        validator = new ValidatorComplexNumber(data);
        try {
            validator.validate();
            ComplexNumber number = ((ValidatorComplexNumber)validator).getNumber();
            expression.add(new ComplexExpression(number));
            return number.toString();
        } catch(Exception e){
            throw e;
        }
    }

    public String addOperation(String data) throws Exception{
        validator = new ValidatorOperation(data);
        try {
            validator.validate();
            String operation = ((ValidatorOperation)validator).getOperation();
            ComplexExpression last = expression.pollLast();
            if(expression.isEmpty()) {
                last.setOperation(operation);
                expression.add(last);
            }
            else if(Operation.getPriority(expression.peekLast().getOperation())>=Operation.getPriority(operation)){
                while(expression.size()>0 && Operation.getPriority(expression.peekLast().getOperation())>=Operation.getPriority(operation)){
                    last = calculator.calculate(expression.pollLast(), last);
                }
                last.setOperation(operation);
                expression.add(last);
            }
            else {
                last.setOperation(operation);
                expression.add(last);
            }
            return operation;
        } catch(Exception e){
            throw e;
        }
    }

    @Override
    public String calculate() {
        ComplexExpression last = expression.pollLast();
        while(expression.size()>0){
            last = calculator.calculate(expression.pollLast(), last);
        }
        return last.getOperand().toString();
    }
}

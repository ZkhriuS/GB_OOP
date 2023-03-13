package model;

public class ComplexOperation implements Operation<ComplexNumber>{
    public double multiplyConjugate(ComplexNumber value){
        return value.getRe()*value.getRe() - value.getIm()*value.getIm();
    }

    @Override
    public ComplexNumber sum(ComplexNumber first, ComplexNumber second) {
        ComplexNumber result = new ComplexNumber();
        result.setRe(first.getRe()+second.getRe());
        result.setIm(first.getIm()+second.getIm());
        return result;
    }

    @Override
    public ComplexNumber subtract(ComplexNumber first, ComplexNumber second) {
        return sum(first, second.getOpposite());
    }

    @Override
    public ComplexNumber multiply(ComplexNumber first, ComplexNumber second) {
        ComplexNumber result = new ComplexNumber();
        result.setRe(first.getRe()*second.getRe()-first.getIm()*second.getIm());
        result.setIm(first.getRe()*second.getIm()+first.getIm()*second.getRe());
        return result;
    }

    @Override
    public ComplexNumber divide(ComplexNumber first, ComplexNumber second) {
        double conjugatedDivider = multiplyConjugate(second.getConjugate());
        second.setRe(second.getRe()/conjugatedDivider);
        second.setIm(second.getIm()/conjugatedDivider);
        return multiply(first, second);
    }


    public ComplexExpression calculate(ComplexExpression first, ComplexExpression second) {
            ComplexNumber firstValue = first.getOperand();
            ComplexNumber secondValue = second.getOperand();
            switch(first.getOperation()){
                case PLUS: first.setOperand(sum(firstValue, secondValue)); break;
                case MINUS: first.setOperand(subtract(firstValue, secondValue)); break;
                case MUL: first.setOperand(multiply(firstValue, secondValue)); break;
                case DIV: first.setOperand(divide(firstValue, secondValue)); break;
            }
        return first;
    }
}

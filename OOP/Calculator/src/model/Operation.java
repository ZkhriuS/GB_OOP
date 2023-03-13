package model;

public interface Operation<T> {
    static final String PLUS = "+";
    static final String MINUS = "-";
    static final String MUL = "*";
    static final String DIV = "/";
    static final String EQUALS = "=";
    static final String OPEN = "(";
    static int getPriority(String operation){
        return switch (operation){
            case PLUS, MINUS -> 1;
            case MUL, DIV -> 2;
            case OPEN -> 0;
            default -> -1;
        };
    }

    T sum(T first, T second);
    T subtract(T first, T second);
    T multiply(T first, T second);
    T divide(T first, T second);
}

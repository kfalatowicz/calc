public enum Operator {

    ADD(1),
    SUBTRACT(2),
    MULTIPLY(3),
    DIVIDE(4);

    final int precedence;

    Operator(int p) {
        precedence = p;
    }

}

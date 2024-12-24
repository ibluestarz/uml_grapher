package fr.lernejo;

import java.util.function.BiFunction;

public class Sample {

    public int op(Operation op, int a, int b) {
        return op.func.apply(a, b);
    }

    enum Operation {
        ADD((a, b) -> a + b),
        MULT((a, b) -> a * b),
        ;

        final BiFunction<Integer, Integer, Integer> func;

        Operation(BiFunction<Integer, Integer, Integer> func) {
            this.func = func;
        }
    }
}


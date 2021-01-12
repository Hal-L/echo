package KnowledgePoints.Lambda_Inter.CalculatorDemo;

public class CalculatorDemo {
    public static void main(String[] args) {
        useCalculator(new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        });
        useCalculator((a, b) ->
                a + b
        );
    }

    public static void useCalculator(Calculator calculator) {
        int result = calculator.calc(13, 24);
        System.out.println(result);
    }
}

@FunctionalInterface
interface Calculator {
    int calc(int a, int b);
}
package Ch4_FunctionalPrograming;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Ex4_FunctionalPrograming {
    public static void main(String[] args) {
        CalculatePerDiem calculatePerDiem = new CalculatePerDiem();
        Function<Integer, Double> curriendByFerstArg = calculatePerDiem.curryFirstArgument(32.4);

        System.out.println(curriendByFerstArg.apply(5));
        System.out.println(curriendByFerstArg.apply(3));
        System.out.println(curriendByFerstArg.apply(10));

        Function<Double, Double> curriedBySecondArgument = calculatePerDiem.currySecondArgument(10);
        System.out.println(curriedBySecondArgument.apply(56.12));
        System.out.println(curriedBySecondArgument.apply(61.63));
    }

    static class CalculatePerDiem implements CurriedBiFunction<Double, Integer, Double>{
        private final Double perDiemRate = 10.15;

        @Override
        public Double apply(Double dollarExchangeRate, Integer amountOfDays) {
            return dollarExchangeRate * amountOfDays * perDiemRate;
        }
    }


    @FunctionalInterface
    interface CurriedBiFunction<T, U, R>
            extends BiFunction<T, U, R> {

        default Function<U, R> curryFirstArgument(T t) {
            return u -> apply(t, u);
        }

        default Function<T, R> currySecondArgument(U u) {
            return t -> apply(t, u);
        }
    }
}

import java.util.HashSet;
import java.util.Set;

public class AmicableNumbers
{

    public static int sumOfProperDivisors(int num)
    {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++)
        {
            if (num % i == 0) sum += i;
        }

        return sum;
    }

    public static boolean isAmicablePair(int a, int b)
    {
        return a != b && sumOfProperDivisors(a) == b && sumOfProperDivisors(b) == a;
    }

    public static int sumOfAmicableNumbers(int limit)
    {
        Set<Integer> amicableNumbers = new HashSet<>();

        for (int i = 1; i < limit; i++)
        {
            int sumOfProperDivisorsA = sumOfProperDivisors(i);
            if (sumOfProperDivisorsA < limit && isAmicablePair(i, sumOfProperDivisorsA))
            {
                amicableNumbers.add(i);
                amicableNumbers.add(sumOfProperDivisorsA);
            }
        }

        int sum = 0;
        for (int num : amicableNumbers) sum += num;

        return sum;
    }

    public static void main(String[] args)
    {
        System.out.println(sumOfAmicableNumbers(10000));
    }
}

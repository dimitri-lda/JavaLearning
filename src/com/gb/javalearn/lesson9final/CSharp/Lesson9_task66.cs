using System;

namespace SumNaturalNumbersRecursion
{
    class Program
    {
        private static void Main(string[] args)
        {
            Console.Write("Введите число m: ");
            int m = int.Parse(Console.ReadLine());
            Console.Write("Введите число n: ");
            int n = int.Parse(Console.ReadLine());
            int sum = SumNaturalNumbers(m, n);
            Console.WriteLine($"Сумма натуральных чисел от {m} до {n}: {sum}");
        }

        private int SumNaturalNumbers(int m, int n)
        {
            if (m <= n)
                return m + SumNaturalNumbers(m + 1, n);
            return 0;
        }
    }
}

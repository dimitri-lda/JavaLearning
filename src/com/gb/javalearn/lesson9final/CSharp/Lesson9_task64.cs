using System;

public class Lesson9task64
{
    public static void Main()
    {
        Console.Write("Введите число n: ");
        int n = int.Parse(Console.ReadLine());
        PrintNumbers(n);
    }

    public static void PrintNumbers(int n)
    {
        if (n != 0)
        {
            Console.Write(n + ", ");
            PrintNumbers(n - 1);
        }
    }
}

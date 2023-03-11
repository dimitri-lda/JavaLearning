using System;

public class Lesson9task64
{
    public static void Main()
    {
        int N = 5;
        PrintNumbers(N);
    }

    public static void PrintNumbers(int n)
    {
        if (n == 0)
        {
            return;
        }
        else
        {
            Console.Write(n + ", ");
            PrintNumbers(n - 1);
        }
    }
}

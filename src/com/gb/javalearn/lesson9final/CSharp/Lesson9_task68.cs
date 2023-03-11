using System;

class Lesson9_task66 {
  public static void Main (string[] args) {
    Console.Write("Введите число m: ");
    int m = int.Parse(Console.ReadLine());
    Console.Write("Введите число n: ");
    int n = int.Parse(Console.ReadLine());
    int result = Ackermann(m, n);
    Console.WriteLine($"A({m},{n}) = {result}");
  }

  public static int Ackermann(int m, int n) {
    int result = 0;
    if (m == 0)
      result = n + 1;
    else if (n == 0)
      result = Ackermann(m - 1, 1);
    else
      result = Ackermann(m - 1, Ackermann(m, n - 1));

    return result;
  }
}

import scala.collection.mutable.Map

// This program returns what the nth number in the fibonacci sequence is
// The fibonacci sequence runs more efficiently in Scala compared to Haskell, especially for larger numbers, due to mutable data structures
// Can change n in the main function

// Compile the code in the command line with: scalac fib.scala
// Run the code with the command: scala Fibonacci

object Fibonacci {
  def fibonacci(n: Int): BigInt = {
    val cache: Map[Int, BigInt] = Map(0 -> 0, 1 -> 1)

    def fib(n: Int): BigInt = {
      if (cache.contains(n)) {
        cache(n)
      } else {
        val result = fib(n - 1) + fib(n - 2)
        cache(n) = result
        result
      }
    }

    fib(n)
  }

  def main(args: Array[String]): Unit = {
    // Can change n
    val n = 100
    val result = fibonacci(n)
    println(s"The $n-th Fibonacci number is: $result")
  }
}


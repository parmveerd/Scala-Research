import scala.util.Random

// This program returns the sum of squares of n
// This program performs worse in Scala compared to C++ due to the runtime overhead od JVM and garbage collector
// C++'s manual memory system, although at risk of leaks, is much more efficient and faster
// We expect Scala's performance to be slower, especially as the size gets bigger and bigger

// Compile the code with the command: scalac sumofsquares.scala
// Run the code with the command: scala SumOfSquares

object SumOfSquares {
  // Function to calculate the sum of squared elements in an array
  def sumOfSquares(arr: Array[Double]): Double = {
    arr.map(x => math.pow(x, 2)).sum
  }

  def main(args: Array[String]): Unit = {
    // Can change the size
    val size = 10000000
    val arr = new Array[Double](size)

    // Initialize array with random values
    val random = new Random()
    for (i <- 0 until size) {
      arr(i) = random.nextDouble()
    }

    val result = sumOfSquares(arr)
    println(s"Sum of squares: $result")
  }
}


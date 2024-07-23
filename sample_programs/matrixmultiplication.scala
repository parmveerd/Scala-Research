// This program does matrix multiplication on two matrices
// Scala does matrix multiplication better than C++ because the code is much more concise by taking advantage of Scala's array manipulation
// Can alter the matrices in the main function

// Compile the code in the command line with: scalac matrixmultiplication.scala
// Run the code in the command line with: scala MatrixMultiplication

object MatrixMultiplication {
  def matrixMultiplication(matrix1: Array[Array[Int]], matrix2: Array[Array[Int]]): Array[Array[Int]] = {
    val rows1 = matrix1.length
    val cols1 = matrix1(0).length
    val cols2 = matrix2(0).length

    val result = Array.ofDim[Int](rows1, cols2)

    for (i <- 0 until rows1) {
      for (j <- 0 until cols2) {
        var sum = 0
        for (k <- 0 until cols1) {
          sum += matrix1(i)(k) * matrix2(k)(j)
        }
        result(i)(j) = sum
      }
    }

    result
  }

  def main(args: Array[String]): Unit = {
    // Can change the matrices here
    val matrix1 = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))
    val matrix2 = Array(Array(9, 8, 7), Array(6, 5, 4), Array(3, 2, 1))

    val result = matrixMultiplication(matrix1, matrix2)
    println(result.map(_.mkString(" ")).mkString("\n"))
  }
}

// Program takes a list of elements and uses recursion to generate all possible permutations
// It is less efficient, especially for larger lists, than the implementation in Haskell because Scala's imperative approach adds more overhead and is less concise
// Also Scala's list cocatenation results in more memory allocation
// Haskell's declarative implementation and lazy evaluation solves this problem more efficiently 

// Compile this code with the command: scalac permutations.scala
// Run this code with the command: scala Permutations

object Permutations {
  def generatePermutations[A](list: List[A]): List[List[A]] = {
    list match {
      case Nil => List(Nil)
      case _ =>
        for {
          x <- list
          xs <- generatePermutations(list.filterNot(_ == x))
        } yield x :: xs
    }
  }

  def main(args: Array[String]): Unit = {
    // Can change this list to see how long the results take for bigger/smaller lists
    val inputList = List(1, 2, 3, 4)
    val permutations = generatePermutations(inputList)
    permutations.foreach(println)
  }
}

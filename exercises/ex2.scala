// The code is done in functional programming to showcase the similarities between Scala and Haskell
// Compile with scalac ex2.scala in the command line
// Run scala with the keyword "scala"
// Type ":load ex2.scala" to load this file
// The instructions for every function is commented right on top of them

// Call this function like: println(divisors(30)) (or any other number)
// println is not necessary but shows a cleaner output
def divisors(n: Int): List[Int] = {
  (2 to n / 2).filter(n % _ == 0).toList
}

// Call this function like: println(primes(7)) (or any other number)
def primes(n: Int): List[Int] = {
  (2 to n).filter(i => divisors(i).isEmpty).toList
}

// Call this function like: println(join(", ", List("one", "two", "three"))) (or any other separator and/or list)
def join(separator: String, list: List[String]): String = {
  list.mkString(separator)
}

// Call this function like: println(pythagorean(10)) (or any other number)
def pythagorean(maxValue: Int): List[(Int, Int, Int)] = {
  val triples = for {
    a <- 1 to maxValue
    b <- a + 1 to maxValue
    c <- b + 1 to maxValue
    if (a*a + b*b == c*c)
  } yield (a, b, c)

  triples.toList
}

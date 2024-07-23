// The code is done in functional programming to showcase the similarities between Scala and Haskell
// Compile with scalac ex3.scala in the command line
// Run scala with the keyword "scala"
// Type ":load ex3.scala" to load this file
// The instructions for every function is commented right on top of them

import java.time.DayOfWeek
import java.time.LocalDate


// For mergesort do println(mergeSort(List(4,2,3,6,20,5,1))) (or any other list of integers)
def merge(left: List[Int], right: List[Int]): List[Int] = (left, right) match {
  case (Nil, right) => right
  case (left, Nil) => left
  case (leftHead :: leftTail, rightHead :: rightTail) =>
    if (leftHead <= rightHead) leftHead :: merge(leftTail, right)
    else rightHead :: merge(left, rightTail)
}

def mergeSort(list: List[Int]): List[Int] = {
  val n = list.length
  if (n <= 1) list
  else {
    val (left, right) = list.splitAt(n / 2)
    merge(mergeSort(left), mergeSort(right))
  }
}


// Call isFriday like: println(isFriday(LocalDate.of(2018, 5, 17))) (or any other date)
// Can also store the date in a variable such as: val date = LocalDate.of(2018, 5, 17) then call println(isFriday(date))
def isFriday(day: LocalDate): Boolean = {
  day.getDayOfWeek == DayOfWeek.FRIDAY
}

// Had to create another function to filter for all the Fridays in a certain year
// Call this function like: println(filterFridays(2018)) (or any other year)
def filterFridays(year: Int): List[LocalDate] = {
  val startDate = LocalDate.of(year, 1, 1)
  val endDate = LocalDate.of(year, 12, 31)

  val allDays = Iterator.iterate(startDate)(_.plusDays(1)).takeWhile(!_.isAfter(endDate))
  val fridays = allDays.filter(_.getDayOfWeek == DayOfWeek.FRIDAY).toList

  fridays
}

// Call this function like: println(isPrimeDay(LocalDate.of(2018, 5, 13))) (or any other date)
def isPrimeDay(day: LocalDate): Boolean = {
  def isPrime(n: Int): Boolean = {
    if (n <= 1) false
    else {
      val range = 2 to math.sqrt(n).toInt
      !range.exists(n % _ == 0)
    }
  }

  isPrime(day.getDayOfMonth)
}

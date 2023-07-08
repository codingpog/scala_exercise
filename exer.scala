//libraries for the isPrimeDay function
import java.time.LocalDate
import java.time.DayOfWeek


object Main extends App {
  // divisors
  def divisors(n:Int) ={
    val d = for{ i <- 2 to (n/2) if n % i == 0} yield i 
    d
  }
  println(divisors(15))

  //primes
  def primes(n:Int) ={
    val p = for{i <- 2 to n if (divisors(i)).isEmpty} yield i
    p
  }
  println(primes(15))
  
  //pythagorean triples
  def pythagorean (n:Int) = {
    val triples = for{
      a <- 1 to n
      b <- 1 to n
      c <- 1 to n
      if (a<b) && (a*a + b*b == c*c)
    }yield (a,b,c)
    triples
  }
  println(pythagorean(30))

  //join function
  def join(sep:String, str:List[String]): String ={
    str match{
      case Nil => ""
      case head :: Nil => head
      case head :: tail => head + sep + join(sep, tail)
    }
  }
  println(join(", ", List("one", "two", "three")))

  //merge function
  def merge(left: List[Int], right:List[Int]) :List[Int] = {
    (left, right) match{
      case (Nil, _) => right
      case (_, Nil) => left
      case (leftHead::leftTail, rightHead::rightTail) => 
        if (leftHead <= rightHead)
          leftHead :: merge(leftTail, right)
        else
          rightHead :: merge(left, rightTail)
    }
  }
  //mergeSort
  def mergeSort(list:List[Int]) : List[Int] = {
    val n = list.length
    if (n <= 1){list}
    else{
      val (left,right) = list.splitAt(n/2)
      merge(mergeSort (left), mergeSort(right))
    }
  }
  println(mergeSort(List(6,2,4,8,9,5,3,1,7,10)))

  //isFriday
  def isFriday(date: LocalDate): Boolean = {
    date.getDayOfWeek == DayOfWeek.FRIDAY
  }
  println(isFriday(LocalDate.of(2023,6,7)))

  //isPrimeDay
  def isPrimeDay(date: LocalDate): Boolean = {
    val day = date.getDayOfMonth
    divisors(day).isEmpty
  }
  println(isPrimeDay(LocalDate.of(2018,5,13)))
  println(isPrimeDay(LocalDate.of(2018,5,14)))
  println(isPrimeDay(LocalDate.of(2018,6,23)))


}

//libraries for sample code #1
import javax.imageio.ImageIO
import java.io.File

object Main extends App{

  
    //Sample code #1
    //Because Scala works based on Java, we can use the many Java libraries that don't have Haskell equivalence
    //The example is using methods from the imageIO libraries to read and determine the image type of the file
    def imageType(filePath: String): Unit = {
      val file = new File(filePath)
      // Get the file format
      val format = ImageIO.getImageReadersBySuffix(filePath.split('.').last)
        .next().getFormatName
      println(format)
    }
  
    //Sample code #2
    // Scala's pattern matching looks too similar to a switch case from imperative programming and doesn't look as clean as Haskell's
    // Function finds the fibonacci number using pattern matching
    def fibonacci(n: Int): Int = {
      n match{
        case 0 => 0
        case 1 => 1
        case _ => fibonacci(n - 1) + fibonacci(n - 2)
      }
    }
    println(fibonacci(5))
  
  //Sample code #3
  // Scala supports both functional programming and OO programming, which is useful in scenarios where it makes sense
  // Example below creates a class Person that takes an immutable name and a mutable age. The class Person has a method celebrateBirthday that uses pattern matching to check if the age is valid. If it's valid, increment the age by 1 and print a Happy BD message. If not, print invalid age
  class Person(val name: String, var age: Int) {
    def celebrateBirthday(): Unit = {
      age match {
        case _ if age < 0 => println("Invalid age")
        case _ =>
          age += 1
          println(s"Happy bday, $name! You are now $age years old.")
      }
    }
  }
  new Person("Josh", 18).celebrateBirthday()
  
}



// 1. The signum of a number is 1 if the number is positive, –1 if it is negative, and 0 if it is zero. Write a function that computes this value.?
def signum(num : Int) : Int = {
  if (num > 0) 1
  else -1
}

//check
signum(1) // res0: Int = 1
signum(0) // res1: Int = -1
signum(-1) // res2: Int = -1

// 2. What is the value of an empty block expression {}? What is its type?
def doNothing() = {}

doNothing() // res3: Unit = ()


// 3.Come up with one situation where the assignment x = y = 1 is valid in Scala.
//(Hint: Pick a suitable type for x.)
var y = 0 // y: Int = 0
val x = y = 1 // x: Unit = ()

// 4. Write a Scala equivalent for the Java loop
//for (int i = 10; i >= 0; i--) System.out.println(i);

for(i <- 10 to 0 by -1) {
  println(i)
}

// 5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.
def countDown(n: Int) : Unit = {
  if (n > 0 ) for (i <- n to 0 by -1) println(i)
}

countDown(5) // printing
countDown(-1) // not printing

// 6. Write a for loop for computing the product of the Unicode codes of all letters in a string. For example, the product of the characters in "Hello" is 825152896
def unicodeProduct(s: String) : Int = {
  var sum = 1
  for (c <- s) {
    sum = sum * c
  }
  sum
}

unicodeProduct("Hello") //res7: Int = 825152896

// 7. Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps Scaladoc.)
// 8. Write a function product(s : String) that computes the product, as described in the preceding exercises.
def unicodeProductWithoutLoop(s: String) : Int = {
  s.foldLeft(1)(_ * _.toInt)
}

unicodeProductWithoutLoop("Hello") // res8: Int = 825152896

// 9. Make the function of the preceding exercise a recursive function
def uniCodeProductWithRec(s: String) : Int = {
  if (s.length == 0) 1
  else s.head * uniCodeProductWithRec(s.tail)
}

uniCodeProductWithRec("Hello")

// 10. Write a function that computes x , where n is an integer. Use the following
//recursive definition:
//Don’t use a return statement.
def pow(x: Int, n: Int) : Double = {
  if (x == 0) 0
  else if (n == 0) 1
  else if (n > 0) {
    if (n % 2 == 0) pow(x, n/2) * pow(x, n/2)
    else x * pow(x, n -1)
  }
  else  1 / pow(x, -1 * n)
}

pow(3,4) // res10: Double = 81.0
pow(3,3) // res11: Double = 27.0
pow(3,0) // res12: Double = 1.0
pow(3,-3) // res13: Double = 0.037037037037037035
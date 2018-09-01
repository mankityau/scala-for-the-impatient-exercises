import scala.collection.mutable.ArrayBuffer
import scala.util.Random


// 1. Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n (exclusive).
def rand(array: Array[Int]) : Unit = {
  val rand = new Random()
  for (i <- array.indices)
    array(i) = rand.nextInt(array.length)
}

// 2. Write a loop that swaps adjacent elements of an array of integers. For example, Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
def swapAdjacent(array: Array[Int]) : Unit = {
  for (i <- 1 until array.length by 2) {
    val temp = array(i - 1)
    array(i-1) = array(i)
    array(i) = temp
  }
}

val emptyArrayOne = new Array[Int](0);
val oddArrayOne = Array(0, 1, 2)
val evenArrayOne = Array(0, 1, 2, 3)

swapAdjacent(emptyArrayOne)
swapAdjacent(oddArrayOne)
swapAdjacent(evenArrayOne)

emptyArrayOne
oddArrayOne
evenArrayOne

// 3. Repeat the preceding assignment, but produce a new array with the swapped values. Use for/yield.
def swapAdjacentWithForAndYield(array: Array[Int]) : Unit = {
  for (i <- array.indices) yield if (i % 2 == 1) {
    if (i == array.length + 1) array(i)
    else array(i + 1)
  } else array(i - 1)
}

val emptyArrayTwo = new Array[Int](0);
val oddArrayTwo = Array(0, 1, 2)
val evenArrayTwo = Array(0, 1, 2, 3)

swapAdjacent(emptyArrayTwo)
swapAdjacent(oddArrayTwo)
swapAdjacent(evenArrayTwo)

emptyArrayTwo
oddArrayTwo
evenArrayTwo

// 4. Given an array of integers, produce a new array that contains all positive values of the original array, in their original order, followed by all values that are zero or negative, in their original order.
def groupIntBySign(array: Array[Int]): Array[Int] = {
  val positiveIntIndex =
    for (i <- array.indices if array(i) > 0) yield i

  val negativeIntIndex =
    for (i <- array.indices if array(i) <= 0) yield i

  val outBuffer = ArrayBuffer[Int]()
  for (i <- positiveIntIndex) outBuffer += array(i)
  for (i <- negativeIntIndex) outBuffer += array(i)

  outBuffer.toArray
}

val groupIntBySignTestArray = Array(1, 2, -1, -2 ,3, -4, 5, 0)
val groupIntBySignResult = groupIntBySign(groupIntBySignTestArray)


// 5. How do you compute the average of an Array[Double]?
def average(array: Array[Double]) : Double = {
  array.sum / array.length
}


// 6. How do you rearrange the elements of an Array[Int] so that they appear in
//reverse sorted order? How do you do the same with an ArrayBuffer[Int]?
def sortAndReverse(array: Array[Int]): Unit = {
  scala.util.Sorting.quickSort[Int](array)(Ordering[Int]reverse)

}

val sortAndReverseTestArray = Array(0, 4, 3, 2)
sortAndReverse(sortAndReverseTestArray)
sortAndReverseTestArray

// 7. Write a code snippet that produces all values from an array with duplicates
//removed. (Hint: Look at Scaladoc.)
def removeDup(array: Array[Int]) : Array[Int] = {
  array.distinct
}

val removeDupTestArray = Array(1, 2, 3, 1, 2, 3)
val removeDupResultArray = removeDup(removeDupTestArray)

// 8. Rewrite the example at the end of Section 3.4, “Transforming Arrays,” on page 34 using the drop method for dropping the index of the first match. Look the method up in Scaladoc
def dropNegativeButFirst(array: Array[Int]): Array[Int] = {
  val arrayBuffer = array.to[ArrayBuffer]
  val negIndex =
    for (i <- array.indices if array(i) < 0) yield i
  val negIndexButFirstReverse = negIndex.drop(1).reverse;

  for (i <- negIndexButFirstReverse) arrayBuffer.remove(i)

  arrayBuffer.toArray
}

val dropNegativeButFirstTestArray = Array(1, 2, 3, -1, -2, -3)
val dropNegativeButFirstReuslt = dropNegativeButFirst(dropNegativeButFirstTestArray)

// 9. Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs that are in America. Strip off the "America/" prefix and sort the result.
val availableIDs = java.util.TimeZone.getAvailableIDs()
val americanIds = availableIDs.filter(_.startsWith("America/")).map(_.drop("America/".length))

// 10. Import java.awt.datatransfer._ and make an object of type SystemFlavorMap with the call
//val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
//Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor and get the return value as a Scala buffer. (Why this obscure class? It’s hard to find uses of java.util.List in the standard Java library.)

/* OMITTING THIS*/
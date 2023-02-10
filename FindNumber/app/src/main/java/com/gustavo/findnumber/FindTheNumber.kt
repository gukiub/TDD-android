package com.gustavo.findnumber


class FindTheNumber {
    var inputedNumber = 2
    var exempleArray = arrayListOf(6,2,1,7)

}

fun findTheNumberInTheArray(inputedNumber: Int, exempleArray: List<Int>): Boolean {
    var checkTheValue = false
     exempleArray.forEach {
         if (it == inputedNumber)
             checkTheValue = true
     }
    return checkTheValue
}

fun findTheSmallestPositiveNumber(): Int{
    val listOfPositiveNumbers = listOf(6,2,1,7)
    var smallestNumber = 0

    for (x in 1..listOfPositiveNumbers.size+1){
           if (findTheNumberInTheArray(x, listOfPositiveNumbers))
               smallestNumber = x
    }
    return smallestNumber
}
package puzzsupport

import java.lang.Long
import ArgUtils._

object JPModule {
  val usage = "Usage: JPModule|run [num people: (Number>0)] [step rate: (Number>0)]"
  
  def main(args: Array[String]) {
    println(consoleCalcSafePos(args))
  }

  def consoleCalcSafePos(args: Array[String]): String = {
    var response: String = "None"
    var n: Long = 0
    var k: Long = 0

    /* Validate the Number of Arguments */	
    if (args.length != 2) {
      response = "Usage Error: Invalid Number of Arguments\n" + usage      
    }

    /* Read the Arguments and Validate Format Details */
    else {
      /* Read the Input Parameters */
      val nJ: Option[scala.Long] = args(0).toLongOpt
      val kJ: Option[scala.Long] = args(1).toLongOpt	  
	  
      /* Validate the Input parameters to be Valid */
      if(nJ == None) {
        response = "Parameter Error: Number of People must be a numeric value\n" + usage
      }
      else if(kJ == None) {
        response = "Parameter Error: Step Rate must be a numeric value\n" + usage
      }
      
      /* Validate the Input Parameters Processing Validity */
      else {
        /* Read the Parameters into Process Variables */
        n = nJ.get
        k = kJ.get
    	
        /* Validate the Input Parameters to be > 0 */
        if (n <= 0) {
          response = "Parameter Error: Number of People must be greater than 0\n" + usage
        }
        else if (k <= 0) {
          response = "Parameter Error: Step Rate must be greater than 0\n" + usage
        }
    	
        /* Validation Checks passed - Determine the Safe Position */
        else {
          response = "Number of People: " + n.toString + "\n"
          response += "Step Rate: " + k.toString + "\n"
          response += "Safe Position: " + calcSafePosition(n,k).toString
        }
      }
    }

    return response
  }

  /*
  * Function to Determine the Safe Position
  * Treat Step Rate of 2 as a Special Case
  * For others use an Iterative Approach  
  */
  def calcSafePosition(n: Long, k: Long): Long = {
    var safePosition: Long = 0
    
    /*
    * Natural Numbers only Validation Check
    * Throw Exception Otherwise
    */
    if ((n <= 0) | (k <= 0)) {
      throw new IllegalArgumentException("Both the Arguments must be greater than 0 " + usage)
    }
    
    /*
    * Step Rate of 2 is a Special Case
    * Can be calculated using a Direct Formula
    * Safe Position = 2L+1 where L = n-2^m and m = floor(log n/log 2)
    */
    if (k == 2) {
      val log2Value: Long = Long.highestOneBit(n)
      safePosition = 2 * (n - log2Value) + 1
    }

    /* 
    * Iteratively Calculate the Safe Position from 1 to n
    * Backend Formula: f(n,k) = ((f(n-1,k) + k - 1) % n) + 1
    * Where f(1,k) = 1
    * Complexity: O(n)
    */
    else {
      var iter: Long = 1	
      while(iter <= n) {
        if (iter == 1) {
          safePosition = 1
        }
        else {
          safePosition = ((safePosition + k - 1) % iter) + 1
        }
        iter = iter + 1
      }	  
    }

    return safePosition
  }

}

package puzzsupport

import org.scalatest._

class JPModuleSpec extends FlatSpec with Matchers { 
  /* Validating Utility Function for case n=3 and k=2 */
  "Counting Out - Safe Position Determination Module" should "show position 3 is safest for n=3 and k=2" in {
    assert(JPModule.calcSafePosition(3,2) === 3)    
  }

  /* Validating Utility Function for case n=65536 and k=2 */
  it should "show position 1 is safest for n=65536 and k=2" in {
    assert(JPModule.calcSafePosition(65536,2) === 1)    
  }
  
  /* Validating Utility Function for case n=5 and k=5 */
  it should "show position 2 is safest for n=5 and k=5" in {
    assert(JPModule.calcSafePosition(5,5) === 2)    
  }  
  
  /* Validating Utility Function for case n=x and k=1 */
  it should "show position x is safest for n=x and k=1" in {
    assert(JPModule.calcSafePosition(32,1) === 32)    
  }

  /* Validating Arguments for the Utility Function */
  it should "throw IllegalArgumentException if Number of People < 1" in {
    assertThrows[IllegalArgumentException] {
      JPModule.calcSafePosition(0,5)
    }
  }
  
  /* Validating Arguments for the Utility Function */
  it should "throw IllegalArgumentException if Step Rate < 1" in {
    assertThrows[IllegalArgumentException] {
      JPModule.calcSafePosition(4,0)
    }
  } 
  
  /* Validating Number of Parameters from running from Console */
  it should "throw an Usage Error if number of arguments are not 2 when running from console" in {
    JPModule.consoleCalcSafePos(Array("5")) should startWith ("Usage Error")
  }
  
  /* Validating Parameters to be numeric values from running from Console */
  it should "throw a Parameter Error if any of arguments are not numbers when running from console" in {
    JPModule.consoleCalcSafePos(Array("a","b")) should startWith ("Parameter Error")
  }
  
}



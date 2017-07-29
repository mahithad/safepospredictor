package puzzsupport

import scala.util.control.Exception._
import java.lang.Long

object ArgUtils {
     implicit class StringImprovements(val s: String) {         
         def toLongOpt = catching(classOf[NumberFormatException]) opt s.toLong
     }
}

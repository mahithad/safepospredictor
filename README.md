# Counting Out - Safe Position Determination Module

## Overview

The application solves the 'Counting Out' problem by determining the safest position for n people standing in a circle for a step rate of k. The application assumes the start position to be position 1 and the skip count direction to be in the incrementing position order from 1 to n. 

## Application Details

The solution has been developed in Scala. Object: JPModule. 
The test framework has been developed in ScalaTest. Object: JPModuleSpec.

JPModule Object provides methods 
  1. consoleCalcSafePos(String Array) - Method that takes 2 string parameters Number of People and Step Rate in an Array format and returns a String response to support Console applications
  2. calcSafePosition(Long, Long) - Method that takes Individual numeric parameters for Number of People and Step Rate and returns a numeric value for safest position
  3. main(String Array) - Method to support "run n k" option from console directly when running an application in sbt

## Execution Details

### Pre-requisites

1. Install Scala
2. Install Sbt

### Step-by-Step Instructions

1. Download the 'jpmodule_2.12-1.0-SNAPSHOT.jar' file from git repository
2. Open the terminal and use "scala [relative path to the downloaded jar file]/jpmodule_2.12-1.0-SNAPSHOT.jar n k" to run the application,
    where n - Number of people parameter
    and  k - Step Rate parameter
     _(validated in Mac)_

The output should read,
```
    Number of People: n
    Step Rate: k
    Safe Position: x
```
Where x is the Calculated Safe Position for given n and k

The application can also be run thru sbt by downloading all the files in the repository to a folder and using "sbt run n k" command from terminal.

## Tests

The tests can be run using "sbt test" command from terminal.


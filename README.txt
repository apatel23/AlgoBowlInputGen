File: README.txt
Author: Alex Patel 

NumGen.java
--------------------
NumGen.java generates random task times and machine speeds given the number of tasks and machines as parameters.
To compile:
  $ javac NumGen.java 
To run:
  $ java NumGen 10 5
  
where 10 is the number of task times you want to generate and 5 is the number of machine speeds you want to generate 

Verify.java
---------------------
Verify.java checks that the solution of the input file is in the correct format. The tests include: all ids are accounted for, regardless of the machine. This also means the test will fail if a task is missing or appears more than once. 
To compile:
    $ javac Verify.java
To run:
    $ java Verify input.txt solution.txt
    
where input.txt is the input to the AlgoBowl problem, in the form:
2
5
12 7 3 22 24
1 2

and solution.txt is in the form:
1 2 3
4 5
23

listing the tasks performed by each machine, and ending with the cost of the input.

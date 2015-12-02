Sudoku solver using Genetic Algorithm

To run this project (after compiling):

java -jar dist/SudokuSolver.jar

Project Tree:

SudokuSolver/
  src/
    Test.java ----> this contains the main() function, you may wish 
                    to place desired methods and inputs here.
    GeneticAlgorithm/ ---> 
    GeneticAlgorithm/
      mutation/ -----> contains mutation methods
    GeneticAlgorithm/
      recombination/ ---> contains crossover methods
    GeneticAlgorithm/
      representation/ ---> contains the individual and allele class
    GeneticAlgorithm/
      selection/  --> contains selection methods
    dist/
        SudokuSolver.jar --> the project is compiled already, you may wish
                    to run this. However, when changing values in
                    Test.java, you may wish to compile the project again.
                    Unfortunately, there is no other way to compile 
                    it but only through Netbeans IDE.


This project was implemented in java and was
edited using Netbeans 8.0.2, you may wish to view it using
the IDE. source code can be found in the src folder.


Compiling the project.
1. Open the project in Netbeans IDE
2. In the 'Projects' window (usually located on the
    left side of the IDE), click the project (right click),
    then click compile. Another shortcut would be opening
    Test.java, then press F5.

Running the project

Using the terminal:
Go to the project, then type:
java -jar dist/SudokuSolver.jar


Using Netbeans IDE:
1. Open the project in the IDE
2. open Test.java
3. You may wish to fine tune the probabilities and other
    methods, you may edit the file.
3. Compile
4. Click anywhere on the edit field of Test.java (right),
    then click run.
    Shortcut would be Shift+F6.


Enjoy!
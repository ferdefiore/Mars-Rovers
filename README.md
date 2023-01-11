# Mars Rovers - IBM Interview
### Problem introduction
 
A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.	
A rover's position and location are represented by a combination of x and y coordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North. 
In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading. 
Assume that the square directly North from (x, y) is (x, y+1).
 
**INPUT:**
The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.
 
The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover's position, and the second line is a series of instructions telling the rover how to explore the plateau. 
The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover's orientation. 
Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.
 
**OUTPUT:**
The output for each rover should be its final coordinates and heading.
 
**EXAMPLE:**
**Test Input:** 5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM
**Expected Output:** 1 3 N 5 1 E

## Extra:
As a complement to the solution of the problem, create a GUI where users should be able to:
- Set up the grid dimensions and visualize it accordingly
- Input rover's stating position and visualize it in the grid
- Input the instructions, run them, and visualize the rover in its final position 

# Main Application Description
This repository contains the source code to solve the Mars Rovers problem. Using Java as programming language, and Oriented Object paradigm. Following good practices, as clean code and SOLID.
The project architecture is oriented to MVC. It has one controller who manages the input requests and sets the output. That request can be both from desktop application UI, or console executing the .jar file giving in the first parameter the string with plateau, rover information, and his instruction set. 
It was made in that way because it's thought to run:

- From user interface with a plateau, many rovers, and his instructions.
- From a backend that gets the information from the frontend, runs the .jar, and after that return the results to the user. [FullStack Project Link](https://github.com/ferdefiore/Mars-Rovers-WebApp)

For running the desktop application download the source code and compile the java jar. If you want to run the .jar, you must be sure to have [Java SDK](https://www.oracle.com/ar/java/technologies/javase/javase-jdk8-downloads.html) installed.

If you only want to run the .jar without compiling java, download it from here
[Java MarsRovers.jar](https://github.com/ferdefiore/Mars-Rovers/tree/master/out/artifacts/MarsRovers_jar) and double click it to run, or with a console from the same folder:

    java -jar .\MarsRovers.jar

#### Test
All the classes with some logic have been tested, getting this coverage percentage:
![Coverage](https://user-images.githubusercontent.com/38536245/88970426-c7576480-d288-11ea-8843-5ada33d893ea.png)

# UI Interface
This application has a simple user interface as mentioned before. 
The first screen is to load the input string. 

![MenuViewImage](https://user-images.githubusercontent.com/38536245/88960111-6b391400-d279-11ea-9bb4-27568d6b9d69.png)

Here you can insert your input. It's important to place the instructions in the way that they were required. If not, it will throw an "input error" message.

![MenuViewImage2](https://user-images.githubusercontent.com/38536245/88960115-6c6a4100-d279-11ea-9b69-8c50963054ba.png)

After sending the commands, the application will open another window with the expedition results.

![ResultMenuView](https://user-images.githubusercontent.com/38536245/88960118-6d02d780-d279-11ea-915b-b7bdfb134422.png)

As the plateau has limits, if a rover went outside it when navigating it will show that also in the outputs results as:

![Error1](https://user-images.githubusercontent.com/38536245/88960602-2a8dca80-d27a-11ea-8e8c-b2351f5df0ed.png)

If the input has some unknow command, it will throw the input error just after the last successful decode. For example, giving an unknown instruction it will throw an error after decoding the rover:

![Error2](https://user-images.githubusercontent.com/38536245/88960662-3a0d1380-d27a-11ea-883c-efb499bde1f8.png)

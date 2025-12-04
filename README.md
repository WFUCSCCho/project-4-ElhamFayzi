# Project 4 @ CSC 201 Fall 2025: Hash Tables

## Pledged Work Policy

This is a ___Pledged Work___ assignment.  This means that the work you submit for grading ___must___ be your work product.  
You may not submit the work of others outside of your team, or the modification of work of others outside of your team.
You are encouraged to talk with each other about general problems.  For example, you may talk to someone about "What does
it mean when the compiler says there is a semicolon missing on line 20", or "I can not get my assignment template to
download from GitHub, what did you do?".  However, you may not engage in "Could you send me a copy of your work so I can
see how to get started?".  You may get full and detailed assistance from me, the Teaching Assistant (TA), and the TAs in
the Computer Science Center.  If you have any question about the appropriateness of assistance, do not hesitate to
consult with me.

If I believe you have violated our ___Pledge Work___ agreement, I will pursue this matter through the college Honor Council.

## Overview

A hash table is a fundamental data structure that stores key-value pairs. It uses a hash function to compute an index
(hash) into an array of buckets or slots, from which the desired value can be found. The hash function is used to 
transform the key into the index of the array that will be used to store the value. Hash tables offer average case 
O(1) time complexity for lookups, insertions, and deletions, assuming that the hash function is well-designed and the
load factor is kept low.

In this project, you will 

1. Implement a hash table that uses separate chaining to handle collisions.
2. Perform the hash table insert, search, and delete operations using already-sorted, shuffled, and reversed datasets 
lists as input.
3. Time the insert, search, and delete operation performances for the different number of inputs.
4. Graph and analyze the performance of the hash table operations.
5. Document your dataset and results in a `README.md` file.

## Invocation and I/O Files:

The name of the program is `Proj4` ( provided with a `main` method in`Proj4.java` ).

You are encouraged to run and debug code in __IntelliJ IDEA__. Also, the program can be invoked from the command-line as:

```shell
java Proj4 {dataset-file} {number-of-lines}
```
## 1. **Implement Separate Chaining Hash Table**

I have enclosed one starter code:
1. `SeparateChainingHashTable.java`
2. `TestSeparateChainingHashTable.java`
3. `Proj4.java`

The `SeparateChainingHashTable.java` file contains an overall structure of that Separate Chaining Hash Table class, and 
you are expected to complete the code where it is indicated (Search for // FINISH ME). The 
`TestSeparateChainingHashTable.java` file must not be modified, and it will be used for testing your Separate Chaining 
Hash Table class. It does not check for every error, but I hope that it will be helpful for you. The Proj4.java file 
contains a starter code for you to implement the main driver of the program.

The program takes in two command line arguments: 1) the filename if your dataset and 2) the number of lines of your 
dataset to read.

## 2. **Perform Hash Table insert, search, and delete operations on Already-Sorted, Shuffled, and Reversed Lists**

You will read your dataset and store the data in an ArrayList. To sort and randomize your ArrayList, you will use the
`Collections.sort()`, `Collections.shuffle()`, and `Collections.sort(al, Collections.reverseOrder())` commands,
respectively.

## 3. **Time Sorting Algorithm Performance**

For the hash table insert, search, and delete operations, you will use `System.nanoTime()` to calculate
the time it takes to run them on already-sorted, shuffled, and reversed lists.

Your program will print out the number of lines evaluated and the times insert, search, and delete each of the dataset 
elements into the already-sorted, shuffled, and reversed lists to the screen in a human-readable format (i.e., nice to 
look at) and also separately to a file named `analysis.txt` in CSV format. Each time the program runs, it will append 
the timing results to `analysis.txt`. At the end of your run, your hash table should be completely empty.

## 4. **Graph and Analyze the Performance of the Sorting Algorithms**

Run your program several times for different number of lines of your dataset, N, by choosing different values of the
second command line argument. After several runs, your `analysis.txt` file will be filled with timing and comparison data.

Using your favorite graphing software (e.g., MS Excel or Google Sheets), plot the running time (in seconds) vs. N for 
each case. Take a screenshot of your graph and put them here by modifying this file, committing, and pushing
it to this repository.

Insertion, search, and deletion running time (already sorted):

<img width="446" height="298" alt="Screenshot 2025-12-03 at 11 27 05 PM" src="https://github.com/user-attachments/assets/9ba8a2bc-881d-4a4f-a2c7-eef344d2998e" />

Insertion, search, and deletion running time (shuffled):

<img width="476" height="302" alt="Screenshot 2025-12-03 at 11 27 11 PM" src="https://github.com/user-attachments/assets/685295bc-a21f-4951-8bb6-ec099d33f125" />

Insertion, search, and deletion running time (reversed):

<img width="484" height="302" alt="Screenshot 2025-12-03 at 11 28 03 PM" src="https://github.com/user-attachments/assets/db2f1160-e458-46f7-b9a4-0336f6b2cc58" />


## 5. **Document your Dataset and Results**
Document the source of your dataset and any modifications you made to it. Describe the results of your analysis and 
how it compares to the theoretical performance of the hash table operations.

Dataset Source: https://www.kaggle.com/datasets/rishikeshkanabar/premier-league-player-statistics-updated-daily </br>
Dataset Modifications ("None" if unchanged): None
Result Analysis: In a standard Separate-Chaining Hash Table with a good hash function and unifrom distribution, the exoected average running time each operation (insertion, search, and deletion) is O(1). The worst-case running time occurs when all elements hash to a single bucket, and in this case, search and deletion require traversing the entire bucket, giving O(n) complexity, while insertion stays O(1) if each bucket is implemented using a linked list and no restructuring is needed after each insertion.
The results I obtained, shown in the attached graphs, also show a nearly constant time for insertion, search, and deletion across varying input sizes. The slight increase in running times noticed in the graphs are duee to looping over the original array to perform each operation on the hash table, which introduces a linear O(n) time complexity. In addition, some abrupt spikes, though unnoticeable, and gradual increase in insertion times can be explained by occasional rehashing of the table as the input size grows, which itself has a time complexity of O(N).

## Side Note:
`run.sh` is a shell script I wrote to automate running the program for different data sizes. It can be executed using `bash run.sh`, should it be needed.

## Submission:

Your project will be developed and graded via GitHub. Your final "push" is your final submission, and it must occur
before it is due. On Canvas, enter the url to your Github repository. Your project will not be graded without it.

## Recommendations:

I ___strongly suggest___ that you carefully think through your strategy before just jumping into the code.  Once that
is working, start adding in new features individually.  A good place to start is building your class.

*In order to get full points of Commenting and Code Style, you need to add comments to every method and head comments
for each file (providing file description, author, date, and acknowledgement).

```
/∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗*
∗ @file: filename.java
∗ @description: This program implements . . .
∗ @author: Your Name
∗ @date: December 4, 2025
∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗∗/
```

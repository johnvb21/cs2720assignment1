#!/bin/bash -x

javac -d bin -cp bin src/cs2720/assignment1/ItemType.java
javac -d bin -cp bin src/cs2720/assignment1/NodeType.java
javac -d bin -cp bin src/cs2720/assignment1/SortedLinkedList.java
javac -d bin -cp bin src/cs2720/assignment1/LinkedListDriver.java

java -cp bin cs2720.assignment1.LinkedListDriver input.txt

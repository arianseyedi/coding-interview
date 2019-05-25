# The Coding-Interview
  This repository is dedicated to efficient implimentation of interesting algorithms, much like the ones asked in phone/in person interviews. </br> The motivation of this project follows directly from Laakmann McDowell, 2015 book "Cracking the Coding Interview". This book is beyond awesome, and I love doing its exercises. Implementations are all mine along with the test cases for each main class.  
### In this Java project you will see the following packages (*JUnit test cases exist but not mentioned here*):

   1. **Data Structures**:  
   
      * **dataStructures_LinkedIntLists**:  
         Description: A linked int list implementation and most commonly used methods such as get, remove(first, last, any), toString, shift left/right and remove duplicate.  
         - *removeDups()*: remove duplicates in a linked list only in O(n) runtime.  
      
      * **dataStructures_StacksAndQueues**:  
         - **ExtremaStack.java**:  
            a stack that keeps track of both minimum and maximum values on a stack, returns them in O(1)   
         - **MyQueue.java**:  
            implementation of a queue using two stack  
         - **MyStack.java**:   
            *sort()*: sort method for a stack using only one other stack as a temporary one  
         - **PlateStack.java**:   
            *peek()*: return top element on PlateStack without chaning stack state.  
            *peek(Integer)*: return top element of an inner stack within the PlateStack  
            *pop()*: pop top element from the PlateStack  
            *pop(Integer)*: pop top element from an inner stack within the PlateStack  
            *push(E)*: push an element onto the most recent stack within the PlateStack  
            *push(E, Integer)*: push an element onto an inner stack within the PlateStack (if stack full, old element will be put on the most recent stack).  
            *stockSize()*: number of stacks that the PlateStack conisits of.  
      
      * **dataStructures_StringsAndArrays**:  
         - **Matrix.java**  
            A full matrix implementation along with a method that rotates any N x N matrix by 45 degrees  
         - **Sorting.java**  
            Two famous linear sorting algorithms, namely the heap sort and merge sort were implemented  
         - **StringsArrays.java**  
               *allMutations(String)*: all mutations of the letters in an input string  
               *couldBeAPalindrome(String)*: whether a series of characters in a string could form a Palindrome  
               *inCommon(Integer[], Integer[])*: The number of elements in common between two input arrays in O(n log n) 
               *isUnique(String, boolean)*: true if no two characters within a string are the same  
               *pairsSum(Integer[], Integer)*: pairs of numbers within an array whose sum is equal to a certain given amount  
               *replaceSpaceWith(String, String)*: URLify a string by replacing all spaces with a given set of characters (e.g. %20)
               *stringCompressor(String)*: return string containing each letter followed by its number of repitition  
       * **dataStructures_Graph**:  
          - This particular data structure is found [here](https://github.com/arianseyedi/JavaProjects/tree/master/Graphs "Graphs").    More information will be found under the given link.
   2. **Concepts And Algorithms**:  
      //TODO
   3. **Knowledge**:  
      //TODO
  
#### Enjoy!

#### Citations:
- Laakmann McDowell, G. (2015). Cracking the coding interview. Palo Alto: CareerCup.

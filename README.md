# The Coding-Interview
  This repository is dedicated to efficient implimentation of interesting algorithms, much like the ones asked in phone/in person interviews. </br> The motivation of this project follows directly from Laakmann McDowell, 2015 book "Cracking the Coding Interview". This book is beyond awesome, and I love doing its exercises. Implementations are all mine along with the test cases for each main class.  
  I do not use the solutions but if I do, I would mention that in the documentation of that method/class. Here I am not trying to duplicate other people's work for mine, nor am I copying something without wanting to mention where from. I simply love coding, and this is my way of practicing and also building a portfolio. You can leave your comments/suggestions for me, it will be greatly appreciated.
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
      
   2. **Concepts And Algorithms**:  
      //TODO
   3. **Knowledge**:  
      //TODO
  
#### Enjoy!

#### Citations:
- Laakmann McDowell, G. (2015). Cracking the coding interview. Palo Alto: CareerCup.

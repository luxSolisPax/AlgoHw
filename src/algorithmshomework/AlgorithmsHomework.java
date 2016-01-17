/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmshomework;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.*;
        
/**
 *
 * @author Benjamin
 */
public class AlgorithmsHomework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//Question 1
/*
This file contains all of the 100,000 integers between 1 and 100,000 (inclusive) in some order, with no integer repeated.

Your task is to compute the number of inversions in the file given, where the ith row of the file indicates the ith entry of an array.
Because of the large size of this array, you should implement the fast divide-and-conquer algorithm covered in the video lectures.
*/
        
        //String input1 = "io/Question1/IntegerArray.txt";        

        //Question1 test1 = new Question1();
        //System.out.println(test1.getInversions(input1));
        
//Question 2
/*
The file contains all of the integers between 1 and 10,000 (inclusive, with no repeats) in unsorted order. The integer in the ith row of the file gives you the ith entry of an input array.

Your task is to compute the total number of comparisons used to sort the given input file by QuickSort.
As you know, the number of comparisons depends on which elements are chosen as pivots, so we'll ask you to explore three different pivoting rules.
You should not count comparisons one-by-one.
Rather, when there is a recursive call on a subarray of length m, you should simply add m−1 to your running total of comparisons.
(This is because the pivot element is compared to each of the other m−1 elements in the subarray in this recursive call.)

WARNING: The Partition subroutine can be implemented in several different ways, 
and different implementations can give you differing numbers of comparisons.
For this problem, you should implement the Partition subroutine exactly as it is described in the video lectures
(otherwise you might get the wrong answer).
*/

        String input2 = "io/Question2/QuickSort.txt";
        
        Question2 test2 = new Question2();
        test2.readInputToArray(input2);
        test2.sortInput();
        System.out.println("end");
    }
    
}

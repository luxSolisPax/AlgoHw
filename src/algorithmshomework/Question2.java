/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmshomework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Benjamin
 */
public class Question2 {
    int[] inputArray = new int[10000];
    int comparisons = 0;
    int temp;
    int p;
    int i;
    
    public void readInputToArray(String fileName){
        int c = 0;
        String line;

        try {
            FileReader fileReader = new FileReader(fileName);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while((line = bufferedReader.readLine()) != null) {
                    inputArray[c] = Integer.parseInt(line);
                    c++;
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Unable to open file '"+fileName+"'");
        } catch (IOException ex) {
            System.err.println("Error reading file '"+fileName+"'");
        }
    }
    
    private void swap(int[] A, int a, int b){
        temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
    
    private void quicksort(int[] A, int head, int tail){
        int length = (tail-head) + 1;
        if (length <= 1) {
            
        } else {
            // part 1
            // proceed without adjustment
            
            // part 2
            //swap(A, head, tail);
            
            // part 3
            
            int mid = (int) (head + Math.floor(length/2));
            int median;
            
            if (A[head] > A[tail]) {
              if (A[tail] > A[mid]) {
                  median = tail;
              } else if (A[head] > A[mid]) {
                  median = mid;
              } else {
                  median = head;
              }
            } else {
              if (A[head] > A[mid]) {
                  median = head;
              } else if (A[tail] > A[mid]) {
                  median = mid;
              } else {
                  median = tail;
              }
            }
            swap(A, head, median);
            
            
            
            //partition
            p = A[head];
            i = head + 1;
            for(int j = i; j <= tail; j++){
                if (A[j] < p) {
                    swap(A, j, i);
                    i++;
                }
            }
            swap(A, head, (i-1));
            comparisons = comparisons+(length-1);
            
            //recurse
            quicksort(A, head, (i-2));
            quicksort(A, i, tail);
        }
    }
    
    public void sortInput(){

        quicksort(inputArray, 0, (inputArray.length - 1));
        for(int i = 0; i<inputArray.length; i++){
            if(inputArray[i] != i+1){
                System.out.println(inputArray[i]);
            }
        }
        System.out.println(comparisons);
    }
}

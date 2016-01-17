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
import java.util.Arrays;

/**
 *
 * @author Benjamin
 */
public class Question1 {

    int[] inputArray = new int[100000];
    int[] tempMergArr;
    int[] mergArr;
    long count;
    
    private void readInput(String fileName){
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
    
    private void calculateInversions(int[] A, int length) {
        mergArr = A;
        count = 0;
        tempMergArr = new int[length];
        doMergeSort(0, length-1);
    }
    
    private void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergePartsAndCount(lowerIndex, middle, higherIndex);
        }
    }
    
    private void mergePartsAndCount(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = mergArr[i];
        }
        
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                mergArr[k] = tempMergArr[i];
                i++;
            } else {
                mergArr[k] = tempMergArr[j];
                count = count + (middle - i) + 1;
                j++;
            }
            k++;
        }
        while (i <= middle) {
            mergArr[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
    
    public long getInversions(String fileName) {
        readInput(fileName);
        calculateInversions(inputArray, 100000);
        
        //int[] test = new int[]{1,5,3,2,4,6};
        //calculateInversions(test, 6);
        //System.out.println(Arrays.toString(test));
        return count;
    }
}


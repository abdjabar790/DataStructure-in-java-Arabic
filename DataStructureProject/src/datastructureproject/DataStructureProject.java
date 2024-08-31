/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datastructureproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author admin
 */
public class DataStructureProject {

    public static void main(String[] args) throws IOException {
        String oldFile = "C:/hashing/FirstFile.txt";
        String newFile = "C:/hashing/sorted.txt";
        HashTable<String, String> hashtable = new HashTable<>(50);
        SortingAndReadingHashTable(oldFile, hashtable);
        

        ArrayList<String> arr = sortingFiles(oldFile, newFile);
        SearchAlghorithms se = new SearchAlghorithms(arr);
        testingHashes(arr,hashtable, newFile);
         
      
        
    }

    
    public static void SortingAndReadingHashTable(String file, HashTable hashtable) throws FileNotFoundException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            ArrayList<String> arr = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                arr.add(line);
            }
            Collections.sort(arr);

            for (String i : arr) {
                hashtable.addItem(i, i);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
    public static ArrayList<String> sortingFiles(String OldFile, String NewFile) {

        ArrayList<String> arr = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(OldFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                arr.add(line);
            }
        } catch (IOException e) {
            System.out.println("error" + e);
        }
        Collections.sort(arr);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NewFile))) {
            for (String line : arr) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("error" + e);
        }
        return arr;
    }
    
    public static void testingHashes(ArrayList<String> list,HashTable ht, String sortedFil) {
        int countB=0;int countH=0;
        int countT=0;int countQ=0;
        int countJ=0;
          SearchAlghorithms se = new SearchAlghorithms(list);
        try (BufferedReader reader = new BufferedReader(new FileReader(sortedFil))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
//    System.out.println("hash: " + line +"  found at: "+
//    se.binarySearch(line) + " searchedBy BinarySearch  " + se.c2);
//     countB+=se.c2;
//
//    System.out.println("hash: "+ line +"  found at: " +
//    se.TernSrchArrLst(line) + " searchedBy TernarySearch  counter " + se.c3);
//        countT+=se.c3;
//
//    System.out.println("hash: " + line +"  found at: "+
//    se.quinarySearch(line) + " searchedBy quinarySearch Search  counter " + se.c5);
//       countQ+=se.c5;
//
//    System.out.println("hash: " + line +"  found at: " +
//    se.jumpSearch(line) + " searchedBy jumpSearch counter " + se.J);
//    countJ+=se.J;
//                
    ht.search(line);
     countH+=LinkedList.count;
            }
            System.out.println("BinarySearchTotalCount :" +countB );
            System.out.println("TernarySearchTotalCount :" +countT );
            System.out.println("JumpSearchTotalCount :" +countJ );
            System.out.println("QuinarySearchTotalCount :" +countQ );
            System.out.println("HashTableSearchTotalCount :" +countH );
        } catch (IOException e) {
            System.out.println("error" + e);
        }
    }
}

class SearchAlghorithms {

    ArrayList<String> list = new ArrayList<>();

    public SearchAlghorithms(ArrayList<String> list) {

        this.list = list;
    }
    public int c2 = 0;

    public int c3 = 0;

    public int c5 = 0;

    public int J = 0;

    public int binarySearch(String target) {
        int left = 0;
        int right = list.size() - 1;
        c2 = 0;
        while (left <= right) {

            c2++;

            int mid = left + (right - left) / 2;
            int result = target.compareTo(list.get(mid));

            if (result == 0) {
                return mid;
            }
            if (result > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public int TernSrchArrLst(String target) {
        int left = 0;
        int right = list.size() - 1;
        if (list.get(right).equals(target)) {
            return right;
        }
        if (list.get(left).equals(target)) {
            return left;
        }
        c3 = 0;
        while (right >= left) {
            c3++;
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (list.get(mid1).equals(target)) {
                return mid1;
            }
            if (list.get(mid2).equals(target)) {
                return mid2;
            }

            if (target.compareTo(list.get(mid1)) < 0) {
                right = mid1 - 1;
            } else if (target.compareTo(list.get(mid2)) > 0) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }

        return -1;

    }

    public int quinarySearch(String target) {
        int left = 0;
        int right = list.size() - 1;
        c5 = 0;
        while (right >= left) {
            c5++;

            int mid1 = left + (right - left) / 5;
            int mid2 = left + 2 * (right - left) / 5;
            int mid3 = left + 3 * (right - left) / 5;
            int mid4 = left + 4 * (right - left) / 5;

            if (list.get(mid1).equals(target)) {
                return mid1;
            }
            if (list.get(mid2).equals(target)) {
                return mid2;
            }
            if (list.get(mid3).equals(target)) {
                return mid3;
            }
            if (list.get(mid4).equals(target)) {
                return mid4;
            }

            if (target.compareTo((String) list.get(mid1)) < 0) {
                right = mid1 - 1;
            } else if (target.compareTo((String) list.get(mid1)) > 0 && target.compareTo((String) list.get(mid2)) < 0) {
                left = mid1 + 1;
                right = mid2 - 1;
            } else if (target.compareTo((String) list.get(mid2)) > 0 && target.compareTo((String) list.get(mid3)) < 0) {
                left = mid2 + 1;
                right = mid3 - 1;
            } else if (target.compareTo((String) list.get(mid3)) > 0 && target.compareTo((String) list.get(mid4)) < 0) {
                left = mid3 + 1;
                right = mid4 - 1;
            } else {
                left = mid4 + 1;
            }
        }

        return -1;
    }

    public int jumpSearch(String target) {
        int n = list.size();
        int step = (int) Math.floor(Math.sqrt(n));

        int prev = 0;
        J = 0;
        while (list.get(Math.min(step, n) - 1).compareTo(target) < 0) {
            J++;
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return -1;
            }
        }

        while (list.get(prev).compareTo(target) < 0) {
            J++;
            prev++;
            if (prev == Math.min(step, n)) {
                return -1;
            }
        }

        if (list.get(prev).equals(target)) {
            return prev;
        }

        return -1;
    }

}

class Node<TKey, TValue> {

    TKey key;
    TValue value;
    Node<TKey, TValue> next;

    Node(TKey key, TValue value) {
        this.key = key;
        this.value = value;
    }
}

class LinkedList<TKey, TValue> {

    public static int count = 0;
    Node<TKey, TValue> head;
    int size = 0;

    public void add(TKey key, TValue value) {
        Node<TKey, TValue> newNode = new Node<>(key, value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public TValue find(TKey key) {
        Node<TKey, TValue> current = head;
        count = 0;
        while (current != null) {
            count++;
            if (current.key.equals(key)) {
                System.out.println("found : [" + current.value + "] count is " + count);
                return current.value;
            }
            current = current.next;
        }
        System.out.println("Not Found");
        return null;
    }
}

class HashTable<TKey, TValue> {

    LinkedList<TKey, TValue>[] table;
    int size;

    HashTable(int size) {
        this.size = size;
        table = (LinkedList<TKey, TValue>[]) new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void printHashes() {

        for (int i = 0; i < table.length; i++) {

        }

    }

    public int hash(TKey key) {
        String value = ((String) key);
        int hashValue = 0;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            hashValue += (int) c;
        }
        return hashValue % size;
    }

    public void addItem(TKey key, TValue value) {
        int index = hash(key);
        table[index].add(key, value);
    }

    public TValue search(TKey key) {
        int index = hash(key);

        return table[index].find(key);

    }
}


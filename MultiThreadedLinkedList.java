/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadedlinkedlist;

/**
 *
 * @author root
 */
public class MultiThreadedLinkedList {
    
    /**
     * This is just for testing purpose.
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        MLinkedList<Integer> l1=new MLinkedList<>(1);
        
        //All the methods here, just create the thread to add to the list. The threads keep
        //running in the background.
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        
        System.out.println("--------------------------");
        
        Thread.sleep(3000); //To give it time to run all the threads.
        l1.printList();
        
        
        System.out.println("--------------------------");
        
        //All the methods here, just create the thread to add to the list. The threads keep
        //running in the background.
        l1.delete(3);
        l1.delete(4);       
       
        Thread.sleep(2000);         //To give it time to run all the threads.
        l1.printList();
        
    }    
}

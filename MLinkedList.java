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
public class MLinkedList<T> {
    MNode<T> head; //Head of the list

    /**
     * Constructor of the list
     * @param data is the data goes in the head of the list
     */
    public MLinkedList(T data) {
        this.head = new MNode<>(data);
    }
    
    /**
     * To add the data to the list. The method creates a new thread for adding every time it's called.
     * @param data is the data to be added to the list
     */
    public void add(T data){
        MAdd<T> madd=new MAdd<>(this.head,data);
        Thread t1=new Thread(madd);        
        t1.start();
        
    }
    
    /**
     * To delete the data from the list.The method creates a new thread for adding every time it's called.
     * @param data is the data to be deleted.
     */
    public void delete(T data){
        MDelete<T> mdelete=new MDelete<>(this.head,data);
        Thread t1=new Thread(mdelete);        
        t1.start();
        
    }
    
    /**
     * Method to update a node in linked list.The method creates a new thread for adding every time it's called.
     * @param staleData
     * @param updatedData 
     */
    public void update(T staleData, T updatedData){
        MUpdate<T> mupdate=new MUpdate<>(this.head,staleData,updatedData);
        Thread t1=new Thread(mupdate);        
        t1.start();
    }
    
    /**
     * Method to print the list.
     */
    public void printList(){
        MNode<T> temp=this.head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    
}

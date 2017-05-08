/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadedlinkedlist;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author root
 * This is a generic Node for the linkedList.
 */
public class MNode<T> {
    
    T data;     //Generic data Holder
    MNode next; //Pointer to the next node
    ReentrantLock lock; //Lock for the node to allow only one thread to insert.
    /**
     * Constructor
     * @param data 
     */
    public MNode(T data) {
        this.data=data;
        this.next=null;
        this.lock=new ReentrantLock();
    }

    /**
     * Getter for the data.
     * @return 
     */
    public T getData() {
        return data;
    }

    /**
     * Setter for the data.
     * @param data 
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Getter for the next node.
     * @return 
     */
    public MNode getNext() {
        return next;
    }

    /**
     * Setter for the next node.
     * @param next 
     */
    public void setNext(MNode next) {
        this.next = next;
    }
}

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
public class MAdd<T>  implements Runnable{
    
    MNode<T> node;
    T data;

    /**
     * Constructor for add class.
     * @param node
     * @param data 
     */
    public MAdd(MNode<T> node, T data) {
        this.node = node;
        this.data = data;
        
        
    }
    
    @Override
    public void run() {        
        MNode<T> temp=node;        
        while(temp.next!=null ){
            if(temp.lock.isLocked())
                temp=temp;
            else
                temp=temp.next;                 
        }       
        
        //Since we are adding, we only need to lock the last node of the linkedList.
        //Critical section
        temp.lock.lock(); 
        temp.next=new MNode(this.data);
        temp.lock.unlock();
        //end of critical section
        
    }
    
}

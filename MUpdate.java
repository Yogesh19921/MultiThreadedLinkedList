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
public class MUpdate<T> implements Runnable {
    MNode<T> node;
    T data;
    T updatedData;

    /**
     * Just the constructor.
     * @param node
     * @param data
     * @param updatedData 
     */
    public MUpdate(MNode<T> node, T data, T updatedData) {
        this.node = node;
        this.data = data;
        this.updatedData = updatedData;
    }
    

    @Override
    public void run() {
        MNode<T> temp=node;
        
        while(temp!=null){
            if(temp.data==this.data){
                //We just have to lock the current node only for the update.
                //Critical section
                temp.lock.lock();
                temp.data=this.updatedData;
                temp.lock.unlock();
                //end of critical section
                break;
            }
            temp=temp.next;
        }
    }
}

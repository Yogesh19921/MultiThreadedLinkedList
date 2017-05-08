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
public class MDelete<T> implements Runnable{
    MNode<T> node;
    T data;

    public MDelete(MNode<T> node, T data) {
        this.node = node;
        this.data = data;
    }

    @Override
    public void run() {
        MNode<T> temp=node;
        
        //If the node to be deleted is the head of the list.
        if(temp.data==this.data){
            //Critical section
            temp.lock.lock();
            node=node.next;
            temp.lock.unlock();
        }
        
        else{
            while(temp.next.data!=this.data){
                if(temp.lock.isLocked())
                    temp=temp;
                else
                    temp=temp.next;
            }
            
            
            //Here we need to lock the node before the deleted one and the one we are deleting.
            //Critical sections
            temp.lock.lock();            
            temp.next.lock.lock();            
            MNode<T> t1=temp.next;            
            temp.next=temp.next.next;
            t1.lock.unlock();
            temp.lock.unlock();
            //end of critical section.
            
        }
    }
    
    
    
    
    
}

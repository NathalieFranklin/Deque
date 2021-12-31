/**This file holds my implementation of
 *a QueueInterface. It uses methods from the
 *mine previously created Deque as shortcuts
 *to create queue methods
 *
 * Author:Nathalie Franklin
 * Email: nfrankli@ucsd.edu
 * References: No refrences were used everything was
 * done and conceptulized by me.
*/

/**This class implements the QueuekInterface to create
 *a queue with limited methods. It'd enqueue, dequeue, peek
 *and isEmpty methods are all relient on the dequeue
 *methods for insertion, deletion, peeking and its size
 *field variable
*/
public class MyQueue<E> implements QueueInterface<E>{
    MyDeque<E> theQueue;
    /**The constrictor intializes the MyDeque instance
     *with intialCapacity.
     *@param intialCapacity of the Deque and queue
    */
    public MyQueue (int initialCapacity){
        theQueue = new MyDeque(initialCapacity);

    /**This method uses the deque's size field
     *varaible to determine if the queue is empty
     *@return true if queue is empty otherwise false 
    */
    }
    public boolean empty(){
        if(theQueue.size == 0){
            return true;
        }
        return false;
    }
    /**This method uses the MyDeques 
     *addLast to add the element at the end 
     *of the queue 
     *@param element to be insert at the end
     *of queue
    */
    public void enqueue(E e){
        theQueue.addLast(e);
    }
    /**This method uses the MyDeques 
     *removeFirst to remove the element at the front
     *of the queue 
     *@return element removed from the front
     *of queue
    */
    public E dequeue(){
        return (E) theQueue.removeFirst();
    }
    /**Returns element at the front of the queue
     *using MyDeques peekFirst method 
     *@return element at the front of queue
    */
    public E peek(){
        return (E) theQueue.peekFirst();
    }
}

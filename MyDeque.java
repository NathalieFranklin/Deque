/**
 *This file holds the implementation of my own 
 *version of Deque. Its methods are written
 * so it can be used to help me implement my own
 *Stack and Queue
 * Author:Nathalie Franklin
 * Email: nfrankli@ucsd.edu
 * References: No refrences were used everything was
 * done and conceptulized by me.
*/
import java.util.Arrays;
/**This class implement the DequeInterface and functions
 *like a Deque with limited functionality. It allows for double
 *sided insertion, deletion and peeking making it flexible to
 *implement other datas structures such as Stack and Queue.
*/
public class MyDeque <E> implements DequeInterface<E> {
    Object[] data;
    int size;
    int rear;
    int front;
    static final int default_cap = 15;
    /**This constructor excepts a potential capacity varifies
     *if it is valid. Then intializes all the instance variables
     *to thier default of 0
     *@param: initialCapacity of the data array
    */
    public MyDeque(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException ();
        }
        data = new Object[initialCapacity];
        rear = 0;
        front = 0;
        size =0;
    }
    /**Returns the size of the Dequeue aka
     *the amount of none null elements
     *@return the amount of none null element in array
    */
    public int size(){
        return size;
    }
    /**This methods when called will move all the
     *valid elements with the fron being index 0
     *and the rear being size-1 away index. Then
     *it will double its capacity unless currently empty
     *where it will simply change capacity to the default
     *15.
    */
    public void expandCapacity(){
        int new_capacity;
        if(data.length == 0){
            this.data = new Object[default_cap];
            return;
        }
        Object[] temp = new Object[data.length];
        int temp_index = 0;
        int i = 0;
        int j =0; 
        //if front and rear are not in order
        //then counting up from front can go
        //from end of the array to the begining
        while(temp_index< data.length){
            //starts at front check if it can go backwards
            if (front + i <= data.length-1 ){
                temp[temp_index] =data[front+i];    
                temp_index+=1;
                i+=1;
            }
            //if it can no longer go bacwards but hasn't hit 
            //rear it will keep going and move to the beginning
            else if (j<=rear){

                 temp[temp_index] = data[j];
                 temp_index++;
                 j++;
            }
            else { 
                break;
            }
        }
        temp = Arrays.copyOf(temp, data.length*2);
        data = temp;
        front = 0;
        rear = size-1;
    }
    /**Check if element is valid then places element to 
     *where the front index of the
     *array lies if array is at capacity then first 
     *expandsCapacity before adding. Then increments 
     *size and decrements front.
     *@param element to insert at front
    */
    @Override
    public void addFirst(E element){
        if(element== null){
            throw new NullPointerException();
        }
        if(size>=data.length){
           expandCapacity();
       }
       if(size==0){
           data[front]= element;
       }
       else if (front -1 < 0) {
           front = data.length-1;
           data[front]= element;
       }
       else{
           data[front -1] = element;
           front = front-1;
       }
         
        size+=1;
    }
    /**This method removes the element at 
     *the front index and increments front
     *while decrementing size.
     *@return the removed element at the front
    */
    public E removeFirst(){
        if(size == 0){
            return (E)null;
        }
        Object temp = data[front];
        data[front]=null;
        size-=1;
        if (front +1 > data.length-1){
            front=0; 
        }
        else if(size!=0) {
             front+=1;
        }
        
        return (E) temp;
    }
    /**This method checks if element is valid and
     *if capacity needs to be expanded first. Then
     *it adds the element to the rear index, incrementing
     *rear and size.
     *@ param the element to be inserted at the rear
    */
    public void addLast(E element){
        if (element == null){
            throw new NullPointerException();
        }
        if(size >= data.length){
            expandCapacity();
        }
        if (size ==0){
            
        }
        else if (rear + 1 > data.length-1){
            rear = 0;
        }
        else{
            rear = rear+1;
        }
        data[rear] = element; 
        size+=1;
    }
    /**Removes the rear index element in the
     *list and decremnets rear and size then returns
     *the element removed from rear
     *@return the element removed from the rear
    */
    public E removeLast(){
        if (size ==0){
            return (E)null;
        }
        size-=1;
        Object temp = data[rear];
        data[rear] = null; 
        if(rear -1 <0) {
            rear = data.length-1;
        }
        else if(size!=0) {
            rear -=1;
        }
        
        return (E)temp;
    }
    /**Returns the element at the front index
     *@return element at the front of the index
    */
    public E peekFirst(){
        if(size==0){
            return (E)null;
        }
        return (E) data[front];
    }
    /**Returns the element at the rear index
     *@return element at the rear of the index
    */
    public E peekLast(){
         if(size==0){
            return (E)null;
        }
        return (E) data[rear];
    }
    
}

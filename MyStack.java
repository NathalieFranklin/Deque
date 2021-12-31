/*This file holds my implementation of
 *a StackInterface. It uses methods from the
 *mine previously created Deque as shortcuts
 *to create stacks methods
 *
 * Author:Nathalie Franklin
 * Email: nfrankli@ucsd.edu
 * References: No refrences were used everything was
 * done and conceptulized by me.
*/

/**This class implements the StackInterface to create
 *a stack with limited methods. It'd push, pop, peek
 *and isEmpty methods are all relient on the dequeue
 *methods for insertion, deletion, peeking and its size
 *field variable
*/
public class MyStack<E> implements StackInterface<E> {
    MyDeque<E> theStack; 
    
    /**This constructor intializes the MyDeque field variable
     *with the initialCapacity passed in.
     *@param the intialCapacity of the Stack and Deque 
    */
    public MyStack (int initialCapacity){ 
        
        theStack = new MyDeque(initialCapacity);  
    }
    /**This method uses the deque's size field
     *varaible to determine if the Stack is empty
     *@ return true if Stack is empty otherwise false 
    */
    public boolean empty(){
        if(theStack.size == 0){
            return true;
        }
        return false;
    }
    /**This method uses MyDeques addLast
     *to add the element to the top of the Stack 
     *@param element to push to the top of the stack
    */
    public void push(E e){
        
        theStack.addLast(e);
    }
    /**This method uses MyDeque's removeLast method
     *to pop the element at the top of the stack
     *@return element at the top of stack 
    */
    public E pop(){
        Object temp =theStack.removeLast();
        if (temp ==null){
            return (E)temp;
        }
        return (E)temp;
    }
    /**This method uses the MyDeque's peekLast
     *method to return the element at the top
     *of the stack
     *@return element at the top of the stack
    */
    public E peek(){
       if (theStack.peekLast()==null){
           return theStack.peekLast();
       }
       return (E)theStack.peekLast();

    }
     
}

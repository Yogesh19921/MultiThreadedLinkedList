# multithreadedlinkedlist
Generic Multi Threaded Linked list for java with thread safety

It is a simple implementation of Linked list to deal with multiple threads accessing the linked list.

MAdd, MUpdate, MDelete are the classes implementing Runnable interface to add, update, and delete in a safe manner for a multithreaded scenario. 
MLinkedList is the class which actually implements the linked list.
MultiThreadedLinkedList is the main method which just shows an example of how to use the linked list.

Instructions to run the test code:
1. Extract the files in a folder.
2. Run the command from terminal 
  **_javac *.java_**
3. Go to the parent folder and run it from there using the command.           
  **_java multithreadedlinkedlist.MultiThreadedLinkedList_** where multithreadedlinkedlist is the name of your package folder.

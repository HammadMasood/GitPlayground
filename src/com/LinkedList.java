package com;
import java.io.IOException;
import java.util.Scanner;


/**
 * @author avisharma
 * 
 * This Class is class for customized linked list
 */
public class LinkedList {
	
	/*
	 * Class level params
	 */
	Node head;
	final static String os = System.getProperty("os.name");
	
	
	
	/**
	 * Constructor with elements option
	 * 
	 * @param elements
	 */
	public LinkedList(String[] elements){
		head = null;
		for(String element:elements){
			push(element);
		}
	}
	
	/**
	 * Constructor for creating empty object
	 */
	public LinkedList(){
		head = null;
	}

	/*Function to rotate list by k places */
	public void rotateList(int k) {
		
		int count=0;
		Node start = head;
		
		if (head == null) {
			System.out.println("lsit is empty");
			return;
		}
		
		while (start.getNext() != null)
		{
			start=start.getNext();
			count = count+1;
		}
		count =count+1;

		k = k % count;
		//System.out.println(k);
		k = Math.abs(count - k);
		//System.out.println(k);
		if (k==0) {
			return;
		}
		
		start.setNext(head);
		
		
		while (k-- >0) {
			start=start.getNext();
		}
		
		head=start.getNext();
		
		start.setNext(null);
		
		return;
	}
	
	
    /* Inserts a new Node at front of the list. */
    public void push(String new_data)
    {
        /* create the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /*Make next of new Node as head */
        new_node.setNext(head); 
 
        /*Move the head to point to new Node */
        head = new_node;
    }
    
	/**
	 * Inserts all Node at front of the list.
	 *  
	 * @param elements
	 */
	private void pushAll(String[] elements) {
		for(String element:elements){
			push(element);
		}
	}
	
	
    public void append(String data) {
    	
    	Node newNode = new  Node(data);
    	
    	newNode.setNext(null);
    	
    	if (head == null) {
    		head = newNode;
    		return;
    	}
    	
    	Node tail=head;
    	
    	while (tail.getNext() !=null) {
    		tail=tail.getNext();
    	}
    	tail.setNext(newNode);
    }
    
	/**
	 * Function to print list 
	 */
	public void printList() {
		Node newNode=head;
		/*Declaring array with dynamic size to store data of lined list*/
		String[] nodeData = new String[getCountRec(head)];
		int i=0;
		
		System.out.print("LinkedList: ");
		
		/*For linear display of list*/
		for(int j=0; j < nodeData.length; j++)
		{
				String data = newNode.getData();
				nodeData[j]= data;
				System.out.print(nodeData[j]);
				newNode=newNode.getNext();
				
				if(j<nodeData.length-1) System.out.print("-->");
				
		}
		System.out.println("\n");
		
		
	}
	
	/*Insert data after specific node with specific data in LinkedList*/
	public void insertAfter(String prevdata, String data) {
		
		Node start =head;
		if (head == null) {
			return;
		}
		
		Node new_node = new Node(data);
		int i = getCountRec(head);
		
		int count=0;
		int validate=0;
		while (head != null) {
			if (head.getData().equals(prevdata)) {
				new_node.setNext(head.getNext()); 
				head.setNext(new_node);	
				validate=1;
			}
			if (head.getNext() == null) {
				break;
			}
			else {
				head=head.getNext();	
			}
			
			
			count=count+1;
		}
		Node tail= head;
		tail.setNext(start);
		head=tail.getNext();
		tail.setNext(null);
		
		/*Validate if given data exist in linked list or not*/
		if(validate == 0) {
			System.out.println("Given data is not present in linked list. Printing orignal linked list.");
		}
		
	}
	
	public void deleteNode(String data) {
	
		if (head == null) {
			return;
		}
		
		if(head.getData().equals(data) && head.getNext() != null) {
			head=head.getNext();
		}
		
		if(head.getData().equals(data) && head.getNext() == null) {
			System.out.println("This is the last node in list, hence cannot delete this node.");
		}
		
		Node start =head;
		
    	while (start.getNext() !=null) {
    		if (start.getNext().getData().equals(data)) {
    			start.setNext(start.getNext().getNext());
    		}
			if (start.getNext() == null) {
				return;
			}
			else {
				start=start.getNext();	
			}
    		
    	}	
    	return;
	}
	
    /* Returns count of nodes in linked list */
    public int getCountRec(Node node)
    {
        // Base case
        if (node == null)
            return 0;
 
        // Count is this node plus rest of the list
        return 1 + getCountRec(node.getNext());
    }
 
    /* Wrapper over getCountRec() */
    public int getCount()
    {
        return getCountRec(head);
    }
	
	public static void main(String[] args) {
		
		System.out.println("OS Type is: "+os);
		
		/* Declaring linked list preliminary sample elements */
		String[] initialElem = {"Violet", "Indigo", "Blue", "Green", "Yellow", "Orange", "Red"} ;
		
		/* Create empty list */
		LinkedList ll = new LinkedList();
		
		/* Inserting data in LinkedList. head will be the last inserted element */
		ll.pushAll(initialElem);

		/* Provide Menu feature */
		ll.casefunction();
		
	}
	
	/*Get run time input (string type) parameter from user*/
	public String strigParam() {
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		return data;
	}
	
	/*Get run time input (integer type) parameter from user*/
	public int intParam() {
		Scanner sc = new Scanner(System.in);
		//TODO entering non int value broke it :(
		int data = sc.nextInt();
		return data;
	}
	
	/*Function to display options of application*/
	public int displayOptions() {
		System.out.println("List of functionalities:");
		System.out.println("1. Push Node [Head]");
		System.out.println("2. Append Node [Tail]");
		System.out.println("3. Insert After");
		System.out.println("4. Get Count in List");
		System.out.println("5. Rotate List by k places");
		System.out.println("6. Delete Node");
		System.out.println("7. Print List");
		System.out.println("0. Exit");
		System.out.println("Choose option to execute function:");
		return intParam();
	}
	
	public void casefunction() {
		//TODO - Need more research
//		clearConsole();
		
		int option = displayOptions();
		switch (option) {
			case 1:   casePushData();
			case 2:   caseAppend();
			case 3:   caseinsertAfter();
			case 4:   casegetListCount();
			case 5:   caseRotateRight();
			case 6:   casedeleteNode();
			case 7:   caseprintList();
			case 0:   System.out.println("Exiting");
					  break;	
			default:  System.out.println("Invalid option chosen.Please choose a valid option.");;
					  casefunction();	  
				
		}
	}
	
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
//	        	System.out.print("\033[H\033[2J");
	        	Runtime.getRuntime().exec("cmd /c cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        System.out.println(e);//  Handle any exceptions.
	    }
	}
	
/*Below are the functions created to maintain flow of application*/	
	public void casePushData() {
		System.out.println("Enter String data to be inserted in node. This node will be head.");
		String data=strigParam();
		push(data);
		System.out.println("Data pushed successfully.Choose below mentioned option to proceed.");
		System.out.println("1. Push Another Node");
		System.out.println("2. Go to main Menu");
		int opt=intParam();
		if (opt == 1) {
		  casePushData();
		}
		else {		
		  casefunction();
		}	
	}
	
	public void caseAppend() {
		System.out.println("Enter String data to be inserted in node. This node will be tail.");
		String data=strigParam();
		append(data);
		System.out.println("Data pushed successfully.Choose below mentioned option to proceed.");
		System.out.println("1. Append Another Node");
		System.out.println("2. Go to main Menu");
		int opt=intParam();
		if (opt == 1) {
		  caseAppend();
		}
		else {		
		  casefunction();
		}			
	}
	
	public void caseinsertAfter() {
		System.out.println("Orignal List:");
		printList();
		System.out.println("Enter data after which  new data needs to be inserted");
        String prev=strigParam();
        System.out.println("Enter new data which needs to be inserted");
        String newdata=strigParam();
        insertAfter(prev, newdata);
		System.out.println("Updated List:");
		printList();
		System.out.println("1. Repeat the task: Insert After");
		System.out.println("2. Go to main Menu");
        int opt=intParam();
		if (opt == 1) {
			caseinsertAfter();
		}
		else {
			casefunction();
		}		
	}
	
	public void casegetListCount() {
		System.out.println("Current List Count: "+getCount());
		System.out.println("1. Repeat the task: Get List Count");
		System.out.println("2. Go to main Menu");
        int opt=intParam();
		if (opt == 1) {
			casegetListCount();
		}
		else {
			casefunction();
		}		
	}
	
	public void caseRotateRight() {
		System.out.println("Orignal List:");
		printList();		
		System.out.println("Enter no. of places to be moved right: ");
		int k=intParam();
		rotateList(k);
		System.out.println("Updated List after rotating k places right:");
		printList();
		System.out.println("1. Repeat the task: Rotate List to right");
		System.out.println("2. Go to main Menu");		
        int opt=intParam();
		if (opt == 1) {
			caseRotateRight();
		}
		else {
			casefunction();
		}		
	}
	
	public void casedeleteNode() {
		System.out.println("Orignal List:");
		printList();		
        System.out.println("Enter data which needs to be deleted");
        String newdata=strigParam();
        deleteNode(newdata);
		System.out.println("Updated List:");
		printList();
		System.out.println("1. Repeat the task: Delete Node");
		System.out.println("2. Go to main Menu");
        int opt=intParam();
		if (opt == 1) {
			casedeleteNode();
		}
		else {
			casefunction();
		}		       
		
	}
	
	public void caseprintList() {
		printList();
		System.out.println("1. Repeat the task: Print List");
		System.out.println("2. Go to main Menu");		
        int opt=intParam();
		if (opt == 1) {
			caseprintList();
		}
		else {
			casefunction();
		}		
	}
}

package com;
import java.io.IOException;
import java.util.Scanner;


/**
 * @author avisharma
 *This Class is class for customized linked list
 */
public class LinkedList {

	Node head;
	
	final static String os = System.getProperty("os.name");
	
	
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
	 * 
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
				System.out.print(nodeData[j] + "-->");		
				newNode=newNode.getNext();
		}
		System.out.println("Null"+"\n");
		
		
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
		/*Declaring linked list*/
		LinkedList ll = new LinkedList();
		
		/*Inserting data in LinkedList. head will the last inserted element*/
		ll.push("Violet"); 
		ll.push("Indigo");
		ll.push("Blue");
		ll.push("Grey");
		ll.push("Yellow");
		ll.push("Orange"); 
		// Linked list is Orange->Yellow->Grey->Blue->Indigo->Violet->Null
		
		//ll.printList();
		//ll.push("Red");
		//ll.printList();
		
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
		int data = sc.nextInt();
		return data;
	}
	
	/*Function to display options of application*/
	public int displayOptions() {
		System.out.println("List of functionalities:");
		System.out.println("1. Push Node");
		System.out.println("2. Insert After");
		System.out.println("3. Get Count in List");
		System.out.println("4. Rotate List by k places");
		System.out.println("5. Print List");
		System.out.println("0. Exit");
		System.out.println("Choose option to execute function:");
		return intParam();
	}
	
	public void casefunction() {
		
		int option = displayOptions();
		switch (option) {
			case 1:   casePushData();
			case 2:   caseinsertAfter();
			case 3:   casegetListCount();
			case 4:   caseRotateRight();
			case 5:   caseprintList();
			case 0:   System.out.println("Exiting");
					  break;	
			default:  System.out.println("Invalid option chosen.Please choose a valid option.");;
					  casefunction();	  
				
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
		System.out.println(getCount());
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

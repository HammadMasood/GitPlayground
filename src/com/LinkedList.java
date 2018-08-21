package com;
import java.util.Scanner;


/**
 * @author avisharma
 *This Class is class for customized linked list
 */
public class LinkedList {

	Node head;
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
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.setNext(head); 
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
	
	
	/**
	 * 
	 */
	public void printList() {
		Node newNode=head;
		String[] nodeData = new String[50];
		int i=0;
		
		while (newNode != null) {
			String data = newNode.getData();
			nodeData[i]= data;
			//System.out.println(" "+data);
			newNode=newNode.getNext();
			i = i+1;
		}
		//For linear display of list
		for(int j=0; j < i; j++)
		{
				System.out.print(nodeData[j] + "-->");			 
		}
		System.out.println("Null"+"\n");
		
		
	}
	
	public Node push(String data , Node node) {
		
		Node newNode = new Node(data);
		
		newNode.setNext(node);
		return newNode;
		
	}
	
	public Node insertAfter(Node prev, String data, Node node) {
		
		Node newNode =new Node(data);
		
		newNode.setNext(prev.getNext());
		prev.setNext(newNode);
		
		return node ;
	}
	
	//Method to get count of nodes/lengt of linked list
    public int getCount()
    {
        Node temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.getNext();
        }
        return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Node linking approach
		//Node node= new Node("Violet");
		//Node node2= new Node("Indigo");
		//Node node3= new Node("Blue");
		//Node node4= new Node("Grey");
		//Node node5= new Node("Yellow");
		//Node node6= new Node("Orange");
		
		//node.setNext(node2);
		//node2.setNext(node3);
		//node3.setNext(node4);
		//node4.setNext(node5);
		//node5.setNext(node6);
		
		//Declaring linked list
		LinkedList ll = new LinkedList();
		
		/*head will the last inserted element*/
		ll.push("Violet"); 
		ll.push("Indigo");
		ll.push("Blue");
		ll.push("Grey");
		ll.push("Yellow");
		ll.push("Orange"); //head 
		// Linked list is Orange->Yellow->Grey->Blue->Indigo->Violet->Null
		ll.printList();
		ll.push("Red");
		ll.printList();
		//System.out.println(ll.getCount());
		System.out.println("Enter no. of places to be moved right: ");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		ll.rotateList(i);
		ll.printList();
		//Node list=rl.push("Avish", node);
		//Node list1=rl.push("Avish1", list);
		//ll.printList();
		
		//rl.printList(rl.insertAfter(node3, "hey", node));

		
		
	}

}

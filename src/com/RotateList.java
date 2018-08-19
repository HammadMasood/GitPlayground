package com;
import java.util.Scanner;


/**
 * @author avisharma
 *This Class will rotate elements of list to right by k places
 */
public class RotateList {

	public Node rotateList(Node head, int k) {
		
		int count=0;
		Node start = head;
		
		while (head.getNext() != null)
		{
			head=head.getNext();
			count = count+1;
		}
		count =count+1;

		k = k % count;
		//System.out.println(k);
		k = Math.abs(count - k);
		//System.out.println(k);
		if (k==0) {
			return start;
		}
		
		head.setNext(start);
		
		
		while (k-- >0) {
			head=head.getNext();
		}
		
		start=head.getNext();
		
		head.setNext(null);
		
		return start;
	}
	
	
	
	
	
	public void printList(Node node) {
		Node head=node;
		while (head != null) {
			String data = head.getData();
			System.out.println(data);
			head=head.getNext();
		}
		
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node node= new Node("Violet");
		Node node2= new Node("Indigo");
		Node node3= new Node("Blue");
		Node node4= new Node("Grey");
		Node node5= new Node("Yellow");
		Node node6= new Node("Orange");
		
		node.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		
		RotateList rl = new RotateList();
		//rl.printList(node);
		System.out.println("Enter no. of places to be moved right: ");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		Node start = rl.rotateList(node, i);
		
		//Node list=rl.push("Avish", node);
		//Node list1=rl.push("Avish1", list);
		rl.printList(start);
		
		//rl.printList(rl.insertAfter(node3, "hey", node));

		
		
	}

}

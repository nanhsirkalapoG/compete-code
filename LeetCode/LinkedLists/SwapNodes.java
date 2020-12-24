import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

// Given a linked list, swap every two adjacent nodes and return its head.
public class SwapNodes {
	
	public static void PrintList(ListNode head) {
		System.out.println("Printing list");
		while(head != null) {
			System.out.print(head.val + "\t");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode();
		head.val = 1;
		head.next = new ListNode();
		head.next.val = 2;
		head.next.next = new ListNode();
		head.next.next.val = 3;
		head.next.next.next = new ListNode();
		head.next.next.next.val = 4;
		
		PrintList(head);
		
		ListNode result = swapPairs(head);
		
		PrintList(result);
	}
	
	public static void populateLists(List<ListNode> oddList, List<ListNode> evenList, ListNode head) {
		int nodeCount = 0;
        while(head != null) {
            nodeCount++;
            if ((nodeCount % 2) == 0) {
            	evenList.add(head);
            } else {
            	oddList.add(head);
            }
            head = head.next;
        }
	}
	
    public static ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        ListNode newList = null, tempList = null;
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> oddList = new ArrayList<ListNode>();
        List<ListNode> evenList = new ArrayList<ListNode>();
        
        populateLists(oddList, evenList, temp);

        Iterator<ListNode> oddListIterator = oddList.iterator();
        Iterator<ListNode> evenListIterator = evenList.iterator();

        while(oddListIterator.hasNext() && evenListIterator.hasNext()) {
        	if (newList == null) {
        		newList = evenListIterator.next();
        		tempList = newList;
        		tempList.next = oddListIterator.next();
        	} else {
        		tempList.next = evenListIterator.next();
        		tempList = tempList.next;
        		tempList.next = oddListIterator.next();
        	}
        	tempList = tempList.next;
        }
        if (evenListIterator.hasNext()) {
        	tempList.next = evenListIterator.next();
        	tempList = tempList.next;
        }
        if (oddListIterator.hasNext()) {
        	tempList.next = oddListIterator.next();
        	tempList = tempList.next;
        }
        tempList.next = null;
        
        return newList;
    }

}

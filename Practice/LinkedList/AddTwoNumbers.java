/**
 * 
 * @author gopalakrishnanramu
 * 
 * You are given two non-empty linked lists representing two non-negative integers.
 *  The digits are stored in reverse order, and each of their nodes contains a single digit.
 *  Add the two numbers and return the sum as a linked list.
 *  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		l1.next.next.next = null;
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		l2.next.next.next = null;
		
		ListNode result = addTwoNumbers(l1, l2);
		
		while(result != null) {
			System.out.print(result.val + "\t");
			result = result.next;
		}
		
	}
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultListNode = new ListNode();
        ListNode tempNode = resultListNode, prevNode = null;
        int carry = 0, sum = 0;
        
        while(l1 != null && l2 != null) {
        	sum = carry + l1.val + l2.val;
        	tempNode.val = sum % 10;
        	carry = (int) (sum / 10);
        	tempNode.next = new ListNode();
        	tempNode.next.next = null;
        	prevNode = tempNode;
        	tempNode = tempNode.next;
        	l1 = l1.next;
        	l2 = l2.next;
        }
        
        while(l1 != null) {
        	sum = carry + l1.val;
        	tempNode.val = sum % 10;
        	carry = (int) (sum / 10);
        	tempNode.next = new ListNode();
        	tempNode.next.next = null;
        	prevNode = tempNode;
        	tempNode = tempNode.next;
        	l1 = l1.next;
        }
        
        while(l2 != null) {
        	sum = carry + l2.val;
        	tempNode.val = sum % 10;
        	carry = (int) (sum / 10);
        	tempNode.next = new ListNode();
        	tempNode.next.next = null;
        	prevNode = tempNode;
        	tempNode = tempNode.next;
        	l2 = l2.next;
        }
        
        if (carry > 0) {
        	tempNode.val = carry;
        } else {
        	tempNode = prevNode;
        	tempNode.next = null;
        }
        
        return resultListNode;
    }

}

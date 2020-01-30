package medium;

import general.ListNode;

public class ReorderListOrListZipping_143 {

	//Input:  1->2->3->4->5->6  
	//Output: 1->6->2->5->3->4
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode cur= head;
		cur.next=  new ListNode(2);
		cur = cur.next;
		cur.next=  new ListNode(3);
		cur = cur.next;
		cur.next=  new ListNode(4);
		cur = cur.next;
		cur.next=  new ListNode(5);
		cur = cur.next;
		cur.next=  new ListNode(6);
		cur = cur.next;
		reorderList(head);
		

	}
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	// 1->2->3->4->5->6
	    public static void reorderList(ListNode head) {
	        //find the mid using slow and fast pointers
	        ListNode slow=head, fast = head;
	        while(fast.next!=null && fast.next.next!=null){
	            slow= slow.next;
	            fast= fast.next.next;
	        }
	        //Split the list at mid
	        ListNode l1=head;
	        ListNode l2 = slow.next;
	        slow.next= null;
	        //reverse the second half of the list
	        l2 = reverseList(l2);
	        //merge the 1 lists in tandum
	        while(l2!=null){ // 1->6->2->5->3    5->4 
	            ListNode newL1 = l1.next;//3
	            ListNode newL2 = l2.next;//4
	            l1.next=l2;
	            l2.next=newL1;
	            l1= newL1;
	            l2= newL2;
	        }
	    }
	    public static ListNode reverseList(ListNode head){
	        ListNode cur= head, newNext= head, curNext= cur.next;
	        while(newNext.next != null){
	            newNext= newNext.next;
	        }
	        ListNode last = newNext;
	        while(cur!=null){ 
	            curNext= cur.next;
	            if(cur==head)
	            	cur.next=null;
	            else
	            	cur.next=newNext;
	            newNext= cur;
	            cur= curNext;
	        }
	        return last;
	    }
	
}


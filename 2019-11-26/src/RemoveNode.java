
//19.删除链表的倒数第N个结点
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class RemoveNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode slow = newHead;
        ListNode fast = newHead;
        for(int i = 0;i <= n;i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
}

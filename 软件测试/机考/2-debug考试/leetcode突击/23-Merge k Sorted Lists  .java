/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/
 //原题
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
    }
}
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (null==lists || lists.size==0)
            return null;
         
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(), new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val==n2.val)
                    return 0;
                else if (n1.val<n2.val)
                    return -1;
                else
                    return 1;
            }
        });
         
        // initialization
        for (ListNode n : lists) {
            if (n==null)
                continue;
                 
            queue.add(n);
        }
         
        ListNode fakeHead = new ListNode(0);
        ListNode current = fakeHead;
         
        while (!queue.isEmpty()) {
            ListNode n = queue.poll();
            current.next = n;
            current = n;
            if (n.next!=null)
                queue.add(n.next);
        }
         
        return fakeHead.next;
    }
}
/*
 将每个链表的表头元素取出来，建立一个小顶堆，因为k个链表中都排好序了，因此每次取堆顶的元素就是k个链表中的最小值，可以将其合并到合并链表中，再将这个元素的指针指向的下一个元素也加入到堆中，再调整堆，取出堆顶，合并链表。。。。以此类推，直到堆为空时，链表合并完毕。
 */
 public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (null==lists || lists.isEmpty())
            return null;
         
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(), new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val==n2.val)
                    return 0;
                else if (n1.val<n2.val)
                    return -1;
                else
                    return 1;
            }
        });
         
        // initialization
        for (ListNode n : lists) {
            if (n==null)
                continue;
                 
            queue.add(n);
        }
         
        ListNode fakeHead = new ListNode(0);
        ListNode current = fakeHead;
         
        while (!queue.isEmpty()) {
            ListNode n = queue.poll();
            current.next = n;
            current = n;
            if (n.next!=null)
                queue.add(n.next);
        }
         
        return fakeHead.next;
    }
}
/*
借鉴归并排序的方法，自顶向下，先递归的对链表的前半部分和后半部分进行归并排序，最后再merge。
*/
public class Solution {  
    ListNode merge2Lists(ListNode list1, ListNode list2) {  
        ListNode head    = new ListNode(-1);  
        ListNode current = head;  
        while(list1!=null&&list2!=null) {  
            if(list1.val<list2.val) {  
                current.next = list1;  
                list1   = list1.next;  
            } else {  
                current.next = list2;  
                list2   = list2.next;  
            }  
            current = current.next;  
        }  
        if(list1!=null) {  
            current.next = list1;  
        } else {  
            current.next = list2;  
        }  
        return head.next;  
    }  
    public ListNode mergeKLists(List<ListNode> lists) {  
        if(lists==null||lists.size()==0) {  
            return null;  
        }  
        if(lists.size()==1) {  
            return lists.get(0);  
        }  
        int length = lists.size() ;  
        int mid = (length - 1)/2 ;  
        ListNode l1 = mergeKLists(lists.subList(0,mid + 1)) ;  
        ListNode l2 = mergeKLists(lists.subList(mid + 1,length)) ;  
  
        return merge2Lists(l1,l2) ;  
    }  
}  
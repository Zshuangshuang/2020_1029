/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-10-29
 * Time:9:31
 **/

class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
public class MyLinkedList {

    public Node head;

    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.setNext(this.head);
        this.head = node;
    }

    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }
        cur.setNext(node);
    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.getData() + "  ");
            cur = cur.getNext();
        }
    }

    private int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.getNext();

        }
        return count;
    }

    private boolean checkPos(int pos) {
        if (pos < 0 || pos > size()) {
            return true;
        }
        return false;
    }

    private Node findIndex(int pos) {
        Node prev = this.head;
        while (pos - 1 > 0) {
            prev = prev.getNext();
            pos--;
        }
        return prev;
    }

    public void addIndex(int pos, int x) {
        if (checkPos(pos)) {
            return;
        }
        Node prev = findIndex(pos);
        Node node = new Node(x);
        node.setNext(prev.getNext());
        prev.setNext(node);
    }

    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.getData() == key) {
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }

    public Node findToRemove(int toRemove) {
        Node cur = this.head;
        while (cur.getNext() != null) {
            if (cur.getNext() != null && cur.getNext().getData() == toRemove) {
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }

    public void remove(int toRemove) {
        if (this.head.getData() == toRemove) {
            this.head = this.head.getNext();
            return;
        }
        Node prev = findToRemove(toRemove);
        if (prev == null) {
            return;
        }

        Node del = prev.getNext();
        prev.setNext(del.getNext());
    }

    public void removeAllKey(int keys) {
        if (this.head == null) {
            return;
        }
        Node prev = this.head;
        Node cur = prev.getNext();
        while (cur != null) {
            if (cur.getData() == keys) {
                prev.setNext(cur.getNext());
                cur = cur.getNext();
            } else {
                prev = cur;
                cur = cur.getNext();
            }
        }
        if (this.head.getData() == keys) {
            this.head = this.head.getNext();
        }
    }

    public Node reverse() {
        //定义prev来保存要反转的节点的前驱
        Node prev = null;
        //定义cur表示当前要反转的节点
        Node cur = this.head;
        //定义newHead保存反转后的头节点
        Node newHead = null;
        while (cur != null) {
            //定义curNext表示cur的后继节点
            Node curNext = cur.getNext();
            //如果curNext为空，则cur所在位置就是反转后链表的头节点
            if (curNext == null) {
                newHead = cur;
            }
            //将cur指向它的前驱
            cur.setNext(prev);
            //cur的前驱指向cur
            prev = cur;
            //cur指向它的后继
            cur = curNext;
        }
        return newHead;
    }

    public void display(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print(cur.getData() + "  ");
            cur = cur.getNext();
        }
        System.out.println();
    }

    public Node middleNode(){
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }
    public Node findKthToTail(int k) {
        //判断k是否合法
        if (k <= 0){
            return null;
        }
        if (this.head == null){
            return null;
        }
        //定义slow和fast均在头节点位置
        Node fast = this.head;
        Node slow = this.head;
        //让fast先走k-1步，若fast在未走到k-步时，已经为空，则不辞u你在当前k位置，直接返回
        for (int i =  0; i < k-1; i++) {
            if (fast.getNext() != null){
                fast = fast.getNext();
            }else {
                return  null;
            }
        }
        //fast和slow一起走，直至走到单链表尾部，slow所在位置就是倒数第k个节点的位置
        while(fast.getNext() != null){
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return slow;

    }
    public Node mergeTwoLists( Node headA,  Node headB) {
        //判断两个单链表是不是空的，若均为空直接返回null
        if (headA == null && headB == null) {
            return null;
        }
        //若A为空，直接返回B
        if (headA == null) {
            return headB;
        }
        //若B为空，直接返回A
        if (headB == null) {
            return headA;
        }
        //定义newHead为新的链表的头
      Node newHead = new Node(-1);
        //定义tmp表示当前要穿起来的节点
        Node tmp = newHead;
        //判断A.data和B.data的大小，若A的值小，直接串A，否则串B
        while(headA != null && headB != null ){
            if (headA.getData() <= headB.getData()){
                tmp.setNext(headA);
                headA = headA.getNext();
                tmp = tmp.getNext();
            }else {
                tmp.setNext(headB);
                headB = headB.getNext();
                tmp = tmp.getNext();
            }
        }
        //若A不空，B空，直接把A剩下的元素串起来
        if (headA != null){

            tmp.setNext(headA);
        }
        //若A空，B不空,直接将B剩下的元素串起来
        if (headB != null){
            tmp.setNext(headB);
        }

     return newHead.getNext();
    }
    public Node partition( int x) {
        // write code here
        Node cur = this.head;
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        while(cur != null){
            if (cur.getData() <= x){
                if (bs == null){
                    bs = cur;
                    be = bs;
                }else {
                    be.setNext(cur);
                    be = be.getNext();
                }
            }else {
                if (as == null){
                    as = cur;
                    ae = as;
                }else {
                    ae.setNext(cur);
                    ae = ae.getNext();
                }
            }
            cur =cur.getNext();
        }
        if (bs == null){
            return  as;
        }
        be.setNext(as);
        if (as != null){
            as.setNext(null);
        }
        return bs;
    }
    public Node deleteDuplication(){
        //定义傀儡节点，用来串不重复的节点
        Node newHead = new Node(-1);
        //定义cur用来遍历单链表
        Node cur = this.head;
        //定义tmp用来实现串元素的动作
        Node tmp = newHead;

        while(cur != null){
            //判断当前cur位置的元素是否和下一个元素的值相等
            if (cur.getNext() != null && cur.getData() == cur.getNext().getData()){
                while(cur.getNext() != null && cur.getData() == cur.getNext().getData()){
                    cur = cur.getNext();
                }
                cur =cur.getNext();
            }else {
                tmp.setNext(cur);
                tmp = cur;
                cur = cur.getNext();

            }
        }
        //如果出了第一个元素，其他元素的值均相等，此时要将尾巴节点tmp的next域置为null
        tmp.setNext(null);
        return newHead.getNext();
    }
    public boolean chkPalindrome() {
        if (this.head == null){
            return true;
        }
        //定义fast和slow两个变量，找到链表的中间位置
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        //对slow所指的中间位置的后边的数据进行逆置
        Node cur = slow.getNext();
        while(cur != null){
            Node curNext = cur.getNext();
            cur.setNext(slow);
            slow = cur;
            cur = curNext;
        }
        //让slow从后往前走，head往后走，判断是否为回文结构
        while(this.head != slow){
            if (this.head.getData() != slow.getData() ){
                return false;
            }
            //偶数情况
            if (this.head.getNext() == slow){
                return true;
            }
            this.head = this.head.getNext();
            slow = slow.getNext();
        }
        return true;
    }
    public Node getIntersectionNode(Node headA, Node headB) {
        Node pL = headA;
        Node pS = headB;
        int lA = 0;
        int lB= 0;
        while(pL != null){
            lA++;
            pL = pL.getNext();
        }
        while(pS != null){
            lB++;
            pS = pS.getNext();
        }
        int len = lA-lB;
        if (len < 0){
            pL = headB;
            pS = headA;
            len = lA-lB;
        }
        while(len > 0){
            pL = pL.getNext();
            len--;
        }
        while(pL != pS){
            pL = pL.getNext();
            pS = pS.getNext();
        }
        if (pL != null && pS != null && pL == pS){
            return pL;
        }
        return null;
    }

}

/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-10-29
 * Time:9:31
 **/
public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(3);
        myLinkedList.addLast(5);
        myLinkedList.addLast(7);
        myLinkedList.addLast(9);
        myLinkedList.addFirst(11);
        myLinkedList.display();
        System.out.println();
        /*myLinkedList.addIndex(2,3);*/
        /*myLinkedList.display();
        System.out.println();
        myLinkedList.remove(99);
        myLinkedList.display();*/

        Node newHead= myLinkedList.reverse();
        myLinkedList.display(newHead);
    }
}

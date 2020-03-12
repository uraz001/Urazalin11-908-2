import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList {
    Element head = null;


    public int size() {
        int size = 0;
        Element cur2 = head;
        if (head != null) {
            while (cur2 != null) {
                size++;
                cur2 = cur2.next;
            }
        }
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }



    public void add(Element o) {
        boolean alreadyHave = false;
        if(head == null){
            head = o;
        } else {
            Element cur = head;
            Element previous = null;
            while(cur != null){
                if((cur.i == o.i && cur.j == o.j) || (cur.i == o.j && cur.j == o.i)){
                    alreadyHave = true;
                    break;
                }
                previous = cur;
                cur = cur.next;
            }
            if (!alreadyHave) {
                previous.next = o;
            }
        }

    }



    public boolean remove(Element o) {
        while (head != null && (head.i == o.i && head.j == o.j) || (head.i == o.j && head.j == o.i)) {
            head = head.next;
        }
        if (head != null) {
            Element cur2 = head;
            Element nextEl;
            while (cur2 != null) {
                if(cur2.next != null) {
                    nextEl = cur2.next;
                    if ((cur2.i == o.i && cur2.j == o.j) || (cur2.i == o.j && cur2.j == o.i)) {
                        cur2.next = nextEl.next;
                    }
                }
                cur2 = cur2.next;

            }
        }

        return true;
    }


    @Override
    public String toString() {
        if(head != null) {
            Element cur = head;
            String answer = "";
            if (head.i != 0) {
                while (cur != null) {
                    answer += cur.i + " " + cur.j + "\n";
                    cur = cur.next;
                }
            }
            return answer;
        } else return "Пусто";
    }

    public void set(int index, Element element) {
        Element cur = head;
        Element bup;
        int k = 0;
        while (cur != null) {
            if (k == index) {
                cur.i = element.i;
                cur.j = element.j;
            }
            k++;
            cur = cur.next;
        }
    }


    public Element remove(int index) {
        Element previous = null;
        Element cur = head;
        int k = 0;
        if (index != 0) {
            while (cur != null) {
                if (k == index) {
                    previous.next = cur.next;
                    return cur;
                }
                k++;
                previous = cur;
                cur = cur.next;
            }
            return null;
        } else {
            head = head.next;
            return cur;
        }
    }

    public int indexOf(Element o) {
        Element cur = head;
        int k = 0;
        while (cur != null) {
            if ((cur.i == o.i && cur.j == o.j) || (cur.i == o.j && cur.j == o.i)) {
                return k;
            }
            cur = cur.next;
            k++;
        }
        return -1;
    }

    public int getMax(){
        Element cur = head;
        int k = 0;
        while (cur != null) {
            if(cur.i > k && cur.i > cur.j){
                k = cur.i;
            } else if(cur.j > k && cur.j > cur.i){
                k = cur.j;
            } else if(cur.j > k && cur.j == cur.i){
                k = cur.j;
            }
            cur = cur.next;
        }
        return k;
    }

}

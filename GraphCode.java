

public class GraphCode {
    LinkedList list = new LinkedList();

    public GraphCode() {
    }

    public GraphCode(int [][] mi){
        for (int i = 0; i < mi[0].length; i++) {
            for (int j = 0; j <mi[0].length ; j++) {
                if(mi[i][j] == 1){
                    Element buf = new Element(i+1,j+1,null);
                    if(list.indexOf(buf) == -1){
                        list.add(buf);
                    }
                }
            }
        }
    }

    public int[][] getMI(){
        if(list.head != null){
        Element cur = list.head;
        int max = list.getMax();
        int[][] mi = new int[max][max];
        while (cur != null){
            mi[cur.i-1][cur.j-1] = 1;
            mi[cur.j-1][cur.i-1] = 1;
            cur = cur.next;
        }
            for (int i = 0; i < mi.length; i++) {
                for (int j = 0; j < mi.length ; j++) {
                    System.out.print("[" + mi[i][j] + "] ");
                }
                System.out.println();
            }
        return mi;
    } else {
            System.out.println("Нет рёбер");
        }
            return new int[1][1];
        }

        public void insert(int i , int j){
        list.add(new Element(i,j,null));
        }

        public void delete(int i, int j){
        list.remove(new Element(i,j,null));
        }

    @Override
    public String toString() {
        return list.toString();
    }

    public GraphCode getEdgesWithNode(int i){
        if(list.head != null){
            GraphCode answer = new GraphCode();
            Element cur = list.head;
            while(cur != null){
                if(cur.i == i || cur.j == i){
                    answer.insert(cur.i,cur.j);
                }
                cur = cur.next;
            }
            return answer;
        }
        System.out.println("Рёбер нет");
        return new GraphCode();
    }

    public void modify(int i){
        if(list.head != null){
            while(list.head.i == i || list.head.j == i){
                list.head = list.head.next;
            }
            Element cur = list.head;
            Element previous = null;
            while(cur != null){
                if(cur.i == i || cur.j == i){
                    previous.next = cur.next;
                }
                previous = cur;
                cur = cur.next;
            }
        }
    }

    public ArrayList show(int m) {
        if (list.head != null) {
            Element cur = list.head;
            ArrayList listNew = new ArrayList(list.getMax());
            while(cur != null){
                listNew.mas[cur.i-1]++;
                listNew.mas[cur.j-1]++;
                cur = cur.next;
            }
            ArrayList answer = new ArrayList();
            for (int i = 0; i < listNew.mas.length; i++) {
                if(listNew.mas[i] > m){
                    answer.add(i+1);
                }
            }
            return answer;

        }
        return null;
    }
}


public class ArrayList<Integer>  {
    int[] mas = new int[0];

    public ArrayList(int[] mas) {
        this.mas = mas;
    }

    public ArrayList(int max){
        this.mas = new int[max];
    }


    public ArrayList() {
    }

    public int size() {
        return mas.length;
    }
    public boolean isEmpty() {
        return mas.length == 0;
    }

    public boolean contains(int o){
        for (int check : mas) {
            if (check == o) {
                return true;
            }
        }
        return false;
    }


    public boolean add(int o) {
        int[] masNew = new int[mas.length + 1];
        int i = 0;
        for (int obj : mas) {
            masNew[i] = obj;
            i++;
        }
        masNew[masNew.length - 1] = o;
        mas = masNew;
        return true;
    }

    public void setIndex(int index, int figure){
        mas[index] = figure;
    }


    public boolean remove(int o) {
        boolean alreadyRemove = false;
        if (this.contains(o)) {
            int j = 0;
            int[] masNew = new int[mas.length - 1];
            for (int i = 0; i < mas.length; i++) {
                if (mas[i] == o & !alreadyRemove) {
                    alreadyRemove = true;
                    continue;
                }
                if (j < mas.length - 1) {
                    masNew[j] = mas[i];
                    j++;
                }
            }
            mas = masNew;
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        String out = "";
        for (int c : mas) {
            System.out.println(c);
        }
        return out;
    }
}

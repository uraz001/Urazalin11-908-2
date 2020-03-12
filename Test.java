public class Test {
    public static void main(String[] args) {

        /* Проверка методов insert , getMI , delete */
        GraphCode gc1 = new GraphCode();
        System.out.println("Начало добавления рёбер: ");
        gc1.insert(1,2);
        gc1.insert(1,3);
        gc1.insert(1,4);
        System.out.println(gc1);
        System.out.println("Продолжение добавления рёбер: ");
        gc1.insert(1,5);
        gc1.insert(2,5);
        gc1.insert(4,5);
        System.out.println(gc1);

        System.out.println("Построение матрицы инциндентности: "); gc1.getMI();

        gc1.delete(1,2);
        gc1.delete(1,3);
        System.out.println("Матрица после удаления рёбер: "); gc1.getMI();



        /* Проверка GraphCode(int [][] mi) , getEdgesWithNode */
        int[][] matrix1 = {{0,0,0,1,1},
                          {1,0,1,1,0},
                          {0,1,0,1,1},
                          {1,1,0,0,0},
                          {1,1,0,1,0}};
        GraphCode gc2 = new GraphCode(matrix1);
        System.out.println("Вывод графа,построенного по двумерной матрице: ");
        System.out.println(gc2);

        System.out.println("Возврат списка ребёр инцидентных вершине 1 ");
        System.out.println(gc2.getEdgesWithNode(1));



        /* Проверка gc3.modify; */
        int[][] matrix2 = {{0,1,1},
                           {1,0,0},
                           {0,1,0}};
        GraphCode gc3 = new GraphCode(matrix2);
        System.out.println("Граф до удаления вершины 1 ");
        System.out.println(gc3);
        gc3.modify(1);
        System.out.println("Граф после удаления вершины 1");
        System.out.println(gc3);



        /* Проверка show(int m)         */
        GraphCode gc4 = new GraphCode(matrix1);
        System.out.println("Вывод списка вершин,у которых степень инцидентности больше 3");
        System.out.println(gc4.show(3));
        System.out.println("Список рёбер у gc4");
        System.out.println(gc4);









    }
}

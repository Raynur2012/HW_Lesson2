package ru.geekbrains.lesson1;

public class Mass {
    public void arraySumm(String[][] arr) throws MySizeArrayException, MyArrayDataException {
        int summ = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i].length!=4 && arr[j].length!=4) {
                    throw new MySizeArrayException("Incorrect size of array on index " + i + " " + j);
                }
                try {
                    int a = Integer.parseInt(arr[i][j]);
                    summ += a;
                } catch (NumberFormatException ex){
                    throw new MyArrayDataException("Incorrect format of Value on index " + i + " " + j);
                }
            }
//        for(String[] s1: arr)
//            for (String s2 : s1) {
//                int a = Integer.parseInt(s2);
//                summ += a;
//            }
        }
        System.out.println(summ);
    }
}

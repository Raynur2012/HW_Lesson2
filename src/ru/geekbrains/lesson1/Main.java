package ru.geekbrains.lesson1;

public class Main {

    public static void main(String[] args) {
//        String[][] arr = new String[4][4];
       String arr[][] = {{"1","2","3","4"},{"5","6","7","8"},{"9","10","11","12"},{"13","14","15","16"}};
       Mass m1 = new Mass();
        try {
            m1.arraySumm(arr);
        } catch (MySizeArrayException ex) {
            System.err.println(ex.getMessage());
        } catch (MyArrayDataException ex){
            System.err.println(ex.getMessage());
        }
    }
}

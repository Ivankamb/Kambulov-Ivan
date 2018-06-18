package ru.kambulov.array;

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int count = 0; count < rst.length; count++) {
            int i = count + 1;
            rst[count] = count + 1;
            rst[count] = i * i;
        }
        return rst;
    }
}

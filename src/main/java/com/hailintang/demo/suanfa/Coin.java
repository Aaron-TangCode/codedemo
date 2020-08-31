package com.hailintang.demo.suanfa;

import java.util.ArrayList;

public class Coin {
    private int value;
    private int quantity;

    Coin(int value, int quantity) {
        this.value = value;
        this.quantity = quantity;
    }
    /* getters & setters */

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /* This is actually the "hard" part */
    public static int selectCandidate(ArrayList<Integer> values) {
        int biggest = Integer.MIN_VALUE;
        for (Integer coin : values) {
            if ((biggest < coin)) {
                biggest = coin;
            }
        }
        return biggest;
    }

    /* Now the actual schema */

    public static ArrayList<Coin> greedySchema(ArrayList<Integer> values, int quantity) {
        /* We initialize our solution structure */
        ArrayList<Coin> solution = new ArrayList<>();
        /* Any auxiliary variable is ok */
        int value;
        //看一下条件是否满足，可选集中是否还有可选
        while ((quantity > 0) && (!values.isEmpty())) {
            /* Select and remove the coin from our monetary system */
            //从可选集中选取数据，并把数据从可选集中移除
            value = selectCandidate(values);
            values.remove(new Integer(value));

            /* If this is true, it meanwe can still look for coins to give */
            //如果满足条件，那就添加到结果集
            if ((quantity / value) > 0) {
                solution.add(new Coin(value, quantity / value));
                /* This will lower the quantity we need to give back */
                quantity = quantity % value;
            }
        }

        /* Once the quantity is 0 we are DONE! */
        if (quantity == 0) {
            return solution;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(50);
        values.add(20);
        values.add(10);
        values.add(5);
        values.add(2);
        values.add(1);

        ArrayList<Coin> coins = greedySchema(values, 29);
        coins.stream().map((x)->{return x.getValue()+":"+x.getQuantity();}).forEach(System.out::println);

    }
}




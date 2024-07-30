package leetcode;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角 {
    public static void main(String[] args) {
        for (List<Integer> list : generate(5)) {
            System.out.println(list);
        }
        System.out.println(getRow(3));
    }

    public static List<List<Integer>> generate(int numRows) {
        //弄不清为什么会多一个第一行，而删掉初始化row1就会报错
        //弄清了，list.get(i-1).get(j-1)改成list.get(i-2).get(j-1)就好了，不用初始化第一行了，因为第一行实际上是存在与list的0号位置，所以第2(n-1)行就要用第一行(n-2)求，初始化第一行实际相当于找了个没用的东西占位置，然后实际第一行就存在list第1号位置，0号位置占位用
        List<List<Integer>>list=new ArrayList<>();
        //List<Integer>row1=new ArrayList<>();
        //row1.add(1);
        //list.add(row1);
        for (int i = 1; i <= numRows; i++) {
            List<Integer>row=new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if(j==0||j==i-1)row.add(1);
                else row.add(list.get(i-2).get(j-1)+list.get(i-2).get(j));
            }
            list.add(row);
        }
        //list.remove(0);
        return list;
    }

    //获取指定的行
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = generate(rowIndex+1);
        return list.get(rowIndex);
    }

}

    /*给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

        在「杨辉三角」中，每个数是它左上方和右上方的数的和。





        示例 1:

        输入: numRows = 5
        输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        示例 2:

        输入: numRows = 1
        输出: [[1]]*/

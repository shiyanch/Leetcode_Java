import LargestDivisibleSubset.LargestDivisibleSubset;
import Triangle.Triangle;

import java.util.ArrayList;
import java.util.List;


public class Answers {

    public static void main(String[] args ) {
//        if(new SymmetricTree().isSymmetric(null))
//            System.out.println("true");
//        else
//            System.out.println("false");

        List<List<Integer>> arg = new ArrayList<>();

        List<Integer> inner1 = new ArrayList<>();
        inner1.add(-10);

        List<Integer> inner2 = new ArrayList<>();
        inner2.add(-2);
        inner2.add(-3);

        arg.add(inner1);
        arg.add(inner2);

        System.out.println(new Triangle().minimumTotal(arg));

    }
}
import BinaryTreeRightSideView.BinaryTreeRightSideView;
import ConvertSortedListToBinarySearchTree.ConvertSortedListToBinarySearchTree;
import CountCompleteTreeNodes.CountCompleteTreeNodes;
import ExcelSheetColumnTitle.ExcelSheetColumnTitle;
import FindMedianFromDataStream.FindMedianFromDataStream;
import FindMinimumInRotatedSortedArray.FindMinimumInRotatedSortedArray;
import FlattenBinaryTreeToLinkedList.FlattenBinaryTreeToLinkedList;
import IntersectionOfTwoArrays.IntersectionOfTwoArrays;
import LengthOfLastWord.LengthOfLastWord;
import PascalsTriangle.PascalsTriangle;
import PlusOne.PlusOne;
import PopulatingNextRightPointersInEachNodeII.PopulatingNextRightPointersInEachNodeII;
import RecoverBinarySearchTree.RecoverBinarySearchTree;
import ReverseInteger.ReverseInteger;
import SerializeAndDeserializeBinaryTree.SerializeAndDeserializeBinaryTree;
import SlidingWindowMaximum.SlidingWindowMaximum;
import SumRootToLeafNumbers.SumRootToLeafNumbers;
import SuperUglyNumber.SuperUglyNumber;
import UglyNumberII.UglyNumberII;


public class Answers {

    public static void main(String[] args ) {
//        if(new SymmetricTree().isSymmetric(null))
//            System.out.println("true");
//        else
//            System.out.println("false");

        int[] res = new IntersectionOfTwoArrays().intersection(
                new int[] {1},
                new int[] {1,1}
        );

        for(int i:res)
            System.out.print(i+" ");

    }
}

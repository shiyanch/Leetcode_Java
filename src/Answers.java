import BinaryTreeRightSideView.BinaryTreeRightSideView;
import ConvertSortedListToBinarySearchTree.ConvertSortedListToBinarySearchTree;
import CountCompleteTreeNodes.CountCompleteTreeNodes;
import ExcelSheetColumnTitle.ExcelSheetColumnTitle;
import FindMedianFromDataStream.FindMedianFromDataStream;
import FindMinimumInRotatedSortedArray.FindMinimumInRotatedSortedArray;
import FlattenBinaryTreeToLinkedList.FlattenBinaryTreeToLinkedList;
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

        FindMedianFromDataStream mf = new FindMedianFromDataStream();
        mf.addNum(1);
        mf.addNum(3);
        mf.addNum(5);
        mf.addNum(2);
        mf.addNum(4);
        mf.addNum(7);
        mf.addNum(6);
        System.out.println(mf.findMedian());

    }
}

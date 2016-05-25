import BinaryTreeRightSideView.BinaryTreeRightSideView;
import ConstructBinaryTreeFromInorderAndPreorderTraversal.ConstructBinaryTreeFromInorderAndPostorderTraversal;
import ConstructBinaryTreeFromPreorderAndInorderTraversal.ConstructBinaryTreeFromPreorderAndInorderTraversal;
import ConvertSortedListToBinarySearchTree.ConvertSortedListToBinarySearchTree;
import CountCompleteTreeNodes.CountCompleteTreeNodes;
import ExcelSheetColumnTitle.ExcelSheetColumnTitle;
import FindMedianFromDataStream.FindMedianFromDataStream;
import FindMinimumInRotatedSortedArray.FindMinimumInRotatedSortedArray;
import FlattenBinaryTreeToLinkedList.FlattenBinaryTreeToLinkedList;
import IntersectionOfTwoArrays.IntersectionOfTwoArrays;
import IntersectionOfTwoArraysII.IntersectionOfTwoArraysII;
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
import WiggleSortII.WiggleSortII;


public class Answers {

    public static void main(String[] args ) {
//        if(new SymmetricTree().isSymmetric(null))
//            System.out.println("true");
//        else
//            System.out.println("false");

//        new WiggleSortII().wiggleSort(new int[] {4,5,5,6});
        new ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(
                new int[] {4,2,5,1,3,7,6},
                new int[] {4,5,2,7,6,3,1}
        );
    }
}
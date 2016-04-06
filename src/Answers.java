
import ContainsDuplicate.ContainsDuplicate;
import MissingNumber.MissingNumber;
import ProductOfArrayExceptySelf.ProductOfArrayExceptSelf;
import SingleNumber.SingleNumber;
import ValidAnagram.ValidAnagam;

import java.util.*;

public class Answers {

    public static void main(String[] args ) {
        ValidAnagam validAnagam = new ValidAnagam();
        if(validAnagam.isAnagram("", ""))
            System.out.println("True");
        else
            System.out.println("False");

    }
}

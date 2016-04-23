import SymmetricTree.SymmetricTree;

public class Answers {

    public static void main(String[] args ) {
        if(new SymmetricTree().isSymmetric(null))
            System.out.println("true");
        else
            System.out.println("false");
    }
}

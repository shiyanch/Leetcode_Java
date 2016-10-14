package AddAndSearchWord;

/**
 * 211. Add and Search Word - Data structure design
 *
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one letter.
 */
public class AddAndSearchWord {

    private TrieNode head = new TrieNode();

    class TrieNode {
        private TrieNode[] children;
        private boolean endHere = false;

        public void insert(char c) {
            if(children == null)
                children = new TrieNode[26];

            if(children[c-'a'] == null) {
                children[c-'a'] = new TrieNode();
            }
        }
    }

    public void addWord(String word) {
        TrieNode cur = head;
        for(char c : word.toCharArray()) {
            cur.insert(c);
            cur = cur.children[c-'a'];
        }
        cur.endHere = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchWithDot(word, head);
    }

    private boolean searchWithDot(String word, TrieNode root) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(cur == null || cur.children == null)
                return false;

            if(c != '.') {
                if(cur.children[c-'a'] == null)
                    return false;
                cur = cur.children[c - 'a'];
            }
            else {
                boolean found = false;
                for(TrieNode child : cur.children) {
                    if(child != null) {
                        found = found || searchWithDot(word.substring(i + 1), child);
                    }
                }
                return found;
            }
        }

        return cur.endHere;
    }

    public static void main(String[] args) {
        AddAndSearchWord addAndSearchWord = new AddAndSearchWord();
        addAndSearchWord.addWord("bad");
        addAndSearchWord.addWord("dad");
        addAndSearchWord.addWord("mad");
        addAndSearchWord.addWord("b");
        System.out.println(addAndSearchWord.search("pad"));
        System.out.println(addAndSearchWord.search("bad"));
        System.out.println(addAndSearchWord.search("bada"));
        System.out.println(addAndSearchWord.search("ba"));
        System.out.println(addAndSearchWord.search("maa"));
        System.out.println(addAndSearchWord.search(".ad"));
        System.out.println(addAndSearchWord.search(".a."));
        System.out.println(addAndSearchWord.search("..d"));
        System.out.println(addAndSearchWord.search(".ap"));
        System.out.println(addAndSearchWord.search(".a.p"));
        System.out.println(addAndSearchWord.search(".a.."));
        System.out.println(addAndSearchWord.search("..a"));
        System.out.println(addAndSearchWord.search("b"));
        System.out.println(addAndSearchWord.search("b."));
        System.out.println(addAndSearchWord.search("."));

    }
}

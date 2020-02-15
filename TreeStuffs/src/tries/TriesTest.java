package tries;

public class TriesTest{
    public static void main(String[] args) {
        Trie tn = new Trie();
        tn.insert("word");
        System.out.println(tn.search("word"));
    }
}
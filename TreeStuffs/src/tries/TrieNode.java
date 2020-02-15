package tries;

import java.util.HashMap;

public class TrieNode {

    //to store the char
    private char c;
    //map to store the trie node with char
    private HashMap<Character, TrieNode> children = new HashMap<>();
    //to see if this node is end node.
    private boolean isLeaf;

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public TrieNode(char c) {
        this.c = c;
    }

    public TrieNode() {
    }

    
    
}
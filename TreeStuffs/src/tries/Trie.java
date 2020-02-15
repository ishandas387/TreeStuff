package tries;

import java.util.HashMap;

public class Trie {

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    //insert a word

    public void insert(String word){

        HashMap<Character, TrieNode> children = root.getChildren();
        TrieNode node  =  null;
        for(int i =0; i < word.length(); i++ ){
            char c = word.charAt(i);
            if(children.containsKey(c)){
               node = children.get(c);
            } else {
                node = new TrieNode(c);
                children.put(c, node);
            }
            children = node.getChildren();
            if(i == word.length()-1){
                node.setLeaf(true);
            }
        }
    }

    /**
     * Get the word through each char , search each char through map and then check if at the end is node null
     * or is node not leaf. Return true or false accordingly;
     * @param word
     * @return
     */

    public boolean search(String word){
        HashMap<Character, TrieNode> children = root.getChildren();
        TrieNode node = null;
        for(int i =0 ; i< word.length();i++){
            char c = word.charAt(i);
            if(children.containsKey(c)){
                node = children.get(c);
                children = node.getChildren();
            } else {
                node = null; 
                break;
            }
        }
        if(node != null && node.isLeaf()){
            return true;
        } else {
            return false;
        }
    }
}
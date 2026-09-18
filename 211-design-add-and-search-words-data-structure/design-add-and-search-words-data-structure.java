class WordDictionary {

    static class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        TrieNode(){
            children=new TrieNode[26];
            isEnd=false;
        }
    }

    private TrieNode root;


    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current=root;
        for(char ch:word.toCharArray()){
            int index=ch -'a';

            if(current.children[index]==null){
                current.children[index]=new TrieNode();
            }
            current=current.children[index];
        }
        current.isEnd=true;
    }
    
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(
        TrieNode node, String word, int index
    ){
        if(index==word.length()){
            return node.isEnd;
        }
        char ch=word.charAt(index);
        if(ch=='.'){
            for(TrieNode child : node.children){
                if(child !=null && search(child,word,index+1)){
                    return true;
                }
            }
            return false;
        }
        int childIndex = ch -'a';
        if(node.children[childIndex]==null){
            return false;
        }
        return search(node.children[childIndex], word, index+1);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
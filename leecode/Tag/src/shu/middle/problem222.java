package shu.middle;

public class problem222 {
    int count = 0;
    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        count(root);
        return count;
    }

    public void count(TreeNode root){
        if(root == null) return;
        count++;
        count(root.left);
        count(root.right);
    }


}

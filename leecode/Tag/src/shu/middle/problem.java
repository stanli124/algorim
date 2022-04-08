package shu.middle;

import java.util.ArrayList;
import java.util.List;

public class problem {
    int sum=0;
    public static void main(String[] args) {

    }

    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    public void inOrder(TreeNode root){
        if (root==null) {
            return;
        }
        inOrder(root.right);
        sum+= root.val;
        root.val = sum;
        inOrder(root.left);
    }


}

/**
 * 合并二叉树
 */
package hot100.simple;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }



public class problem617 {
    public static void main(String[] args) {

    }

//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        if (root1!=null && root2!=null){
//            TreeNode root = new TreeNode(root1.val + root2.val);
//        }else if (root1==null && root2==null){
//            return null;
//        }else if (root1!=null){
//            //root2为null
//            TreeNode root = new TreeNode(root1.val);
//        }
//
//
//
//        return new TreeNode();
//    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

//        TreeNode l = mergeTrees(root1.left, root2.left);
//        TreeNode r = mergeTrees(root1.right,root2.right);
//
//
//        TreeNode root;
//        if (root1!=null && root2!=null){
//            root = new TreeNode(root1.val + root2.val);
//        }else if (root1==null && root2==null){
//            return null;
//        }else if (root1!=null){
//            //root2为null
//            root = new TreeNode(root1.val);
//        }else{
//            root = new TreeNode(root2.val);
//        }
//        return root;

        if (root1==null) return root2;
        if (root2==null) return root1;

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;

    }

}

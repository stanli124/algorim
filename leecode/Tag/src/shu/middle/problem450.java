/** 删除二叉搜索树中的节点
 *  给定一个根节点root和一个值val，删除值为val的这个节点，并保证二叉搜索树的性质不变。
 */

package shu.middle;

public class problem450 {

    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) return root;

        if (root.val == key){ //找到要删除的节点值
            if (root.left ==null && root.right==null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            //既有左子树又有右子树：去右子树找最小的节点，将其移动到删除节点的位置
            TreeNode minnode = getMin(root.right);
            root.right = deleteNode(root.right, minnode.val);
            minnode.left = root.left;
            minnode.right = root.right;
            root = minnode;
        }else if (root.val > key){
            root.left = deleteNode(root.left, key);
        }else if (root.val < key){
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode getMin(TreeNode node){
        while (node.left!=null) node = node.left;
        return node;
    }


//    public TreeNode deleteNode(TreeNode root, TreeNode parent, int key) {
//        if (root==null) return root;
//
//        if (root.val == key){
//            //找到节点，删除该节点
//            if (root.left == null && root.right == null){
//                if (parent.right.val == key){
//                    parent.right = null;
//                }else
//                    parent.left = null;
//            }else if (root.left == null){
//                //右边有值
//                if (parent.right.val == key){
//                    parent.right = root.right;
//                }else
//                    parent.left = root.right;
//            }else if (root.right == null){
//                //要删除节点的左边有值
//                if (parent.right.val == key){
//                    parent.right = root.left;
//                }else
//                    parent.left = root.left;
//            }else{
//                if (parent.right.val == key){
//                    root.right.left = root.left;
//                    parent.right = root.right;
//                }else {
//                    root.right.left = root.left;
//                    parent.right = root.right;
//                }
//            }
//
//
//        }else if (root.val > key){
//            deleteNode(root.left, root, key); //去右边找
//        }else if (root.val < key){
//            deleteNode(root.right, root, key);  //去左边找
//        }
//
//        return root;
//    }

}

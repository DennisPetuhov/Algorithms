//class TreeNode<T>(val value: T) {
//    var left: TreeNode<T>? = null
//    var right: TreeNode<T>? = null
//}
//
//class BinaryTree<T> {
//    var root: TreeNode<T>? = null
//
//    fun insert(value: T) {
//        root = insertRec(root, value)
//    }
//
//    private fun insertRec(current: TreeNode<T>?, value: T): TreeNode<T> {
//        if (current == null) {
//            return TreeNode(value)
//        }
//
//        if (value < current.value) {
//            current.left = insertRec(current.left, value)
//        } else if (value > current.value) {
//            current.right = insertRec(current.right, value)
//        }
//
//        return current
//    }
//
//    fun inorderTraversal() {
//        inorderTraversalRec(root)
//    }
//
//    private fun inorderTraversalRec(node: TreeNode<T>?) {
//        if (node != null) {
//            inorderTraversalRec(node.left)
//            print("${node.value} ")
//            inorderTraversalRec(node.right)
//        }
//    }
//}
//
//fun main() {
//    val tree = BinaryTree<Int>()
//    val values = arrayOf(5, 3, 7, 2, 4, 6, 8)
//
//    for (value in values) {
//        tree.insert(value)
//    }
//
//    println("Inorder traversal:")
//    tree.inorderTraversal()
//}
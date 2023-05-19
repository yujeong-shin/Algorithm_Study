package DataStructure;

//class Node {
//    int data;
//    Node lt, rt;
//    public Node(int val) {
//        data=val;
//        lt=rt=null;
//    }
//}

public class TreeTraverse {
    Node root;
    public void preorder_DFS(Node root){
        if(root==null) return;
        else{
            System.out.print(root.data + " ");
            preorder_DFS(root.lt);
            preorder_DFS(root.rt);
        }
    }
    public void inorder_DFS(Node root){
        if(root==null) return;
        else{
            inorder_DFS(root.lt);
            System.out.print(root.data + " ");
            inorder_DFS(root.rt);
        }
    }
    public void postorder_DFS(Node root){
        if(root==null) return;
        else{
            postorder_DFS(root.lt);
            postorder_DFS(root.rt);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        TreeTraverse tree = new TreeTraverse();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        System.out.print("전위순회 ==> ");
        tree.preorder_DFS(tree.root); //전위순회

        System.out.print("\n중위순회 ==> ");
        tree.inorder_DFS(tree.root); //중위순회

        System.out.print("\n후위순회 ==> ");
        tree.postorder_DFS(tree.root); //후위순회
    }
}

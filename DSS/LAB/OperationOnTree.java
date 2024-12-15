


public class OperationOnTree
{
    Node root=null;

static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

Node constructTree(Node root,int key)
{
    if(root==null)
    {
        root=new Node(key);
    }

    if(key<root.data)
    {
        if(root.left==null)
        {
            root.left=new Node(key);
        }
        else{
            constructTree(root.left,key);
        }
    }
    
    if(key>root.data)
    {
        if(root.right==null)
        {
            root.right=new Node(key);
        }
        else{
            constructTree(root.right,key);
        }
    }

    return  root;

}

void binearSearchTree(Node root ,int key)
{
    if(root==null)
    {
    System.out.println(key+" Not Found");
    return;
    }

    if(root.data==key)
    {
        System.out.println(key+ " Found");
        return;
    }

    if(root.data>key)
    {
        binearSearchTree(root.left,key);
    }
    else
    {
        binearSearchTree(root.right, key);
    }
}

void inOrder(Node root)
{   
    if(root!=null)
    {   
        inOrder(root.left);
        System.out.print(" "+root.data);
        inOrder(root.right);
    }
}

void preOrder(Node root)
{   
    if(root!=null)
    {   
        System.out.print(" "+root.data);
        inOrder(root.left);
        inOrder(root.right);
    }
}

void postOrder(Node root)
{   
    if(root!=null)
    {   
        inOrder(root.left);
        inOrder(root.right);
        System.out.print(" "+root.data);
    }
}

// util function

void displayTree() {
    printTree(root, "", true);
}
void printTree(Node root, String prefix, boolean isLeft) {
    if (root != null) {
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.data);
        printTree(root.left, prefix + (isLeft ? "│   " : "    "), true);
        printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
    }
}

public static void main(String[] args) {
    OperationOnTree bst = new OperationOnTree ();
    bst.root = bst.constructTree(bst.root, 50);
    bst.root = bst.constructTree(bst.root, 10);
    bst.root = bst.constructTree(bst.root, 0);
    bst.root = bst.constructTree(bst.root, 8);
    bst.root = bst.constructTree(bst.root, 100);
    bst.root = bst.constructTree(bst.root, 3);
    bst.root = bst.constructTree(bst.root, 25);

    bst.displayTree();

    // bst.binearSearchTree(bst.root, 1);

    System.out.println("Inorder Traversal: ");
    bst.inOrder(bst.root);
    System.out.println(" ");
    
    System.out.println("Preorder Traversal: ");
    bst.preOrder(bst.root);
    System.out.println(" ");

    System.out.println("Postorder Traversal: ");
    bst.postOrder(bst.root);

}

}

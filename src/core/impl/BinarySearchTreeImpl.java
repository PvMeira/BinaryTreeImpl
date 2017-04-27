package core.impl;

import core.BinarySearchTree;
import entity.Node;

/**
 * Created by pvmeira on 27/04/17.
 */
public class BinarySearchTreeImpl implements BinarySearchTree {

    private Node root;

    public BinarySearchTreeImpl() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;

    }

    public void insert(int data) {
        root = this.insert(root, data);

    }

    private Node insert(Node node, int data) {
        if (node == null)
            node = new Node(data);
        else {
            if (data <= node.getData())
                node.setLeft(insert(node.getLeft(), data));
            else
                node.setRight(insert(node.getRight(), data));
        }
        return node;
    }

    public void delete(int k) {

        if (isEmpty())

            System.out.println("Tree Empty");

        else if (search(k) == false)

            System.out.println("Sorry " + k + " is not present");

        else

        {

            root = delete(root, k);
            System.out.println(k + " deleted from the tree");

        }

    }

    /**
     * Delete method
     *
     * @param root
     * @param data
     * @return
     */
    private Node delete(Node root, int data) {
        Node resultNode;
        Node resultNode2;
        Node node;
        //Case the data that needs to be remove is the root
        //this is necessary, to re-align the tree
        if (root.getData() == data) {

            Node leftLeaf = root.getLeft();
            Node rightLeaf = root.getRight();

            if (leftLeaf == null && rightLeaf == null)
                return null;

            else if (leftLeaf == null) {
                resultNode = rightLeaf;
                return resultNode;

            } else if (rightLeaf == null) {
                resultNode = leftLeaf;
                return resultNode;

            } else {
                resultNode2 = rightLeaf;
                resultNode = rightLeaf;
                while (resultNode.getLeft() != null)
                    resultNode = resultNode.getLeft();
                resultNode.setLeft(leftLeaf);
                return resultNode2;
            }
        }
        if (data < root.getData()) {
            node = delete(root.getLeft(), data);
            root.setLeft(node);
        } else {
            node = delete(root.getRight(), data);
            root.setRight(node);
        }
        return root;

    }
         /* Functions to count number of nodes */

    public int countNodes()

    {

        return countNodes(root);

    }

     /* Function to count number of nodes recursively */

    private int countNodes(Node node) {
        if (node == null)
            return 0;
        else {
            int counter = 1;
            counter += countNodes(node.getLeft());
            counter += countNodes(node.getRight());
            return counter;
        }
    }

    /* Functions to search for an element */
    public boolean search(int val) {
        return search(root, val);
    }

    /* Function to search for an element recursively */
    private boolean search(Node node, int data) {

        boolean found = false;

        while ((node != null) && !found) {
            int dataTemp = node.getData();
            if (data < dataTemp)
                node = node.getLeft();
            else if (data > dataTemp)
                node = node.getRight();
            else {
                found = true;
                break;
            }
            found = search(node, data);
        }
        return found;
    }

    /* Function for inorder traversal */
    public void inorder() {
        inorder(root);
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.getLeft());
            System.out.print(node.getData() + " ");
            inorder(node.getRight());
        }
    }

    /* Function for preorder traversal */
    public void preorder() {
        preorder(root);
    }

    private void preorder(Node node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }

    /* Function for postorder traversal */
    public void postorder() {
        postorder(root);
    }

    private void postorder(Node node) {
        if (node != null) {
            postorder(node.getLeft());
            postorder(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }
}



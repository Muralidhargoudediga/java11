package com.mediga.ds;

public class AVLTree {
    static class Node {
        int data;
        int height;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public Node insert(int data) {
        return insert(root, data);
    }

    private int getHeight(Node node)  {
        if(node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalance(Node node) {
        if(node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private Node insert(Node node, int data) {
        if(node == null) {
            return new Node(data);
        }
        if(data < node.data) {
            node.left = insert(node.left, data);
        } else if(data > node.data) {
            node.right = insert(node.right, data);
        } else {
            return node;
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int bal = getBalance(node);

        if(bal > 1 && data < node.left.data) {
            return rightRotate(node);
        }

        if(bal > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if(bal < -1 && data > node.right.data) {
            return leftRotate(node);
        }

        if(bal < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public Node delete(int data) {
        return delete(root, data);
    }

    private Node delete(Node node, int data) {
        if(node == null) {
            return null;
        }
        if(data < node.data) {
            node.left = delete(node.left, data);
        } else if(data > node.data) {
            node.right = delete(node.right, data);
        } else {
            if(node.left == null && node.right == null) {
                node = null;
            } else if(node.left == null) {
                node = node.right;
            } else if(node.right == null) {
                node = node.left;
            } else {
                Node minNode = getMinValueNode(node.right);
                node.data = minNode.data;
                node.right = delete(node.right, minNode.data);
            }
        }

        if(node == null) {
            return null;
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int bal = getBalance(node);

        if(bal > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }

        if(bal > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if(bal < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }

        if(bal < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private Node getMinValueNode(Node node) {
        while(node.left != null) {
            node = node.left;
        }

        return node;
    }

    private Node leftRotate(Node node) {
        Node x = node.right;
        Node y = x.left;

        node.right = y;
        x.left = node;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    private Node rightRotate(Node node) {
        Node x = node.left;
        Node y = x.right;

        node.left = y;
        x.right = node;

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }
}

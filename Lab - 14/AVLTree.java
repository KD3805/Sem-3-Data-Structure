import java.util.Arrays;

public class AVLTree {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();

        int arr[] = { 0, 1, 3, 2, 4, 5, 10, 8, -1, -3, -2, -4 };
        for (int x : arr) {
            avl.insertNode(x);
        }

        int maxHeight = avl.maxHeight(avl.root);
        System.out.println("Max Height: " + maxHeight);
        avl.displayFormattedTree();
    }

    Node root;

    int maxHeight(Node root) {
        if (root == null) {
            return -1;
        }

        int lh = maxHeight(root.lptr);
        int rh = maxHeight(root.rptr);

        return Math.max(lh, rh) + 1;
    }

    Node leftRotation(Node node) {
        Node newRoot = node.rptr;
        Node leftOfNewRoot = newRoot.lptr;

        newRoot.lptr = node;
        node.rptr = leftOfNewRoot;

        return newRoot;
    }

    Node rightRotation(Node node) {
        Node newRoot = node.lptr;
        Node rightOfNewRoot = newRoot.rptr;

        newRoot.rptr = node;
        node.lptr = rightOfNewRoot;

        return newRoot;
    }

    int getBalanceFactor(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = maxHeight(root.lptr);
        int rh = maxHeight(root.rptr);

        return lh - rh;
    }

    public void insertNode(int data) {
        this.root = insertNode(this.root, data);
    }

    private Node insertNode(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.info) {
            root.lptr = insertNode(root.lptr, data);
        } else if (data > root.info) {
            root.rptr = insertNode(root.rptr, data);
        } else {
            return root; // Duplicate values are not allowed
        }

        int balance = getBalanceFactor(root);

        // Left Left Case
        if (balance > 1 && data < root.lptr.info) {
            return rightRotation(root);
        }

        // Right Right Case
        if (balance < -1 && data > root.rptr.info) {
            return leftRotation(root);
        }

        // Left Right Case
        if (balance > 1 && data > root.lptr.info) {
            root.lptr = leftRotation(root.lptr);
            return rightRotation(root);
        }

        // Right Left Case
        if (balance < -1 && data < root.rptr.info) {
            root.rptr = rightRotation(root.rptr);
            return leftRotation(root);
        }

        return root;
    }

    private static class Node {
        int info;
        Node lptr;
        Node rptr;

        Node(int info) {
            this.info = info;
        }
    }

    int getNoOfSlashes(int n) {
        return 2 * ((int) Math.pow(2, n) - 1);
    }

    void displayFormattedTree() {
        StringBuilder sb = new StringBuilder();
        int maxHeight = maxHeight(root);
        int levels = maxHeight;
        int cols = 4 * ((int) Math.pow(2, levels));
        int rows = 0;
        for (int i = 1; i <= levels; i++) {
            rows += getNoOfSlashes(i);
        }
        rows += levels + 1; // include root row

        displayFormattedTree(sb, root, levels, 0, cols / 2);

        System.out.println(sb.toString());
    }

    void displayFormattedTree(
            StringBuilder sb,
            Node root,
            int level,
            int i,
            int j
    ) {
        if (root == null) {
            return;
        }

        // format center element
        if (root.info > 99 || root.info < -99) {
            sb.append(root.info / 100).append(Math.abs(root.info) / 10 % 10).append(Math.abs(root.info) % 10);
        } else if (root.info > 9 || root.info < -9) {
            sb.append(root.info / 10).append(Math.abs(root.info) % 10);
        } else {
            sb.append(root.info);
        }

        int slashes = getNoOfSlashes(level);

        if (root.lptr != null) {
            for (int k = i + 1, m = j - 1, count = 0; count < slashes; count++) {
                sb.append("/");
                k++;
                m--;
            }

            displayFormattedTree(sb, root.lptr, level - 1, i + 1, j - 1);
        }

        if (root.rptr != null) {
            for (int k = i + 1, m = j + 1, count = 0; count < slashes; count++) {
                sb.append("\\");
                k++;
                m++;
            }

            displayFormattedTree(sb, root.rptr, level - 1, i + 1, j + 1);
        }
    }
}

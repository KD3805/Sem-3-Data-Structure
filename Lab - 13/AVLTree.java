import java.util.Arrays;

class AVLTree {

  public static void main(String[] args) {
    ImplementAVL avl = new ImplementAVL();

    int arr[] = { 0, 1, 3, 2, 4, 8, -1, -3, -2, -4 };
    for (int x : arr) {
      avl.insertNode(x);
    }

    int[] count = avl.maxHeight(avl.root);
    System.out.println(count[0] + " " + count[1]);
    avl.displayFormatedTree();
  }
}

class ImplementAVL {

  private class Node {
    int info;
    Node lptr;
    Node rptr;

    Node(int info) {
      this.info = info;
    }
  }

  Node root;

  int[] maxHeight(Node root) {
    if (root == null) {
      int[] arr = { -1, -1 };
      return arr;
    }

    int[] lh = maxHeight(root.lptr);
    int[] rh = maxHeight(root.rptr);

    int maxL = (lh[0] > lh[1] ? lh[0] : lh[1]);
    int maxR = (rh[0] > rh[1] ? rh[0] : rh[1]);

    int[] maxHeight = { maxL + 1, maxR + 1 };

    return maxHeight;
  }

  Node leftRotation(Node root) {
    Node parent = root;
    Node newParent = parent.rptr;
    Node leftOfNewParent = newParent.lptr;

    newParent.lptr = parent;
    parent.rptr = leftOfNewParent;
    return newParent;
  }

  Node rightRotation(Node root) {
    Node parent = root;
    Node newParent = parent.lptr;
    Node rightOfNewParent = newParent.rptr;

    newParent.rptr = parent;
    parent.lptr = rightOfNewParent;

    return newParent;
  }

  int getBalanceFactor(Node root) {
    if (root == null) {
      return 0;
    }
    int[] height = maxHeight(root);

    return (height[0] - height[1]);
  }

  public void insertNode(int data) {
    this.root = insertNode(this.root, data);
  }

  public Node insertNode(Node root, int data) {
    Node n = new Node(data);

    if (root == null) {
      root = n;
      System.out.println("First Node info " + n.info + " inserted in BST");
      return root;
    }
    Node parent;
    Node child = root;

    while (true) {
      parent = child;

      if (child.info <= n.info) {
        child = child.rptr;

        if (child == null) {
          parent.rptr = n;
          System.out.println("Node info " + n.info + " inserted on RHS");
          break;
        }
      } else {
        child = child.lptr;

        if (child == null) {
          parent.lptr = n;
          System.out.println("Node info " + n.info + " inserted on LHS");
          break;
        }
      }
    }

    // Check the balance factor and perform rotations if necessary
    int balance = getBalanceFactor(root);

    // Left Left Case
    if (balance > 1 && data < root.lptr.info) {
      System.out.println("right rotation");

      return rightRotation(root);
    }

    // Right Right Case
    if (balance < -1 && data > root.rptr.info) {
      System.out.println("left rotation");

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

  int getNoOfSlashes(int n) {
    int ans = 2;
    for (int i = 1, j = 2; i < n; i++, j *= 2) {
      ans += j;
    }

    return ans;
  }

  void displayFormatedTree() {
    int lengths[] = maxHeight(root);
    int levels = (lengths[0] > lengths[1]) ? lengths[0] : lengths[1];
    int cols = 4 * ((int) Math.pow(2, levels));
    int rows = 0;
    for (int i = 1; i <= levels; i++) {
      rows += getNoOfSlashes(i);
    }
    rows += levels + 1; // include root row
    Object treeArr[][] = new Object[rows][cols]; // Object array contains any data type together

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        treeArr[i][j] = " ";
      }
    }

    displayFormatedTree(treeArr, root, levels, 0, cols / 2);

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(treeArr[i][j]);
      }
      System.out.println();
    }
  }

  void displayFormatedTree(
      Object treeArr[][],
      Node root,
      int level,
      int i,
      int j) {
    if (root == null) {
      return;
    }
    // format center element
    if (root.info > 99 || root.info < -99) {
      treeArr[i][j - 1] = root.info / 100;
      treeArr[i][j] = (Math.abs(root.info) / 10) % 10;
      treeArr[i][j + 1] = Math.abs(root.info) % 10;
    } else if (root.info > 9 || root.info < -9) {
      treeArr[i][j] = root.info / 10;
      treeArr[i][j + 1] = Math.abs(root.info) % 10;
    } else {
      treeArr[i][j] = root.info;
    }
    int k, m, count;
    int slashes = getNoOfSlashes(level);

    if (root.lptr != null) {
      for (k = i + 1, m = j - 1, count = 0; count < slashes; count++) {
        treeArr[k][m] = "/";
        k++;
        m--;
      }

      displayFormatedTree(treeArr, root.lptr, level - 1, k, m + 1);
    }

    if (root.rptr != null) {
      for (k = i + 1, m = j + 1, count = 0; count < slashes; count++) {
        treeArr[k][m] = "\\";
        k++;
        m++;
      }

      displayFormatedTree(treeArr, root.rptr, level - 1, k, m - 1);
    }
  }
}

// Deletion

// public void delete(int data) {
// root = deleteNode(root, data);
// }

// private Node deleteNode(Node root, int data) {
// if (root == null) {
// return root;
// }

// if (data < root.data) {
// root.left = deleteNode(root.left, data);
// } else if (data > root.data) {
// root.right = deleteNode(root.right, data);
// } else {
// if (root.left == null || root.right == null) {
// Node temp = null;
// if (temp == root.left) {
// temp = root.right;
// } else {
// temp = root.left;
// }

// if (temp == null) {
// temp = root;
// root = null;
// } else {
// root = temp;
// }
// } else {
// Node temp = minValueNode(root.right);
// root.data = temp.data;
// root.right = deleteNode(root.right, temp.data);
// }
// }

// if (root == null) {
// return root;
// }

// root.height = 1 + Math.max(height(root.left), height(root.right));

// int balance = getBalance(root);

// if (balance > 1 && getBalance(root.left) >= 0) {
// return rotateRight(root);
// }

// if (balance > 1 && getBalance(root.left) < 0) {
// root.left = rotateLeft(root.left);
// return rotateRight(root);
// }

// if (balance < -1 && getBalance(root.right) <= 0) {
// return rotateLeft(root);
// }

// if (balance < -1 && getBalance(root.right) > 0) {
// root.right = rotateRight(root.right);
// return rotateLeft(root);
// }

// return root;
// }

// private Node minValueNode(Node node) {
// Node current = node;

// while (current.left != null) {
// current = current.left;
// }

// return current;
// }

// Search

// public boolean search(int data) {
// return searchNode(root, data);
// }

// private boolean searchNode(Node node, int data) {
// if (node == null) {
// return false;
// }

// if (data < node.data) {
// return searchNode(node.left, data);
// } else if (data > node.data) {
// return searchNode(node.right, data);
// } else {
// return true;
// }
// }

package Task1;

public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public static int NumberOfLeaves(Node root) {
        if (root != null) {
            int res = 0;
            if (root.left != null) {
                res += NumberOfLeaves(root.left);
            }
            if (root.right != null) {
                res += NumberOfLeaves(root.right);
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            return res;
        }
        return 0;
    }

    public static int LargestNumberOfEdgesToLeaf(Node root) {
        if (root != null) {
            int leftLength = 0;
            int rightLength = 0;
            if (root.left == null && root.right == null) {
                return 0;
            }
            if (root.left != null) {
                leftLength = LargestNumberOfEdgesToLeaf(root.left) + 1;
            }
            if (root.right != null) {
                rightLength = LargestNumberOfEdgesToLeaf(root.right) + 1;
            }
            return Math.max(leftLength, rightLength);
        }
        return 0;
    }

    public static boolean IsTreeSame(Node firstRoot, Node secondRoot) {
        if (firstRoot == null && secondRoot == null) {
            return true;
        }
        if (firstRoot != null && secondRoot != null) {
            return firstRoot.value == secondRoot.value &&
                    (
                            (IsTreeSame(firstRoot.left, secondRoot.left) && IsTreeSame(firstRoot.right, secondRoot.right))
                                    || (IsTreeSame(firstRoot.left, secondRoot.right) && IsTreeSame(firstRoot.right, secondRoot.left))
                    );

        }
        return false;
    }
}
import Task1.Node;
import org.junit.Assert;
import org.junit.Test;


public class Task1 {


    @Test
    public void Test1(){
        Node root = new Node(5);
        Assert.assertEquals(Node.NumberOfLeaves(root), 1);
        root.left = new Node(3);
        Assert.assertEquals(Node.NumberOfLeaves(root), 1);
        root.left.left = new Node(2);
        Assert.assertEquals(Node.NumberOfLeaves(root), 1);
        root.left.right = new Node(5);
        Assert.assertEquals(Node.NumberOfLeaves(root), 2);
        root.right = new Node(7);
        Assert.assertEquals(Node.NumberOfLeaves(root), 3);
        root.right.left = new Node(1);
        Assert.assertEquals(Node.NumberOfLeaves(root), 3);
        root.right.right = new Node(0);
        Assert.assertEquals(Node.NumberOfLeaves(root), 4);
        root.right.right.left = new Node(2);
        Assert.assertEquals(Node.NumberOfLeaves(root), 4);
        root.right.right.right = new Node(8);
        Assert.assertEquals(Node.NumberOfLeaves(root), 5);
        root.right.right.right.right = new Node(5);
        Assert.assertEquals(Node.NumberOfLeaves(root), 5);

    }

    @Test
    public void Test2() {
        Node root = new Node(5);
        Assert.assertEquals(Node.LargestNumberOfEdgesToLeaf(root), 0);
        root.left = new Node(3);
        Assert.assertEquals(Node.LargestNumberOfEdgesToLeaf(root), 1);
        root.left.left = new Node(2);
        Assert.assertEquals(Node.LargestNumberOfEdgesToLeaf(root), 2);
        root.left.right = new Node(5);
        Assert.assertEquals(Node.LargestNumberOfEdgesToLeaf(root), 2);
        root.right = new Node(7);
        Assert.assertEquals(Node.LargestNumberOfEdgesToLeaf(root), 2);
        root.right.left = new Node(1);
        Assert.assertEquals(Node.LargestNumberOfEdgesToLeaf(root), 2);
        root.right.right = new Node(0);
        Assert.assertEquals(Node.LargestNumberOfEdgesToLeaf(root), 2);
        root.right.right.left = new Node(2);
        Assert.assertEquals(Node.LargestNumberOfEdgesToLeaf(root), 3);
        root.right.right.right = new Node(8);
        Assert.assertEquals(Node.LargestNumberOfEdgesToLeaf(root), 3);
        root.right.right.right.right = new Node(5);
        Assert.assertEquals(Node.LargestNumberOfEdgesToLeaf(root), 4);
    }


    @Test
    public void Test3(){
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.left.left = new Node(2);
        root1.left.right = new Node(5);
        root1.right = new Node(7);
        root1.right.left = new Node(1);
        root1.right.right = new Node(0);
        root1.right.right.left = new Node(2);
        root1.right.right.right = new Node(8);
        root1.right.right.right.right = new Node(5);
        Node root2 = new Node(5);
        root2.right = new Node(3);
        root2.right.left = new Node(2);
        root2.right.right = new Node(5);
        root2.left = new Node(7);
        Assert.assertFalse(Node.IsTreeSame(root1, root2));
        root2.left.left = new Node(1);
        root2.left.right = new Node(0);
        root2.left.right.left = new Node(2);
        root2.left.right.right = new Node(8);
        root2.left.right.right.right = new Node(5);

        Assert.assertTrue(Node.IsTreeSame(root1, root2));
    }
}

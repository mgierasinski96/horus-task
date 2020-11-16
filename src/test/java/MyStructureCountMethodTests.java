import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MyStructureCountMethodTests {

    public MyStructureCountMethodTests() {
    }

    private MyStructure myTestStructure;

    @Test
    public void test_Count_EmptyStructure() {
        myTestStructure = new MyStructure();
        Assertions.assertEquals(myTestStructure.count(), 0);
    }
    @Test
    public void test_Count_OnlyINodes() {
        myTestStructure = new MyStructure();
        myTestStructure.addNode(new Node("",""));
        myTestStructure.addNode(new Node("",""));
        myTestStructure.addNode(new Node("",""));
        myTestStructure.addNode(new Node("",""));
        myTestStructure.addNode(new Node("",""));
        myTestStructure.addNode(new Node("",""));
        Assertions.assertEquals(myTestStructure.count(), 6);
    }
    @Test
    public void test_Count_SimplyCompositeNodes() {
        myTestStructure = new MyStructure();;
        myTestStructure.addNode(new Node("",""));
        CompositeNode compNode=new CompositeNode("", "");
        compNode.addNode(new Node("", ""));
        compNode.addNode(new Node("", ""));
        myTestStructure.addNode(compNode);
        compNode=new CompositeNode("", "");
        compNode.addNode(new Node("", ""));
        compNode.addNode(new Node("", ""));
        compNode.addNode(new Node("", ""));
        compNode.addNode(new Node("", ""));
        myTestStructure.addNode(compNode);
        Assertions.assertEquals(myTestStructure.count(), 9);
    }
    @Test
    public void test_Count_HighlyNestedCompositeNodes() {
        myTestStructure = new MyStructure();
        CompositeNode compNode=new CompositeNode("", "");
        CompositeNode compNode1=new CompositeNode("", "");
        CompositeNode compNode2=new CompositeNode("", "");
        CompositeNode compNode3=new CompositeNode("", "");
        CompositeNode compNode4=new CompositeNode("", "");
        compNode4.addNode(new Node("", ""));
        compNode3.addNode(compNode4);
        compNode3.addNode(new Node("", ""));
        compNode3.addNode(new Node("", ""));
        compNode2.addNode(new Node("", ""));
        compNode2.addNode(new Node("", ""));
        compNode1.addNode(compNode2);
        compNode1.addNode(compNode3);
        compNode1.addNode(new Node("", ""));
        compNode1.addNode(new Node("", ""));
        compNode1.addNode(new Node("", ""));
        compNode.addNode(compNode1);
        compNode.addNode(new Node("", ""));
        myTestStructure.addNode(new Node("",""));
        myTestStructure.addNode(compNode);
        Assertions.assertEquals(myTestStructure.count(), 15);

    }
}

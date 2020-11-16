import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MyStructureFindByCodeMethodTests {

    public MyStructureFindByCodeMethodTests() {
    }
    private MyStructure myTestStructure;

    private final Node SEARCHED_NODE_TEST_1 =new Node("code13", "renderer13");
    private final CompositeNode SEARCHED_COMPOSITE_NODE_TEST_2 =new CompositeNode("code3", "renderer3");
    private final Node SEARCHED_NODE_TEST_3 =new Node("code12", "renderer12");
    private final Node SEARCHED_NODE_TEST_4 =new Node("code5", "renderer5");




    @Test
    public void test_1_FindBy_Code_NotNestedNode() {
        Assertions.assertEquals(myTestStructure.findByCode("code13"), SEARCHED_NODE_TEST_1);
    }
    @Test
    public void test_2_FindBy_Code_CompositeNode() {
        Assertions.assertEquals(myTestStructure.findByCode("code3"), SEARCHED_COMPOSITE_NODE_TEST_2);
    }
    @Test
    public void test_3_FindBy_Code_NestedNode() {
        Assertions.assertEquals(myTestStructure.findByCode("code12"), SEARCHED_NODE_TEST_3);
    }
    @Test
    public void test_4_FindBy_Code_HighlyNestedNode() {
        Assertions.assertEquals(myTestStructure.findByCode("code5"), SEARCHED_NODE_TEST_4);
    }

    @BeforeEach
    void prepareStructure() {
        myTestStructure = new MyStructure();
        CompositeNode compNode=new CompositeNode("code", "renderer");
        CompositeNode compNode1=new CompositeNode("code1", "renderer1");
        CompositeNode compNode2=new CompositeNode("code2", "renderer2");
        CompositeNode compNode4=new CompositeNode("code4", "renderer4");
        compNode4.addNode(SEARCHED_NODE_TEST_4);
        SEARCHED_COMPOSITE_NODE_TEST_2.addNode(compNode4);
        SEARCHED_COMPOSITE_NODE_TEST_2.addNode(new Node("code6", "renderer6"));
        SEARCHED_COMPOSITE_NODE_TEST_2.addNode(new Node("code7", "renderer7"));
        compNode2.addNode(new Node("code8", "renderer8"));
        compNode2.addNode(new Node("code9", "renderer9"));
        compNode1.addNode(compNode2);
        compNode1.addNode(SEARCHED_COMPOSITE_NODE_TEST_2);
        compNode1.addNode(new Node("code10", "renderer10"));
        compNode1.addNode(new Node("code11", "renderer11"));
        compNode1.addNode(SEARCHED_NODE_TEST_3);
        compNode.addNode(compNode1);
        compNode.addNode(SEARCHED_NODE_TEST_1);
        myTestStructure.addNode(new Node("code14","renderer14"));
        myTestStructure.addNode(compNode);
    }

}


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompositeNode extends Node implements ICompositeNode {

    private List<INode> nodes = new ArrayList<>();

    public CompositeNode(String code, String renderer) {
        super(code, renderer);
    }

    @Override
    public List<INode> getNodes() {
        return this.nodes;
    }
    @Override
    public void addNode(INode iNode) {
        nodes.add(iNode);
    }
}

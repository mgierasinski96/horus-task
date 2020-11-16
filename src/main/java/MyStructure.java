import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyStructure implements IMyStructure {
    private List<INode> nodes = new ArrayList<>();

    @Override
    public INode findByCode(String code) {
        Optional<INode> optionalINode = findAllINodesRecursiveStrategy(this.nodes).stream()
                .filter((node) -> node.getCode().equals(code)).findAny();
        if (optionalINode.isPresent()) {
            return optionalINode.get();
        }
        return null;
    }

    @Override
    public INode findByRenderer(String renderer) {
        Optional<INode> optionalINode = findAllINodesRecursiveStrategy(this.nodes).stream()
                .filter((node) -> node.getRenderer().equals(renderer)).findAny();
        if (optionalINode.isPresent()) {
            return optionalINode.get();
        }
        return null;
    }

    @Override
    public int count() {
        return findAllINodesRecursiveStrategy(this.nodes).size();
    }

    List<INode> findAllINodesRecursiveStrategy(List<INode> nodes) {
        List<INode> iNodes = new ArrayList<>();
        for (INode iNode : nodes) {
            if (iNode instanceof ICompositeNode) {
                iNodes.addAll(findAllINodesRecursiveStrategy(((ICompositeNode) iNode).getNodes()));
            }
            iNodes.add(iNode);
        }
        return iNodes;
    }

    public void addNode(INode iNode) {
        nodes.add(iNode);
    }
}

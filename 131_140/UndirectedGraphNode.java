import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
    int label;
    List<UndirectedGraphNode> neighbors;
}

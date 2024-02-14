import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConsistentHashing {
    private final SortedSet<Integer> nodeHashes = new TreeSet<>();
    // node_hash -> node
    private final Map<Integer, String> nodeMap = new HashMap<>();
    private final int numberOfReplicas;

    void addNode(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            String replicaNode = node + "_" + i;
            int hash = getHash(replicaNode);
            nodeHashes.add(hash);
            nodeMap.put(hash, replicaNode);
        }
    }

    void removeNode(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            int hash = getHash(node + "_" + i);
            nodeHashes.remove(hash);
            nodeMap.remove(hash);
        }
    }

    String getNode(String key) {
        if (nodeHashes.isEmpty()) {
            return null;
        }
        int hash = getHash(key);
        if (!nodeHashes.contains(hash)) {
            SortedSet<Integer> tailSet = nodeHashes.tailSet(hash);
            hash = tailSet.isEmpty() ? nodeHashes.first() : tailSet.first();
        }
        return "Node: " + nodeMap.get(hash) + " for key: " + key + " with hash: " + hash;
    }

    int getHash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(key.getBytes());
            // Using only the first 4 bytes for simplicity (adjust as needed)
            int hash = (hashBytes[0] & 0xFF) | ((hashBytes[1] & 0xFF) << 8) | ((hashBytes[2] & 0xFF) << 16) | ((hashBytes[3] & 0xFF) << 24);
            return hash;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 not supported", e);
        }
    }

    public static void main(String[] args) {
        ConsistentHashing consistentHashing = new ConsistentHashing(3);
        consistentHashing.addNode("A");
        consistentHashing.addNode("B");
        consistentHashing.addNode("C");
        System.out.println(consistentHashing.getNode("1"));
        System.out.println(consistentHashing.getNode("2"));
        System.out.println(consistentHashing.getNode("3"));
        consistentHashing.removeNode("B");
        System.out.println(consistentHashing.getNode("1"));
        System.out.println(consistentHashing.getNode("2"));
        System.out.println(consistentHashing.getNode("3"));
    }
}

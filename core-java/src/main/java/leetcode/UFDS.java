package leetcode;

public class UFDS {
    private int[] parent;

    private int getParent(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = getParent(parent[a]);
    }

    public boolean validTree(int n, int[][] edges) {
        parent = new int[n];
        int[] ts = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            ts[i] = 1;
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            int pa = getParent(a);
            int pb = getParent(b);
            if (pa == pb) {
                return false;
            }
            if (ts[pa] >= ts[pb]) {
                parent[pb] = pa;
                ts[pa] += ts[pb];
            } else {
                parent[pa] = pb;
                ts[pb] += ts[pa];
            }
        }
        return ts[parent[0]] == n;
    }

}

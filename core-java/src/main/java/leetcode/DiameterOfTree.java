package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DiameterOfTree {
    List<List<Integer>> G;
    List<Integer> path;
    boolean[] vis;
    int n;

    int findFarthest(int node) {
        boolean[] vis = new boolean[n];
        int max_dist = 0;
        int farthest = 0;
        Queue<int[]> mq = new LinkedList<>();
        vis[node] = true;
        mq.add(new int[]{node, 0});
        while (!mq.isEmpty()) {
            int[] top = mq.poll();
            if (top[1] > max_dist) {
                max_dist = top[1];
                farthest = top[0];
            }
            for (var neigh : G.get(top[0])) {
                if (vis[neigh]) {
                    continue;
                }
                vis[neigh] = true;
                mq.offer(new int[]{neigh, top[1] + 1});
            }
        }
        return farthest;
    }

    void findPath(int curr, int target, List<Integer> p) {
        p.add(curr);
        if (curr == target) {
            path = new ArrayList<>(p);
            return;
        }
        for (var n : G.get(curr)) {
            if (vis[n]) {
                continue;
            }
            vis[n] = true;
            findPath(n, target, p);
        }
        p.remove(p.size() - 1);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        this.n = n;
        this.vis = new boolean[n];
        this.G = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            G.add(new ArrayList<>());
        }

        // create adjency list
        for (int[] e : edges) {
            G.get(e[0]).add(e[1]);
            G.get(e[1]).add(e[0]);
        }

        int a = findFarthest(0);
        int b = findFarthest(a);

        findPath(a, b, new ArrayList<>());
        List<Integer> ans = new ArrayList<>();

        int sz = path.size();
        if (sz % 2 == 0) {
            ans.add(path.get(sz / 2 - 1));
            ans.add(path.get(sz / 2));
        } else {
            ans.add(path.get(sz / 2));
        }
        return ans;

    }
}

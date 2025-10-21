package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TopologicalSortAndCycle {
    int UNVISITED = 0, VISITED = 1, COMPLETED = 2;
    List<Integer> order;
    int[] state;
    List<List<Integer>> G;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        state = new int[numCourses];
        G = new ArrayList<>();
        order = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            G.add(new ArrayList<>());
        }
        for (int[] e : prerequisites) {
            G.get(e[0]).add(e[1]);
        }
        boolean pos = true;
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == UNVISITED) {
                pos = pos && dfs(i);
            }
        }
        if (!pos) {
            return new int[0];
        }
        return order.stream().mapToInt(i -> i).toArray();

    }

    boolean dfs(int i) {
        state[i] = VISITED;
        boolean pos = true;
        for (int n : G.get(i)) {
            if (state[n] == VISITED) {
                return false;
            }
            if (state[n] == UNVISITED) {
                pos = pos && dfs(n);
            }
        }
        state[i] = COMPLETED;
        order.add(i);
        return pos;
    }
}

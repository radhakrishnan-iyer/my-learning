package com.learning.trees;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BFS g = new BFS(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.BFS(2);
	}
		private int vertices;
		
		LinkedList<Integer> adj[];
		public BFS(int v) {
			vertices = v;
			adj = new LinkedList[vertices];
			for(int i = 0 ; i<vertices ; i++)
				adj[i] = new LinkedList();
		}
		
		public void BFS(int start) {
			boolean visited [] = new boolean[vertices];
			bfsUtil(visited , start);
		}
		
		public void addEdge(int x , int y) {
			adj[x].add(y);
		}
		
		private void bfsUtil(boolean visited[] , int v) {
			
			LinkedList<Integer> queue = new LinkedList<Integer>();
			visited[v] = true;
			queue.add(v);
			
			while(queue.size() > 0) {
				int x = queue.poll();
				System.out.print(x +" ");
				Iterator<Integer> itr = adj[x].listIterator();
				while(itr.hasNext()) {
					int y = itr.next();
					if(!visited[y]) {
						visited[y] = true;
						queue.add(y);
					}
				}
			}
		}

}

package ocp.exam.java11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TraverseBinaryTree {

	public static class Node {
		int data;
		Node left, right;
		
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	
	
	public static void main(String[] args) {
		//Create a Tree
		Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
        root.right.right.right = new Node(30);

        //BFS
        levelOrderTraversal(root);
       
	}


	private static void levelOrderTraversal(Node root) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		preOrderBasedOnLevel(root, 1, map);

		map.forEach((a,b) -> System.out.print(a+ " "+b +";"));
		
	}


	private static void preOrderBasedOnLevel(Node root, int level, Map<Integer, List<Integer>> map) {
		//NLR
		if(root == null) return;
		map.putIfAbsent(level, new ArrayList<Integer>());
		map.get(level).add(root.data);
		
		preOrderBasedOnLevel(root.left, level+1, map);
		preOrderBasedOnLevel(root.right, level+1, map);
		
	}

}

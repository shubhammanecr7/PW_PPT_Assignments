package assignment8_july4;

/*
💡 **Question 4**
You need to construct a binary tree from a string consisting of parenthesis and integers.
The whole input represents a binary tree. It contains an integer followed by zero, one or two 
pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains 
a child binary tree with the same structure.
You always start to construct the **left** child node of the parent first if it exists.
**Input:** s = "4(2(3)(1))(6(5))"
**Output:** [4,2,6,3,1,5]
*/

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}

public class Q4 {
	public static void main(String[] args) {
		String s = "4(2(3)(1))(6(5))";
		TreeNode root = str2tree(s);
		inorderTraversal(root);
	}

	private static void inorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.val + " ");
		inorderTraversal(root.right);
	}

	private static TreeNode str2tree(String s) {
		if (s.isEmpty()) {
			return null;
		}

		int firstParen = s.indexOf("(");

		if (firstParen == -1) {
			// The entire string is a single value (root node)
			return new TreeNode(Integer.parseInt(s));
		}

		// Create the root node from the first integer value
		int rootVal = Integer.parseInt(s.substring(0, firstParen));
		
		TreeNode root = new TreeNode(rootVal); //generate tree with root

		int start = firstParen; // Starting index of the left child's substring

		// Find the index of the corresponding closing parenthesis
		int count = 0;
		for (int i = start; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count++;
			} else if (s.charAt(i) == ')') {
				count--;
			}

			if (count == 0 && start == firstParen) {
				// Found the closing parenthesis for the left child
				root.left = str2tree(s.substring(start + 1, i));
				start = i + 1; // Starting index of the right child's substring
			} else if (count == 0) {
				// Found the closing parenthesis for the right child
				root.right = str2tree(s.substring(start + 1, i));
			}
		}

		return root;
	}
}
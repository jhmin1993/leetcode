package range_sum_of_bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RangeSumOfBst {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			TreeNode root = stringToTreeNode(line);
			line = in.readLine();
			int L = Integer.parseInt(line);
			line = in.readLine();
			int R = Integer.parseInt(line);

			int ret = new RangeSumOfBst().rangeSumBST(root, L, R);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}

	public static TreeNode stringToTreeNode(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		String item = parts[0];
		TreeNode root = new TreeNode(Integer.parseInt(item));
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);

		int index = 1;
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.left = new TreeNode(leftNumber);
				nodeQueue.add(node.left);
			}

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int rightNumber = Integer.parseInt(item);
				node.right = new TreeNode(rightNumber);
				nodeQueue.add(node.right);
			}
		}
		return root;
	}

	public int rangeSumBST(TreeNode root, int L, int R) {
		int sum = 0;

		if (root != null) {
			if (R < root.val) {
				sum = rangeSumBST(root.left, L, R);
			} else if (L > root.val) {
				sum = rangeSumBST(root.right, L, R);
			} else {
				sum = rangeSumBST(root.left, L, root.val) + root.val + rangeSumBST(root.right, root.val, R);
			}
		}
		return sum;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

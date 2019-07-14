package il.karpov.algorithm.exercises.cci.trees;

class TreeTraversal {

        public void inOrder(TreeNode node) {
                if (node != null) {
                        inOrder(node.left);
                        System.out.println(node.val);
                        inOrder(node.right);
                }
        }

	public void preOrder(TreeNode node) {
		if (node != null) {
			System.out.println(node.val);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public void postOrder(TreeNode node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.val);
		}
	}

        public static void main(String[] args) {
		TreeNode leftSub = new TreeNode(4);
		leftSub.left = new TreeNode(2);
		leftSub.right = new TreeNode(6);
		
		TreeNode rightSub = new TreeNode(20);
		rightSub.left = new TreeNode(10);
		rightSub.right = new TreeNode(25);

                TreeNode root = new TreeNode(8);
		root.left = leftSub;
		root.right = rightSub;


		TreeTraversal traverse = new TreeTraversal();
                System.out.println("In order traversal:");
                traverse.inOrder(root);

		System.out.println("Pre order traversal:");
		traverse.preOrder(root);

		System.out.println("Post order traversal:");
		traverse.postOrder(root);
        }

        private static class TreeNode {
                int val;
                TreeNode left;
                TreeNode right;

                public TreeNode(int val) {
                        this.val = val;
                }
        }
}

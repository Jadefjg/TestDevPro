package mdln;


class BinaryTree{
	private class Node{
		@SuppressWarnings("rawtypes")
		private Comparable data;
		private Node left;
		private Node right;
		
		public Node(Comparable data){
			this.data = data;
		}
		
		public void addNode(Node newNode){
			if (this.data.compareTo(newNode)<0){
				if(this.left == null){	//û��������
					this.left = newNode;
				}else{
					this.left.addNode(newNode);
				}
			}else{
				if(this.right == null){
					this.right = newNode;
				}else{
					this.right.addNode(newNode);
				}
			}
		}
		public void printNode(){
			if(this.left != null){
				this.left.printNode();
			}
			System.out.println(this.data);
			if(this.right != null){
				this.right.printNode();
			}
		}
	}
	private Node root;	// ���ڵ�
	
	public void add(Student data){
		if (data == null){
			return;   // ���ص��ô�
		}
		Node newNode = new Node(data); //�����ݷ�װΪ�ڵ�
		if (this.root == null){		//û�и��ڵ�
			this.root = newNode;
		}else{		// ���浽���ʵ�λ��
			this.root.addNode(newNode);
		}
	}
	public void print(){
		if(this.root != null){
			this.root.printNode();
		}
	}
	
}

public class BinaryTreeDemo{
	public static void main(String[] args){
		BinaryTree tree = new BinaryTree();
		tree.add(new Student("小",20, 0));
		tree.add(new Student("哈",19, 0));
		tree.add(new Student("你",21, 0));
		
	}
}





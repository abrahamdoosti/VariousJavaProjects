
public class MyLinkedList {
	private Node rootNode = null;

	public void add(Object obj) {
		Node lastNode=null;
		Node node = new Node();
		node.setData(obj);
		if (rootNode == null) {
			rootNode = node;
			return;
		}
		lastNode=getLastNode();
		lastNode.setAfter(node);
		
		

	}

	private Node getLastNode() {
		if (rootNode == null) {
			return null;
		} else {
			Node node = rootNode;
			while (node.getAfter() != null) {
				node = node.getAfter();
			}
			return node;
		}
	}
	
	public void printList() {
		Node node = rootNode;
		while (node.getAfter() != null) {
			System.out.println(node.getData());
			node = node.getAfter();
		}
		System.out.println(node.getData());
	}

}

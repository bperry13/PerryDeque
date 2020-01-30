//create a node
class Node<Item> {
	Item item;
	Node<Item> next;
	Node<Item> prev;
	
	//constructor
	public Node (Item item) {
		this.item = item;
		prev = null;
		next = null;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Node<Item> getPrev() {
		return prev;
	}

	public void setPrev(Node<Item> prev) {
		this.prev = prev;
	}

	public Node<Item> getNext() {
		return next;
	}

	public void setNext(Node<Item> next) {
		this.next = next;
	}

}
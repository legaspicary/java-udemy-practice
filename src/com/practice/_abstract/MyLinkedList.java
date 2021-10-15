package com.practice._abstract;

public class MyLinkedList implements NodeList {

	private ListItem root;

	public MyLinkedList(ListItem root) {
		this.root = root;
	}

	@Override
	public ListItem getRoot() {
		return this.root;
	}

	@Override
	public boolean addItem(ListItem item) {
		boolean isAdded = true;
		if (this.root == null) {
			this.root = item;
		} else {
			ListItem current = this.root;
			while (current != null) {
				int comparisonResult = current.compareTo(item);
				if (comparisonResult < 0) {
					ListItem next = current.next();
					if (next == null) {
						current.setNext(item).setPrevious(current);
						break;
					} else {
						current = next;
					}
				} else if (comparisonResult > 0) {
					ListItem previous = current.previous();
					if (previous == null) {
						item.setNext(this.root).setPrevious(item);
						this.root = item;
						break;
					} else {
						previous.setNext(item);
						item.setPrevious(previous);
						item.setNext(current);
						current.setPrevious(item);
						break;
					}

				} else {
					isAdded = false;
					break;
				}
			}
		}
		return isAdded;
	}

	@Override
	public boolean removeItem(ListItem item) {
		boolean isRemoved = false;
		ListItem foundItem = null;
		ListItem current = this.root;
		if (item != null) {
			System.out.println("Deleting item " + item.getValue());
		}
		while (current != null) {
			int comparisonResult = current.compareTo(item);
			if (comparisonResult > 0) {
				break;
			} else if (comparisonResult == 0) {
				foundItem = current;
				break;
			}
			current = current.next();
		}
		if (foundItem != null) {
			ListItem previous = foundItem.previous();
			ListItem next = foundItem.next();
			if (previous == null) {
				this.root = next;
				this.root.setPrevious(null);
			} else if (next == null) {
				previous.setNext(null);
			} else {
				previous.setNext(next);
				next.setPrevious(previous);
			}
			isRemoved = true;
		}
		return isRemoved;
	}

	@Override
	public void traverse(ListItem root) {
		if (root == null) {
			System.out.println("The list is empty");
		} else {
			while (root != null) {
				System.out.println(root.getValue());
				root = root.next();
			}
		}
	}

}

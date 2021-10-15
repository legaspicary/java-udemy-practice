package com.practice._abstract;

public class SearchTree implements NodeList {
	private ListItem root = null;

	public SearchTree(ListItem root) {
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
				int comparisonResult = item.compareTo(current);
				if (comparisonResult < 0) {
					ListItem previous = current.previous();
					if (previous == null) {
						current.setPrevious(item);
						break;
					}
					current = previous;
				} else if (comparisonResult > 0) {
					ListItem next = current.next();
					if (next == null) {
						current.setNext(item);
						break;
					}
					current = next;
				} else {
					System.out.println(item.getValue() + " is already present");
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
		if (item != null) {
			System.out.println("Deleting item " + item.getValue());
			ListItem parent = null;
			ListItem current = this.getRoot();
			while (current != null) {
				int comparisonResult = item.compareTo(current);
				if (comparisonResult == 0) {
					this.performRemoval(current, parent);
					isRemoved = true;
					break;
				} else if (comparisonResult < 0) {
					parent = current;
					current = current.previous();
				} else {
					parent = current;
					current = current.next();
				}
			}
		}
		return isRemoved;
	}

	private void performRemoval(ListItem item, ListItem parent) {
		boolean isLeaf = item.previous() == null && item.next() == null;
		boolean hasOneChild = item.previous() == null || item.previous() == null;
		boolean isItemOnLeftOfParent = parent != null && parent.previous().compareTo(item) == 0;
		boolean isItemRoot = parent == null;

		if (isLeaf) {
			if (isItemRoot) {
				this.root = null;
			} else if (isItemOnLeftOfParent) {
				parent.setPrevious(null);
			} else {
				parent.setNext(null);
			}
		} else if (hasOneChild) {

			if (isItemRoot) {

				if (item.previous() != null) {
					this.root = item.previous();
				} else {
					this.root = item.next();
				}
			} else if (isItemOnLeftOfParent) {
				parent.setPrevious(null);
			} else {
				parent.setNext(null);
			}
		} else {
			// find leftmost in the right branch
			ListItem leftmost = item.next();
			ListItem parentOfLeftmostItem = item;
			while (leftmost.previous() != null) {
				parentOfLeftmostItem = leftmost;
				leftmost = leftmost.previous();
			}

			item.setValue(leftmost.getValue());

			// handle deletion if no leftmost in the right branch
			if (parentOfLeftmostItem == item) {
				item.setNext(leftmost.next());
			} else {
				// no need to handle left child (must be null already if leftmost is found)
				parentOfLeftmostItem.setPrevious(leftmost.next());
			}
		}
	}

	@Override
	public void traverse(ListItem root) {
		if (root != null) {
			traverse(root.previous());
			System.out.println(root.getValue());
			traverse(root.next());
		}
	}
//
//	public static void main(String[] args) {
//		SearchTree list = new SearchTree(new Node("C"));
//		list.addItem(new Node("E"));
//		list.addItem(new Node("B"));
//		list.addItem(new Node("F"));
//		list.addItem(new Node("A"));
//		list.addItem(new Node("D"));
//		list.traverse(list.getRoot());
//		System.out.println("-----------------");
//		list.removeItem(new Node("C"));
//		list.traverse(list.getRoot());
//	}
}

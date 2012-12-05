package listImplementations;

/**
 * Note: You might expect this to use generic types i.e. the 
 * <XX> syntax, but Java doesn't allow the creation of generic type
 * arrays. We have used Objects instead and cast where necessary
 */
public class SList {

  private final int DEFAULT_SIZE = 20;
  private Object[] items;
  private int currLength;

  public SList(int size) {
    items = new Object[size];
    currLength = 0;
  }

  public void List() {
    items = new Object[DEFAULT_SIZE];
    currLength = 0;
  }

  /**
   * Get the value of currentLength
   * @return the value of currentLength
   */
  private int getCurrLength() {
    return currLength;
  }

  /**
   * Set the value of currentLength
   * @param currentLength new value of currentLength
   */
  private void setCurrLength(int currentLength) {
    this.currLength = currentLength;
  }

  /**
   * Get the value of items
   * @return the value of items
   */
  public Object[] getItems() {
    return items;
  }

  /**
   * Set the value of items
   * @param items new value of items
   */
  private void setItems(Object[] items) {
    this.items = items;
  }

  /**
   * Get the value of items at specified index
   * @param index
   * @return the value of items at specified index
   */
  public Object getItem(int index) {
    return this.items[index];
  }

  /**
   * Set the value of items at specified index.
   * @param index
   * @param newItems new value of items at specified index
   */
  private void setItems(int index, int newItems) {
    this.items[index] = newItems;
  }

  /**
   * This method inserts an item into the list.
   * @param item to be inserted
   * @return true if the item was inserted, false if the item 
   *         wasn't inserted because the list is full
   */
  public boolean add(Object item) {
    boolean success = false;

    if (!isFull()) {
      int length = getCurrLength();
      items[length] = item;
      currLength++;
      success = true;
    }
    return success;
  }

  /**
   * This method removes an Object from the list
   * @param item Object to be removed
   * @return true if the Object was found on the list 
   *         and removed, otherwise false
   */
  public boolean remove(Object item) {
    boolean removed = false;
    int position = contains(item);
    if (position > 0) {
      removed = remove(position);
    }
    return removed;
  }

  /**
   * Removes the item at the given position and closes the gap
   * @param position
   * @return returns true if the item is found and removed, 
   *         otherwise false.
   */
  public boolean remove(int position) {
    boolean removed = false;
    if (!isEmpty()) {
      for (int i = position; i < getCurrLength(); i++) {
        items[i] = items[i + 1];
      }
      setCurrLength(getCurrLength() - 1);
      items[getCurrLength()] = 0;
      removed = true;
    }
    return removed;
  }

  public boolean isFull() {
    return (currLength == items.length);
  }

  public boolean isEmpty() {
    return (currLength == 0);
  }

  /**
   * Finds an item in a list
   * @param item Item to be inserted
   * @return The position in the list of the item
   *         or -1 if the item is not found
   */
  public int contains(Object item) {
    if (!isEmpty()) {
      // Start at the beginning of the list
      // Stop when the item is found
      for (int i = 0; i < getCurrLength(); i++) {
        if (item.equals(items[i])) {
          return i;
        }
      }
    }
    return -1;
  }

  public void clear() {
    setCurrLength(0);
    for (int i = 0; i < items.length; i++) {
      items[i] = 0;
    }
  }

  public void display() {
    for (int i = 0; i < currLength; i++) {
      System.out.println(items[i].toString());
    }
  }

  @Override
  public String toString() {
    String strList = null;
    for (int i = 0; i < currLength; i++) {
      strList = strList + items[i].toString();
    }
    return strList;
  }
}//SList.java
/*****************************************************
 * Author = ar2-nutt
 * Student ID = 11004967
 * File = Node.java
 *****************************************************/
package listImplementations;

public class DNode<item> {

  private item item;
  private DNode<item> next;

  public DNode(item item) {
    this.item = item;
    this.next = null;
  }

  public DNode(item item, DNode<item> next) {
    this.item = item;
    this.next = next;
  }

  public item getItem() {
    return item;
  }

  public void setItem(item item) {
    this.item = item;
  }

  public DNode<item> getNext() {
    return next;
  }

  public void setNext(DNode<item> next) {
    this.next = next;
  }
}//DNode.java
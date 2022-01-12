//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P10 Binary Bookshelf
// Course: CS 300 Fall 2021
//
// Author: Surya Somayyajula
// Email: somayyajula@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: https://stackoverflow.com/questions/13736832/binary-search-tree-recursive-insert
// -not-displaying-anything, this helped me recurse through the subtrees in the insert method
///////////////////////////////////////////////////////////////////////////////
/**
 * Contains the necessary fields and methods to have a functioning TreeNode, which can contain two
 * TreeNode, and those can contain its own and so forth.
 * 
 * 
 *
 */
public class TreeNode<T> {
  private T data; // Holds the object itself
  private TreeNode<T> left; // The left child of the node
  private TreeNode<T> right; // The right child of the node

  /**
   * Constructs the tree node with only the object data
   * 
   * @param data holds the object itself
   */
  public TreeNode(T data) {
    this.data = data;
  }

  /**
   * Constructs the tree node with the object data and creates the left and right children
   * 
   * @param data  object itself
   * @param left  child of the node
   * @param right child of the node
   */
  public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  /**
   * Getter for the left child data field
   * 
   * @return left child of the node
   */
  public TreeNode<T> getLeft() {
    return left;
  }

  /**
   * Getter for the right child data field
   * 
   * @return right child of the node
   */
  public TreeNode<T> getRight() {
    return right;
  }

  /**
   * Getter for the data generic object field
   * 
   * @return data generic object field
   */
  public T getData() {
    return data;
  }

  /**
   * Setter for the left child of the node
   * 
   * @param left takes new TreeNode and sets it to the left child of the parent node
   */
  public void setLeft(TreeNode<T> left) {
    this.left = left;
  }

  /**
   * Setter for the right child of the node
   * 
   * @param right takes new TreeNode and sets it to the right child of the parent node
   */
  public void setRight(TreeNode<T> right) {
    this.right = right;
  }


  /**
   * Makes the String representation of the data generic object field
   * 
   * @return String representation of the data generic object field
   */
  @Override
  public String toString() {
    return "" + data;
  }

}

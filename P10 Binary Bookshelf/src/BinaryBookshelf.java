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
 * Contains the necessary fields and methods to create a functioning Binary Bookshelf, via a binary
 * search tree
 * 
 * 
 *
 */
import java.util.ArrayList;

public class BinaryBookshelf {
  private TreeNode<Book> root; // The root node of the shelf
  private int size; // Current size of the shelf
  private Attribute[] sortList; // How the shelf is ordered in terms of highest to lowest
                                // precendence of the Attribute elements in the list

  /**
   * Constructs a shelf with
   * 
   * @param sortList how the shelf should be ordered according to the highest to lowest predence of
   *                 the elements
   */
  public BinaryBookshelf(Attribute[] sortList) {
    // If the array has a length other than 4 or the starting element is not AUTHOR, then throw an
    // IllegalArgumentException
    if (sortList.length != 4 || sortList[0] != Attribute.AUTHOR) {
      throw new IllegalArgumentException("Sortlist is invalid");
    }
    // If there are any duplicate elements in the array, then throw an IllegalArgumentException
    for (int i = 0; i < sortList.length; i++) {
      for (int j = i + 1; j < sortList.length; j++) {
        if (sortList[i] == sortList[j]) {
          throw new IllegalArgumentException("Sortlist is invalid");
        }
      }
    }
    // Sets the sortlist and the size to 0
    this.sortList = sortList;
    size = 0;
  }

  /**
   * Getter for the size field: O(1)
   * 
   * @return the size of the shelf
   */
  public int size() {
    return size;
  }

  /**
   * Checks whether or not the shelf is empty: O(1)
   * 
   * @return true if size is 0, false otherwise
   */
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Makes a String representation of the Attribute array
   * 
   * @return order of the Attributes in the array
   */
  public String getAttributeOrder() {
    String order = "";
    // Puts all the elements from 1 to 4
    for (int i = 1; i <= sortList.length; i++) {
      order += i + ":" + sortList[i - 1] + " ";
    }
    // Gets rid of the whitespace
    order = order.strip();
    return order;
  }

  /**
   * Checks whether the shelf has a particular book: O(N)
   * 
   * @param book in question, whether or not it is in the shelf
   * @return true if it is in the shelf, otherwise false
   */
  public boolean contains​(Book book) {
    return containsHelper​(book, root);
  }

  /**
   * Recursive helper method that traverses the BST to see if a particular book is in said BST
   * 
   * @param book    to look for in the BST shelf
   * @param current node that the method is at in the BST
   * @return true if it finds the book in the shelf, otherwise false
   */
  protected boolean containsHelper​(Book book, TreeNode<Book> current) {
    // If the shelf is empty, then return false
    if (current == null) {
      return false;
    }
    // Keeps comparing the particular book to the current node's book
    int compare = compareToHelper​(book, current.getData());
    // If comp is 0, that means that the book and the current node book is equal, so return true
    if (compare == 0) {
      return true;
    }
    // If comp is less than 0, that means that the book is less than the book in terms of
    // attributes, so
    // explore the subtree
    if (compare < 0 && current.getLeft() != null) {
      return containsHelper​(book, current.getLeft());

    }
    // If comp is greater than 0, that means that the book is greater than the book in terms of
    // attributes, so
    // explore the subtree
    if (compare > 0 && current.getRight() != null) {
      return containsHelper​(book, current.getRight());
    }

    // If method makes it to this point, that means it did not find the book
    return false;
  }

  /**
   * Compares 2 book objects based on the sortList element precedence from highest to lowest
   * 
   * @param one Book object to compare
   * @param two Book object to compare to one
   * @return 0 if books are equal, 1 if one is bigger than two, otherwise -1
   */
  protected int compareToHelper​(Book one, Book two) {
    // If books are equal, return 0
    if (one.equals(two)) {
      return 0;
    }
    // Cycles through sortList attributes if attributes are equal in the Book objects, if one is
    // greater than two in some attribute, return 1, otherwise -1
    int result = 0;
    for (int i = 0; i < sortList.length; i++) {
      if (one.compareTo(two, sortList[i]) < 0) {
        result = -1;
        break;
      } else if (one.compareTo(two, sortList[i]) > 0) {
        result = 1;
        break;
      }
    }
    return result;

  }

  /**
   * Creates an ArrayList containing all the books written by a particular author
   * 
   * @param authorName, used to look for books written by author
   * @return ArrayList with all the books written by the author
   */
  public ArrayList<Book> getBooksByAuthor​(String authorName) {
    return getBooksByAuthorHelper​(authorName, root);
  }

  /**
   * Recursive helper method for getBooksByAuthor that creates the ArrayList containing all the
   * books written by the author
   * 
   * @param authorName, used to look for books written by author
   * @param current     node the method is at in the BST shelf
   * @return ArrayList with all the books written by the author
   */
  protected ArrayList<Book> getBooksByAuthorHelper​(String authorName, TreeNode<Book> current) {

    ArrayList<Book> authoredBooks = new ArrayList<Book>();
    // If shelf is empty, return an empty arraylist
    if (current == null) {
      return authoredBooks;
    }
    int compare = authorName.compareTo(current.getData().getAuthor());
    // Explore the left subtree and add the result to the arraylist
    authoredBooks.addAll(getBooksByAuthorHelper​(authorName, current.getLeft()));

    // If the current node author is equal to the authorName, then add to the arraylist
    if (compare == 0) {
      authoredBooks.add(current.getData());
    }

    // Explore the right subtree and add the result to the arraylist
    authoredBooks.addAll(getBooksByAuthorHelper​(authorName, current.getRight()));


    return authoredBooks;
  }

  /**
   * Makes the string of the BST: O(N)
   * 
   * @return the string representation of the BST in inorder traversal
   */
  @Override
  public String toString() {

    return toStringHelper​(root);
  }

  /**
   * Recursive helper method for toString that constructs String representation of the BST in
   * inorder traversal
   * 
   * @param current node that the method is at in the BST
   * @return String of the BST in inorder traversal
   */
  protected String toStringHelper​(TreeNode<Book> current) {
    String string = "";
    // Recurse through left and right subtree, and add these nodes String representation to the
    // final String
    if (current != null) {
      string = string + toStringHelper​(current.getLeft());
      string = string + current.toString() + "\n";
      string = string + toStringHelper​(current.getRight());
    }
    return string;

  }

  /**
   * Getter for the root TreeNode field
   * 
   * @return root of the shelf
   */
  protected TreeNode<Book> getRoot() {
    return root;
  }

  /**
   * Sets the root node to null and sets size to 0
   */
  public void clear() {
    root = null;
    size = 0;
  }

  /**
   * Insert book into the BST shelf by traversing the BST
   * 
   * @param book to insert into the BST shelf
   */
  public void insertBook​(Book book) {
    // If the book is already in the shelf, then throw an IllegalArgumentException
    if (contains​(book)) {
      throw new IllegalArgumentException("This book is already in the bookshelf");
    }
    // If the shelf is empty, create a new node at the roots
    if (isEmpty()) {
      root = new TreeNode<Book>(book);
    }
    // Otherwise, call the recursive helper method to traverse the BST and insert it where
    // appropriate
    else {
      insertBookHelper​(book, root);
    }
    // Increase the size regardless of which action is taken, as one node is made either way
    size++;
  }

  /**
   * Recursive helper method that inserts the book where appropriate via BST traversal and
   * compareToHelper method
   * 
   * @param book    to insert into the BST
   * @param current node where the method is at in the BST
   */
  protected void insertBookHelper​(Book book, TreeNode<Book> current) {
    // If book is less than current node, then if the left child is null, then set this to the left
    // child, else recurse through the subtree
    if (compareToHelper​(book, current.getData()) < 0) {
      if (current.getLeft() == null) {
        current.setLeft(new TreeNode<Book>(book));
      } else {
        insertBookHelper​(book, current.getLeft());
      }
    }
    // If book is greater than the current node, then if the right child is null, then set this to
    // the right child, else recurse through the subtree
    else if (compareToHelper​(book, current.getData()) > 0) {
      if (current.getRight() == null) {
        current.setRight(new TreeNode<Book>(book));
      } else {
        insertBookHelper​(book, current.getRight());
      }
    }
  }
}


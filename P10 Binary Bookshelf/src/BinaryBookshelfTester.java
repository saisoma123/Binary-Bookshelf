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
//
///////////////////////////////////////////////////////////////////////////////
/**
 * Tests the correctness of Binary Bookshelf's methods, as well as TreeNode's. If all tests succeed,
 * then true is returned, otherwise false is returned
 * 
 * 
 *
 */
import java.util.ArrayList;

public class BinaryBookshelfTester {
  /**
   * Checks if the TreeNode object's methods work correctly
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean testTreeNode() {
    // Reset ID
    Book.resetGenerator();
    try {
      // Checks if the single node has null children
      TreeNode<Integer> node = new TreeNode<Integer>(23);
      if (node.getLeft() != null) {
        return false;
      }
      if (node.getRight() != null) {
        return false;
      }
      // Checks if the single node has the correct value and its string representation is correct
      if (!node.getData().equals(23)) {
        return false;
      }
      if (!node.toString().equals("23")) {
        return false;
      }
      // Checks if node2 is the left child of node1 and the right child is null
      TreeNode<Double> node1 = new TreeNode<Double>(2.0);
      TreeNode<Double> node2 = new TreeNode<Double>(3.0);
      node1.setLeft(node2);
      if (node1.getLeft() != node2) {
        return false;
      }
      if (node1.getRight() != null) {
        return false;
      }
      // Checks if the left child is null
      node1.setLeft(null);
      if (node1.getLeft() != null) {
        return false;
      }
      // Checks if the parent node has the correct children, c1 and c2, checks if the children has
      // the correct values
      TreeNode<Boolean> c1 = new TreeNode<Boolean>(true);
      TreeNode<Boolean> c2 = new TreeNode<Boolean>(false);
      TreeNode<Boolean> parent = new TreeNode<Boolean>(false, c1, c2);
      if (parent.getLeft() != c1 && parent.getLeft().getData() != true) {
        return false;
      }
      if (parent.getRight() != c2 && parent.getRight().getData() != false) {
        return false;
      }

      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }


  }

  /**
   * Private helper method that checks if the BinaryBookshelf constructor method throws a
   * IllegalArgumentException, since the shelf is zero
   * 
   * @return true if all tests pass, false otherwise
   */
  private static boolean emptyShelf() {
    // Reset ID
    Book.resetGenerator();
    try {
      Attribute[] zero = {};
      BinaryBookshelf empty = new BinaryBookshelf(zero);
      return true;

    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }


  }

  /**
   * Private helper method checks if the BinaryBookshelf constructor throws an
   * IllegalArgumentException, since the Attribute sortList a length that is not 4
   * 
   * @return true if all tests pass, false otherwise
   */
  private static boolean wrongArraySize() {
    // Reset ID
    Book.resetGenerator();
    try {
      Attribute[] unique = {Attribute.AUTHOR, Attribute.ID};
      BinaryBookshelf wrong = new BinaryBookshelf(unique);
      return true;

    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }


  }

  /**
   * Private helper method checks if the BinaryBookshelf constructor throws an
   * IllegalArgumentException, since the Attribute sortList has duplicate elements
   * 
   * @return true if all tests pass, false otherwise
   */
  private static boolean duplicateElement() {
    // Reset ID
    Book.resetGenerator();
    try {
      Attribute[] dup = {Attribute.AUTHOR, Attribute.ID, Attribute.ID, Attribute.PAGECOUNT};
      BinaryBookshelf dupshelf = new BinaryBookshelf(dup);
      return true;
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }


  }

  /**
   * Private helper method checks if the BinaryBookshelf constructor throws an
   * IllegalArgumentException, since the Attribute sortList has the incorrect starting element
   * 
   * @return true if all tests pass, false otherwise
   */
  private static boolean wrongStartingElement() {
    // Reset ID
    Book.resetGenerator();
    try {
      Attribute[] wrongstart =
          {Attribute.ID, Attribute.AUTHOR, Attribute.PAGECOUNT, Attribute.TITLE};
      BinaryBookshelf wrongagain = new BinaryBookshelf(wrongstart);
      return true;
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }


  }

  /**
   * Checks if the emptyShelf has the correct results for all the BinaryBookshelf methods
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean testEmptyTree() {
    // Reset ID
    Book.resetGenerator();
    try {
      if (emptyShelf() && wrongArraySize() && duplicateElement()
          && wrongStartingElement() != true) {
        return false;
      }
      // Creates an empty shelf
      Attribute[] normal = {Attribute.AUTHOR, Attribute.ID, Attribute.TITLE, Attribute.PAGECOUNT};
      BinaryBookshelf normalshelf = new BinaryBookshelf(normal);
      // Checks if the size is 0, if it is empty, if the String representation is correct, and if
      // the root is null
      if (normalshelf.size() != 0 && !normalshelf.isEmpty() && !normalshelf.toString().equals("")
          && normalshelf.getRoot() != null) {
        return false;
      }
      // Checks if the attribute order is correct, if the shelf does not contain the book, and if
      // the getBooksByAuthor method returns an empty ArrayList
      Book book = new Book("Hitchhikers Guide to the Galaxy", 202, "Name", "Forgotten");
      if (!normalshelf.getAttributeOrder().equals("1:AUTHOR 2:ID 3:TITLE 4:PAGECOUNT")) {
        return false;
      }
      if (normalshelf.contains​(book) != false) {
        return false;
      }
      if (normalshelf.getBooksByAuthor​("Name").size() != 0) {
        return false;
      }
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Checks if the insertBook method works correctly
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean testInsertBook() {
    // Reset ID
    Book.resetGenerator();
    try {
      // Creates an empty shelf and checks if the size is correct
      Attribute[] normal = {Attribute.AUTHOR, Attribute.TITLE, Attribute.ID, Attribute.PAGECOUNT};
      BinaryBookshelf normalshelf = new BinaryBookshelf(normal);
      if (normalshelf.size() != 0) {
        return false;
      }
      // Inserts a book and checks if the size is correct
      Book book = new Book("The Fellowship of the Ring", 202, "Tolkien", "JRR");
      normalshelf.insertBook​(book);
      if (normalshelf.size() != 1) {
        return false;
      }
      // Checks if the root book is correct
      if (normalshelf.getRoot().getData() != book) {
        return false;
      }
      // Inserts a book and checks if the size is correct
      Book two = new Book("Oliver Twist", 100, "Dickens", "Charles");
      normalshelf.insertBook​(two);
      if (normalshelf.size() != 2) {
        return false;
      }
      // Checks if the root's left child has the correct book
      if (normalshelf.getRoot().getLeft().getData() != two) {
        return false;
      }
      // Inserts a book and checks if the size is correct
      Book three = new Book("The Two Towers", 202, "Tolkien", "JRR");
      normalshelf.insertBook​(three);
      if (normalshelf.size() != 3) {
        return false;
      }
      // Checks if the root's right child has the correct book
      if (normalshelf.getRoot().getRight().getData() != three) {
        return false;
      }
      // Checks if the insertBook method throws an IllegalArgumentException
      try {
        normalshelf.insertBook​(two);
      } catch (IllegalArgumentException e) {
        e.printStackTrace();
        return true;
      } catch (Exception e) {
        e.printStackTrace();
        return false;
      }

      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Checks if the contains methods works correctly
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean testContains() {
    // Reset ID
    Book.resetGenerator();
    try {
      // Creates an empty shelf
      Attribute[] normal = {Attribute.AUTHOR, Attribute.TITLE, Attribute.ID, Attribute.PAGECOUNT};
      BinaryBookshelf normalshelf = new BinaryBookshelf(normal);
      Book three = new Book("The Guardians of the Galaxy", 202, "Name", "Forgotten");
      normalshelf.insertBook​(three);
      if (!normalshelf.contains​(three)) {
        return false;
      }
      Book four = new Book("Oliver Twist", 100, "Dickens", "Charles");
      if (normalshelf.contains​(four)) {
        return false;
      }
      // Constructs a binary tree through shallow copy of the root node from the shelf
      TreeNode<Book> copyshelf = normalshelf.getRoot();
      copyshelf.setLeft(new TreeNode<Book>(four));
      Book five = new Book("Zenith of the world", 200, "Steven", "Aorty");
      copyshelf.setRight(new TreeNode<Book>(five));
      Book six = new Book("Zenith of the world", 200, "Aorty", "Steven");
      copyshelf.getLeft().setLeft(new TreeNode<Book>(six));
      Book seven = new Book("Hitchhikers", 300, "Bippty", "Steven");
      copyshelf.getLeft().getLeft().setRight(new TreeNode<Book>(seven));
      // Checks if the books are in the shelf
      if (!normalshelf.contains​(three)) {
        return false;
      }
      if (!normalshelf.contains​(seven)) {
        return false;
      }
      if (!normalshelf.contains​(four)) {
        return false;
      }
      Book notinshelf = new Book("Dr. Jekyll and Mr. Hyde", 209, "Stevenson", "Robert");
      if (normalshelf.contains​(notinshelf)) {
        return false;
      }
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * 
   * @return
   */
  public static boolean testGetBooksByAuthor() {
    // Reset ID
    Book.resetGenerator();
    try {
      // Creates an empty shelf
      Attribute[] normal = {Attribute.AUTHOR, Attribute.TITLE, Attribute.ID, Attribute.PAGECOUNT};
      BinaryBookshelf normalshelf = new BinaryBookshelf(normal);
      Book three = new Book("The Guardians of the Galaxy", 202, "Name", "Forgotten");
      normalshelf.insertBook​(three);
      ArrayList<Book> one =
          normalshelf.getBooksByAuthor​(normalshelf.getRoot().getData().getAuthor());
      if (one.size() != 1) {
        return false;
      }
      ArrayList<Book> empty = normalshelf.getBooksByAuthor​("Dickens, Charles");
      if (empty.size() != 0) {
        return false;
      }
      // Constructs a binary tree through shallow copy of the root node from the shelf
      TreeNode<Book> copyshelf = normalshelf.getRoot();
      Book four = new Book("Oliver Twist", 100, "Dickens", "Charles");
      copyshelf.setLeft(new TreeNode<Book>(four));
      Book five = new Book("Zenith of the world", 200, "Steven", "Aorty");
      copyshelf.setRight(new TreeNode<Book>(five));
      Book six = new Book("Zenith of the world", 200, "Aorty", "Steven");
      copyshelf.getLeft().setLeft(new TreeNode<Book>(six));
      Book seven = new Book("Hitchhikers", 300, "Dickens", "Charles");
      copyshelf.getLeft().getLeft().setRight(new TreeNode<Book>(seven));
      // Checks if the arrayList has the correct size
      ArrayList<Book> oneauthor = normalshelf.getBooksByAuthor​("Steven, Aorty");
      if (oneauthor.size() != 1) {
        return false;
      }
      ArrayList<Book> twoauthor = normalshelf.getBooksByAuthor​("Dickens, Charles");
      if (twoauthor.size() != 2) {
        return false;
      }
      ArrayList<Book> noauthor = normalshelf.getBooksByAuthor​("Silvia, Pepe");
      if (noauthor.size() != 0) {
        return false;
      }
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Prints true if all the tests run correctly, false otherwise
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(testTreeNode() && testEmptyTree() && testInsertBook() && testContains()
        && testGetBooksByAuthor());
  }
}

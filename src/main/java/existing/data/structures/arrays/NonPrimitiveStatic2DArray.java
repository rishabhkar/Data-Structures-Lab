package existing.data.structures.arrays;

import java.lang.reflect.*;
import java.util.*;

/**
 * Stores a row and column position inside the 2D array.
 *
 * @param row row index
 * @param col column index
 */
record Coordinates(int row, int col) {}

/**
 * Fixed-size generic two-dimensional array wrapper. Stores values in a reflection-created backing
 * array.
 *
 * @param <T> type of element stored in the array
 */
public class NonPrimitiveStatic2DArray<T> {

  int rowSize, colSize;
  T[][] array;

  /**
   * Creates a fixed-size 2D generic array using the given dimensions.
   *
   * @param className runtime type of the elements
   * @param rowSize number of rows in the array
   * @param colSize number of columns in the array
   */
  public NonPrimitiveStatic2DArray(Class<T> className, int rowSize, int colSize) {
    if (rowSize > 0) this.rowSize = rowSize;
    if (colSize > 0) this.colSize = colSize;

    // Reflection is used because Java cannot create generic arrays directly.
    @SuppressWarnings("unchecked")
    T[][] temp = (T[][]) Array.newInstance(className, rowSize, colSize);
    this.array = temp;
  }

  /**
   * Returns the total number of rows.
   *
   * @return configured row size
   */
  public int getRowSize() {
    return this.rowSize;
  }

  /**
   * Returns the total number of columns.
   *
   * @return configured column size
   */
  public int getColSize() {
    return this.colSize;
  }

  /**
   * Checks whether the given 2D array has uneven row lengths.
   *
   * @param arr array to inspect
   * @return true if at least one row has a different length
   */
  public boolean isJagged(T[][] arr) {
    if (arr == null) throw new IllegalArgumentException("Array passed is null.");
    if (arr.length == 0) return false;

    int value = arr[0].length;
    for (T[] row : arr) {
      if (row == null || row.length != value) return true;
    }
    return false;
  }

  /**
   * Returns the backing 2D array stored by this wrapper.
   *
   * @return internal 2D array reference
   */
  public T[][] getArray() {
    return this.array;
  }

  /**
   * Replaces the backing array when the dimensions and type match.
   *
   * @param newArray replacement array to store
   */
  public void setArray(T[][] newArray) {

    if (newArray == null) throw new IllegalArgumentException("Array passed is null.");
    // Only replace the backing array when type and dimensions stay compatible.
    if (this.array.getClass().equals(newArray.getClass())
        && this.rowSize == newArray.length
        && (!isJagged(newArray) && this.colSize == newArray[0].length)) {
      this.array = newArray;
    }
  }

  /**
   * Returns the element stored at the given row and column.
   *
   * @param row row index to read from
   * @param col column index to read from
   * @return value stored at the given position
   */
  public T getElement(int row, int col) {
    if ((row < this.rowSize && row >= 0) && (col < this.colSize && col >= 0)) {
      return this.array[row][col];
    } else throw new IndexOutOfBoundsException("Row or Column passed are out of bounds.");
  }

  /**
   * Stores an element at the given row and column.
   *
   * @param row target row index
   * @param col target column index
   * @param element value to place in the array
   */
  public void setElement(int row, int col, T element) {
    if ((row < this.rowSize && row >= 0) && (col < this.colSize && col >= 0)) {
      this.array[row][col] = element;
    } else throw new IndexOutOfBoundsException("Row or Column passed are out of bounds.");
  }

  /**
   * Returns one full row from the array.
   *
   * @param index row index to return
   * @return row stored at the given index
   */
  public T[] getRow(int index) {
    if (index < this.rowSize && index >= 0) {
      return this.array[index];
    } else throw new IndexOutOfBoundsException("Row Index passed is out of bounds for row size.");
  }

  /**
   * Replaces one full row in the array.
   *
   * @param index row index to replace
   * @param replacementRow row values to store
   */
  public void setRow(int index, T[] replacementRow) {
    if (index < 0 || index >= this.rowSize) {
      throw new IndexOutOfBoundsException("Row Index passed is out of bounds for row size.");
    }
    if (replacementRow == null) {
      throw new IllegalArgumentException("Replacement row passed is null.");
    }
    if (replacementRow.length != colSize) {
      throw new IllegalArgumentException(
          "Replacement row size not matching the existing array's column size.");
    }

    this.array[index] = replacementRow;
  }

  /**
   * Returns one full column from the array.
   *
   * @param index column index to return
   * @return column values collected into a new array
   */
  public T[] getColumn(int index) {
    if (index < 0 || index >= this.colSize) {
      throw new IndexOutOfBoundsException(
          "Column index passed is out of bounds compared to column size.");
    }

    Class<?> componentType = this.array.getClass().getComponentType().getComponentType();

    @SuppressWarnings("unchecked")
    T[] temp = (T[]) Array.newInstance(componentType, rowSize);

    for (int i = 0; i < this.rowSize; i++) {
      temp[i] = this.array[i][index];
    }

    return temp;
  }

  /**
   * Replaces one full column in the array.
   *
   * @param index column index to replace
   * @param replacementColumn column values to store
   */
  public void setColumn(int index, T[] replacementColumn) {
    if (replacementColumn.length == 0) return;
    if (index < this.colSize && index >= 0) {

      for (int i = 0; i < this.rowSize; i++) {
        this.array[i][index] = replacementColumn[i];
      }
    } else
      throw new IndexOutOfBoundsException(
          "Column index passed is out of bounds compared to Column "
              + "size of the existing array");
  }

  /**
   * Checks whether every position in the 2D array is null.
   *
   * @return true if no non-null element is stored
   */
  public boolean isEmpty() {

    for (T[] row : this.array) {
      for (T value : row) {
        if (value != null) return false;
      }
    }
    return true;
  }

  /**
   * Checks whether the given element exists in the 2D array.
   *
   * @param element value to search for
   * @return true if the value is found, otherwise false
   */
  public boolean contains(T element) {
    if (element == null) throw new IllegalArgumentException("Element passed is null.");

    for (T[] row : this.array) {
      for (T value : row) {
        if (value != null && value.equals(element)) return true;
      }
    }

    return false;
  }

  /**
   * Finds the first position of the given element.
   *
   * @param element value to search for
   * @return coordinates of the first match, or (-1, -1) when not found
   */
  public Coordinates indexOf(T element) {

    if (element != null) {
      for (int i = 0; i < rowSize; i++) {
        for (int j = 0; j < colSize; j++) {
          if (this.array[i][j] != null && this.array[i][j].equals(element))
            return new Coordinates(i, j);
        }
      }
    } else throw new IllegalArgumentException("Element provided is null.");

    return new Coordinates(-1, -1);
  }

  /**
   * Finds the last position of the given element.
   *
   * @param element value to search for
   * @return coordinates of the last match, or (-1, -1) when not found
   */
  public Coordinates lastIndexOf(T element) {

    if (element != null) {
      for (int i = rowSize - 1; i >= 0; i--) {
        for (int j = colSize - 1; j >= 0; j--) {
          if (this.array[i][j] != null && this.array[i][j].equals(element))
            return new Coordinates(i, j);
        }
      }
    } else throw new IllegalArgumentException("Element provided is null.");

    return new Coordinates(-1, -1);
  }

  /** Clears the array by setting each position to null. */
  public void clear() {

    for (int i = 0; i < rowSize; i++) {
      for (int j = 0; j < colSize; j++) {
        assert array[i] != null;
        array[i][j] = null;
      }
    }
  }

  /**
   * Fills every position in the array with the same value.
   *
   * @param value value to store in each position
   */
  public void fill(T value) {
    for (int i = 0; i < rowSize; i++) {
      for (int j = 0; j < colSize; j++) {
        assert array[i] != null;
        array[i][j] = value;
      }
    }
  }

  /**
   * Swaps the values stored at two coordinates.
   *
   * @param index1 first position to swap
   * @param index2 second position to swap
   */
  public void swap(Coordinates index1, Coordinates index2) {

    if ((index1.col() < colSize && index1.col() >= 0)
        && (index1.row() < rowSize && index1.row() >= 0)
        && (index2.col() < colSize && index2.col() >= 0)
        && (index2.row() < rowSize && index2.row() >= 0)) {

      T temporary = this.array[index1.row()][index1.col()];
      this.array[index1.row()][index1.col()] = this.array[index2.row()][index2.col()];
      this.array[index2.row()][index2.col()] = temporary;
    } else throw new IndexOutOfBoundsException("Passed index/indexes are out of bound.");
  }

  /** Prints each element together with its row and column index. */
  public void print() {

    for (int i = 0; i < rowSize; i++) {
      for (int j = 0; j < colSize; j++) {
        assert array[i] != null;
        System.out.println("Element at Row " + i + " and Column " + j + " is : " + array[i][j]);
      }
    }
  }

  /**
   * Copies the stored values into the provided array.
   *
   * @param newArray target array that receives the values
   * @return shallow clone of the backing array
   */
  public T[][] copyArray(T[][] newArray) {

    if (this.array.getClass().equals(newArray.getClass())
        && this.rowSize == newArray.length
        && (!isJagged(newArray) && !isJagged(array) && this.colSize == newArray[0].length)) {

      // Copy each stored value into the provided target array.
      for (int i = 0; i < rowSize; i++) {
        for (int j = 0; j < colSize; j++) {
          newArray[i][j] = this.array[i][j];
        }
      }

    } else throw new IllegalArgumentException("Parameters between both arrays do not match.");

    return array.clone();
  }

  /**
   * Counts how many positions currently store non-null values.
   *
   * @return number of filled positions
   */
  public int elementCount() {

    int count = 0;

    for (int i = 0; i < rowSize; i++) {
      for (int j = 0; j < colSize; j++) {
        if (this.array[i][j] != null) count++;
      }
    }

    return count;
  }

  public T[] boundaryTraversal() {

    T[] temp = (T[]) Array.newInstance(this.array.getClass().getComponentType().getComponentType(), (rowSize * 2) + (colSize * 2 - 4));

    int row = 0;
    int col = 0;
    int tempCounter = 0;
    boolean horizontal = true;
    boolean verticalDecrease = false;
    do {

      if (col == colSize) {
        col--;
        row++;
        horizontal = false;
      } else if (row == rowSize && col == colSize-1) {
        row--;
        col--;
        horizontal = true;
      } else if (col < 0) {
        col++;
        row--;
        horizontal = false;
        verticalDecrease = true;
      }

      if (row == 0 && col < colSize && horizontal) {
        temp[tempCounter++] = this.array[row][col];
        col++;
      }
      else if (row != 0 && row < rowSize && !horizontal && !verticalDecrease) {
        temp[tempCounter++] = this.array[row][col];
        row++;
      }
      else if (row == rowSize-1 && horizontal) {
        temp[tempCounter++] = this.array[row][col];
        col--;
      }
      else if (col == 0 && row > 0 && !horizontal && verticalDecrease) {
        temp[tempCounter++] = this.array[row][col];
        row--;
      }

    } while (tempCounter < temp.length);

    return temp;
  }
}

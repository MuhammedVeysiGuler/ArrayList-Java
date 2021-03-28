package arraylist;

public class ArrayList<T> {
  private T[] array = null;
  private int length = 14;
  private int index = 0;

  public ArrayList() {
    this.array = this.createArray();
  }

  private T[] createArray() {
    this.length *= 2;
    return (T[]) new Object[this.length];
  }

  private void copyPreviousArray(T[] newArray) {
    for (int i = 0; i < this.index; i++) {
      newArray[i] = this.array[i];
    }
  }

  private boolean checkArrayFullness() {
    if (this.index == this.length) {
      return true;
    } else {
      return false;
    }
  }

  public void add(T value) {
    if (this.checkArrayFullness()) {
      this.doubleArray();
    }

    this.array[this.index] = value;

    this.index++; 
  }

  private void doubleArray() {
      T[] newArray = createArray();
      copyPreviousArray(newArray);
      this.array = newArray;
  }

  public void insert(int index, T value) {
    if (this.checkArrayFullness()) {
      this.doubleArray();
    }

    if (this.index >= index) {
      for (int i = this.index - 1; i >= index; i--) {
        this.array[i + 1] = this.array[i];
      }

      this.array[index] = value;
    } else {
      this.add(value);
    }

    this.index++;
  }

  public int count() {
    return this.index;
  }

  public T get(int index) {
    return this.array[index];
  } 

  public void set(int index, T value) {
    this.array[index] = value;
  }

  public void remove(T value) {
    int index = 0;

    if ((index = this.indexOf(value)) != -1) {
      for (int i = index; i < this.index - 1; i++) {
        this.array[i] = this.array[i + 1];
      }

      this.index--;
    }
  }

  public boolean contains(T value) {
    for (int i = 0; i < this.index; i++) {
      if (this.array[i] == value) {
        return true;
      }
    }

    return false;
  } 

  public int indexOf(T value) {
    for (int i = 0; i < this.index; i++) {
      if (this.array[i] == value) {
        return i;
      }
    }

    return -1;
  }
}


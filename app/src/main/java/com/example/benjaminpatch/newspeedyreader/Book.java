package com.example.benjaminpatch.newspeedyreader;


/**
 * Represents a book including the book name and
 * the words per line of text in that book.
 * Will help to determine how fast they should read
 * each line of text for this book.
 */
public class Book {
    String name;
    int wordsPerLine;

    /**
     * the book constructor taking the book name and words per line of text
     * @param newName the name of the book
     * @param newPages the pages per line of text in this book
     */

    public Book(){
        name = " ";
        wordsPerLine = 0;
    }

    public Book(String newName, int newPages){
        setName(newName);
        setWordsPerLine(newPages);
    }

    //have to make some changes in order to push this...
    public String getName(){
        return name;
    }

    /**
     * a common set method
     * @param newName a new name for the book
     */

    public void setName(String newName){
        name = newName;
    }

    /**
     * A simple return method.
     * @return the pages per line of text in this specific book
     */
    public int getPagesPerLine(){
        return wordsPerLine;
    }

    /**
     * Sets the statistic of how many words per
     * line ot text there are in this book
     * @param newWPL returns the words per line for this specific book.
     */
    public void setWordsPerLine(int newWPL){
        wordsPerLine = newWPL;
    }

    public String toString(){
        //Book = nameOfBook^wordsPerPage

        String string =  new String();
        string = getName();
        string += "^" + String.valueOf(wordsPerLine);

        return string;
    }

    public void fromString(String string) {
        //Book = nameOfBook^wordsPerPage (done in the book.toString() method
        String[] parts = string.split("^");
        setName(parts[0]);
        setWordsPerLine(Integer.parseInt(parts[1]));
    }
}

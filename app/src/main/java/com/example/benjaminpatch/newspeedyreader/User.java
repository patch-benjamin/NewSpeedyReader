package com.example.benjaminpatch.newspeedyreader;

import java.util.ArrayList;

/**
 * a class for each user. contains the books they are reading,
 * the highest level they have completed, and their name.
 */
public class User {
    String firstName;
    String lastName;
    int highestLevel;
    ArrayList<Book> books;

    public String getName(){
        return firstName + lastName;
    }

    public void setName(String newFirst, String newLast){
        firstName = newFirst;
        lastName = newLast;
    }

    /**
     * a simple setter
     * @param newHighestLevel the highest level completed by this user
     */
    public void setHighestLevel(int newHighestLevel){
        highestLevel = newHighestLevel;
    }

    /**
     * a simple getter.
     * @return return the int of the highest level completed by this user.
     */
    public int getHighestLevel(){
        return highestLevel;
    }

    public void addBook(String bookName, int pagesPerLine){
        Book book = new Book(bookName, pagesPerLine);
        books.add(book);
    }
    public ArrayList<Book> getBooks(){
        return books;
    }

    public String toString(){
        //UserName~HighestLevel~Book1~Book2 etc.
        //UserName = firstName_lastName
        //Book = nameOfBook^wordsPerPage (done in the book.toString() method
        //Example: Benjamin_Patch~12~odessey^45~Book_of_Mormon^15

        String string = new String();
        string = firstName + "_" + lastName;
        string += "~" + String.valueOf(getHighestLevel());
        for (int i = 0; i < books.size(); i++){
            string += "~" + books.get(i).toString();
        }

        return string;
    }

    public void fromString(String string){
        //UserName~HighestLevel~Book1~Book2 etc.
        //UserName = firstName_lastName

        String[] parts = string.split("~");
        String[] name = parts[0].split("_");
        //name
        firstName = name[0];
        lastName = name[1]; // check to make sure there is a last name?
        //highestLevel
        highestLevel = Integer.parseInt(parts[1]);
        //list of books
        for(int i = 2; i < parts.length; i++){
            Book temp = new Book();
            temp.fromString(parts[i]);
            books.add(temp);
        }
    }
}


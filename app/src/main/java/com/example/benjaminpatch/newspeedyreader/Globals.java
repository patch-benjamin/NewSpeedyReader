package com.example.benjaminpatch.newspeedyreader;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by benjaminpatch on 7/17/15.
 */
public class Globals {

    private static ArrayList<User> users = new ArrayList<User>();
    private static User user = new User();
    private static int userID = 0;

    public Globals(){
//        users = new ArrayList<User>();
//        user = new User();
        userID = 0;

    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User nUser) {
        Globals.user = nUser;
        if(users.contains(nUser)) {
            userID = (users.indexOf(nUser));
            user = users.get(userID);
        } else{
            Log.i("testing", "user set with new user, not a previously added user... DANGER!");
            users.add(nUser);
            userID = (users.indexOf(nUser));
            user = users.get(userID);
        }
    }

    public static int getUserID() {
        return userID;
    }

    public static void setUserID(int userID) {
        Globals.userID = userID;
        user = users.get(userID);
        Log.i("userID", "ID = " + userID);
        MainActivity.saveData();
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User getUser(int index) {
        return users.get(index);
    }

    public static void setUsers(ArrayList<User> users) {
        Globals.users = users;
        MainActivity.saveData();
    }

    public static void addUser(User newUser){
        if(!users.contains(newUser)) {
            Log.i("testing", "before addUser: " + getUsers().toString());
            users.add(newUser);
            Log.i("testing", "1: " + Globals.getUsers().toString());

            userID = (users.indexOf(newUser));
            Log.i("testing", "2: " + Globals.getUsers().toString());
            user = users.get(userID);
            Log.i("testing", "3: " + Globals.getUsers().toString());
            MainActivity.saveData();
            Log.i("testing", "after saved: " + Globals.getUsers().toString());
        }
    }
    public static void addUser(User newUser, boolean startup){
        boolean userFound = true;
        if(users.isEmpty()){
            users.add(newUser);
            userID = (users.indexOf(newUser));
            user = users.get(userID);
            Log.i("testing", "users is empty, added new user: " + getUsers().toString());
        } else {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getName().equals(newUser.getName())) {
                    userFound = true;
                    break;
                } else {
                    userFound = false;
                }
                Log.i("testing", "round " + i + " completed.");
            }
            Log.i("testing", "for loop finished.");
            if(!userFound){
                users.add(newUser);
                userID = (users.indexOf(newUser));
                user = users.get(userID);
            }
        }


    }
}

package no.hvl.dat153.planner;

import java.util.ArrayList;

public class Database {

    private ArrayList<User> database;

    public Database (ArrayList<User> database) {
        this.database = database;
    }

    public ArrayList<User> getDatabase() {
        return database;
    }

    public void setDatabase(ArrayList<User> database) {
        this.database = database;
    }

    public void leggTilBruker(User u) {
        database.add(u);
    }

    public boolean userExist(String username, String password) {
        boolean loggedIn = false;

        for (User u : database) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                loggedIn=true;
            }
        }

        return loggedIn;
    }

}

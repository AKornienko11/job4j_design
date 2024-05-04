package ru.job4j.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        HashMap<User, Object> map = new HashMap<>(10);
        Calendar birthday = new GregorianCalendar(1990, 6, 11);
        User user1 = new User("Alex", 1, birthday);

        int hashCode1 = user1.hashCode();
        System.out.println("hashCode user1 " + hashCode1);
        int hash1 = hashCode1 ^ (hashCode1 >>> 16);
        System.out.println("hash user1 " + hash1);
        int buket1 = hash1 & 10;
        System.out.println("Buket user1 " + buket1);
        User user2 = new User("Alex", 1, birthday);
        int hashCode2 = user2.hashCode();
        System.out.println("hashCode user2 " + hashCode2);
        int hash2 = hashCode2 ^ (hashCode1 >>> 16);
        System.out.println("hash user2 " + hash2);
        int buket2 = hash2 & 10;
        System.out.println("Buket user2  " + buket2);
        map.put(user1, new Object());
        map.put(user2, new Object());

        for (User res : map.keySet()) {
            System.out.println(res);
        }

    }

    @Override
    public String toString() {
        return "User{" + "name='" + name
                + '\''
                + ", children=" + children
                + ", birthday=" + birthday
                + '}';
    }
}

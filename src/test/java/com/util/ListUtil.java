package com.util;

import com.DemoTestApplication;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SpringBootTest(classes = DemoTestApplication.class)
class ListUtilTest {

    public static void main(String[] args) {
        new ListUtilTest().testListSort();
    }

    @Test
    void testListSort(){
        User u1 = new User(1, "熊大", "20100304");
        User u2 = new User(2, "熊二", "20090305");
        User u3 = new User(3, "椰果", "20200506");
        User u4 = new User(4, "柒柒", "20201212");

        u4.testThis();

        List<User> userList = new ArrayList<>();
        userList.add(u4);
        userList.add(u1);
        userList.add(u3);
        userList.add(u2);

        forEachList(userList);
        listSort(userList);
        forEachList(userList);

    }

    class User{
        int year;
        String name;
        String birthday;

        public User() {
        }

        public User(int year, String name, String birthday) {
            this.year = year;
            this.name = name;
            this.birthday = birthday;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public void testThis(){
            System.out.println(this);
        }

        @Override
        public String toString() {
            return "User{" +
                    "year=" + year +
                    ", name='" + name + '\'' +
                    ", birthday='" + birthday + '\'' +
                    '}';
        }
    }

    private void listSort(List<User> listData){
        Collections.sort(listData, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
//                // 按照 year 降序排序
//                return o2.getYear() - o1.getYear();
                // 按照 生日 降序排序
                return Integer.parseInt(o2.getBirthday()) - Integer.parseInt(o1.getBirthday());
            }
        });
    }

    private void forEachList(List<User> list){
        System.out.println("---------- list for each ----------");
        for (User u:list){
            System.out.println(u.toString());
        }
        System.out.println("---------- ---- end ---- ----------");
    }

}

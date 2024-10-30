package com.exam;

public class ConnectionEx01 {
    public static void main(String[] args) {
        System.out.println("시작");
        //드라이버 이름 :org.mariadb.jdbc.Driver
        //동적으로 클래스로딩
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("드라이버 로딩 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("에러" + e.getMessage());
        }
        System.out.println("끝");
    }
}

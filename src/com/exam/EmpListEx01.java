package com.exam;

import java.sql.*;

public class EmpListEx01 {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/sample";
        String user = "root";
        String password = "123456";

        Connection conn = null;
        Statement stmt = null;

        ResultSet rs = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("드라이버 성공");
            conn = DriverManager.getConnection(url, user,password);
            System.out.println("데이터베이스 연결");

            stmt = conn.createStatement();


            String sql = "select empno, ename, sal, sal*12+ifnull(comm, 0) annsal from  emp where deptno =10";
            rs =stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.print(rs.getString("empno") + "\t");
                System.out.print(rs.getString("ename") + "\t");
                System.out.print(rs.getString("sal")+ "\t");
                System.out.println(rs.getString("annsal"));

            }
        }catch (SQLException e) {
            System.out.println("에러 " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("에러" + e.getMessage());
        } finally {
            if( rs != null) { try{rs.close();} catch (SQLException e) {}}
            if( stmt != null) { try {stmt.close();} catch (SQLException e) {}}
            if(conn != null) { try { conn.close();} catch (SQLException e) {}}
        }
    }
}

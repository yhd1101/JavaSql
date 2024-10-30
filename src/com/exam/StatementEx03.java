package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementEx03 {
    public static void main(String[] args) {
        System.out.println("시작");

        String url ="jdbc:mariadb://localhost:3306/sample";
        String user = "root";
        String password = "123456";

        Connection conn =null;
        //Statement = 자바.sql
        Statement stmt = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("드라이버 로딩 성공");

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스 연결 성공");

            stmt = conn.createStatement();

            // DDL
            //String sql ="create table dept3 (deptno int(2), dname varchar(14), loc varchar(13))";
            StringBuilder sb = new StringBuilder();
            sb.append("create table dept4 (");
            sb.append("deptno int(2),");
            sb.append("dname varchar(14),");
            sb.append("loc varchar(13)");
            sb.append(")");
//            int result = stmt.executeUpdate(sql);
            int result = stmt.executeUpdate(sb.toString());


            //result 영향받은 행수 ex) update를 했을때 영향받은 행수에따라 결과가 나옴.
            System.out.println("쿼리 실행 성공: " + result);

        }catch (SQLException e) {
            System.out.println("에러" + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("에러" + e.getMessage());
        } finally {
            if( stmt != null) { try {stmt.close();} catch (SQLException e) {}}
            if(conn != null) { try { conn.close();} catch (SQLException e) {}}
        }

        System.out.println("끝");
    }
}

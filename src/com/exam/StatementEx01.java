package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementEx01 {
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
            //Statement + SQL
            // select => 리턴
            // 기타전부 => 리턴없음
            //      insert / update / delete

            stmt = conn.createStatement();
            // select 이외의 모든 sql문을 사용함 update만 쓰는거 아님.
           // stmt.executeUpdate("insert into dept2 values (51, '영업부','부산')");

//            String sql = "insert into dept2 values(52, '생산부','목포')";
//            stmt.executeUpdate(sql);
            String deptno = "53";
            String dname = "연구부";
            String loc = "대전";


            System.out.println("쿼리 실행 성공");

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

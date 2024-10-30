package com.exam;

import java.sql.*;

public class EmpListEx02 {
    public static void main(String[] args) {
        // 10번부서의 사원번호, 사원이름, 급여, 입사일자를 출력
        //단 입자일자 (YYYY/ MM /DD);
        //방법 1. sql 문에 처리
        //date_format
        //방법 2. java api를 통해서 처리
        //replaceall

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

            //date format
            String sql = "select empno, ename, sal, hiredate from  emp where deptno =10";
//            String sql = "select empno, ename, sal ,date_format( hiredate, '%Y/%m/%d') hiredate from emp where deptno =10";
            rs =stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.print(rs.getString("empno") + "\t");
                System.out.print(rs.getString("ename") + "\t");
                System.out.print(rs.getString("sal")+ "\t");
                //repalceAll 방법도있다.
                System.out.println(rs.getString("hiredate").replaceAll("-", "/"));
                // System.out.println(rs.getString("hiredate"));
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

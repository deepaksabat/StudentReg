package com.student.doa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.student.been.Student;
public class StudentDoa {
	public static Connection getConnection()
	{
		Connection conn= null;
		try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","deepak");  
	    }catch(Exception e){System.out.println(e);}  
	    return conn;
	}
	public static int save(Student s){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"insert into students(name,address,sex,phno) values(?,?,?,?)");  
	        ps.setString(1,s.getName());    
	        ps.setString(2,s.getAddress());  
	        ps.setString(3,s.getSex());  
	        ps.setString(4,s.getPhno());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}
	public static int update(Student s){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"update students set name=?,address=?,sex=?,phno=? where id=?");  
	        ps.setString(1,s.getName());  
	        ps.setString(2,s.getAddress());  
	        ps.setString(3,s.getSex());  
	        ps.setString(4,s.getPhno());   
	        ps.setInt(5,s.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}
	public static int delete(Student s){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from students where id=?");  
	        ps.setInt(1,s.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}
	public static List<Student> getAllRecords(){  
	    List<Student> list=new ArrayList<Student>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from students");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            Student u=new Student();  
	            u.setId(rs.getInt("id"));  
	            u.setName(rs.getString("name")); 
	            u.setAddress(rs.getString("address"));
	            u.setSex(rs.getString("sex"));  
	            u.setPhno(rs.getString("phno"));  
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	} 
	public static Student getRecordById(int id){  
	    Student u=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from students where id=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            u=new Student();  
	            u.setId(rs.getInt("id"));  
	            u.setName(rs.getString("name")); 
	            u.setAddress(rs.getString("address"));
	            u.setSex(rs.getString("sex"));  
	            u.setPhno(rs.getString("phno"));  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}
}
	



package com.mini1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.cart.TableCart;

public class LoginIdentification {

	public void loginmail() {
		TableCart tc=new  TableCart();
		try {
			Scanner scan = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			System.out.println("Enter your email");
			String mail = scan.next();
			PreparedStatement prp = con.prepareStatement("SELECT * FROM user.record where gmail='" + mail + "'");

			// System.out.println(prp);
			ResultSet rs = prp.executeQuery();
			if (rs.next()) {
				System.out.println("Email Checked!");
				//tc.usersCarttablecreation(mail);

			} else
				System.out.println("Please check mail or login details  ");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void passwordcheck() {
		
		try {
			Scanner scan = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			System.out.println("Enter your Password");
			String pass = scan.next();

			PreparedStatement prp = con.prepareStatement("SELECT * FROM user.record where password='" + pass + "'");

			ResultSet rs = prp.executeQuery();

			if (rs.next()) {

				System.out.println("Login Scuessfull");
				
				

			} else
				throw new forloginExpection("Invalid Password or mail");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public static void main(String[] args) throws SQLException {
		LoginIdentification ll = new LoginIdentification();

	}

}

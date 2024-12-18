package com.quizapp.display;

import java.util.Scanner;

import com.quizapp.Question;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminDisplay {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		dispalyScoreByAsending();
		//studentScoreUsindId();
	}

	public static void dispalyScoreByAsending() {
		String url = "jdbc:mysql://localhost:3306/quizdb";
		String user = "root";
		String password = "Giridhar@96";
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			String query = "SELECT r.user_id, u.username, r.score " + "FROM results r "
					+ "JOIN students u ON r.user_id = u.id " + "ORDER BY r.score ASC";
			ResultSet resultSet = statement.executeQuery(query);

			System.out.println("User ID\tUsername\tScore");
			while (resultSet.next()) {
				int userId = resultSet.getInt("user_id");
				String username = resultSet.getString("username");
				int score = resultSet.getInt("score");
				System.out.println(userId + "\t" + username + "\t" + score);
			}

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void studentScoreUsindId() {
		
		
	}

	

	public static void addQuetionIntoDatabase() {
		Question question = new Question();
		question.inputQuetion();

	}

	public void adminInfo() {
		System.out.println("\r\n" + "1. Display all students score as per ascending order \r\n"
				+ "2. Fetch student score by using id \r\n" + "3. Add question with 4 options into database");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			dispalyScoreByAsending();
			break;
		case 2:
			studentScoreUsindId();
			break;
		case 3:
			addQuetionIntoDatabase();
			break;
		}

	}
}

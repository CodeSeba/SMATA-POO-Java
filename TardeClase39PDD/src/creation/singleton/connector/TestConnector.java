package creation.singleton.connector;

import java.util.Scanner;

public class TestConnector {
	
	public static void main(String[] args) throws Exception {
		Connector.getConnection().createStatement().execute(
				"drop database if exists test"
		);
		new Scanner(System.in).nextLine();
		Connector.getConnection().createStatement().execute(
				"create database test"
		);
		new Scanner(System.in).nextLine();
		Connector.getConnection().createStatement().execute(
				"use test"
		);
		new Scanner(System.in).nextLine();
	}
}

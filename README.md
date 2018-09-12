# Java Trit Chat Application
Made using Eclipse and Oracle, Trit is a chat application which supports groups to help people communicate with each other.

# Tools Used
- Eclipse
- Oracle Database
- Java Swing

# Usage
1. Open the project in eclipse.
2. Configure build path of the project and add the external jars "jgoodies-forms-1.8.0.jar", "ojdbc7.jar", and "miglayout15-swing.jar".
3. Open Oracle and import all the database tables from the "/database-tables" folder into your database.
4. Open DBConn.java and go to line 14. Change the arguments of the DriverManager.getConnection function according to your database details. Syntax: DriverManager.getConnection("jdbc:oracle:thin:@*Host*:*Port Number*:*Database Name*", *Database User*, *Database Password*)
5. Open MainChat.java and run the file to start the application.

# Features
- Group chats
- User friendly and modern looking GUI
- Error handling
- User information management
- Each message time and date
- And much more

# Test Users
Username: username1 <br />
Password: userpass <br />
Username: username2 <br />
Password: userpass2

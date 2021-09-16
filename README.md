# Preparing SQL Server for application connections

There are two methods when connection to a SQL Server: Windows Authentication mode and SQL Server and Windows Authentication mode (also referred to as mixed mode). Windows Authentication mode enables Windows Authentication and disables SQL Server Authentication. Mixed mode enables both Windows Authentication and SQL Server Authentication. 

Connecting with Windows Authentication mode requires a Windows user account and SQL server validates the account through the operating system. A connection to SQL Server that uses Windows Authentication is the most secure of the two and is also referred to as a trusted connection. User accounts can be created at domain level, and user administration is simpler. 

When using SQL Server Authentication, logins are created in SQL Server that are not based on Windows user accounts. Both the username and the password are created by using SQL Server and stored in SQL Server. Users connecting using SQL Server Authentication must provide their credentials (login and password) every time that they connect.

The major disadvantage in this approach is that the username and password must be sent over the network when connection to the SQL Server, and because of that client applications often store credentials either in configuration files or in the code. This introduces an attack point for malicious adversaries to exploit.

However, it is sometimes necessary to use mixed mode in cases where a windows authentication approach is not applicable. In such a case you must also create a SQL Server login and a database user with appropriate rights.

## Set SQL Server authentication to mixed mode

First you should enable mixed mode on your SQL Server by following these few steps. 

1.	In Object Explorer right click on the database server and select Properties.
1.	In the Server Properties dialog select the Security page and ensure that SQL Server and Windows Authentication mode is selected.
1.	Click OK

It is now possible to logon to the SQL Server with both a domain user and credentials created on the server. So, the next step is to create a login on the database server.

## Create Login

If you expand the Security folder and the Logins folder in Object Explorer, you can see a list of login credentials for the database server (Figure 1). You may not have the same list as shown here, but something similar. Most of the logins are created in the installation process and are used by system functions.

The sa login is a little special. It has administrative rights on the server and should only be used by system administrators. If you logon with the sa login, you are allowed to do everything which is not something we would be interested in. Imagine an application that handles the employees in a company, that also can access all other databases on the server, change their schemas and manipulate their data. It does not take a hacker genius to exploit such a security flaw. 

The little red cross on the sa login means it is disabled, as it should also be on your database server. If it is not, just right click on it and select Properties and in the Login Properties dialog on the Status page you can mark the Disabled radio button, click OK and now your SQL Server is safe.

The next step is to create a more secure login.

1.	Right click on the Logins folder and select New Login.

1.	In the Login – New dialog on the General page you should write a name for the login, select SQL Server authentication, and provide and confirm the password. You can uncheck the Enforce password policy if you do not want the password to comply. (Since this login is for an application and not a user, I actually recommend unchecking this option. Just make sure your password is long and you should be ok)

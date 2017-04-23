As explained in the demo, we have divided our project into 3 separate modules:

1. Customer Module(Nathan Morgenstern, Shehpar Sohail, Fahd Humayun)


2. Manager Module(Raphaelle Marcial, Ama Freeman)


3. Kitchen/Waiter Module (Alex Dewey, Dwayne Anthony)


At the end, these modules will be integrated together to form the Zestware System.



This read me will describe how to run the codes for each of the respective modules




*******************************************************************************
***
************************* Customer Module ****************************************
************************************************************************
**********

For the first demo, we have partially implemented the Customer Table Screen(CTS) 
and the Customer Welcome Screen(CWS). The main function for the CTS that was focused

on is the BitcoinPayment. Additionally, a rough overall interface was developed to 
include 
the options: Place Order, Make Payment, Call Assistance, and Entertainment. 
Furthermore,
 database connection was added to the CustomerTableScreenSetup for the 
waiters/host when 
they are first setting up the software at the tables.



To Run the Customer Table Screen For LINUX/MAC OS (the file is in runnable jar format):
type into the terminal:

cd ZestWare/demo_1/Customer/CustomerTableScreen

java -jar CTS.jar



The portions of the Customer Welcome Screen(CWS) that were implemented were:
 NewReservation, 
Floor Mapping System(FMS), Updating 

and linking with mySQL database (online server - AWS RDS).
The screenshots of the database tables (while testing and running the software) are attached.
The GUI has been attempted to be made similar to the screen mock ups provided in the prior
reports submitted. 

To Run the Customer Welcome Screen For LINUX/MAC OS (the file is in runnable jar format):
type into the terminal:


cd ZestWare/demo_1/Customer/CustomerWelcomeScreen

java -jar ZestWareCWS.jar

Alternatively the coding has been done and implemented in Eclipse Java, so, the entire folder
can be downloaded and run from the eclipse. 






*******************************************************************************
***
************************* Manager Module  ****************************************
*******************************************************************************
***

The Zestware Manager Portal is a desktop website portal 
which makes the tasks of a restaurant manager simpler.


The manager portal was designed and coded by Raphaelle
Marcial and Ama Freeman.
 
The Manager Portal was tested by
hosting the web application
 using a localhost program called XAMPP. Please download and 
install the XAMPP program in order to host the Zestware 
Manager Portal. It is recommended to follow this tutorial
 online, for optimal download, up to minute 4:30 
(https://www.youtube.com/watch?v=xdvVKywGlc0). For the test,
 access to the database
will require the username and password 
you have chosen. However, in order to avoid issues, set the 
username to
"root" and the password to "somethingstupid" 
temporarily for use with the program. 

Once XAMPP has been installed,
clone the Manager Branch into
 the "htdocs" folder located in the following path: 
"C:\xampp\htdocs"

Furthermore,
within the "htdocs" folder, cut and paste the 
"mysqli_connect.php" file into the "xampp" folder
located here: 
"C:\xampp"

 Now, with xampp running, go to the following link in your browser:
"http://localhost:1234/phpmyadmin/"
and log in with the credentials:
 Username = root
 Password = somethingstupid 

Click to create a new database and
choose the import option in the
 options bar. Within the path "C:\xampp\htdocs" is a file called
 "zestware.sql".
Import this file to create the database for testing. 

Now the system should be ready for testing. Within your
browser, 
run this link: 
"http://localhost:1234/startbootstrap-simple-sidebar-gh-pages/login.php"

 From here you
can test any of the employees from the employee
 database table by typing in their last name, which is their
username, and their password will be their 4 digit pin number.
 A successful login will send the user to the
Employee or Manager 
Portal. Clicking "Toggle Menu" will open the side menu where 
most options are accessible.
The permissions depend on the type
 of employee that logged in. The manager will have more options 
than any other
employee. 

Please enjoy the program!





*******************************************************************************
**
********************  Kitchen/Waiter Module   ***********************************
*******************************************************************************

**

How to run the Kitchen Program 
1. Open the kitchen folder in a java IDE 

2. Compile and run App.java 

3. Wait for keypad to pop up

4. Type in 5 numbers 

6. Hit the OK button on the button right of the keypad 

7. Click the Chef tab on the top right 

8. Select and delete items if need be 

9. Cycle between the Clock in and Chef tab to obsever any updates 


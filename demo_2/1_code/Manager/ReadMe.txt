Zestware

Manager Portal

README

The Zestware Manager Portal is a desktop website portal 
which makes the tasks of a restaurant manager simpler. 

The manager portal was designed and coded by Raphaelle
Marcial and Ama Freeman.

No compiling of source code is necessary as the project 
is hosted on a third party server. The employee hub is 
a website application written in HTML, CSS, Javascript, 
and PHP.

No runnable file is necessary.

Authentication credentials for a manager and general 
employee are located below.

Log in Credentials for Website:
Manager = Jane Doe 
	(Username = Doe = Last Name; Password = Pin = 2219)
General Employee (Waiter, Chef, Busboy) = Gil Martinez 
	(Username = Martinez = Last Name; Password = Pin = 9998)
	
Employee Types:
M = manager
W = waiter/waitress
B = Busboy
C = Chef

Files:
/mPortal.php				Manager Portal
/startbootstrap-simple-sidebar-gh-pages/absence.php		Absence Table
/startbootstrap-simple-sidebar-gh-pages/surveyTable.php	Survey Table where Manager can sort according to ratings
/employees.php											Employee Table where Manager can create new shifts and calculate wages
/inventoryIndex.php										Inventory Table where Manager can delete items and sort them alphabetically
/music.php				Spotify Music Integration
/startbootstrap-simple-sidebar-gh-pages/shifts.php		Shift Table which automatically calculates employee wages
/finances.php											Finance Table where Manager can create new accounts to organize payments

/startbootstrap-simple-sidebar-gh-pages/login.php		Employee login screen
/startbootstrap-simple-sidebar-gh-pages/logout.php		Employee logout, which directs to the login screen
/mysqli_connect.php										Establishes connection to database
/script-complete.js										Javascript for music.php

/index.html													Directs user to login.php			
/notes.svg													Picture of music note used for music.php			
/startbootstrap-simple-sidebar-gh-pages/mysqli_connect.php	Establishes connection to database

/bootstrap.css									css formating
/bootstrap.min.css								css formating
/simple-sidebar.css								css formating
/glyphicons-halflings-regular.eot				fonts
/glyphicons-halflings-regular.sbg				fonts
/glyphicons-halflings-regular.ttf				fonts
/glyphicons-halflings-regular.woff				fonts
/glyphicons-halflings-regular.woff2				fonts
/bootstrap.js									javascript for bootstrap
/bootstrap.min.js								javascript for bootstrap
/jquery.js										javascript for bootstrap
/package.json									json files for bootstrap

/delete.php				Allows Manager to delete inventory item.
/addEmployee.php		Allows manager to add a new employee to the restaurant.
/addInventoryItem.php	Allows manager to add a new inventory item to the restaurant system.
/employeeAdded.php		Confirms addition of new employee if successful.
/itemAdded.php			Confirms addition of new item if successful.
/getEmployeeInfo.php	Gets details on employees working at the restaurant.

temp.css														General styling template for mobile optimization
temp2.css														General styling template for mobile optimization
temp3.css														General styling template for mobile optimization
/startbootstrap-simple-sidebar-gh-pages/temp.css				General styling template for mobile optimization
/startbootstrap-simple-sidebar-gh-pages/temp2.css				General styling template for mobile optimization
/startbootstrap-simple-sidebar-gh-pages/temp3.css				General styling template for mobile optimization
/startbootstrap-simple-sidebar-gh-pages/survey.css				General styling template for mobile optimization
/startbootstrap-simple-sidebar-gh-pages/login.css				General styling template for mobile optimization
/style.css														General styling template for music.php

Image Files:
/buttons/AbsenceReport.png
/buttons/EditInformation.png
/buttons/EmployeeTable.png
/buttons/Finances.png
/buttons/Inventory.png
/buttons/LogOut.png
/buttons/Music.png
/buttons/RatingHL.png
/buttons/RatingLH.png
/buttons/ReportAbsence.png
/buttons/ShfitTable.png
/buttons/Submit.png
/buttons/Survey.png
/buttons/SurveyResults.png
/buttons/zesty.png
/buttons/zesty.svg
/buttons/zesty1.svg

Database Table Details:
absence		Database table containing employee submitted absence reports. Visible only from Manager screen. Columns: firstName, lastName, date (date of possible absence), comment (reason for absence), type (type of employee being absent)
employees	Database table containing details of hired employees of the restaurant. Columns: first (first name of employee), lastName (last name of employee), pin (unique employee pin number), hourlyWage (amount employee makes per hour working), type (type of employee), totalWage
finances	Database table of restaurant's financial accounts, detailing amounts of the restaurant. Columns: Account (name of the monetary account), AccountNumber (unique account number for the account), AccountType (type of the account, can be either checking or savings), Total (amount of money in the account)
inventory	Database table detailing inventory items of the restaurant. Columns: itemID (unique identification number for item), itemName (name of the inventory item), unitMeasurement (measurement for the item per unit), itemCostPerUnit (the cost per unit of the item)
shifts		Database table of employee shifts. Columns: firstName (first name of employee), date (date of shift for employee), clockIn (clock in time for when employee starts shift), calculatedWage (amount made after shift is complete)
survey		Database table of submitted surveys from customers. Columns: surveyID (unique identification number of submitted survey), rating (customer submitted star rating), time (time survey was submitted), comment (comment left by customer), managerResponse (manager's response to the submitted survey)

Manager Page:
	Absence Report: List's employee submitted absence reports
	Survey Results: List's surveys posted by employees and customers
		-Rating Low to High: Sorts list by rating from lowest to highest rating
		-Rating High to Low: Sorts list by rating from highest to lowest rating
	Employee Table: List relevant details about employees of the restaurant
		-Calculate Total Wage: Calculates the total wage of an input employee
			-Any period may be chosen. Any date my be chosen. Suggested Employee input: Janice
		-New Shift: Adds a new shift for a chosen employee
			-Select any future date from time of input
			-Select Any Employee name from table
			-Enter clock in time in 24 hour format (ex. 12:00 or 14:00)
			-Enter work hours in decimal or integer format (ex. 3 or 4.5)
	Rastaurant Inventory:
		-Alphabetical Sort: Sort the items in alphabetical order
		-Add Item: Allows manager to add a new item to the inventory
			-Item Name: Enter name of item
			-Item Total: Enter an amount in integer or decimal format (ex. 3 or 5.6)
			-Unit Measurement: Enter the unit measurement of the item (ex. ounces or oz)
			-Total Cost Per Unit: Enter the cost per unit in money format (ex. 3.99 or 4.00)
			-Submit: Adds item to database
			-Back to Inventory: Sends manager back to inventory page
			-Back to Portal: Sends manager back to main page
	Music: Allows manager to create a playlist for restaurant atmosphere and to play it
		-Create: Enter a type of music or keywords, separated by commas(,) (ex. restaurant, happy)
	Shift Table: Shift table created by manager
	Finances: Finance table of restaurant accounts
		-Create New Financial Account: Allows manager to add a new account
			-Select Account Type: Choose either checking or savings
			-Enter Account Name: Enter name of account for recognizability
			-Enter Account Amount: Enter amount in account in money format (ex. 123.45)
			-Submit: Adds the new account to the account table
	Log Out: Logs Manager out of current session

Employee Page:
	On Log In: Displays employee name, wage, and type of employee
	Shift Table: Shift table created by manager
	Edit Information: Allows employee to edit their first name and pin
		-Name: Enter a new name 
		-PIN: Enter a new pin
		-Submit: Makes changes and confirms
	Absence Report:
		-Date: Choose a date in the future from current date
		-Comments: Enter reasoning for future absence
	Survey: Allows employee to submit a survey of experiences directly to manager
		-Stars: Enter a star rating by clicking the stars
		-Please Enter Comment: Enter a comment of experience
		-Submit: Sends survey to manager and confirms
	Log Out: Logs Employee out of current session





# RailwayReservationSystem

## **Set-up Instructions**

1. Clone the HTTPS link to a folder that holds your projects.
2. Open Eclipse, set the workspace to the folder that holds your projects.
3. Select "Import Projects" in the package explorer.
4. In the window that opens, select "General" drop down arrow, and click "Existing Projects into Workspace."
5. Click "Browse" and select the "RailwayReservationSystem" Folder. Then click Finish.
6. Navigate to App.java

![image](https://user-images.githubusercontent.com/46533825/150437432-72a3c0ee-f9bd-46c1-88dd-49a46db6c143.png)

7. Select the green "Run App" button on the toolbar to start the application.

# **Software Requirements And Design Specification for Railway Reservation**

#### Kenya Holland, Lance Blum, Dylan Morris, Priya Pilla, Evan Jones
##### Open "Required Software Requirements and Design Template.pdf" to view full development process

## **Project Description**
The Railway Reservation System (the product) will likely be a replacement for existing systems, as
an upgrade to existing railway ticketing systems that are fairly dated, especially in parts of the
Northeastern United States. This product contains a graphical interface and database component
for a service in which users can look up train routing information, including: price, routing
information, and other services. The working components include a GUI for booking a train ticket
and a database in order to write, read, update, and delete both user data and train data. This would
give both customers and administrators a new, easier to use system than ones currently available.

There are two ways a user can go into this program, the customer route and an administration
route. The program stores train information and the only users that will have direct access to this
information is the administration. Administration includes: security, customer service and ticketing
staff, locomotive handler/motorman, engineers, etc. Administration is expected to have high levels
of experience in ticketing systems and administration. Administration has the highest privilege and
security levels, for they can change many aspects of train information. Customer user classes
include anyone that needs to book a ticket for a train. Customers have low privilege levels when it
comes to accessing and managing train information. They will only have access to their own
information, for the ticket that they are booking. This includes top level information such as train
routes, meals and types of seats offered, prices, and days that they will travel on said train.

## **UI**
This is the opening scene when running App.java.

![image](https://user-images.githubusercontent.com/46533825/150438432-c4628812-35d6-476c-99fe-f368c4d2d04e.png)

If you click Exit Program, the program will terminate.
If you click Book a Ticket Now, you will be redirected to the following page.

![image](https://user-images.githubusercontent.com/46533825/150438474-59376653-1547-432d-a7f5-442c75688a8a.png)

On this screen, you can enter your name, select your starting point, and be presented with the
following destination points as shown in the following picture.

![image](https://user-images.githubusercontent.com/46533825/150438506-523cfa5d-8169-40c3-8eee-987b48fcd663.png)

Here, you can see the two types of trains you can select. Express trains will not stop at any
intermediate points, and Standard trains have destinations points in-between. (These intermediate
points have not yet been added).
Once a starting and a destination point is selected, you may choose what meals and what seating
options are available for that train. Some trains don’t have all options, as shown below.

![image](https://user-images.githubusercontent.com/46533825/150438551-5c24c1db-baf5-4c52-b801-dff922bbb8fb.png)

After all options have been selected by the user, the user can either cancel their ticket booking by
returning to the main screen, which returns them to the first image above, or they can go ahead
and book a ticket. If they choose to book a ticket, they will be redirected to the following page.

![image](https://user-images.githubusercontent.com/46533825/150438585-1269a4b6-3ef6-4a77-9c75-a48c573bde56.png)

Here, all of the information that the user chose will be presented to them. If they made a mistake,
they can return to the ticket booking page by selecting “Go Back to Ticket Page.” Otherwise, if they
are done, they may confirm their ticket and return to the main screen by pressing “Confirm and
Return to Main Screen.”
From the main screen, when you select “Sign in as An Administrator,” you will be redirected to a
login screen. For the purpose of easy testing, the username and password are given.

![image](https://user-images.githubusercontent.com/46533825/150438990-24603fbd-9a6f-4feb-9123-7cf45f40425f.png)

Once the correct login is inputed, you may select the login button. This will redirect you to the back
office page. The back office page consists of a list of trains that coincide with a button.

![image](https://user-images.githubusercontent.com/46533825/150439034-cc115c59-e2c7-4b65-94b6-7532511e2204.png)

Select the button of the train you wish to edit and you will be redirected to an editing page. Some
train characteristics will have text boxes and others won’t. This is because some characteristics
about a train cannot be changed, such as its route and ID. This is meant to allow for more meals
and seats or less meals and seats.

![image](https://user-images.githubusercontent.com/46533825/150439063-ce638036-ff01-46dc-a8fe-e2b0fac15ef8.png)

When a change is made, a confirmation pop-up will appear. The “Ok” button will return you to the
main screen and the “Cancel” button will return you to the back office page.

![image](https://user-images.githubusercontent.com/46533825/150439096-c718a474-24f2-4a08-bb37-1f0a7f560548.png)

## **Features**
### **1. Booking a Train Ticket**
#### Description
Customer users will be able to book a ticket on their desired train, with their options of
starting point, destination, seat type and meals, and express or standard trip.

#### Completed Functionality
The system allows the user to choose their starting point and destination.
The system allows for the user to choose an express or standard train.
The system allows for the user to choose available meals on their train.
The system allows the user to choose from available seating options.
The system allows the user to choose their starting point and destination.
The system allows for the user to choose an express or standard train.
The system allows for the user to choose available meals on their train.
The system allows the user to choose from available seating options.

### **2. Administrator edit trains**
#### Description
Administrator users will be able to view all train information on trains that are currently
housed in the database. The user will then also be able to edit non-critical
information on the train.

#### Completed Functionality
The system allows the user to access an admin side of the program.
The system allows for the user to enter administrator login credentials.
The system allows for secure administrative access.
The system allows the user to see all trains currently in the database.
The system allows the user to choose to edit a train.
The system allows for the user to edit dining options available on the train.
The system allows for the user to edit seating options available on the train.
The system allows the user to reset, cancel or confirm changes.

## **SQL Database Schema**

![image](https://user-images.githubusercontent.com/46533825/150439450-9fb659b3-e054-4936-ada2-760cdb1653aa.png)

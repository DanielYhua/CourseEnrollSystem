project log
Note: I know it's spelled enrol in NZ, and I apologize for using enrolled since I was educated in the States.
Project 1 (40%) - Requirements
This assignment focuses on software design thinking and HAI collaborative development.
Students are required to propose a project topic, generate and analyze requirements,
design the system architecture, and implement a CUI-based Java Application using Generative AI tools.

First iteration:
*barebones of the program structure->
Course Selection System
Functions (Use case):
-View courses
-View course details
-Enroll in courses
-Dropout courses
-Enrollment History (GPA & Credit checker)
-Request transcript
-Broadcast mail
-Course management(details such as credits and req)

Relationships <Include><Extend><Generalization>:
-Message -> inbox
-Enroll -> drop
-Request -> produce

Users (Actors):
-Student
-Lecturer
-Administrator (Department Head)

UML Script:
@startuml
left to right direction

actor "Student" as Student
actor "Lecturer" as lec
actor " Administrator" as admin

rectangle "Course Enroll System " {
usecase " View courses " as UC1
usecase " View course details " as UC2
usecase " Enroll in courses " as UC3
usecase " Dropout courses " as UC4
usecase " Enrollment history  " as UC5
usecase " Request transcript " as UC6
usecase " Manage courses " as UC7
usecase " Message broadcast " as UC8
usecase " Message inbox " as UC9
usecase " Compile transcript " as UC10
}

'Relationships
UC9 <|-- UC8 : <<Extented>>
UC4 <|-- UC3 : <<Include>>
UC6 <|-- UC10 : <<Include>>

' Student
Student --> UC1
Student --> UC2
Student --> UC3
Student --> UC4
Student --> UC5
Student --> UC6
Student --> UC9

'Lecturer
UC7 <-- lec
UC1 <-- lec
UC2 <-- lec

'Administrator
UC1 <-- admin
UC2 <-- admin
UC3 <-- admin
UC4 <-- admin
UC5 <-- admin
UC7 <-- admin
UC8 <-- admin
UC10 <-- admin
@enduml

SECOND iteration (Enhanced with AI):
Prompt: greetings, this is my structure for my program in uml script, what other features am i missing?
-AI corrected my flawed uml script and suggested to remove the message broadcast and message inbox feature as
they should be held in a separate system. and add Authentication/Accounts, timetable management, and validation system.

UML Script (improved by AI):
@startuml
left to right direction

actor Student
actor Lecturer
actor Administrator as Admin

rectangle "Course Enrollment System" {

  '======================
  ' Authentication
  '======================
  usecase "Login" as UC_Login
  usecase "Logout" as UC_Logout

  '======================
  ' Course Viewing
  '======================
  usecase "View Courses" as UC_ViewCourses
  usecase "View Course Details" as UC_ViewDetails

  '======================
  ' Enrollment
  '======================
  usecase "Enroll in Course" as UC_Enroll
  usecase "Drop Course" as UC_Drop
  usecase "View Enrollment History" as UC_History

  ' Validation (included use cases)
  usecase "Check Prerequisites" as UC_Prereq
  usecase "Check Schedule Conflict" as UC_Clash
  usecase "Check Course Capacity" as UC_Capacity

  '======================
  ' Academic Records
  '======================
  usecase "View Grades" as UC_ViewGrades
  usecase "Request Transcript" as UC_RequestTranscript
  usecase "Compile Transcript" as UC_CompileTranscript
  usecase "Submit Grades" as UC_SubmitGrades

  '======================
  ' Course Management
  '======================
  usecase "Create Course" as UC_CreateCourse
  usecase "Update Course" as UC_UpdateCourse
  usecase "Delete Course" as UC_DeleteCourse
  usecase "Manage Enrolled Students" as UC_ManageStudents

  '======================
  ' Messaging System
  '======================
  usecase "Send Message" as UC_SendMsg
  usecase "Receive Message" as UC_ReceiveMsg
  usecase "Broadcast Message" as UC_Broadcast

  '======================
  ' Admin Controls
  '======================
  usecase "Manage Users" as UC_ManageUsers
  usecase "Assign Lecturer" as UC_AssignLecturer
  usecase "Override Enrollment" as UC_Override
  usecase "Generate Reports" as UC_Reports
}

'======================
' Relationships (Include / Extend)
'======================

' Enrollment includes validation
UC_Enroll --> UC_Prereq : <<include>>
UC_Enroll --> UC_Clash : <<include>>
UC_Enroll --> UC_Capacity : <<include>>

' Transcript depends on grades
UC_RequestTranscript --> UC_CompileTranscript : <<include>>
UC_CompileTranscript --> UC_ViewGrades : <<include>>

' Broadcast is a special type of send
UC_Broadcast ..> UC_SendMsg : <<extend>>

'======================
' Actor Associations
'======================

' Student
Student --> UC_Login
Student --> UC_Logout
Student --> UC_ViewCourses
Student --> UC_ViewDetails
Student --> UC_Enroll
Student --> UC_Drop
Student --> UC_History
Student --> UC_ViewGrades
Student --> UC_RequestTranscript
Student --> UC_ReceiveMsg

' Lecturer
Lecturer --> UC_Login
Lecturer --> UC_Logout
Lecturer --> UC_ViewCourses
Lecturer --> UC_ViewDetails
Lecturer --> UC_SubmitGrades
Lecturer --> UC_ManageStudents
Lecturer --> UC_SendMsg
Lecturer --> UC_Broadcast

' Admin
Admin --> UC_Login
Admin --> UC_Logout
Admin --> UC_ManageUsers
Admin --> UC_AssignLecturer
Admin --> UC_CreateCourse
Admin --> UC_UpdateCourse
Admin --> UC_DeleteCourse
Admin --> UC_Override
Admin --> UC_Reports
Admin --> UC_Broadcast

@enduml

--------------------------------------
Project Structure for version 1:
-core entities/->
--User.java //lec and admin
--Student.java
--Course.java
-service/->
--EnrollmentServ.java
--CourseServ.java
--SecurityServ.java
-ui/->
--StudentUi.java
--AdminUi.java
-Main.java //entry point

Improvement under AI:
Prompt: This is my structure for the program, how do i improve?
-AI showed my missing classes and services and output a better structure

core/
 ├── User.java
 ├── Student.java
 ├── Lecturer.java
 ├── Admin.java
 ├── Course.java
 ├── Enrollment.java
 ├── Grade.java

service/
 ├── EnrollmentService.java
 ├── CourseService.java
 ├── UserService.java
 ├── SecurityService.java

ui/
 ├── StudentUi.java
 ├── LecturerUi.java
 ├── AdminUi.java

Main.java

AI Prompt: is it good practice to put method beneath main method?
-Yes you should follow the Step-down rule

AI Prompt: what kind of feature should admin account normally have in a course enroll system
-User and role management, course and content administration, enrolment and performance oversight, reporting and analytics,
system config

AI Prompt: I would like to make my classes serializable to i can save and load data where my data will persist between runs.

------------------------------------------
To start, I've first created structured packages and the classes
then compile core first and run tests, then code in the logic so layers in and links up all the systems

Current work in progress:

Core|Structure design (v) ->
     Code implementaion1 (v) ->
     Test1 with dummy data (v) ->
Serv|Code implementaion2 (v) ->
     Test2 with dummy data (v) ->
UseI|Code implementaion3 (v) ->
     Test3 with dummy data (v) ->

*****Completion of Version1(v)*****

------------------------------------------
V2 Starts here
*need to update grade.java and other classes to have lecturer's ui work
LecturerUi.java(v)->
test(v)->
AdminUi.java(v)->
test(v)->

*****Completion of Version2(v)*****

--------------------------------
V3 Starts here
*need to make classes Serializable to perform basic i/o
Serializable(v)->
i/o integration(v)->
test(v)->

*****Completion of Version3(v)*****
----------------------------
Overall Missing features:
Admin UI (v)
Lecturer UI (v)
Grade checkup (v)
single session logout loop(v)
Transcript request ()
Transcript output ()

------------------------------------
Following are tests ran:

Course Enrollment System - Testing Report (Mugi)

Test 1: Program Startup
Expected: Program should compile and launch properly
Actual: Program compiled and launched successfully
Result: PASS

Test 2: Invalid Login
Input: abc
Expected: System should say "User not found"
Actual: System displayed "User not found"
Result: PASS

Test 3: Student Login
Input: s1
Expected: Student menu should show
Actual: Student menu displayed correctly
Result: PASS

Test 4: Menu Input with Leading Space
Input: " 3"
Expected: System should still accept it as option 3
Actual: Program crashed with NumberFormatException
Result: FAIL

Test 5: Menu Input with Letters
Input: "abc"
Expected: System should show an error message
Actual: Program crashed
Result: FAIL

Test 6: Enroll in Valid Course
Input: COMP100
Expected: Should enroll successfully
Actual: System displayed "You are now enrolled"
Result: PASS

Test 7: Enroll in Same Course Twice
Input: COMP100 again
Expected: Should not allow duplicate enrollment
Actual: System displayed "Student is already enrolled in this course."
Result: PASS

Test 8: Enroll in Invalid Course
Input: COMP999
Expected: Should show course not found or unavailable
Actual: System displayed "Course not available or found"
Result: PASS

Test 9: View Courses
Expected: Should display list of courses
Actual: Courses displayed correctly (COMP100, COMP101)
Result: PASS

Test 10: View Grades (No Grades Yet)
Expected: Should show grades or say none available
Actual: Nothing showed, just returned to menu
Result: PASS (but could be improved with a message)

Test 11: Exit Student Menu
Expected: Should return to login screen
Actual: Returned to login prompt with "Logged-out."
Result: PASS

Test 12: Admin Login
Input: a1
Expected: Admin menu should show
Actual: Admin menu displayed correctly
Result: PASS

Test 13: Admin View Courses
Expected: Should display all courses
Actual: Courses displayed correctly with lecturer info
Result: PASS

Test 14: Admin Add User - Empty Input----
Input: Pressed Enter without typing 1, 2, or 3
Expected: Should show error or ask again
Actual: Program crashed with NumberFormatException
Result: FAIL

Test 15: Lecturer Login
Input: l1
Expected: Lecturer menu should show
Actual: Lecturer menu displayed correctly
Result: PASS

Test 16: Lecturer View My Courses
Expected: Should show assigned courses
Actual: COMP100 ---> Intro to Prog displayed
Result: PASS

Test 17: Lecturer Assign Grade (Invalid Course ID)
Input: 342
Expected: Should show course not found
Actual: System displayed "Course not found"
Result: PASS

Test 18: Lecturer Menu Input with Letters
Input: "ght"
Expected: Should show error message
Actual: Program crashed with NumberFormatException
Result: FAIL

Conclusion:

Overall, the system works well for normal use. Features like login, course enrollment, and viewing courses all worked as expected across student, admin, and lecturer roles.
However, a main issue found was input handling. The system crashes when invalid input is entered, such as letters, empty input, or inputs with spaces.
This shows that while the system works for correct input, it needs better validation to make it more stable and user-friendly.

---------------------

all bug fixed.
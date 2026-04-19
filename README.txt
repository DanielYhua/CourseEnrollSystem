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

V1 Missing features:
Admin UI ()
Lecturer UI (v)
Grade checkup (v)
Transcript request ()
Transcript output ()
------------------------------------------
V2 Starts here
-need to update grade.java to have lecturer's ui work
LecturerUi.java(v)->
test(v)->
AdminUi.java()->
test()->
i/o integration()
test()->

*****Completion of Version2()*****


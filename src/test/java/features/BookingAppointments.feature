@bookings
Feature: Booking Appointment from admin portal

  #In Order to book Appointment for registered patient
  #As a admin
  #I have to login to Admin portal and fill all mandatory fields and submit the form
  Background:
    Given Admin is in login page
    When  Admin enter username "Admin@lgp.com"  and enter password "Admin@123$"
    Then  Admin should be navigate to Home page "LGP Appointment"


  Scenario Outline: Booking In Hours Appointment for Out of practice hours (i.e before 9:00 and after 17:30) from admin portal


    When  Admin select Appointments from left side panel and select Book Appointment
    Then  Admin should be navigate to Book Appointment screen
    When  Admin select date of Appointment
    And   Admin select "<site>", "<time>", "<patient>", "<AppointmentType>", "<DoctorName>","<comments>"
    And   Admin click submit button
    Then  Admin should get validation message to book for Out of Hours

    Examples:
      | site   | time|patient    |AppointmentType    |DoctorName     |comments|
      |In Hours|01:00|James Woods|Health Screen      |Dr Catrin Bevan|        |
      |In Hours|05:30|James Woods|Consultation       |Dr Catrin Bevan|        |
      |In Hours|08:00|James Woods|Nurse Consultation |Dr Catrin Bevan|        |
      |In Hours|08:30|James Woods|Video Consultation |Dr Catrin Bevan|        |
      |In Hours|18:30|James Woods|Occupational Health|Dr Catrin Bevan|        |
      |In Hours|22:00|James Woods|Nurse Consultation |Dr Catrin Bevan|        |
      |In Hours|21:30|James Woods|Consultation       |Dr Catrin Bevan|        |


  Scenario Outline: Booking In Hours Appointment with in the practice hours (i.e 9:00 to 17:30) from admin portal

    When  Admin select Appointments from left side panel and select Book Appointment
    Then  Admin should be navigate to Book Appointment screen
    When  Admin select date of Appointment
    And   Admin select "<site>", "<time>", "<patient>", "<AppointmentType>", "<DoctorName>","<comments>"
    And   Admin click submit button
    Then  Admin should get validation message
    And   Booking should be updated in All Appointment screen with Confirmed status

    Examples:
      |site    |time |patient    |AppointmentType    |DoctorName|comments|
      |In Hours|09:00|James Woods|Health Screen      |Dr Angela|        |
      |In Hours|09:30|James Woods|Consultation       |Dr Angela|        |
      |In Hours|11:30|James Woods|Video Consultation |Dr Angela|        |
      |In Hours|13:00|James Woods|Occupational Health|Dr Angela|        |
      |In Hours|15:30|James Woods|Health Screen      |Dr Angela|        |
      |In Hours|17:00|James Woods|Nurse Consultation |Dr Angela|        |
      |In Hours|17:30|James Woods|Consultation       |Dr Angela|        |


  Scenario Outline: Booking new appointment for registered patient by assigning the Doctor from the admin portal

    When  Admin select Appointments from left side panel and select Book Appointment
    Then  Admin should be navigate to Book Appointment screen
    When  Admin select date of Appointment
    And   Admin select "<site>", "<time>", "<patient>", "<AppointmentType>", "<DoctorName>","<comments>"
    And   Admin click submit button
    Then  Admin should get validation message
    And   Booking should be updated in All Appointment screen with Confirmed "<status>"

    Examples:
      |site        |time |patient    |AppointmentType   |DoctorName  |status   |comments|
      |In Hours    |09:00|James Woods|Health Screen     |Dr Ettlinger|Confirmed|        |
      |Out of Hours|22:30|James Woods|Video Consultation|Dr Ettlinger|Confirmed|        |

 #@laxmi
  Scenario Outline: Booking new appointment for registered patient with out assign Doctor from the admin portal

    When  Admin select Appointments from left side panel and select Book Appointment
    Then  Admin should be navigate to Book Appointment screen
    When  Admin select date of Appointment
    And   Admin select "<site>", "<time>", "<patient>", "<AppointmentType>", "<DoctorName>","<comments>"
    And   Admin click submit button
    Then  Admin should get validation message
    And   Appointment booking should be updated in All Appointment screen with Pending "<status>"

    Examples:
      |site        |time |patient    |AppointmentType|DoctorName   |comments                |status |
      |In Hours    |09:00|James Woods|Health Screen  |Please Select|Hi Doctor, This is James|Pending|
      |Out of Hours|22:30|James Woods|Consultation   |Please Select|Hi Doctor, This is James|Pending|

  #@laxmi
  Scenario Outline: Booking In Hours Appointment on Saturday (i.e on WeedEnds) from admin portal

    When  Admin select Appointments from left side panel and select Book Appointment
    Then  Admin should be navigate to Book Appointment screen
    When  Admin select Saturday as date of Appointment
    And   Admin select "<site>", "<time>", "<patient>", "<AppointmentType>", "<DoctorName>","<comments>"
    And   Admin click submit button
    Then  Admin should get validation message for booking weekend Appointment "On Saturdays and Sundays please select a Out of Hours."

    Examples:
      |site    |time |patient    |AppointmentType    |DoctorName    |comments|
      |In Hours|09:00|James Woods|Health Screen      |Dr Sam Bennett|        |
      |In Hours|09:30|James Woods|Consultation       |Dr Sam Bennett|        |
      |In Hours|12:30|James Woods|Video Consultation |Dr Sam Bennett|        |
      |In Hours|15:30|James Woods|Nurse Consultation |Dr Sam Bennett|        |
      |In Hours|16:00|James Woods|Occupational Health|Dr Sam Bennett|        |

 # @laxmi
  Scenario Outline: Booking In Hours Appointment on Sunday (i.e on WeedEnds) from admin portal

    When  Admin select Appointments from left side panel and select Book Appointment
    Then  Admin should be navigate to Book Appointment screen
    When  Admin select Sunday as date of Appointment
    And   Admin select "<site>", "<time>", "<patient>", "<AppointmentType>", "<DoctorName>","<comments>"
    And   Admin click submit button
    Then  Admin should get validation message for booking weekend Appointment "On Saturdays and Sundays please select a Out of Hours."

    Examples:
      |site    |time |patient    |AppointmentType    |DoctorName       |comments|
      |In Hours|09:00|James Woods|Health Screen      |Dr Stuart Sanders|        |
      |In Hours|10:30|James Woods|Consultation       |Dr Stuart Sanders|        |
      |In Hours|12:30|James Woods|Video Consultation |Dr Stuart Sanders|        |
      |In Hours|13:30|James Woods|Nurse Consultation |Dr Stuart Sanders|        |
      |In Hours|15:00|James Woods|Occupational Health|Dr Stuart Sanders|        |

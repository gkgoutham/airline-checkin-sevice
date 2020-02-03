package com.airline.checkin.model;

import java.util.List;


public class Ticket {
    private String bookingId;
    private String ticketNumber;
    private List<Passenger> passengers;
    private String boardingLocation;
    private String departureLocation;
    private String bookingDate;
    private String travelingDate;
    private boolean checkIn;
    private String email;
    private String name;
    private String lastName;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "bookingId='" + bookingId + '\'' +
                ", ticketNumber='" + ticketNumber + '\'' +
                ", lastName='" + lastName + '\'' +
                ", boardingLocation='" + boardingLocation + '\'' +
                ", departureLocation='" + departureLocation + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", travelingDate='" + travelingDate + '\'' +
                ", checkIn=" + checkIn +
                ", emailId='" + email + '\'' +
                ", name='" + name + '\'' +

                ", phone='" + phone + '\'' +
                ", passengers=" + passengers +
                '}';
    }

    class Passenger {
        private String name;
        private String lastName;
        private int age;
        private String gender;

        @Override
        public String toString() {
            return "Passenger{" +
                    "name='" + name + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public String getBoardingLocation() {
        return boardingLocation;
    }

    public void setBoardingLocation(String boardingLocation) {
        this.boardingLocation = boardingLocation;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTravelingDate() {
        return travelingDate;
    }

    public void setTravelingDate(String travelingDate) {
        this.travelingDate = travelingDate;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }
}

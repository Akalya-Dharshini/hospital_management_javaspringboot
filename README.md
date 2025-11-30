# hospital_management_javaspringboot


🏥 Hospital Management System

A simple full-stack Hospital Management System built using Java Spring Boot, React.js, Bootstrap, and MySQL.
This project provides a basic structure for managing patients, doctors, and appointments with a clean UI and REST API backend.

🚀 Tech Stack
Frontend

React.js

Bootstrap (for responsive UI)

Axios (API calls)

Backend

Java Spring Boot

Spring Web

Spring Data JPA

MySQL Driver

Database

MySQL (patients, doctors, appointments tables)

📌 Features
Frontend (React + Bootstrap)

Responsive UI built with Bootstrap

Pages:

Home

Doctors

Patients

Appointments

CRUD operations for:
✔ Add Patient
✔ Add Doctor
✔ Book Appointment
✔ Edit / Delete records

Basic validations

Simple navigation with React Router

Backend (Spring Boot)

REST API endpoints for Patients, Doctors, Appointments

JPA for database operations

Error handling for invalid input

Layered structure:

Controller

Service

Repository

Model (Entity)

🗄 Database Structure (MySQL)
Tables

patients

doctors

appointments

Each table includes basic fields like name, email, phone, doctor specialization, appointment date/time, etc.

▶️ How to Run the Project
Backend

Install Java 17+

Install MySQL and create database:

CREATE DATABASE hospital_db;


Update MySQL credentials in application.properties

Run the Spring Boot application

API will start on:

http://localhost:8080

Frontend

Go to the React project folder

Install dependencies:

npm install


Start the development server:

npm start


App runs at:

http://localhost:3000

📁 Folder Structure
Backend
src/main/java/com/hospital
 ├── controller
 ├── service
 ├── repository
 └── entity

Frontend
src/
 ├── components/
 ├── pages/
 ├── services/ (API calls)
 └── App.js

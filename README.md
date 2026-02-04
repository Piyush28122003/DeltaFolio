# DevFolio - Financial Portfolio Management System

A comprehensive Spring Boot application for managing financial portfolios with AI-powered chatbot assistance, risk analysis, and real-time stock market integration.

## 🚀 Features

- **User & Bank Account Management**: User can track bank account
- **Portfolio Management**: Buy/sell stocks, track holdings, calculate profit/loss
- **Real-time Stock Data**: Integration with Alpha Vantage  APIs for live stock prices
- **Risk Analysis**: Automated risk profiling (Conservative/Moderate/Aggressive) using Gemini AI
- **AI Chatbot**: Google Gemini-powered chatbot for portfolio queries and recommendations (In Progress)
- **Analytics & Charts**: Portfolio visualization with Chart.js (pie charts, line charts)
- **RESTful API**: Clean API design with DTOs and proper exception handling


## 🛠️ Tech Stack

- **Backend**: Java 17, Spring Boot 3.2.0, Maven
- **Database**: MySQL
- **Frontend**: HTML, CSS, JavaScript
- **External APIs**:
    - Stock Market: Alpha Vantage
    - AI Chatbot: Google Gemini API



## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+






## 🔧 Setup Instructions

### 1. Database Setup

```bash
# Create MySQL database
mysql -u root -p
CREATE DATABASE portfolio_db;
exit;
```



### 2. Build and Run

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### 4. Access the Frontend

Open your browser and navigate to:
```
http://localhost:8080/index.html
```

## 📝 License

This project is for training and evaluation purposes.

## 👥 Support

For issues or questions, please refer to the code comments or Spring Boot documentation.

---
## Contributors
1) Pravlika M 
2) Prashanna Kumar
3) Piyush Srivastava
---
**Built with ❤️ using Spring Boot and modern web technologies**




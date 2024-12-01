# School Management System

## Overview

The **School Management System** is a desktop application developed using JavaFX, designed to streamline the management of professors and departments within an educational institution. The application provides an intuitive interface to perform essential operations such as adding, updating, and deleting records, as well as assigning professors to specific departments. With integrated search functionality, the system ensures that users can quickly locate and manage data efficiently.

---

## Key Features

### **Professor Management**
- Add, update, and delete professor records.
- Assign professors to relevant departments.
- View a list of professors filtered by department.

### **Department Management**
- Create, edit, and remove departments.
- View department details along with their associated professors.

### **Dynamic Search**
- Search professors and departments using keywords for faster access to specific records.

---

## Architecture

The application is designed with a clear structure to ensure scalability and maintainability:

1. **User Interface**:
    - Built with JavaFX, the UI consists of distinct panels for professor and department management.
    - Offers a clean, modern design for easy navigation.

2. **Business Logic**:
    - The `IMetier` interface defines core methods for CRUD operations.
    - `MetierImpl` implements these methods to handle business logic effectively.

3. **Database Integration**:
    - Powered by a MySQL database, the application securely stores all data related to professors and departments.

4. **Modular Design**:
    - The application is divided into manageable modules for easier development and future enhancements.

---

## How It Works

1. **Launch**:
    - Open the application and choose between the "Professor Management" or "Department Management" panels.

2. **Perform Operations**:
    - Use the provided forms to add, edit, or delete records.
    - Assign professors to departments as needed.

3. **Search**:
    - Type keywords into the search bar to dynamically filter and locate records.

---

## Benefits

- **Time-Saving**: Simplifies routine administrative tasks with easy-to-use forms and quick searches.
- **Efficient Management**: Organizes data effectively, providing a centralized view of professors and departments.
- **Customizable**: Easily adaptable to meet the needs of various educational institutions.

---

## Demonstration

Watch a video demonstration of the application: [School Management System - Video Demo](https://vimeo.com/1035020202/2ea483b7e3?share=copy)

---

## Conclusion

The **School Management System** demonstrates how a desktop application can significantly enhance administrative efficiency in schools. By combining JavaFX's rich UI features with the robust capabilities of MySQL, the system ensures reliable and user-friendly management of institutional data. Whether managing professors, organizing departments, or searching for specific records, this application offers a practical and powerful solution.

Lab Activity 6 – To-Do List Application (Swing)

This Java program was developed for Lab Activity 6 in DCIT-23: Introduction to Object-Oriented Programming. It is a graphical To-Do List application built using Java Swing, allowing users to add and manage tasks with descriptions and statuses in a table view.

⸻

Program Features
	•	GUI-based task management application
	•	Main window (ToDoListViewer) displays a table of tasks with:
	•	Task Name
	•	Description
	•	Status (Not Started, Ongoing, Completed)
	•	Button to add new tasks via a form window
	•	Form window (ToDoListForm) includes:
	•	Input fields for task name and description
	•	Dropdown to select task status
	•	Input validation with error message for incomplete entries
	•	Dynamically updates the table with new task entries

⸻

Sample Flow
	1.	User clicks “Add Task”
	2.	Form window opens
	•	User enters task details and selects a status
	3.	Task is added to the table

⸻

Technologies Used
	•	Java SE (JDK 8 or higher)
	•	Java Swing components:
	•	JFrame, JTable, JTextField, JTextArea, JComboBox, JButton, JLabel, JScrollPane
	•	Table management with DefaultTableModel
	•	Layout managers: BorderLayout, GridLayout

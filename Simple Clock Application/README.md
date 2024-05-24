**Simple Clock Application**

**Introduction**

This document provides a detailed explanation of the Clock application developed in Java. The application utilizes Java threads to display the current time and date concurrently. 

**Code Explanation**

**Clock Class**

The **Clock** class implements the **Runnable interface**, which means it can be executed by a thread. The Runnable interface is chosen over extending the **Thread** class as Java does not support multiple inheritance, and hence, the Clock class is free to extend another class if needed in the future.

- **_DateTimeFormatter_**

A **DateTimeFormatter** is declared to format the date and time in the “HH:mm:ss dd-MM-yyyy” pattern.

- **_run Method_**

The **run method** is overridden from the **Runnable interface**. It contains an infinite loop that prints the current date and time, then sleeps for one second. If the thread is interrupted while sleeping, the interrupt status is restored.

- **_main Method_**

The main method is the entry point of the application. A new **Thread** is created with an instance of **Clock** as its target. The priority of this thread is set to **MAX_PRIORITY** to ensure that it gets more CPU time. Finally, the thread is started, which causes the JVM to call the **run method** of Clock.

**Output**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/819f0416-e6ec-4249-b894-a4ec256e0080)

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/97dc6bf3-f63a-45b6-9108-5a9e29c86ff9)

**Conclusion**

This Clock application is a simple demonstration of how to use Java threads to perform tasks concurrently. It also shows how to set thread priorities to influence the scheduler in favor of more important threads.

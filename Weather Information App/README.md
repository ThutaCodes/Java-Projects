**Weather Information App**

**Overview**

This Java application fetches real-time weather data from the OpenWeatherMap API. It provides users with relevant weather information such as temperature, humidity, wind speed, and weather conditions. The app features a user-friendly GUI built using JavaFX.

**Features**

- Fetches real-time weather data from the OpenWeatherMap API.
- User-friendly GUI with input options for city name or coordinates.
- Displays temperature, humidity, wind speed, and weather conditions.
- Supports unit conversion between metric and imperial units.
- Allows users to view search history.

**How to Use**

1. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
2. Copy and paste provided source codes.
3. Build and run the application (**WeatherApp.java**).
4. Enter the city name or coordinates (latitude, longitude) in the input field.
5. Click on the "Get Weather" button to fetch weather information.
6. Optionally, toggle the unit conversion checkbox to switch between metric and imperial units.
7. To view search history, click on the "Show History" button.

**Dependencies**

- JavaFX
- JSON (org.json)

**API Used**

- OpenWeatherMap API

**Notes**

- Make sure to replace **API_KEY** in the **WeatherApiClient** class with your actual OpenWeatherMap API key.
- This application currently supports fetching weather data from OpenWeatherMap API only.

**1\. WeatherApp Class:**

- This class extends the **Application** class provided by JavaFX, indicating that it's a JavaFX application.
- It contains the main method (**main**) that launches the JavaFX application.
- The **start** method is overridden to set up the GUI components and initialize the application window.
- The GUI elements include labels, text fields, buttons, checkboxes, and a list view for displaying search history.
- The **setBackgroundBasedOnTime** method dynamically sets the background color of the application window based on the time of day.
- Action event handlers are defined for the "Get Weather" button and unit conversion checkbox.
- The **parseWeatherData** method parses the JSON weather data obtained from the API and formats it for display.
- The **addToHistory** method adds user search queries to the search history list.
- The **displayWeatherIcon** method retrieves and displays the weather icon based on the weather data.
- The **showErrorAlert** method displays error messages in alert dialogs.

**2\. WeatherApiClient Class:**

- This class is responsible for fetching weather data from the OpenWeatherMap API.
- It contains methods **getWeatherDataByCity** and **getWeatherDataByCoordinates** for fetching weather data by city name or coordinates, respectively.
- The API key and base URL for the OpenWeatherMap API are defined as constants.
- These methods make HTTP GET requests to the API endpoints and parse the JSON responses to return weather data.

**3\. CSS Styling:**

- CSS styling is applied to customize the appearance of GUI components.
- Styles are defined for labels, buttons, and checkboxes to set font size and weight.

**Explanation:**

- The **WeatherApp** class is the main entry point of the application, responsible for setting up the GUI and handling user interactions.
- It interacts with the **WeatherApiClient** class to fetch weather data from the OpenWeatherMap API.
- GUI components are defined using JavaFX classes such as **Label**, **TextField**, **Button**, and **ListView**.
- Event handling is implemented using lambda expressions to respond to user actions such as button clicks and checkbox selections.
- The **WeatherApiClient** class encapsulates the logic for making HTTP requests to the API and processing the JSON responses.
- CSS styling is applied to enhance the visual appearance of the application.

Overall, the code demonstrates a JavaFX application that fetches weather data from an API and presents it to the user in a user-friendly interface. It follows object-oriented principles and uses external libraries (JavaFX and org.json) for GUI development and JSON parsing, respectively.

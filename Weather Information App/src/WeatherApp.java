import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * The WeatherApp class represents a JavaFX application for displaying weather information.
 */
public class WeatherApp extends Application {
    private WeatherApiClient weatherApiClient;
    private static final double KELVIN_TO_CELSIUS = -273.15;
    private static final double M_S_TO_MPH = 2.23694;
    private List<String> searchHistory = new ArrayList<>();
    private ListView<String> historyListView;
    private ImageView weatherIconImageView = new ImageView();

    /**
     * The main method that launches the JavaFX application.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        weatherApiClient = new WeatherApiClient();
        weatherIconImageView = new ImageView();

        // Set up the scene
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        // GUI components
        Label titleLabel = new Label("Today's Weather");
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setFont(Font.font(18));
        titleLabel.setStyle("-fx-font-weight: bold;");
        TextField cityInput = new TextField();
        cityInput.setPromptText("Enter city name or coordinates");
        Button getWeatherButton = new Button("Get Weather");
        Label weatherInfoLabel = new Label();
        CheckBox unitConversionCheckbox = new CheckBox("Use Metric Units");
        unitConversionCheckbox.setSelected(true);
        unitConversionCheckbox.setTextFill(Color.WHITE);

        // Radio buttons for selecting input type
        ToggleGroup inputTypeGroup = new ToggleGroup();
        RadioButton cityNameRadioButton = new RadioButton("City Name");
        cityNameRadioButton.setTextFill(Color.WHITE);
        RadioButton coordinatesRadioButton = new RadioButton("Coordinates");
        coordinatesRadioButton.setTextFill(Color.WHITE);
        cityNameRadioButton.setToggleGroup(inputTypeGroup);
        coordinatesRadioButton.setToggleGroup(inputTypeGroup);
        cityNameRadioButton.setSelected(true);

        // Create a horizontal box to hold the radio buttons
        HBox radioButtonBox = new HBox(10);
        radioButtonBox.getChildren().addAll(cityNameRadioButton, coordinatesRadioButton);
        radioButtonBox.setAlignment(Pos.CENTER_LEFT);

        // Search history ListView
        historyListView = new ListView<>();
        historyListView.setPrefHeight(100);
        historyListView.setVisible(false);

        // Button to toggle search history visibility
        Button showHistoryButton = new Button("Show History");
        showHistoryButton.setOnAction(event -> historyListView.setVisible(!historyListView.isVisible()));

        // Weather icon box
        HBox weatherIconBox = new HBox();
        weatherIconBox.setAlignment(Pos.CENTER);
        weatherIconBox.getChildren().add(weatherIconImageView);

        getWeatherButton.setOnAction(event -> {
            String userInput = cityInput.getText();
            String weatherData;
            if (!userInput.isEmpty()) {
                if (cityNameRadioButton.isSelected()) {
                    weatherData = weatherApiClient.getWeatherDataByCity(userInput);
                } else {
                    // For simplicity, assume user input is in format "latitude,longitude"
                    String[] coordinates = userInput.split(",");
                    if (coordinates.length == 2) {
                        double latitude = Double.parseDouble(coordinates[0]);
                        double longitude = Double.parseDouble(coordinates[1]);
                        weatherData = weatherApiClient.getWeatherDataByCoordinates(latitude, longitude);
                    } else {
                        showErrorAlert("Invalid coordinates format. Please enter latitude and longitude separated by comma.");
                        return;
                    }
                }

                if (weatherData != null) {
                    weatherInfoLabel.setText(parseWeatherData(weatherData, unitConversionCheckbox.isSelected()));
                    displayWeatherIcon(weatherData);
                    addToHistory(userInput);
                } else {
                    showErrorAlert("Failed to fetch weather data. Please try again.");
                }
            } else {
                showErrorAlert("Please enter a city name or coordinates.");
            }
        });

        unitConversionCheckbox.setOnAction(event -> {
            String userInput = cityInput.getText();
            String weatherData;
            if (!userInput.isEmpty()) {
                if (cityNameRadioButton.isSelected()) {
                    weatherData = weatherApiClient.getWeatherDataByCity(userInput);
                } else {
                    // For simplicity, assume user input is in format "latitude,longitude"
                    String[] coordinates = userInput.split(",");
                    if (coordinates.length == 2) {
                        double latitude = Double.parseDouble(coordinates[0]);
                        double longitude = Double.parseDouble(coordinates[1]);
                        weatherData = weatherApiClient.getWeatherDataByCoordinates(latitude, longitude);
                    } else {
                        showErrorAlert("Invalid coordinates format. Please enter latitude and longitude separated by comma.");
                        return;
                    }
                }

                if (weatherData != null) {
                    weatherInfoLabel.setText(parseWeatherData(weatherData, unitConversionCheckbox.isSelected()));
                } else {
                    showErrorAlert("Failed to fetch weather data. Please try again.");
                }
            }
        });

        root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(titleLabel, radioButtonBox, cityInput, getWeatherButton, unitConversionCheckbox, weatherInfoLabel, showHistoryButton, historyListView, weatherIconBox);

        // Apply dynamic background
        setBackgroundBasedOnTime(root);

        // Apply CSS styling
        root.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());


        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Weather Information App");
        primaryStage.show();


    }

    /**
     * Parses weather data retrieved from the API and formats it for display.
     * @param weatherData The JSON string containing weather data.
     * @param useMetricUnits Flag indicating whether to use metric units for temperature and wind speed.
     * @return A formatted string containing weather information.
     */
    private String parseWeatherData(String weatherData, boolean useMetricUnits) {
        JSONObject jsonObject = new JSONObject(weatherData);

        // Extracting relevant weather information
        JSONObject main = jsonObject.getJSONObject("main");
        double temperature = main.getDouble("temp");
        double humidity = main.getDouble("humidity");

        JSONObject wind = jsonObject.getJSONObject("wind");
        double windSpeed = wind.getDouble("speed");

        JSONArray weatherArray = jsonObject.getJSONArray("weather");
        JSONObject weather = weatherArray.getJSONObject(0);
        String description = weather.getString("description");

        // Convert temperature to Celsius or Fahrenheit
        if (!useMetricUnits) {
            temperature = (temperature + KELVIN_TO_CELSIUS) * 9 / 5 + 32; // Convert from Kelvin to Celsius, then to Fahrenheit
        } else {
            temperature += KELVIN_TO_CELSIUS; // Convert from Kelvin to Celsius
        }

        // Convert wind speed to miles per hour if not using metric units
        if (!useMetricUnits) {
            windSpeed *= M_S_TO_MPH;
        }

        // Formatting weather information
        StringBuilder builder = new StringBuilder();
        builder.append("Temperature: ").append(temperature).append(useMetricUnits ? "°C" : "°F").append("\n");
        builder.append("Humidity: ").append(humidity).append("%\n");
        builder.append("Wind Speed: ").append(windSpeed).append(useMetricUnits ? " m/s" : " mph").append("\n");
        builder.append("Description: ").append(description);

        return builder.toString();
    }

    /**
     * Adds a search query to the search history.
     */
    private void addToHistory(String userInput) {
        // Add the search history entry with timestamp
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String entry = userInput + " - " + timestamp;
        searchHistory.add(entry);
        // Update the ListView
        updateHistoryListView();
    }

    private void updateHistoryListView() {
        historyListView.getItems().clear();
        historyListView.getItems().addAll(searchHistory);
    }

    // Method to display weather icon based on weather data
    private void displayWeatherIcon(String weatherData) {
        JSONObject jsonObject = new JSONObject(weatherData);
        JSONArray weatherArray = jsonObject.getJSONArray("weather");
        if (weatherArray.length() > 0) {
            JSONObject weather = weatherArray.getJSONObject(0);
            String iconCode = weather.getString("icon");
            String iconUrl = "https://openweathermap.org/img/wn/" + iconCode + ".png";

            try {
                // Load icon image from URL
                Image iconImage = new Image(iconUrl);
                weatherIconImageView.setImage(iconImage);
            } catch (Exception e) {
                System.err.println("Error loading weather icon: " + e.getMessage());
            }
        }
    }

    /**
     * Displays an error alert with the given message.
     * @param message The error message to be displayed.
     */
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Method to set background color based on time of day
    private void setBackgroundBasedOnTime(Region region) {
        LocalTime currentTime = LocalTime.now();
        if (currentTime.isAfter(LocalTime.of(6, 0)) && currentTime.isBefore(LocalTime.of(18, 0))) {
            // Daytime background
            region.setStyle("-fx-background-color: #99ccff;"); // Light blue
        } else {
            // Nighttime background
            region.setStyle("-fx-background-color: #01093b;"); // Dark blue
        }
    }
}

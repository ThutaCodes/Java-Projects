import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * The WeatherApiClient class is responsible for fetching weather data from the OpenWeatherMap API.
 */
public class WeatherApiClient {
    private static final String API_KEY = "468ba769c393d91c3184b9bb96291f3e";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

    /**
     * Fetches weather data by city name from the OpenWeatherMap API.
     *
     * @param cityName The name of the city for which weather data is to be fetched.
     * @return A string containing the JSON response with weather data.
     */
    public String getWeatherDataByCity(String cityName) {
        try {
            URL url = new URL(BASE_URL + "?q=" + cityName + "&appid=" + API_KEY);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Fetches weather data by coordinates (latitude and longitude) from the OpenWeatherMap API.
     *
     * @param latitude  The latitude of the location for which weather data is to be fetched.
     * @param longitude The longitude of the location for which weather data is to be fetched.
     * @return A string containing the JSON response with weather data.
     */
    public String getWeatherDataByCoordinates(double latitude, double longitude) {
        try {
            URL url = new URL(BASE_URL + "?lat=" + latitude + "&lon=" + longitude + "&appid=" + API_KEY);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

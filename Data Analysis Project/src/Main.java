import java.util.ArrayList;// Importing the java class 'ArrayList' from the java built-in library'java.util'

public class Main {
    // Calculate the average stock price from an array
    //Defining the 'calculateAveragePrice'method that takes in an array of stock prices and calculateAveragePrice price.
    public static float calculateAveragePrice(float[] prices) {
        float sum = 0; // Initialize the sum of prices to zero
        for (float price : prices) { // Loop through each price in the array
            sum += price;// Add each price to the sum
        }
        return sum / prices.length;// Return the average by dividing the sum by the number of prices
    }

    //Find the maximum stock price from an array
    //Defining the 'findMaximumPrice'method takes in an array of stock prices and returns the maximum price
    public static float findMaximumPrice(float[] prices) {
        float maxPrice = prices[0];// Set the initial maximum price as the first element in the array
        // Go through each price in the array 
        for (float price : prices) {
        // Check if the current price is greater than the current maximum price
            if (price > maxPrice) { //If it is, update the maximum price to the current price
                maxPrice = price;
            }
        }
        return maxPrice;//Return the maximum price found in the array
    }

    // Count occurrences of a specific price in an array
    //Define the method 'countOccurrences' that holds prices and targetPrice as paremeters.
    public static int countOccurrences(float[] prices, float targetPrice) {
        int count = 0;//Initialize a variable to count occurrences, starting at 0
        for (float price : prices) { //Loop through each price in the array
            if (price == targetPrice) {  //Check if the current price matches the target price
                count++; //If there's a match, increase the count by 1
            }
        }
        return count;//Return the total count of occurrences
    }

    // Compute cumulative sum of stock prices from an ArrayList
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        //Creating a new ArrayList to store the cumulative sum
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float sum = 0;//Initializing a variable 'sum'to hold the sum of prices
        //Loop through each price in the 'prices' ArrayList
        for (float price : prices) { 
            sum += price; //Add the current price to the sum
            cumulativeSum.add(sum);//Add the current sum to the 'cumulativeSum' ArrayList
        }
        return cumulativeSum;//Return the ArrayList containing the cumulative sums
    }

    public static void main(String[] args) {
        float[] stockPricesArray = { 	3092.06f,  //2023-1-16
            3122.82f,  //2023-1-17
            3107.61f,  //2023-1-18
            3141.87f,  //2023-1-19
            3147.10f,  //2023-1-20
            3128.32f,  //2023-1-23
            3130.00f,  //2023-1-24
            3145.05f,  //2023-1-25
            3146.43f,  //2023-1-26
            3153.42f,  //2023-1-27
        };
        /*This array contains the opening stock prices for Amazon (AMZN) from January 16, 2023, 
        to January 26, 2023, in USD. 
        The prices are obtained from Yahoo Finance.*/
        /*'f' is used as a suffix because numbers like these are considered as double by default.
        But when you explicitly add 'f' in the end, java will treat it as float value.*/

        //Creating an ArrayList to store the stock prices
        ArrayList<Float> stockPricesArrayList = new ArrayList<>();
        //Converting the array into an ArrayList
        for (float price : stockPricesArray) {
            stockPricesArrayList.add(price);//Adding each price from the array to the ArrayList
        }

        // Calculate average price
        float averagePrice = calculateAveragePrice(stockPricesArray);
        System.out.println("Average stock price (array): " + averagePrice);

        // Find maximum price
        float maxPrice = findMaximumPrice(stockPricesArray);
        System.out.println("Maximum stock price (array): " + maxPrice);

        // Count occurrences of a specific price
        float targetPrice = 3153.42f;
        int occurrences = countOccurrences(stockPricesArray, targetPrice);
        System.out.println("Occurrences of " + targetPrice + ": " + occurrences);

        // Compute cumulative sum
        ArrayList<Float> cumulativeSum = computeCumulativeSum(stockPricesArrayList);
        System.out.println("Cumulative sum (ArrayList): " + cumulativeSum );
    }
}

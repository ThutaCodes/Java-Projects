**Text Analysis Tool**

This program is designed to provide insights into any paragraph or lengthy text provided by the user. By simply inputting your text, you’ll unlock a range of features to explore its composition and characteristics. The tool calculates the total number of characters and words, identifies the most common character, and offers insights into the frequency of specific characters and words.

This Java program, encapsulated within the **Main** class, furnishes a suite of functionalities for text analysis.

Within the **analyzeText()** method, users are prompted to input text, initiating a sequence of analyses. The method calculates the character and word counts within the provided text, identifies the most frequently occurring character, and prompt user input to ascertain the frequency of specific characters and words. Additionally, it determines the number of unique words present in the text.

The **mostCommonCharacter()** method is instrumental in identifying the character that appears most frequently within the text. Employing lowercase conversion for case insensitivity, this method utilizes an array to track the occurrence frequency of each letter, ultimately returning the character with the highest frequency.

Similarly, the **countCharacterFrequency()** method facilitates the calculation of a specific character’s frequency within the text. Employing lowercase conversion for consistency, it iterates through the text, tallying occurrences of the provided character to furnish an accurate frequency count.

Concurrently, the **countWordFrequency()** method extends this functionality to words, enabling users to determine the frequency of a specific word within the text. Employing lowercase conversion for uniformity, it parses the text into individual words, iteratively counting occurrences of the specified word to provide a precise frequency count.

Supplementary to these analyses, the **countUniqueWords()** method discerns the number of unique words present within the text. By converting all words to lowercase and employing a **Set** data structure to eliminate duplicates, this method accurately computes the total count of unique words, offering valuable insight into the text’s lexical diversity.

Alongside with the analytical functions, the **askToContinue()** method facilitates user interaction by prompting them to continue or exit the program. Equipped with input validation to ensure user compliance, this method ensures a seamless user experience, allowing for iterative analysis as desired.

The **main()** method orchestrates the program's execution, iterating through the text analysis process until the user opts to exit. By invoking the **analyzeText()** method within a loop and utilizing the **askToContinue()** method to manage user input, the program seamlessly integrates analysis and user interaction, facilitating intuitive utilization.

**_Output_**

"C:\\Users\\User\\AppData\\Local\\Programs\\Eclipse Adoptium\\jdk-17.0.9.9-hotspot\\bin\\java.exe" "-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA 2023.2.5\\lib\\idea_rt.jar=52086:C:\\Program Files\\JetBrains\\IntelliJ IDEA 2023.2.5\\bin" -Dfile.encoding=UTF-8 -classpath "C:\\Users\\User\\IdeaProjects\\Text Analysis Tool\\out\\production\\Text Analysis Tool" Main

Please enter your text:

Peter Piper picked a peck of pickled peppers, a peck of pickled peppers Peter Piper picked. If Peter Piper picked a peck of pickled peppers, Where's the peck of pickled peppers Peter Piper picked?

Character Count: 196

Word Count: 34

Most Common Character: p

Please enter a character to check its frequency:

e

Frequency of 'e': 35

Please enter a word to check its frequency:

peter

Frequency of 'peter': 4

Number of Unique Words: 14

Do you want to continue? (Yes/No)

no

Exiting program...

Process finished with exit code 0

**_Output Screenshots_**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/d0c1a8be-53d9-4e0a-abcc-2d8202e0c769)

Screenshot-1

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/3339c18a-c3eb-49c3-b311-9f5c42c2de13)

Screenshot-2

**Please enter your text:**: This prompts the user to input text for analysis.

**Peter Piper picked a peck of pickled peppers, a peck of pickled peppers Peter Piper picked. If Peter Piper picked a peck of pickled peppers, Where's the peck of pickled peppers Peter Piper picked?:** This is the text entered by the user for analysis.

**Character Count: 196**: This indicates the total number of characters in the input text, including spaces and punctuation.

**Word Count: 34**: This indicates the total number of words in the input text.

**Most Common Character: e**: This indicates the character that appears most frequently in the input text.

**Please enter a character to check its frequency:** This prompts the user to input a specific character to check its frequency in the text.

**Frequency of 'e':** 35 - This is the frequency of the character 'e' in the text.

**Please enter a word to check its frequency: peter:** This prompts the user to input a specific word to check its frequency in the text.

**Frequency of 'peter':** 4 - This is the frequency of the word 'peter' in the text.

**Number of Unique Words:** 14 - This is the count of unique words in the text.

**Do you want to continue? (Yes/No):** The user is asked if they want to continue. If they choose “Yes,” they can input another text for analysis. If they choose “No,” the program terminates.

**_Choosing ‘No’…_**

**Exiting program...:** Displays exiting message.

**_If ‘Yes’ was chosen…_**

**yes**

**Please enter your text:**

They can input another text for analysis.

**_Error Handling Implementation:_**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/430daea7-3a10-4877-ad71-2518195ad440)

When the user enters any other characters, words or integers, the system will re-prompt the user to only Enter a Yes or a No.

**Islamic Quiz**

**_The source code is presented below. The explanations are added to each lines within the code in the form of comments._**

**_Screenshots of the output:_**

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/348b22cf-cfad-4b87-a70b-67566abe0da0)

As you can see, the welcome note for the user and the first question of the quiz is displayed. And the program is in the state of waiting for the user’s interaction with it.

Once the user answer the question, it will show the result, whether if it is correct or incorrect. As you may see that, I type the answer in the lowercase letter. But anyhow, the program manages to match the answer to the answer option. This is because of this line: **_char userAnswer = scanner.next().toUpperCase().charAt(0);_** I have included the explanation to it.

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/3ab37cbc-bd09-4b2a-b94e-8f0b1edf546b)

‘for’ loop will iterate through all five questions.

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/e3f2256b-7d55-429f-a140-ce37a969b619)

As you can see, I intentionally committed the wrong answer to prove that it is actually a working program. It is evident that I only answered 3 questions correctly out of 5. It also displays the result in percentage.

![image](https://github.com/ThutaCodes/Java-Projects/assets/157232035/2de9a788-7694-4a3b-bd64-de521db42cbf)

This is what you would expect to see if you got all the questions correct.

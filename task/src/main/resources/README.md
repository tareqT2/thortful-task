# Thortful API Challenge

* Before starting makew sure you have Java JDK 11 and maven installed on your local machine
* The application built it to show certain jokes using a 3rd part API: https://sv443.net/jokeapi/v2/
* To Launch the applicaiton locally you need to import the application as a maven project into your IDE workspace.
* Make sure maven build is triggered on the project to install the independices
* To run the application, you need to run TaskApplication as a Java application. The default port used is 8080, feel free to change this from the applicaiton.properies if it's conflicting with any other service.
* The base url of the Jokes API is localhost:8080/api/joke/, use curl or postman you would be able to see result joke result as JSON.
* The following url shows all the parameters can be used within this API, test it out and enjoy the jokes!
localhost:8080/api/joke/Programming,Miscellaneous,Dark,Pun,Spooky,Christmas?blacklistFlags=nsfw,religious,political,racist,sexist,explicit&type=single,twopart&contains=Java&amount=2
* From the above url you can extract certain scnearios to use for testing this API, Keep in mind all all of them are optional
- Programming,Miscellaneous,Dark,Pun,Spooky,Christmas are categories
- nsfw,religious,political,racist,sexist,explicit are blacklisted flag (example you can avoid racist jokes)
- single,twopart are used to decide if it's a single joke, or a 2 part (answer & question)
- contains=Java used to get jokes having a certain word/sentance
- amount=2 Optional,(min =1 & max = 10)
- Any invalid request or path paramaters should end up with Internal Servcer Error

 


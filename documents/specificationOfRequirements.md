<h1>Specifications of requirements</h1>
<h2>Purpose of the application</h2>
The purpose of this application is to help and give users a fun and easy way of learning a new language. 
To do so the application will provide a gamified approach into learning with its achivement section that is linked with the users progress during their learning period. With the use of this application, the users will have an easy access for adding new words into the user made lists and a way for practicing these words.
By completing these tasks, the user will see their progress and hopefully will be more motivated to continue their learning.
<h2>Users</h2>
There will only be a single user format that will have access to the ability for adding their 
own wordlists which can be combined with the words from other lists that the user has made during the game section of the program.
<h2>Interface sketch</h2>
This will act as a sketch that shows how some of the main views of the program would look like. This is, however, not the final look and it does not contain all the views of the application.
<img src="https://github.com/Branuz/ot-harjoitustyo/blob/master/documents/photos/flow_interface_sketch.png" width="600">

<h2>Programs functionality</h2>
<h3>Before login</h3>

- User can choose between login or creating a new account
  - By choosing the create a new account they will be forwarded to a section for this purpose
    - Account creation section will require the user to provide username, email, password and re-entering password.
    - This information will be stored in the database so that there can be multiple users for the application.
  
   - Login screen
      - There will be a username and password boxes and a login button that should be pressed after typing in the information that were used when registering the account.
      - If the username or password does not match with the information in the database there will be a notification for this and the user will be asked to double    check their information.
      - If the login details match with the databse information the user will be forwarder to mainscreen of the application.

<h3>After login</h3>

  - In the main GUI, there will be 3 sections to choose from at the top that are main menu, achievements and logout.
    - Main menu will be containing 2 options for word game and dictionary. These sections will lead to corresponding sections of the program.
     ---
     - <h3>Word game</h3>
      - This game will have a menu where the user will choose what sets of words they wish to pratice with. It will also have a start button which begins the game after selecting the wanted lists.
        - The game itself will give a random word from the chosen sets of words that the user will ne to provide a translation for. If the user is successfull they will be given a green light and passed to the next word. If the user fails they can try again or skip to next word.
       ---
       - <h3>Dictionary </h3>
       -  In the dictionary the user will be able to add new lists of words that can be selected and used in the word game selection when the user wishes to practice these. The user will also be able to edit and delete already excisting lists they have made. These lists will be saved in a database so the user will have access only to their own lists.
       ---
<h3>Achivements</h3>

In the achivements section of the application the user will have trophies that can be completed by passing the trophies requirements. When the user has successfully completed a trophy it will become visible and untill then it will be hidden.

<h3>Logout</h3> 

By clicking the logout icon the user will be logged out of the application so that a different user may login from the same computer.

<h2>Ideas for further developement</h2>

After creating the working basic version of the application it may be expanded by adding some of the following functionalities.
- New game types.
- Options section that could contain options such as changing the language of the application
- More statistics and rewards based on the students progress.
- Timed notification or popup to remind the user to complete their daily study goal.

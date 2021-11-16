<h1>Specifications of requirements</h1>
<h2>Purpose of the application</h2>
The purpose of this application is to help and give users a fun and easy way of learning a new language. 
To do so the application will provide a gamified approach into learning with its achivement and daily goals section that is linked with the users progress during their learning period. With the use of this application the users will have an easy access to preset chapters that will include different types of tasks such as filling up a sentence and giving a translations for words.
By completing these tasks the user will see their progress and hopefully will be more motivated to continue their learning.
<h2>Users</h2>
At first there will only be a single user format that will have access to the premade tasks and to the ability of adding their 
own wordlists which can be combined with the words already provided by the application.
In the future there might be an extra role for a moderator / teacher who has the ability to add new chapters and possibly new tasks for the users to complete.
<h2>Interface sketch</h2>
To be made

<h2>Programs functionality</h2>
<h3>Before login</h3>

- User can choose between login or creating a new account
  - By choosing the create a new account they will be forwarded to a section for this purpose
    - Account creation section will require the user to provide username, email, password and re-entering password.
    - This information will be stored in the database so that the user is able to access their progress through different devices.
  
   - Login screen
      - There will be a username and password boxes and a login button that should be pressed after typing in the information that were used when registering the account.
      - If the username or password does not match with the information in the database there will be a notification for this and the user will be asked to double    check their information.
      - If the login details match with the databse information the user will be forwarder to mainscreen of the application.

<h3>After login</h3>

  - In the main gui there will be 3 sections to choose from at the top that are main menu, achievements and logout
    - Main menu will be containing 3 options for chapters, word game and word book. These sections will lead to corresponding sections of the program.
     ---
     - <h3>Chapters</h3>
      - These are the chapters that are created by the moderator/possible teacher in the future but for now there will be a few basic ones provided in the basic program. Screen will have options like chapter 1, chapter 2 ...
        - After choosing which chapter the user would like to practice they will be forwaded to a screen that contains different topics of the specific chapter. These could be topics such as weekdays, numbers or introdcution for example.
        
        - Sections will have two different types of exercise at the basic version of the game that are translating a specific word from language a to language b or vise verca. And second game which will be sentence filling up. In the second game you will be given a sentences with blanks to fill from given list of words.
     ---
     - <h3>Word game</h3>
      - This game will have a menu where the user will choose what sets of words they wish to pratice. There will be two sections to choose from which are the words that are made by the user and saved as their own sets in the word book section of the game. There will also be lists of words available based on chapters such as all the words in chapter 1 or chapter 2. It will also have a start button which begins the game after selecting the wanted lists.
        - The game itself will give a random word from the chosen sets of words that the user will ne to provide a translation for. If the user is successfull they will be given a green light and passed to the next word. If the user fails the correct answer will be provided before the next words is brought up.
       ---
       - <h3>Word book </h3>
       -  In the word book the user will be able to add new words or lists of words that can be selected and used in the word gane selection when the user wishes to pratice these. The user will also be able to delete these lists. 

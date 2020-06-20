#Game of Games Java Server

### How to Set Up and Use the Server

- Clone this repository, navigate to application.properties
- Install MySQL Database and MySQL server
- Create a new connection in MySQL workbench. Name it, ensure clicking 'test connection' is successful.
- Create a new schema in the connected server. I named it "game_of_games"
- On the left hand side of MySQL workbench, you should see the 'SCHEMAS' tab. Below it, switch from 'Schemas' to 'Administration'
- Under MANAGEMENT, click "Users and Privileges". Add a new account with username and password.
- Return to application.properties, the first line should read "spring.datasource.url=jdbc:mysql://localhost:3306/game_of_games?serverTimezone=UTC" Ensure what you named your scheme is replaced with "game_of_games"
- update the following lines with the correct username and password. In my case, it reads: 
spring.datasource.username=cs4550su12020
spring.datasource.password=cs4550su12020

You should now be all set. Try and run DemoApplication. I recommend doing this through Intellij.
 
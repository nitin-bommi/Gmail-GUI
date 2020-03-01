# Gmail-GUI

### Getting the code
The code is made public and you can clone/fork it for your development.

### About the code
The code makes use of `JavaMail` API which is used to compose, write and read emails.

The `JavaMail` API provides protocol-independent and plateform-independent framework for sending and receiving mails.

More about `JavaMail` API can be found [here](https://javaee.github.io/javamail/).

### Setting up the environment

* #### On an application
If the code is being tested/run on an application(IntelliJ, Eclipse, etc.) follow the steps below.

  1. The Dependecies are available in the folder [here](https://github.com/Nitin1901/Gmail-GUI/tree/master/Dependancies).

  2. Import the dependancies into the workspace and the code should now be able to execute perfectly fine. (*raise an issue if it doesn't work*)

* #### On terminal/cmd
If you are using a terminal/cmd, make sure the `.jar` files are in the same directory as the code and follow the steps.

  1. Load the .jar file
  ```java
  set classpath=mail.jar;activation.jar;.;
  ```

  2. Compile the source code
  ```java
  javac Gmail.java
  ```
  
  3. Run the code
  ```java
  java Gmail
  ```
  
For any issues, raise an issue [here](https://github.com/Nitin1901/Gmail-GUI/issues).

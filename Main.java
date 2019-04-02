package BeltLineApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("resources/fxml/UserLogin.fxml"));
        primaryStage.setTitle("BeltLine");
        Scene rootScene = new Scene(root, 280, 215);
        primaryStage.setScene(rootScene);
        primaryStage.show();
        primaryStage.setResizable(false);
        //primaryStage.centerOnScreen();

        //setting all scenes based on document
        Parent registerNavigation = FXMLLoader.load(getClass().getResource("resources/fxml/RegisterNavigation.fxml"));
        Scene registerNavigationScene = new Scene(registerNavigation, 250, 290);

        Parent registerUser = FXMLLoader.load(getClass().getResource("resources/fxml/RegisterUser.fxml"));
        Scene registerUserScene = new Scene(registerUser, 600, 400);

        Parent registerVisitorOnly = FXMLLoader.load(getClass().getResource("resources/fxml/RegisterVisitorOnly.fxml"));
        Scene registerVisitorOnlyScene = new Scene(registerVisitorOnly, 600, 400);

        Parent registerEmployeeOnly = FXMLLoader.load(getClass().getResource("resources/fxml/RegisterEmployeeOnly.fxml"));
        Scene registerEmployeeOnlyScene = new Scene(registerEmployeeOnly, 600, 500);

        Parent registerEmployeeVisitor = FXMLLoader.load(getClass().getResource("resources/fxml/RegisterEmployeeVisitor.fxml"));
        Scene registerEmployeeVisitorScene = new Scene(registerEmployeeVisitor, 600, 500);

        Parent userFunctionality = FXMLLoader.load(getClass().getResource("resources/fxml/userFunctionality.fxml"));
        Scene userFunctionalityScene = new Scene(userFunctionality, 250, 200);

        Parent userTakeTransit = FXMLLoader.load(getClass().getResource("resources/fxml/userTakeTransit.fxml"));
        Scene userTakeTransitScene = new Scene(userTakeTransit, 600, 450);

        //User Login Functionality
        //User Login to Register Navigation
        Button register = (Button) root.lookup("#register");
        register.setOnAction(e-> primaryStage.setScene(registerNavigationScene));

        //Register Navigation Functionality
        //Register Navigation to User Only
        Button userOnly = (Button) registerNavigation.lookup("#userOnly");
        userOnly.setOnAction(e-> primaryStage.setScene(registerUserScene));

        //Register Navigation to Visitor Only
        Button visitorOnly = (Button) registerNavigation.lookup("#visitorOnly");
        visitorOnly.setOnAction(e-> primaryStage.setScene(registerVisitorOnlyScene));

        //Register Navigation to Employee Only
        Button employeeOnly = (Button) registerNavigation.lookup("#employeeOnly");
        employeeOnly.setOnAction(e-> primaryStage.setScene(registerEmployeeOnlyScene));

        //Register Navigation to Employee-Visitor Only
        Button employeeVisitor = (Button) registerNavigation.lookup("#employeeVisitor");
        employeeVisitor.setOnAction(e-> primaryStage.setScene(registerEmployeeVisitorScene));

        //Register Navigation back to User Login
        Button backRegisterNavigation = (Button) registerNavigation.lookup("#back");
        backRegisterNavigation.setOnAction(e-> primaryStage.setScene(rootScene));

        //Register User
        //back to Register Navigation
        Button backRegisterUser = (Button) registerUser.lookup("#back");
        backRegisterUser.setOnAction(e-> primaryStage.setScene(registerNavigationScene));

        //Register to User Functionality
        Button registerRegisterUser = (Button) registerUser.lookup("#register");
        registerRegisterUser.setOnAction(e-> primaryStage.setScene(userFunctionalityScene));

        //User Functionality
        //User to Take Transit
        Button takeTransitUserFunct = (Button) userFunctionality.lookup("#takeTransit");
        takeTransitUserFunct.setOnAction(e-> primaryStage.setScene(userTakeTransitScene));

        //User Functionality Back
        Button backUserFunctionality = (Button) userFunctionality.lookup("#back");
        backUserFunctionality.setOnAction(e-> primaryStage.setScene(rootScene));
    }


    public static void main(String[] args) {
        launch(args);
    }
}

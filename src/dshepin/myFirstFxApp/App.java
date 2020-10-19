package dshepin.myFirstFxApp;

import dshepin.myFirstFxApp.logic.Calculator;
import dshepin.myFirstFxApp.logic.processor.DataProcesser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan("dshepin.myFirstFxApp")
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fx/window.fxml"));
        primaryStage.setTitle("Коммунальный калькулятор.");

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

      /*  ApplicationContext context =
                new AnnotationConfigApplicationContext("dshepin.myFirstFxApp");*/
        ApplicationContext context = new ClassPathXmlApplicationContext("annotations-autowired-config.xml");
        DataProcesser dataProcesser = (DataProcesser) context.getBean(DataProcesser.class);
        Calculator calculator = (Calculator) context.getBean(Calculator.class);
    }


    public static void main(String[] args) {
        launch(args);
    }
}

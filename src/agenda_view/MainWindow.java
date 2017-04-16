package agenda_view;

import java.util.TimeZone;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Agenda;
import model.MyCalendar;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;


public class MainWindow extends Application{
	
	//public static MyCalendar calendar;
	
	protected static model.Agenda agenda = new model.Agenda();
	
	
	//the root
	static BorderPane root = new BorderPane();
	
	//the actions menu
	static Menu actions;
	//the month pane
	static MonthPane mp;
	//the week pane
	static WeekPane wp;
	//menu item to move to week view
	static MenuItem weekView = new MenuItem("Week View");
	//menu item to move to month view
	static MenuItem monthView = new MenuItem("Month View");;
	

	//sets the agenda used by the application-- should be called at beginning of program.
	public void setAgenda(model.Agenda agenda) {
		this.agenda = agenda;
	}
	
	@Override
	public void start(Stage primaryStage) {

		//Border Layout Root
		
		Scene scene = new Scene(root,800,600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				
		//Menu Bar
		MenuBar menuBar = new MenuBar();

		//Actions
        actions = new Menu("Actions");
        MenuItem addEvent = new MenuItem("Add Event");
        actions.getItems().add(addEvent);

		//File
		Menu file = new Menu("File");
		MenuItem quit = new MenuItem("Quit"); 
		quit.setOnAction( (e) -> {
			primaryStage.close();
		});
		
		//Add items to file
		file.getItems().add(quit);
		
		//Add menus to bar
		menuBar.getMenus().add(file);
		
		
		//Add Elements to the root.
		root.setTop(menuBar);
				
		// Add the Week Pane for testing.
		wp = new WeekPane();
		root.setCenter(wp);
		
		//java.util Calendar (we might want to refactor our Calendar Class to avoid duplicate names).
		java.util.Calendar c = java.util.Calendar.getInstance(TimeZone.getDefault());
		
		//Use to test dates in the MonthPane. 
		//Month is 0 based, year and day start at 1.
		//c.set(2017, 3, 31);
		
		//null as a parameter will result in the same as the c above.
		mp = new MonthPane(c);
//		root.setCenter(mp);

        //Month View NOTE: This needed to be down here for it to work, maybe someone else has a better way of doing this
        //Week View, see above
        monthView.setOnAction( (e) -> {
            loadMonthView();
        });
        weekView.setOnAction( (e) -> {
            loadWeekView();
        });
       addEvent.setOnAction( (e) -> {
    	   loadEventPane();
       });


        //Add items to actions
        actions.getItems().add(monthView);

        //Add menus to bar
        menuBar.getMenus().add(actions);

		//Show the stage. 
		primaryStage.setTitle("HCI Group Project");
		primaryStage.setMinWidth(800);
		primaryStage.setMinHeight(600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void startGUI(String[] args) {
		launch(args); 
	}
	
	protected static void loadWeekView(){
		root.setCenter(wp);
        actions.getItems().add(monthView);
        actions.getItems().removeAll(weekView);
	}
	
	protected static void loadMonthView(){
		root.setCenter(mp);
        actions.getItems().add(weekView);
        actions.getItems().removeAll(monthView);
	}
	
	protected static void loadEventPane(){
		root.setCenter(new BigEventPane());
	}

}

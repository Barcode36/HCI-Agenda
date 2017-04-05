package agenda_view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

/*
 * This class will define the view for a week
 * 
 * 
 */
public class WeekPane extends GridPane{
	
	public WeekPane() {
		
		this.setGridLinesVisible(true);
		final int numCols = 14;
		final int numRows = 24;
		for(int i = 0; i < numCols; i++ ) {
			ColumnConstraints colConst = new ColumnConstraints();
			if(i % 2 == 0) {
				colConst.setPercentWidth(100.0 / numCols /2);
			}
			else {
				colConst.setPercentWidth(100.0 / numCols * 2);
			}
			this.getColumnConstraints().add(colConst);
		}
		for(int i = 0; i < numRows; i++) {
			RowConstraints rowConst = new RowConstraints();
			rowConst.setPercentHeight(100.0 / numRows);
			this.getRowConstraints().add(rowConst);
		}
		
		for(int i = 0; i < numCols; i+=2) {
			for(int j = 1; j <= numRows/2; j++) {
				Label hour = new Label(""+j);
				this.add(hour, i, j);
			}
			for(int j = 1; j <= numRows/2; j++) {
				Label hour = new Label(""+j);
				this.add(hour, i, j+12);
			}
		}
		
		
		Label sundayLbl = new Label ("Sunday");
		this.add(sundayLbl, 1, 0);
		
		Label mondayLbl = new Label ("Monday");
		this.add(mondayLbl, 3, 0);
		
		Label tuesdayLbl = new Label("Tuesday");
		this.add(tuesdayLbl, 5, 0);
		
		Label wednesdayLbl = new Label ("Wednesday");
		this.add(wednesdayLbl, 7, 0);
		
		Label thursdayLbl = new Label ("Thursday");
		this.add(thursdayLbl, 9, 0);
		
		Label fridayLbl = new Label ("Friday");
		this.add(fridayLbl, 11, 0);
		
		Label saturdayLbl = new Label ("Saturday");
		this.add(saturdayLbl, 13, 0);
		
	}
	
	private void init() {
		
		
	}
}

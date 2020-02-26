package dad.javafx.calendario;

import dad.javafx.componentes.MonthCalendar;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class CalendarioController implements Initializable {
	// Model
	private IntegerProperty yearModel = new SimpleIntegerProperty();
	@FXML
	private GridPane view;

	@FXML
	private Button previousButton;

	@FXML
	private Button nextButton;

	@FXML
	private Label year;

	@FXML
	void onNextActionButton(ActionEvent event) {
		yearModel.set(getYearModel() + 1);
	}

	@FXML
	void onPreviousActionButton(ActionEvent event) {
		yearModel.set(getYearModel() - 1);
	}

	public CalendarioController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CalendariofFullView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		yearModel.addListener((o, ov, nv) -> onChanges(nv));
		yearModel.set(LocalDate.now().getYear());
		year.textProperty().bind(yearModelProperty().asString());
		yearModel.set(LocalDate.now().getYear());
		inicializaMeses();
	}

	private void onChanges(Number nv) {
		MonthCalendar mCalendar;
		for (int i = 3; i < 15; i++) {
			mCalendar = (MonthCalendar) view.getChildren().get(i);
			mCalendar.setYear(nv.intValue());
		}
	}

	public void inicializaMeses() {
		MonthCalendar mCalendar;
		for (int i = 3, j = 0; i < 15; i++, j++) {

			mCalendar = (MonthCalendar) view.getChildren().get(i);
			mCalendar.setMonth(j);
		}
	}

	public final IntegerProperty yearModelProperty() {
		return this.yearModel;
	}

	public final int getYearModel() {
		return this.yearModelProperty().get();
	}

	public final void setYearModel(final int yearModel) {
		this.yearModelProperty().set(yearModel);
	}

	public GridPane getView() {
		return view;
	}

}

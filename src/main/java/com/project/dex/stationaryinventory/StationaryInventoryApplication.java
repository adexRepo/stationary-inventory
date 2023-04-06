package com.project.dex.stationaryinventory;

import static com.project.dex.stationaryinventory.common.jfxsupport.GUIState.getStage;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.project.dex.stationaryinventory.common.jfxsupport.AbstractFxmlView;
import com.project.dex.stationaryinventory.common.jfxsupport.GUIState;
import com.project.dex.stationaryinventory.common.jfxsupport.PropertyReaderHelper;
import com.project.dex.stationaryinventory.view.LoginView;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@SpringBootApplication
public class StationaryInventoryApplication extends Application {

	private static Logger LOGGER = LoggerFactory.getLogger(StationaryInventoryApplication.class);
	private static ConfigurableApplicationContext applicationContext;
	private static List<Image> icons = new ArrayList<>();

	@Override
	public void init() throws Exception {
		// called immediately after the Application class is loaded and constructed
		SpringApplicationBuilder builder = new SpringApplicationBuilder(StationaryInventoryApplication.class);
		builder.application().setWebApplicationType(WebApplicationType.NONE);
		applicationContext = builder.run(getParameters().getRaw().toArray(new String[0]));
		// final List<String> fsImages =
		// PropertyReaderHelper.get(applicationContext.getEnvironment(),
		// "javafx.appicons");
		// if (!fsImages.isEmpty()) {
		// fsImages.forEach((s) -> icons.add(new
		// Image(getClass().getResource(s).toExternalForm())));
		// } else {
		// icons.add(new
		// Image(getClass().getResource("/images/gear_16x16.png").toExternalForm()));
		// }
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// The start method is called after the init method has returned
		GUIState.setStage(primaryStage);
		GUIState.setHostServices(this.getHostServices());
		showInitialView();
	}

	@Override
	public void stop() throws Exception {
		applicationContext.close();
	}

	private void showInitialView() {
		final String stageStyle = applicationContext.getEnvironment().getProperty("javafx.stage.style");
		if (stageStyle != null) {
			getStage().initStyle(StageStyle.valueOf(stageStyle.toUpperCase()));
		} else {
			getStage().initStyle(StageStyle.DECORATED);
		}
		// showView(MainView.class);
		showView(LoginView.class);
	}

	public static void showView(final Class<? extends AbstractFxmlView> newView) {
		try {
			final AbstractFxmlView view = applicationContext.getBean(newView);

			if (GUIState.getScene() == null) {
				GUIState.setScene(new Scene(view.getView()));
			} else {
				GUIState.getScene().setRoot(view.getView());
			}
			getStage().setScene(GUIState.getScene());
			applyEnvPropsToView();
			getStage().getIcons().addAll(icons);
			// GUIState.getStage().addEventHandler(WindowEvent.WINDOW_SHOWN, e -> {
			// if (view.getFxmlLoader().getController() instanceof LoginController) {
			// LoginController loginController = (LoginController)
			// view.getFxmlLoader().getController();
			// loginController.onWindowShownEvent();
			// }
			// LOGGER.debug("Stage view shown: {} ", view.getClass());
			// });
			getStage().show();
		} catch (Throwable t) {
			LOGGER.error("Failed to load application: ", t);
			showErrorAlert(t);
		}
	}

	private static void applyEnvPropsToView() {
		PropertyReaderHelper.setIfPresent(
				applicationContext.getEnvironment(),
				"javafx.title",
				String.class,
				getStage()::setTitle);

		PropertyReaderHelper.setIfPresent(
				applicationContext.getEnvironment(),
				"javafx.stage.width",
				Double.class,
				// (val) -> getStage().setWidth(val));
				getStage()::setWidth);

		PropertyReaderHelper.setIfPresent(
				applicationContext.getEnvironment(),
				"javafx.stage.height",
				Double.class,
				// (val) -> getStage().setHeight(val));
				getStage()::setHeight);

		PropertyReaderHelper.setIfPresent(
				applicationContext.getEnvironment(),
				"javafx.stage.resizable",
				Boolean.class,
				// (val) -> getStage().setResizable(val));
				getStage()::setResizable);
	}

	private static void showErrorAlert(Throwable throwable) {
		Alert alert = new Alert(AlertType.ERROR, "Oops! An unrecoverable error occurred.\n"
				+ "Please contact your software vendor.\n\n" + "The application will stop now.");
		alert.showAndWait().ifPresent(response -> Platform.exit());
	}

	public static void main(String[] args) {
		SpringApplication.run(StationaryInventoryApplication.class, args);
	}

}

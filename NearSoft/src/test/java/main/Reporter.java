package main;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * This class houses few utilities required for the report
 */
@SuppressWarnings("unused")
public class Reporter {
    private static Map<String, Boolean> systemInfoKeyMap = new HashMap<String, Boolean>();

    private Reporter() {
        // Defeat instantiation
    }

    
    /**
     * Gets the {@link ExtentHtmlReporter} instance created through listener
     *
     * @return The {@link ExtentHtmlReporter} instance
     */
    public static ExtentHtmlReporter getExtentHtmlReport() {
        return ExtentCucumberFormatter.getExtentHtmlReport();
    }

    /**
     * Gets the {@link KlovReporter} instance created through listener
     *
     * @return The {@link KlovReporter} instance
     */
    public static KlovReporter getKlovReport() {
        return ExtentCucumberFormatter.getKlovReport();
    }

    /**
     * Gets the {@link ExtentReports} instance created through the listener
     *
     * @return The {@link ExtentReports} instance
     */
    public static ExtentReports getExtentReport() {
        return ExtentCucumberFormatter.getExtentReport();
    }

    /**
     * Loads the XML config file
     *
     * @param xmlPath The xml path in string
     */
    public static void loadXMLConfig(String xmlPath) {
        getExtentHtmlReport().loadXMLConfig(xmlPath);
    }

    /**
     * Loads the XML config file
     *
     * @param file The file path of the XML
     */
    public static void loadXMLConfig(File file) {
        getExtentHtmlReport().loadXMLConfig(file);
    }

    /**
     * Adds an info message to the current step
     *
     * @param message The message to be logged to the current step
     */
    public static void addStepLog(String message) {
        getCurrentStep().info(message);
      
    }

    /**
     * Adds an info message to the current scenario
     *
     * @param message The message to be logged to the current scenario
     */
    public static void addScenarioLog(String message) {
        getCurrentScenario().info(message);
        
    }

    /**
     * Adds the screenshot from the given path to the current step
     *
     * @param imagePath The image path
     * @throws IOException Exception if imagePath is erroneous
     */
    public static void addScreenCaptureFromPath(String imagePath) throws IOException {
    	//getCurrentStep().addScreenCaptureFromPath(imagePath);
    	getCurrentScenario().addScreenCaptureFromPath(imagePath);
       
        
    }

    /**
     * Adds the screenshot from the given path with the given title to the current step
     *
     * @param imagePath The image path
     * @param title     The title for the image
     * @throws IOException Exception if imagePath is erroneous
     */
    
	/*
	 * public static void afterScenario(Scenario scenario) { if
	 * (scenario.isFailed()) { String screenshotName =
	 * scenario.getName().replaceAll(" ", "_"); try { //This takes a screenshot from
	 * the driver at save it to the specified location
	 * 
	 * File sourcePath = ((TakesScreenshot)
	 * CucumberRunner.driver).getScreenshotAs(OutputType.FILE);
	 * 
	 * //Building up the destination path for the screenshot to save //Also make
	 * sure to create a folder 'screenshots' with in the cucumber-report folder File
	 * destinationPath = new File(System.getProperty("user.dir") +
	 * "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
	 * 
	 * //Copy taken screenshot from source location to destination location
	 * Files.copy(sourcePath, destinationPath);
	 * 
	 * //This attach the specified screenshot to the test
	 * Reporter.addScreenCaptureFromPath(destinationPath.toString()); if
	 * (scenario.equals("Success")) { screenshotName =
	 * scenario.getName().replaceAll(" ", "_");
	 * 
	 * //This takes a screenshot from the driver at save it to the specified
	 * location
	 * 
	 * sourcePath = ((TakesScreenshot)
	 * CucumberRunner.driver).getScreenshotAs(OutputType.FILE);
	 * 
	 * //Building up the destination path for the screenshot to save //Also make
	 * sure to create a folder 'screenshots' with in the cucumber-report folder
	 * destinationPath = new File(System.getProperty("user.dir") +
	 * "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
	 * 
	 * //Copy taken screenshot from source location to destination location
	 * Files.copy(sourcePath, destinationPath);
	 * 
	 * //This attach the specified screenshot to the test
	 * Reporter.addScreenCaptureFromPath(destinationPath.toString()); } } catch
	 * (IOException e) { } }
	 * 
	 * 
	 * }
	 */
    
    
    
    
    public static void addScreenCaptureFromPath(String imagePath, String title) throws IOException {
        getCurrentStep().addScreenCaptureFromPath(imagePath, title);
    }

    /**
     * Adds the screen cast from the given path to the current step
     *
     * @param screenCastPath The screen cast path
     * @throws IOException Exception if imagePath is erroneous
     */
    public static void addScreenCast(String screenCastPath) throws IOException {
        getCurrentStep().addScreencastFromPath(screenCastPath);
    }

    /**
     * Sets the system information with the given key value pair
     *
     * @param key   The name of the key
     * @param value The value of the given key
     */
    
    public static void setSystemInfo(String key, String value) {
        if (systemInfoKeyMap.isEmpty() || !systemInfoKeyMap.containsKey(key)) {
            systemInfoKeyMap.put(key, false);
        }
        if (systemInfoKeyMap.get(key)) {
            return;
        }
        getExtentReport().setSystemInfo(key, value);
        systemInfoKeyMap.put(key, true);
    }

    /**
     * Sets the test runner output with the given list of strings
     *
     * @param log The list of string messages
     */
    public static void setTestRunnerOutput(List<String> log) {
        getExtentReport().setTestRunnerOutput(log);
    }

    /**
     * Sets the test runner output with the given string
     *
     * @param outputMessage The message to be shown in the test runner output screen
     */
    public static void setTestRunnerOutput(String outputMessage) {
        getExtentReport().setTestRunnerOutput(outputMessage);
    }

    /**
     * Sets the author name for the current scenario
     * @param authorName The author name of the current scenario
     */
    public static void assignAuthor(String... authorName) {
        getCurrentScenario().assignAuthor(authorName);
    }

    private static ExtentTest getCurrentStep() {
        return ExtentCucumberFormatter.stepTestThreadLocal.get();
    }

    private static ExtentTest getCurrentScenario() {
        return ExtentCucumberFormatter.scenarioThreadLocal.get();
    }
   /* private static ExtentTest getCurrentScenario1() {
        return ExtentCucumberFormatter.getExtentReport().createTest(CucumberRunner.BrowserType4, "Test1");
    }*/
}

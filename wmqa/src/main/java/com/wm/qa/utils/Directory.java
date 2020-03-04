package com.wm.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;

import com.wm.qa.enums.ReportLabels;
import com.wm.qa.exceptions.WmReporterException;
import com.wm.qa.writers.HTMLDesignFilesWriter;
import com.wm.qa.WmReports;
/**
 * Configurations
 * @author Babu 
 *
 */
public class Directory {

	static Logger log = Logger.getLogger(Directory.class.getName());
	public static final String CURRENTDir = System.getProperty("user.dir");
	public static final String SEP = System.getProperty("file.separator");
	public static String REPORTSDIRName = "Sensiple Reports";
	public static String REPORTSDir = CURRENTDir + SEP + REPORTSDIRName;
	public static String RESULTSDir = REPORTSDir + SEP + "Results";
	public static String HTMLDESIGNDIRName = "HTML_Design_Files";
	public static String HTMLDESIGNDir = REPORTSDir + SEP + HTMLDESIGNDIRName;
	public static String CSSDIRName = "CSS";
	public static String CSSDir = HTMLDESIGNDir + SEP + CSSDIRName;
	public static String IMGDIRName = "IMG";
	public static String IMGDir = HTMLDESIGNDir + SEP + IMGDIRName;
	public static String JSDIRName = "JS";
	public static String JSDir = HTMLDESIGNDir + SEP + JSDIRName;
	public static String RUNName = "Test Execution_1"; // Babu
	public static String RUNDir = RESULTSDir + SEP + RUNName;
	public static String SETTINGSFile = RESULTSDir + SEP + "Settings.properties";
	public static final char JS_SETTINGS_DELIM = ';';
	public static final String REPO_DELIM = "##@##@##";
	public static final char JS_FILE_DELIM = ',';
	public static final String MENU_LINK_NAME = "Run ";
	public static final String SCREENSHOT_TYPE = "PNG";
	public static final String SCREENSHOT_EXTENSION = ".PNG";
	private static String logo = null;
	public static String SCREENSHOT_DIRName = "img";
	public static boolean generateConfigReports = true;
	public static boolean generateExcelReports = false;
	public static boolean takeScreenshot = false;
	public static boolean continueExecutionAfterStepFailed = false;
	public static boolean recordExecutionAvailable = false;
	public static boolean recordSuiteExecution = false;
	public static boolean recordTestMethodExecution = false;
	public static boolean reexecution=true;
	public static final String MAIN_RECORD_FILE_NAME = "ATU_CompleteSuiteRecording";
	public static String userName=null;
	public static String password=null;
	public static String smtpHost=null;
	public static String fromAddress=null;
	public static String toAddress=null;
	public static String ccAddress=null;
	//public static String bccAddress=null;
	public static String testCasePath=null;
	public static String ORSheetPath=null;
	public static String browser=null;
	public static String Subject=null;
	public static String Reports_Path=null;
	public static String Zipfolder_Path=null;
	public static String WIDGET_HTML_FILE=null;
	public static String WaitFor=null;
	public static String yopmailurl=null;
	
	public static String uploadFilePath=null;
	public static String MailDropurl=null;
	
	public static String Guerrillamailurl=null;
	
	public static String Oracle_Port=null;
	public static String Oracle_Databasename=null;
	public static String Oracle_User=null;
	public static String Oracle_Pass =null;
	public static String Oracle_Hostname=null;
	public static String Sql_Hostname=null;
	public static String Sql_Databasename=null;
	public static String Sql_User=null;
	public static String Sql_Pass=null;
	public static String Sql_Port=null;	
	
	public static String MOBILE_APPPATH=null;
	public static String MOBILEAPP_APK_NAME=null;
	public static String MOBILE_DEVICE_NAME=null;
	public static String MOBILE_DEVICE_VERSION=null;
	public static String MOBILE_APK_APPPACKAGE=null;
	public static String MOBILE_APK_appActivity=null;
	public static String MOBILE_DEVICE_TYPE=null;
	public static String MOBILE_IOSDEVICE_UDID= null;
	public static String MOBILE_APP_TYPE=null;
	public static String MOBILE_WEB_BROWSER_NAME=null;
	public static String MOBILE_WEB_URL=null;

	
	public static String GRID_IP=null;
	
	public static String QS_MONTH=null;
	public static String QS_DAY=null;
	public static String QS_YEAR=null;


	/**
	 * Retrieve values from custom properties
	 * @throws WmReporterException
	 * @throws Exception 
	 */
	public static void init() throws WmReporterException, Exception {
		if (getCustomProperties() != null) {
			log.info("Reading from custom properties");
			Properties localProperties = new Properties();

			try {
				localProperties.load(new FileReader(getCustomProperties()));
				String reportsDir = localProperties.getProperty("wm.reports.dir")			.trim();
				String headerText = localProperties.getProperty(			"wm.proj.header.text").trim();	
				String projectDescription = localProperties.getProperty(			"wm.proj.description").trim();
				String takeScreenShot = localProperties.getProperty(			"wm.reports.takescreenshot").trim();
				String configReports = localProperties.getProperty(			"wm.reports.configurationreports").trim();
				String excelReport = localProperties.getProperty("wm.reports.excel")			.trim();
				String contExectution = localProperties.getProperty(			"wm.reports.continueExecutionAfterStepFailed").trim();
				String reExecution = localProperties.getProperty(   "wm.failures.reexecution").trim();
				//String recordExecution = localProperties.getProperty(			"wm.reports.recordExecution").trim();
				userName = localProperties.getProperty(			"wm.mail.username").trim();
				password = localProperties.getProperty(			"wm.mail.password").trim();
				smtpHost = localProperties.getProperty(			"wm.mail.smtp.host").trim();
				fromAddress = localProperties.getProperty(			"wm.mail.from.address").trim();
				toAddress = localProperties.getProperty(			"wm.mail.to.address").trim();
				ccAddress = localProperties.getProperty(				"wm.mail.cc.address").trim();	
				Subject = localProperties.getProperty(				"wm.mail.subject").trim();
				Reports_Path = localProperties.getProperty(				"wm.reports.dir").trim();
				Zipfolder_Path = localProperties.getProperty(				"wm.mail.zipfolder").trim();
				testCasePath = localProperties.getProperty(			"wm.proj.testcasePath").trim();
				String ORSheet = localProperties.getProperty(			"wm.proj.ORSheet.path").trim();
				ORSheetPath=testCasePath+"/"+ORSheet;
				browser = localProperties.getProperty(			"wm.browser.name").trim().toLowerCase();
				//WIDGET_HTML_FILE = localProperties.getProperty(			"zado.proj.widget").trim().toLowerCase();
				WaitFor = localProperties.getProperty(			"wm.proj.waitSec").trim().toLowerCase();				
				//Properties urlsProperties = new Properties();
				System.out.println("testCasePath: "+testCasePath);								
				String uploadPath=localProperties.getProperty(   "wm.proj.uploadfile").trim();
				uploadFilePath=testCasePath+"/"+uploadPath+"/";
				String logo1 = localProperties.getProperty("wm.proj.header.logo")			.trim();
				logo=uploadFilePath+logo1;

				//Mobile Configuration
				String MOBILE_APP_PATH=localProperties.getProperty(   "wm.mobileapp.apk.path").trim();
				MOBILE_APPPATH=uploadFilePath+MOBILE_APP_PATH;
				MOBILEAPP_APK_NAME=localProperties.getProperty(   "wm.mobile.apk.name").trim();
				MOBILE_DEVICE_NAME=localProperties.getProperty(   "wm.mobile.devicename").trim();
				MOBILE_DEVICE_VERSION=localProperties.getProperty(   "wm.mobile.version").trim();
				MOBILE_APK_APPPACKAGE=localProperties.getProperty(   "wm.mobile.apppackage.name").trim();
				MOBILE_APK_appActivity=localProperties.getProperty(   "wm.mobile.apk.appActivity").trim();
				MOBILE_APP_TYPE = localProperties.getProperty(   "wm.mobile.app.type").trim();
				MOBILE_WEB_BROWSER_NAME = localProperties.getProperty(   "wm.mobile.web.browser").trim();
				MOBILE_WEB_URL = localProperties.getProperty(   "wm.mobile.web.Url").trim();
				MOBILE_DEVICE_TYPE = localProperties.getProperty(   "wm.mobile.device.type").trim();
				MOBILE_IOSDEVICE_UDID = localProperties.getProperty(   "wm.ios.mobile.udid").trim();
				GRID_IP = localProperties.getProperty(			"wm.Grid").trim().toLowerCase();

				
				try {
					if ((headerText != null) && (headerText.length() > 0)) {
						ReportLabels.HEADER_TEXT.setLabel(headerText);
					}
					if ((reExecution != null) && (reExecution.length() > 0)) {
						try {
							reexecution = Boolean.parseBoolean(reExecution);
						} catch (Exception localException1) {
						}
					}
					if ((takeScreenShot != null) && (takeScreenShot.length() > 0)) {
						try {
							takeScreenshot = Boolean.parseBoolean(takeScreenShot);
						} catch (Exception localException1) {
						}
					}
					if ((configReports != null) && (configReports.length() > 0)) {
						try {
							generateConfigReports = Boolean.parseBoolean(configReports);
						} catch (Exception localException2) {
						}
					}
					if ((excelReport != null) && (excelReport.length() > 0)) {
						try {
							generateExcelReports = Boolean.parseBoolean(excelReport);
						} catch (Exception localException3) {
						}
					}
					if ((contExectution != null) && (contExectution.length() > 0)) {
						try {
							continueExecutionAfterStepFailed = Boolean
									.parseBoolean(contExectution);
						} catch (Exception localException4) {
						}
					}
					/*if ((recordExecution != null) && (recordExecution.length() > 0)) {
			try {
			    RecordingFor localRecordingFor = RecordingFor
				    .valueOf(recordExecution.toUpperCase());
			    if (localRecordingFor == RecordingFor.SUITE) {
				recordSuiteExecution = true;
			    } else if (localRecordingFor == RecordingFor.TESTMETHOD) {
				recordTestMethodExecution = true;
			    }
			} catch (Throwable localThrowable) {
			}
		    }
					File file = new File(reportsDir);
					if(file.exists())
					{
						FileUtils.cleanDirectory(file); //clean out directory (this is optional -- but good know)
			            FileUtils.forceDelete(file);
						System.out.println("Report directory deleted");
					}*/
					File outputFile = new File(Directory.Zipfolder_Path);
					if(!outputFile.exists()){
						outputFile.mkdir();
					}


					if ((projectDescription != null) && (projectDescription.length() > 0)) {
						WmReports.indexPageDescription = projectDescription;
					}
					if ((reportsDir != null) && (reportsDir.length() > 0)) {
						REPORTSDir = reportsDir;
						REPORTSDIRName = new File(REPORTSDir).getName();
						RESULTSDir = REPORTSDir + SEP + "Results";
						HTMLDESIGNDIRName = "HTML_Design_Files";
						HTMLDESIGNDir = REPORTSDir + SEP + HTMLDESIGNDIRName;
						CSSDIRName = "CSS";
						CSSDir = HTMLDESIGNDir + SEP + CSSDIRName;
						IMGDIRName = "IMG";
						IMGDir = HTMLDESIGNDir + SEP + IMGDIRName;
						JSDIRName = "JS";
						JSDir = HTMLDESIGNDir + SEP + JSDIRName;
						RUNName = "Run_";
						RUNDir = RESULTSDir + SEP + RUNName;
						SETTINGSFile = RESULTSDir + SEP + "Settings.properties";
					}
				} catch (Exception localException5) {
					throw new WmReporterException(localException5.toString());
				}
			} catch (FileNotFoundException localFileNotFoundException) {
				throw new WmReporterException(
						"The Path for the Custom Properties file could not be found", localFileNotFoundException);
			} catch (IOException localIOException) {
				throw new WmReporterException(
						"Problem Occured while reading the Zado Reporter Config File");
			}
		}
	}

	public static void mkDirs(String paramString) {
		File localFile = new File(paramString);
		if (!localFile.exists()) {
			localFile.mkdirs();
		}
	}

	public static boolean exists(String paramString) {
		File localFile = new File(paramString);
		return localFile.exists();
	}
	/**
	 * Verifying required files for report generation
	 * @throws Exception 
	 */
	public static void verifyRequiredFiles() throws Exception {
		init();
		log.info("Setting Reports Dir---"+REPORTSDir);
		log.info("Setting Results Dir---"+RESULTSDir);
		mkDirs(REPORTSDir);
		if (!exists(RESULTSDir)) {
			mkDirs(RESULTSDir);
			SettingsFile.initSettingsFile();
		}
		if (!exists(HTMLDESIGNDir)) {
			mkDirs(HTMLDESIGNDir);
			mkDirs(CSSDir);
			mkDirs(JSDir);
			mkDirs(IMGDir);
			HTMLDesignFilesWriter.writeCSS();
			HTMLDesignFilesWriter.writeIMG();
			HTMLDesignFilesWriter.writeJS();
		}
		if ((logo != null) && (logo.length() > 0)) {
			String str = new File(logo).getName();
			if (!new File(IMGDir + SEP + str).exists()) {
				copyImage(logo);
			}
			ReportLabels.PROJ_LOGO.setLabel(str);
		}
	}

	private static void copyImage(String paramString) throws WmReporterException {
		File localFile = new File(paramString);
		if (!localFile.exists()) {
			return;
		}
		FileImageInputStream localFileImageInputStream = null;
		FileImageOutputStream localFileImageOutputStream = null;
		try {
			localFileImageInputStream = new FileImageInputStream(new File(
					paramString));
			localFileImageOutputStream = new FileImageOutputStream(new File(
					IMGDir + SEP + localFile.getName()));
			int i = 0;
			while ((i = localFileImageInputStream.read()) >= 0) {
				localFileImageOutputStream.write(i);
			}
			localFileImageOutputStream.close();
			return;
		} catch (Exception localException2) {
		} finally {
			try {
				localFileImageInputStream.close();
				localFileImageOutputStream.close();
				localFile = null;
			} catch (Exception localException4) {
				localFileImageInputStream = null;
				localFileImageOutputStream = null;
				localFile = null;
			}
		}
	}

	public static String getCustomProperties() {
		return System.getProperty("wm.reporter.config");
	}

	public static String createTestRunDateTime() {
		Calendar cal = Calendar.getInstance();
		return DateFormatUtils.format(cal, "dd-MM-yy, hh.mm aa");
	}

	public static String getTestRunDateTime(int run) {
		try {
			String testRun = SettingsFile.get("testRunDT");
			String timeArray [] = testRun.split(";");
			return timeArray[run-1];
		} catch (WmReporterException e) {
			e.printStackTrace();
		}
		return " ";
	}
}
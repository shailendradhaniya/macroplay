package org.sha;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Timer;

import org.apache.commons.lang3.time.StopWatch;
import org.sha.model.MacroInfo;
import org.sha.task.RobotTask;
import org.sha.util.MacroUtil;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MacroPlayMain {

	public static void main(String[] args) {
		MacroPlayMain play=new MacroPlayMain();
		Properties props=play.getConfig("config.properties");
		System.out.println(props.toString());
		String macroInfoFilePath=props.getProperty("macroInfoFilePath");
		String macroDurationForPlay=props.getProperty("macroPlayDurationInMins");
		Long macroDurationInMillis=Long.parseLong(macroDurationForPlay)*60000;
		MacroInfo macroInfo=play.readMacroJson(macroInfoFilePath);
		List<RobotTask> timerTasks=MacroUtil.getTimerTaskList(macroInfo);
		StopWatch stopWatch=new StopWatch();
		stopWatch.start();
		Timer timer;
		while(stopWatch.getTime()<=macroDurationInMillis) {
		timer=new Timer();
		for(RobotTask task:timerTasks) {
			System.out.println(stopWatch.getTime());
				timer.schedule(task,task.getEventInfo().getDelaySeconds());
		}
		
		}
		stopWatch.stop();
		/**/
		System.out.println(macroInfo);
	}
	public MacroInfo readMacroJson(String macroInfoFilePath) {
		ObjectMapper mapper=new ObjectMapper();
		MacroInfo macroInfo=null;
		try {
			macroInfo=mapper.readValue(new File(macroInfoFilePath),MacroInfo.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return macroInfo;
	}
	public InputStream getResourceFile(String fileName) {
		ClassLoader classLoader =Thread.currentThread().getContextClassLoader();
		return classLoader.getResourceAsStream(fileName);

	}
	public Properties getConfig(String propertyFileName) {
		Properties props=new Properties();
		try {
			props.load(getResourceFile(propertyFileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;
	}

}

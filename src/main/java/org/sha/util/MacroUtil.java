package org.sha.util;

import java.util.ArrayList;
import java.util.List;

import org.sha.model.EventInfo;
import org.sha.model.MacroInfo;
import org.sha.task.RobotTask;

public class MacroUtil {

	public static List<RobotTask> getTimerTaskList(MacroInfo macroInfo) {
		List<RobotTask> timerTasks=new ArrayList<>();
		for(EventInfo eventInfo:macroInfo.getEventList()) {
			RobotTask robotTask=new RobotTask(eventInfo);
			timerTasks.add(robotTask);
		}
		return timerTasks;
	}

}

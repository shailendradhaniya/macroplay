package org.sha.task;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.TimerTask;

import javax.swing.KeyStroke;

import org.sha.model.EventInfo;
import org.sha.model.EventSourceEnum;

public class RobotTask extends TimerTask implements Comparable<RobotTask>{
	
	private Integer sequenceNumber;
	
	private EventInfo eventInfo;
	public RobotTask(EventInfo eventInfo) {
		this.eventInfo=eventInfo;
		this.sequenceNumber=eventInfo.getSequenceNumber();
	}

	@Override
	public void run() {
		try {
			Robot robot = new Robot();
			if(eventInfo.getEventSource().equals(EventSourceEnum.MOUSE.getSourceName())) {
				robot.mouseMove(eventInfo.getClickPoint().getX(), eventInfo.getClickPoint().getY());
				if(eventInfo.getMouseButton()==1) {
				   robot.mousePress(InputEvent.BUTTON1_MASK);
				   robot.mouseRelease(InputEvent.BUTTON1_MASK);
				}else {
					robot.mousePress(InputEvent.BUTTON2_MASK);
					robot.mouseRelease(InputEvent.BUTTON2_MASK);
				}
			}else {
				//KEYBOARD SOURCE
				char inputKeyButton=eventInfo.getKeyButton();
				typeCharacter(robot,inputKeyButton);
				
				/*Integer keyCode=eventInfo.getInputKeyCode();
				//int inputKeyChar=eventInfo.getKeyButton();
				//KeyStroke ks=KeyStroke.getKeyStroke(inputKeyChar, eventInfo.getInputKeyModifier());
				System.out.println("Keycode: "+keyCode);
				if(keyCode==14 || keyCode == 15) {
					
				}else
				{
					
					
				robot.keyPress(keyCode);
				robot.keyRelease(keyCode);*/
//				}
			}
			robot=null;
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public int compareTo(RobotTask o) {
		return this.sequenceNumber-o.getSequenceNumber();
	}

	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public EventInfo getEventInfo() {
		return eventInfo;
	}

	public void setEventInfo(EventInfo eventInfo) {
		this.eventInfo = eventInfo;
	}
	
	 public void typeCharacter(Robot robot,char letter) {
		    if (Character.isLetter(letter)) {
		        try {
		            boolean upperCase = Character.isUpperCase(letter);
		            String variableName = "VK_" + Character.toUpperCase(letter);
		            Class clazz = KeyEvent.class;
		            Field field = clazz.getField(variableName);
		            int keyCode = field.getInt(null);
		             
		            System.out.println(keyCode + " = keyCode");
		 
		            robot.delay(80);
		 
		            if (upperCase) robot.keyPress(KeyEvent.VK_SHIFT);
		 
		            robot.keyPress(keyCode);
		            robot.keyRelease(keyCode);
		 
		            if (upperCase) robot.keyRelease(KeyEvent.VK_SHIFT);
		        }
		        catch(Exception e) { System.out.println(e); }
		        }
		        else {
		        if (letter == '.') {
		            robot.keyPress(KeyEvent.VK_PERIOD); //keyCode 46
		            robot.keyRelease(KeyEvent.VK_PERIOD);
		            }
		            else if (letter=='!') {
		            robot.keyPress(KeyEvent.VK_SHIFT); //keyCode 16
		            robot.keyPress(KeyEvent.VK_1); //keycode 49
		            robot.keyRelease(KeyEvent.VK_1);
		            robot.keyRelease(KeyEvent.VK_SHIFT);
		            }
		            else if (letter==' ') {
		            robot.keyPress(KeyEvent.VK_SPACE);
		            robot.keyRelease(KeyEvent.VK_SPACE);
		            }
		            else if (letter=='?') {
		            robot.keyPress(KeyEvent.VK_SHIFT); //keyCode 16
		            robot.keyPress(KeyEvent.VK_SLASH); //keyCode 47
		            robot.keyRelease(KeyEvent.VK_SLASH);
		            robot.keyRelease(KeyEvent.VK_SHIFT);
		            }
		            else if (letter==',') {
		            robot.keyPress(KeyEvent.VK_COMMA);
		            robot.keyRelease(KeyEvent.VK_COMMA);
		            }
		            else if(letter == '\r') {
		            	robot.keyPress(KeyEvent.VK_ENTER);
			            robot.keyRelease(KeyEvent.VK_ENTER);
		            }
		            else if(letter == '\t') {
		            	robot.keyPress(KeyEvent.VK_TAB);
			            robot.keyRelease(KeyEvent.VK_TAB);
		            }
		        }
		    }

}

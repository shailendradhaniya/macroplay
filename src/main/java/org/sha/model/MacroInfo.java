package org.sha.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class MacroInfo {

		private Long duration;
		private List<EventInfo> eventList;
		public Long getDuration() {
			return duration;
		}
		public void setDuration(Long duration) {
			this.duration = duration;
		}
		public List<EventInfo> getEventList() {
			return eventList;
		}
		public void setEventList(List<EventInfo> eventList) {
			this.eventList = eventList;
		}
		
		
}

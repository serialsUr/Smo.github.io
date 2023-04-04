package com.damoye.secondproject.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ChatDTO {

		private int chattingNo;
		private String writerId;
		private String content;
		private int roomNo;
		@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="MM월 dd일 hh:mm")
		private Date creDate;
		
		public ChatDTO() {}
		public ChatDTO(int chattingNo, String writerId, String content, int roomNo,Date creDate) {
			this.chattingNo = chattingNo;
			this.writerId = writerId;
			this.content = content;
			this.roomNo = roomNo;
			this.creDate = creDate;
		}
		public int getChattingNo() {
			return chattingNo;
		}
		public String getWriterId() {
			return writerId;
		}
		public String getContent() {
			return content;
		}
		public int getRoomNo() {
			return roomNo;
		}
		public String getCreDate() {
			SimpleDateFormat sdf = new SimpleDateFormat("MM월 dd일 a hh:mm");
			Calendar cal = Calendar.getInstance();
			cal.setTime(creDate);
			cal.add(Calendar.HOUR_OF_DAY, -9);
			return sdf.format(cal.getTime());
		}
		public void setChattingNo(int chattingNo) {
			this.chattingNo = chattingNo;
		}
		public void setWriterId(String writerId) {
			this.writerId = writerId;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public void setRoomNo(int roomNo) {
			this.roomNo = roomNo;
		}
		public void setCreDate(Date creDate) {
			this.creDate = creDate;
		}
		
		
	}

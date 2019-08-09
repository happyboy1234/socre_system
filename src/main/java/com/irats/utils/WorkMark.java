package com.irats.utils;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WorkMark {
	//mark表的id
	private Integer id;
	//workrecord表的id
    private Integer workId;

    private Integer ifmark;

    private String ifmarkstr;
    
    private Integer mark;
    
    private String tip;
    
    private String sno;

    private String stuname;
    
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date date;

    private String start;

    private String end;

    private String workname;

    private String shifts;
    
    public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getIfmarkstr() {
		return ifmarkstr;
	}

	public void setIfmarkstr(String ifmarkstr) {
		this.ifmarkstr = ifmarkstr;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWorkId() {
		return workId;
	}

	public void setWorkId(Integer workId) {
		this.workId = workId;
	}

	public Integer getIfmark() {
		return ifmark;
	}

	public void setIfmark(Integer ifmark) {
		this.ifmark = ifmark;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getWorkname() {
		return workname;
	}

	public void setWorkname(String workname) {
		this.workname = workname;
	}

	public String getShifts() {
		return shifts;
	}

	public void setShifts(String shifts) {
		this.shifts = shifts;
	}

	@Override
	public String toString() {
		return "WorkMark [id=" + id + ", workId=" + workId + ", ifmark=" + ifmark + ", mark=" + mark + ", sno=" + sno
				+ ", stuname=" + stuname + ", date=" + date + ", start=" + start + ", end=" + end + ", workname="
				+ workname + ", shifts=" + shifts + ", ifmarkstr=" + ifmarkstr + "]";
	}

    
}

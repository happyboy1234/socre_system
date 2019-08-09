package com.irats.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.irats.pojo.WorkRecord;
import com.irats.service.StudentService;
import com.irats.service.WorkRecordeService;
import com.irats.utils.E3Result;

/**
 * 工作记录Controller
 * @author pan tao
 *
 */
@Controller
public class WorkRecordeController {
	
	@Autowired
	private WorkRecordeService workRecordeService;
	@Autowired
	private StudentService sutdentService;
	
	@RequestMapping("/workRecord-list")
	@ResponseBody
	public List<WorkRecord> showRecorde(String stuname,String sno,String shifts,
		String workname,@DateTimeFormat(pattern="yyyy-MM-dd")Date date) throws Exception{
		stuname = new String(stuname.getBytes("ISO-8859-1"),"UTF-8");
		shifts = new String(shifts.getBytes("ISO-8859-1"), "UTF-8");
		workname = new String(workname.getBytes("ISO-8859-1"), "UTF-8");
		WorkRecord record = new WorkRecord();
		record.setStuname(stuname);
		record.setSno(sno);
		record.setShifts(shifts);
		record.setWorkname(workname);
		record.setDate(date);
		//将字符串转换为日期类型
/*		Date date2 =null;
		if(StringUtils.isNotBlank(date)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				date2 = sdf.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
/*		Date date2 = null;
		if(StringUtils.isNotBlank(date)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date2 =sdf.parse(date);
			System.out.println(date2);
		}*/
		List<WorkRecord> list = workRecordeService.getRecorde(record);
		return list;
	}
	
	
	@RequestMapping("/workRecord/workRecord-delete")
	@ResponseBody
	public E3Result deleteRecords(String ids) {
		E3Result e3Result = workRecordeService.deleteRecord(ids);
		return e3Result;
	}
	
	
	@RequestMapping("/workRecord/workRecord_edit")
	public String toWorkRecordEdit(HttpServletRequest request,String id) {
		System.out.println("id");
		Integer wid = Integer.valueOf(id);
		WorkRecord record = workRecordeService.getRecordById(wid);
		request.setAttribute("record", record);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(record.getDate());
		request.setAttribute("date",date);
		return "/score/editpage/workRecord_edit";
	}
	
	
	@RequestMapping("/edit3/Record")
	@ResponseBody
	public E3Result updateRecord(String sno,String stuname,String end,
			String start,String shifts,@DateTimeFormat(pattern="yyyy-MM-dd")Date date,
			String workname,String id) {
		//判断是否为空数值
		if(StringUtils.isBlank(sno)) {
			return E3Result.build(209, "修改的学号为空,修改失败");
		}
		if(StringUtils.isBlank(stuname)) {
			return E3Result.build(209, "学生信息为空");
		}
		//判断学生是否存在,如果不存在则不允许插入工作记录
		E3Result checkE3Result = sutdentService.checkStudentIfExist(sno,stuname);
		if(checkE3Result.getStatus() != 200) {
			checkE3Result.setMsg("学生不存在,无法修改工作记录!请检查学生信息是否正确");
			return checkE3Result;
		}
		//学生存在,插入数据
		if(date == null) {
			return E3Result.build(209, "修改的日期为空,修改失败");
		}
		if(StringUtils.isBlank(end)) {
			return E3Result.build(209, "修改的结束时间为空,修改失败");
		}
		if(StringUtils.isBlank(start)) {
			return E3Result.build(209, "修改的开始时间为空,修改失败");
		}
		if(StringUtils.isBlank(shifts)) {
			return E3Result.build(209, "修改的工作地点为空,修改失败");
		}
		if(StringUtils.isBlank(workname)) {
			return E3Result.build(209, "修改的班次为空,修改失败");
		}
		WorkRecord record = new WorkRecord();
		record.setDate(date);
		record.setSno(sno);
		record.setWorkname(workname);
		record.setEnd(end);
		record.setShifts(shifts);
		record.setStart(start);
		record.setStuname(stuname);
		record.setId(Integer.valueOf(id));
		E3Result result = workRecordeService.updateRecord(record);
		return result;
	}
	
	@RequestMapping("/workRecord/workRecord_add")
	public String gotoAdd() {
		return "/score/editpage/workRecord_add";
	}
	
	@RequestMapping("/add/Record")
	@ResponseBody
	public E3Result addRecord(String sno,String stuname,String end,
			String start,String shifts,@DateTimeFormat(pattern="yyyy-MM-dd")Date date,
			String workname) {
		//判断是否为空数值
		if(StringUtils.isBlank(sno)) {
			return E3Result.build(209, "添加的学号为空,修改失败");
		}
		if(StringUtils.isBlank(stuname)) {
			return E3Result.build(209, "学生信息为空");
		}
		//判断学生是否存在,如果不存在则不允许插入工作记录
		E3Result checkE3Result = sutdentService.checkStudentIfExist(sno,stuname);
		if(checkE3Result.getStatus() != 200) {
			//学生不存在,不允许插入工作记录
			return checkE3Result;
		}
		//学生存在,继续执行
		if(date == null) {
			return E3Result.build(209, "添加的日期为空,修改失败");
		}
		if(StringUtils.isBlank(end)) {
			return E3Result.build(209, "添加的结束时间为空,修改失败");
		}
		if(StringUtils.isBlank(start)) {
			return E3Result.build(209, "添加的开始时间为空,修改失败");
		}
		if(StringUtils.isBlank(shifts)) {
			return E3Result.build(209, "添加的工作地点为空,修改失败");
		}
		if(StringUtils.isBlank(workname)) {
			return E3Result.build(209, "添加的班次为空,修改失败");
		}
		WorkRecord record = new WorkRecord();
		record.setDate(date);
		record.setSno(sno);
		record.setWorkname(workname);
		record.setEnd(end);
		record.setShifts(shifts);
		record.setStart(start);
		record.setStuname(stuname);
		//插入工作记录并默认评分
		E3Result result = workRecordeService.addRecord(record);
		return result;
	}
	
}

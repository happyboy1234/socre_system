package com.irats.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irats.dao.MarkMapper;
import com.irats.dao.WorkRecordMapper;
import com.irats.pojo.Mark;
import com.irats.pojo.MarkExample;
import com.irats.pojo.WorkRecord;
import com.irats.pojo.WorkRecordExample;
import com.irats.pojo.WorkRecordExample.Criteria;
import com.irats.service.WorkRecordeService;
import com.irats.utils.E3Result;
/**
 * 工作记录service
 * @author pan tao
 *
 */
@Service
public class WorkRecordeServiceImpl implements WorkRecordeService {
	
	@Autowired
	private WorkRecordMapper workRecordMapper;
	@Autowired
	private MarkMapper markMapper;
	
	@Override
	public List<WorkRecord> getRecorde(WorkRecord record) {
		//创建条件对象
		WorkRecordExample example = new WorkRecordExample();
		Criteria criteria = example.createCriteria();
		//根据传入条件
		//判断学生姓名是否为空
		if(StringUtils.isNotBlank(record.getStuname())) {
			criteria.andStunameEqualTo(record.getStuname());
		}
		//判断学生学号是否为空
		if(StringUtils.isNotBlank(record.getSno())) {
			criteria.andSnoEqualTo(record.getSno());
		}
		//判断工作班次是否为空
		if(StringUtils.isNotBlank(record.getWorkname())) {
			criteria.andWorknameEqualTo(record.getWorkname());
		}
		//判断工作地点是否为空
		if(StringUtils.isNotBlank(record.getShifts())) {
			criteria.andShiftsEqualTo(record.getShifts());
		}
		//判断工作日期是否为空
		if(record.getDate() != null) {
			criteria.andDateEqualTo(record.getDate());
		}
		//设置条件
		//执行查询
		List<WorkRecord> list = workRecordMapper.selectByExample(example);
		//返回查询结果
		if(list.size() ==0 || list == null) {
			return new ArrayList<>();
		}
		return list;
	}
	
	/**
	 * 删除工作记录
	 */
	@Override
	public E3Result deleteRecord(String ids) {
		String[] idsStr = ids.split(",");
		for (String idstr : idsStr) {
			int id = Integer.parseInt(idstr);
			workRecordMapper.deleteByPrimaryKey(id);
			MarkExample example = new MarkExample();
			com.irats.pojo.MarkExample.Criteria createCriteria = example.createCriteria();
			createCriteria.andWorkIdEqualTo(id);
			markMapper.deleteByExample(example);
		}
		//执行删除
		return E3Result.ok();
	}
	
	/**
	 * 
	 */
	@Override
	public E3Result updateRecord(WorkRecord record) {
		workRecordMapper.updateByPrimaryKey(record);
		return E3Result.ok();
	}
	
	@Override
	public E3Result addRecord(WorkRecord record) {
		//插入工作记录
		workRecordMapper.insert(record);
		if(record.getId() > 0) {
			//插入成功则在评分表插入对应记录
			Mark mark = new Mark();
			mark.setDate(record.getDate());
			mark.setSno(record.getSno());
			mark.setWorkname(record.getWorkname());
			mark.setEnd(record.getEnd());
			mark.setShifts(record.getShifts());
			mark.setStart(record.getStart());
			mark.setWorkId(record.getId());
			mark.setStuname(record.getStuname());
			//初始化评分: 已评分 未评分
			mark.setIfmark("未评分");
			//插入评分
			markMapper.insert(mark);
			return E3Result.ok();
		}
		return E3Result.build(257, "插入的数据失败,请重新操作");
	}

	@Override
	public WorkRecord getRecordById(Integer id) {
		WorkRecord record = workRecordMapper.selectByPrimaryKey(id);
		return record;
	}

}

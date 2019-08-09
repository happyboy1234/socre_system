package com.irats.service.impl;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.irats.dao.StudentMapper;
import com.irats.pojo.Student;
import com.irats.pojo.StudentExample;
import com.irats.pojo.StudentExample.Criteria;
import com.irats.service.StudentService;
import com.irats.utils.E3Result;

/**
 * @author IrAts
 *
 */
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentMapper studentMapper;
	
	/**
	 * 查询student列表
	 */
	@Override
	public List<Student> getStudentListPage(String studentname, String studentno) throws Exception {
		StudentExample example = new StudentExample();
		Criteria cirterir = example.createCriteria();
		//判断设置条件
		if(StringUtils.isNotBlank(studentname)) {
			studentname = new String(studentname.getBytes("iso8859-1"),"utf-8");
			cirterir.andNameEqualTo(studentname);
		}
		if(StringUtils.isNotBlank(studentno)) {
			studentno = new String(studentno.getBytes("iso8859-1"),"utf-8");
			cirterir.andSnoEqualTo(studentno);
		}
		//查询
		List<Student> list = studentMapper.selectByExample(example);
		return list;
	}

	@Override
	public E3Result deleteStudent(String ids,String path) {
		if(StringUtils.isNotBlank(ids)) {
			String[] students = ids.split(",");
			for (String idStr : students) {
				int id = Integer.parseInt(idStr);
				//删除对应的图片
				Student student = studentMapper.selectByPrimaryKey(id);
				String imageadr = student.getImageadr();
				//获取文件后缀
				imageadr = imageadr.substring(imageadr.lastIndexOf("/"), imageadr.length());
				File file = new File(path,imageadr);
				//判断文件是否存在
				if(file != null) {
					//存在则删除
					file.delete();
				}
				studentMapper.deleteByPrimaryKey(id);
			}
		}
		return E3Result.ok();
	}

	@Override
	public Student selectStudentById(String idStr) {
		int id = Integer.parseInt(idStr);
		Student student = studentMapper.selectByPrimaryKey(id);
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		studentMapper.updateByPrimaryKey(student);
	}

	@Override
	public void addStudent(MultipartFile img, Student student, String path) throws Exception {
		//插入数据返回id
		studentMapper.insertStudentGetId(student);
	
		String imageadr = "";
		//判断是否有文件传输进来
		if(img.getSize() != 0 ) {
			//获取文件名
			String originalFilename = img.getOriginalFilename();
			//获取文件后缀
			String str = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
			//以id作为文件名
			String filename = student.getId() + str;
			File file = new File(path,filename);
			//判断文件是否存在
			if(file != null) {
				//存在则删除
				file.delete();
			}
			//保存文件
			img.transferTo(file);
			imageadr = "/student/images/" + filename;
		}
		//如果上传了文件,将文件上传地址放入student
		if(StringUtils.isNotBlank(imageadr)) {
			student.setImageadr(imageadr);
			//调用studentService更新数据
			studentMapper.updateByPrimaryKey(student);
		}
	}

	@Override
	public E3Result checkStudentIfExist(String sno,String stuname) {
		//设置查询条件
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andSnoEqualTo(sno);
		criteria.andNameEqualTo(stuname);
		//查询学生
		List<Student> list = studentMapper.selectByExample(example);
		if(list.size() == 0) {
			//学生不存在
			return E3Result.build(209, "该学生不存在!无法添加工作记录,请检查学生信息");
		}
		//学生存在返回成功
		return E3Result.ok();
	}

	@Override
	public Student getStudentBySnoAndName(String sno, String name) {
		StudentExample example = new StudentExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andNameEqualTo(name);
		createCriteria.andSnoEqualTo(sno);
		List<Student> list = studentMapper.selectByExample(example);
		Student student = null;
		if(list.size() != 0) {
			student = list.get(0);
		}
		return student;
	}
	
	
	

}

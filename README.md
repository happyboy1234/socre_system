# socre_system
学生信息存储和工作评分系统

基于ssm编写

tomcat使用版本为7.x.x

数据库为mysql5.5.xx,建表语句如下

```
-- 工作记录
CREATE TABLE `work_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '每一个工作生成一个id',
  `sno` varchar(50) NOT NULL COMMENT 'student表中的学号',
  `stuname` varchar(50) NOT NULL COMMENT '工作的日期',
  `date` datetime DEFAULT NULL COMMENT '工作开始时间',
  `start` varchar(20) DEFAULT NULL COMMENT '工作结束时间',
  `end` varchar(20) DEFAULT NULL COMMENT '三个结果: 二楼,三楼,四楼',
  `workname` varchar(10) DEFAULT NULL COMMENT '班次: 早,中,晚',
  `shifts` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;

-- 用户
CREATE TABLE `gd_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL COMMENT '用户名,不能有相同值',
  `password` varchar(40) NOT NULL,
  `power` int(11) NOT NULL COMMENT '权限,1为管理员,0为普通用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- 评分
CREATE TABLE `mark` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动生成',
  `work_id` int(11) NOT NULL COMMENT '为workRecord表中的id',
  `ifmark` varchar(10) DEFAULT NULL COMMENT '1:已评分 0:未评分',
  `mark` int(11) DEFAULT NULL COMMENT '评分分数',
  `tip` varchar(200) DEFAULT NULL COMMENT '备注',
  `sno` varchar(50) NOT NULL COMMENT '学号',
  `stuname` varchar(50) NOT NULL COMMENT '学生姓名',
  `date` datetime DEFAULT NULL COMMENT '工作日期',
  `start` varchar(20) DEFAULT NULL COMMENT '工作开始时间',
  `end` varchar(20) DEFAULT NULL COMMENT '工作结束时间',
  `workname` varchar(10) DEFAULT NULL COMMENT '工作名称:二楼,三楼,四楼',
  `shifts` varchar(10) DEFAULT NULL COMMENT '工作班次:早班,午班,晚班',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- 学生信息
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动生成,自增长',
  `name` varchar(50) NOT NULL COMMENT '学生姓名,可以相同',
  `sno` varchar(50) NOT NULL COMMENT '学号,不能重复',
  `academy` varchar(30) DEFAULT NULL COMMENT '学院',
  `grade` varchar(50) DEFAULT NULL COMMENT '班级',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `imageadr` varchar(200) DEFAULT NULL COMMENT '上传来的图片地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `work_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '每一个工作生成一个id',
  `sno` varchar(50) NOT NULL COMMENT 'student表中的学号',
  `stuname` varchar(50) NOT NULL COMMENT '工作的日期',
  `date` datetime DEFAULT NULL COMMENT '工作开始时间',
  `start` varchar(20) DEFAULT NULL COMMENT '工作结束时间',
  `end` varchar(20) DEFAULT NULL COMMENT '三个结果: 二楼,三楼,四楼',
  `workname` varchar(10) DEFAULT NULL COMMENT '班次: 早,中,晚',
  `shifts` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;

```




package com.irats.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MarkExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWorkIdIsNull() {
            addCriterion("work_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkIdIsNotNull() {
            addCriterion("work_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkIdEqualTo(Integer value) {
            addCriterion("work_id =", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotEqualTo(Integer value) {
            addCriterion("work_id <>", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdGreaterThan(Integer value) {
            addCriterion("work_id >", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_id >=", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLessThan(Integer value) {
            addCriterion("work_id <", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLessThanOrEqualTo(Integer value) {
            addCriterion("work_id <=", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdIn(List<Integer> values) {
            addCriterion("work_id in", values, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotIn(List<Integer> values) {
            addCriterion("work_id not in", values, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdBetween(Integer value1, Integer value2) {
            addCriterion("work_id between", value1, value2, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("work_id not between", value1, value2, "workId");
            return (Criteria) this;
        }

        public Criteria andIfmarkIsNull() {
            addCriterion("ifmark is null");
            return (Criteria) this;
        }

        public Criteria andIfmarkIsNotNull() {
            addCriterion("ifmark is not null");
            return (Criteria) this;
        }

        public Criteria andIfmarkEqualTo(String value) {
            addCriterion("ifmark =", value, "ifmark");
            return (Criteria) this;
        }

        public Criteria andIfmarkNotEqualTo(String value) {
            addCriterion("ifmark <>", value, "ifmark");
            return (Criteria) this;
        }

        public Criteria andIfmarkGreaterThan(String value) {
            addCriterion("ifmark >", value, "ifmark");
            return (Criteria) this;
        }

        public Criteria andIfmarkGreaterThanOrEqualTo(String value) {
            addCriterion("ifmark >=", value, "ifmark");
            return (Criteria) this;
        }

        public Criteria andIfmarkLessThan(String value) {
            addCriterion("ifmark <", value, "ifmark");
            return (Criteria) this;
        }

        public Criteria andIfmarkLessThanOrEqualTo(String value) {
            addCriterion("ifmark <=", value, "ifmark");
            return (Criteria) this;
        }

        public Criteria andIfmarkLike(String value) {
            addCriterion("ifmark like", value, "ifmark");
            return (Criteria) this;
        }

        public Criteria andIfmarkNotLike(String value) {
            addCriterion("ifmark not like", value, "ifmark");
            return (Criteria) this;
        }

        public Criteria andIfmarkIn(List<String> values) {
            addCriterion("ifmark in", values, "ifmark");
            return (Criteria) this;
        }

        public Criteria andIfmarkNotIn(List<String> values) {
            addCriterion("ifmark not in", values, "ifmark");
            return (Criteria) this;
        }

        public Criteria andIfmarkBetween(String value1, String value2) {
            addCriterion("ifmark between", value1, value2, "ifmark");
            return (Criteria) this;
        }

        public Criteria andIfmarkNotBetween(String value1, String value2) {
            addCriterion("ifmark not between", value1, value2, "ifmark");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(Integer value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(Integer value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(Integer value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(Integer value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(Integer value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<Integer> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<Integer> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(Integer value1, Integer value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(Integer value1, Integer value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andTipIsNull() {
            addCriterion("tip is null");
            return (Criteria) this;
        }

        public Criteria andTipIsNotNull() {
            addCriterion("tip is not null");
            return (Criteria) this;
        }

        public Criteria andTipEqualTo(String value) {
            addCriterion("tip =", value, "tip");
            return (Criteria) this;
        }

        public Criteria andTipNotEqualTo(String value) {
            addCriterion("tip <>", value, "tip");
            return (Criteria) this;
        }

        public Criteria andTipGreaterThan(String value) {
            addCriterion("tip >", value, "tip");
            return (Criteria) this;
        }

        public Criteria andTipGreaterThanOrEqualTo(String value) {
            addCriterion("tip >=", value, "tip");
            return (Criteria) this;
        }

        public Criteria andTipLessThan(String value) {
            addCriterion("tip <", value, "tip");
            return (Criteria) this;
        }

        public Criteria andTipLessThanOrEqualTo(String value) {
            addCriterion("tip <=", value, "tip");
            return (Criteria) this;
        }

        public Criteria andTipLike(String value) {
            addCriterion("tip like", value, "tip");
            return (Criteria) this;
        }

        public Criteria andTipNotLike(String value) {
            addCriterion("tip not like", value, "tip");
            return (Criteria) this;
        }

        public Criteria andTipIn(List<String> values) {
            addCriterion("tip in", values, "tip");
            return (Criteria) this;
        }

        public Criteria andTipNotIn(List<String> values) {
            addCriterion("tip not in", values, "tip");
            return (Criteria) this;
        }

        public Criteria andTipBetween(String value1, String value2) {
            addCriterion("tip between", value1, value2, "tip");
            return (Criteria) this;
        }

        public Criteria andTipNotBetween(String value1, String value2) {
            addCriterion("tip not between", value1, value2, "tip");
            return (Criteria) this;
        }

        public Criteria andSnoIsNull() {
            addCriterion("sno is null");
            return (Criteria) this;
        }

        public Criteria andSnoIsNotNull() {
            addCriterion("sno is not null");
            return (Criteria) this;
        }

        public Criteria andSnoEqualTo(String value) {
            addCriterion("sno =", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotEqualTo(String value) {
            addCriterion("sno <>", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThan(String value) {
            addCriterion("sno >", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThanOrEqualTo(String value) {
            addCriterion("sno >=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThan(String value) {
            addCriterion("sno <", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThanOrEqualTo(String value) {
            addCriterion("sno <=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLike(String value) {
            addCriterion("sno like", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotLike(String value) {
            addCriterion("sno not like", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoIn(List<String> values) {
            addCriterion("sno in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotIn(List<String> values) {
            addCriterion("sno not in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoBetween(String value1, String value2) {
            addCriterion("sno between", value1, value2, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotBetween(String value1, String value2) {
            addCriterion("sno not between", value1, value2, "sno");
            return (Criteria) this;
        }

        public Criteria andStunameIsNull() {
            addCriterion("stuname is null");
            return (Criteria) this;
        }

        public Criteria andStunameIsNotNull() {
            addCriterion("stuname is not null");
            return (Criteria) this;
        }

        public Criteria andStunameEqualTo(String value) {
            addCriterion("stuname =", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameNotEqualTo(String value) {
            addCriterion("stuname <>", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameGreaterThan(String value) {
            addCriterion("stuname >", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameGreaterThanOrEqualTo(String value) {
            addCriterion("stuname >=", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameLessThan(String value) {
            addCriterion("stuname <", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameLessThanOrEqualTo(String value) {
            addCriterion("stuname <=", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameLike(String value) {
            addCriterion("stuname like", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameNotLike(String value) {
            addCriterion("stuname not like", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameIn(List<String> values) {
            addCriterion("stuname in", values, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameNotIn(List<String> values) {
            addCriterion("stuname not in", values, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameBetween(String value1, String value2) {
            addCriterion("stuname between", value1, value2, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameNotBetween(String value1, String value2) {
            addCriterion("stuname not between", value1, value2, "stuname");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andStartIsNull() {
            addCriterion("start is null");
            return (Criteria) this;
        }

        public Criteria andStartIsNotNull() {
            addCriterion("start is not null");
            return (Criteria) this;
        }

        public Criteria andStartEqualTo(String value) {
            addCriterion("start =", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotEqualTo(String value) {
            addCriterion("start <>", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThan(String value) {
            addCriterion("start >", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThanOrEqualTo(String value) {
            addCriterion("start >=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThan(String value) {
            addCriterion("start <", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThanOrEqualTo(String value) {
            addCriterion("start <=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLike(String value) {
            addCriterion("start like", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotLike(String value) {
            addCriterion("start not like", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartIn(List<String> values) {
            addCriterion("start in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotIn(List<String> values) {
            addCriterion("start not in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartBetween(String value1, String value2) {
            addCriterion("start between", value1, value2, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotBetween(String value1, String value2) {
            addCriterion("start not between", value1, value2, "start");
            return (Criteria) this;
        }

        public Criteria andEndIsNull() {
            addCriterion("end is null");
            return (Criteria) this;
        }

        public Criteria andEndIsNotNull() {
            addCriterion("end is not null");
            return (Criteria) this;
        }

        public Criteria andEndEqualTo(String value) {
            addCriterion("end =", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotEqualTo(String value) {
            addCriterion("end <>", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndGreaterThan(String value) {
            addCriterion("end >", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndGreaterThanOrEqualTo(String value) {
            addCriterion("end >=", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLessThan(String value) {
            addCriterion("end <", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLessThanOrEqualTo(String value) {
            addCriterion("end <=", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLike(String value) {
            addCriterion("end like", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotLike(String value) {
            addCriterion("end not like", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndIn(List<String> values) {
            addCriterion("end in", values, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotIn(List<String> values) {
            addCriterion("end not in", values, "end");
            return (Criteria) this;
        }

        public Criteria andEndBetween(String value1, String value2) {
            addCriterion("end between", value1, value2, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotBetween(String value1, String value2) {
            addCriterion("end not between", value1, value2, "end");
            return (Criteria) this;
        }

        public Criteria andWorknameIsNull() {
            addCriterion("workname is null");
            return (Criteria) this;
        }

        public Criteria andWorknameIsNotNull() {
            addCriterion("workname is not null");
            return (Criteria) this;
        }

        public Criteria andWorknameEqualTo(String value) {
            addCriterion("workname =", value, "workname");
            return (Criteria) this;
        }

        public Criteria andWorknameNotEqualTo(String value) {
            addCriterion("workname <>", value, "workname");
            return (Criteria) this;
        }

        public Criteria andWorknameGreaterThan(String value) {
            addCriterion("workname >", value, "workname");
            return (Criteria) this;
        }

        public Criteria andWorknameGreaterThanOrEqualTo(String value) {
            addCriterion("workname >=", value, "workname");
            return (Criteria) this;
        }

        public Criteria andWorknameLessThan(String value) {
            addCriterion("workname <", value, "workname");
            return (Criteria) this;
        }

        public Criteria andWorknameLessThanOrEqualTo(String value) {
            addCriterion("workname <=", value, "workname");
            return (Criteria) this;
        }

        public Criteria andWorknameLike(String value) {
            addCriterion("workname like", value, "workname");
            return (Criteria) this;
        }

        public Criteria andWorknameNotLike(String value) {
            addCriterion("workname not like", value, "workname");
            return (Criteria) this;
        }

        public Criteria andWorknameIn(List<String> values) {
            addCriterion("workname in", values, "workname");
            return (Criteria) this;
        }

        public Criteria andWorknameNotIn(List<String> values) {
            addCriterion("workname not in", values, "workname");
            return (Criteria) this;
        }

        public Criteria andWorknameBetween(String value1, String value2) {
            addCriterion("workname between", value1, value2, "workname");
            return (Criteria) this;
        }

        public Criteria andWorknameNotBetween(String value1, String value2) {
            addCriterion("workname not between", value1, value2, "workname");
            return (Criteria) this;
        }

        public Criteria andShiftsIsNull() {
            addCriterion("shifts is null");
            return (Criteria) this;
        }

        public Criteria andShiftsIsNotNull() {
            addCriterion("shifts is not null");
            return (Criteria) this;
        }

        public Criteria andShiftsEqualTo(String value) {
            addCriterion("shifts =", value, "shifts");
            return (Criteria) this;
        }

        public Criteria andShiftsNotEqualTo(String value) {
            addCriterion("shifts <>", value, "shifts");
            return (Criteria) this;
        }

        public Criteria andShiftsGreaterThan(String value) {
            addCriterion("shifts >", value, "shifts");
            return (Criteria) this;
        }

        public Criteria andShiftsGreaterThanOrEqualTo(String value) {
            addCriterion("shifts >=", value, "shifts");
            return (Criteria) this;
        }

        public Criteria andShiftsLessThan(String value) {
            addCriterion("shifts <", value, "shifts");
            return (Criteria) this;
        }

        public Criteria andShiftsLessThanOrEqualTo(String value) {
            addCriterion("shifts <=", value, "shifts");
            return (Criteria) this;
        }

        public Criteria andShiftsLike(String value) {
            addCriterion("shifts like", value, "shifts");
            return (Criteria) this;
        }

        public Criteria andShiftsNotLike(String value) {
            addCriterion("shifts not like", value, "shifts");
            return (Criteria) this;
        }

        public Criteria andShiftsIn(List<String> values) {
            addCriterion("shifts in", values, "shifts");
            return (Criteria) this;
        }

        public Criteria andShiftsNotIn(List<String> values) {
            addCriterion("shifts not in", values, "shifts");
            return (Criteria) this;
        }

        public Criteria andShiftsBetween(String value1, String value2) {
            addCriterion("shifts between", value1, value2, "shifts");
            return (Criteria) this;
        }

        public Criteria andShiftsNotBetween(String value1, String value2) {
            addCriterion("shifts not between", value1, value2, "shifts");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
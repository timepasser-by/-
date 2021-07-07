package com.kkb.pojo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class LoginuserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LoginuserExample() {
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

        public Criteria andU_loginNameIsNull() {
            addCriterion("u_loginName is null");
            return (Criteria) this;
        }

        public Criteria andU_loginNameIsNotNull() {
            addCriterion("u_loginName is not null");
            return (Criteria) this;
        }

        public Criteria andU_loginNameEqualTo(String value) {
            addCriterion("u_loginName =", value, "u_loginName");
            return (Criteria) this;
        }

        public Criteria andU_loginNameNotEqualTo(String value) {
            addCriterion("u_loginName <>", value, "u_loginName");
            return (Criteria) this;
        }

        public Criteria andU_loginNameGreaterThan(String value) {
            addCriterion("u_loginName >", value, "u_loginName");
            return (Criteria) this;
        }

        public Criteria andU_loginNameGreaterThanOrEqualTo(String value) {
            addCriterion("u_loginName >=", value, "u_loginName");
            return (Criteria) this;
        }

        public Criteria andU_loginNameLessThan(String value) {
            addCriterion("u_loginName <", value, "u_loginName");
            return (Criteria) this;
        }

        public Criteria andU_loginNameLessThanOrEqualTo(String value) {
            addCriterion("u_loginName <=", value, "u_loginName");
            return (Criteria) this;
        }

        public Criteria andU_loginNameLike(String value) {
            addCriterion("u_loginName like", value, "u_loginName");
            return (Criteria) this;
        }

        public Criteria andU_loginNameNotLike(String value) {
            addCriterion("u_loginName not like", value, "u_loginName");
            return (Criteria) this;
        }

        public Criteria andU_loginNameIn(List<String> values) {
            addCriterion("u_loginName in", values, "u_loginName");
            return (Criteria) this;
        }

        public Criteria andU_loginNameNotIn(List<String> values) {
            addCriterion("u_loginName not in", values, "u_loginName");
            return (Criteria) this;
        }

        public Criteria andU_loginNameBetween(String value1, String value2) {
            addCriterion("u_loginName between", value1, value2, "u_loginName");
            return (Criteria) this;
        }

        public Criteria andU_loginNameNotBetween(String value1, String value2) {
            addCriterion("u_loginName not between", value1, value2, "u_loginName");
            return (Criteria) this;
        }

        public Criteria andU_passWordIsNull() {
            addCriterion("u_passWord is null");
            return (Criteria) this;
        }

        public Criteria andU_passWordIsNotNull() {
            addCriterion("u_passWord is not null");
            return (Criteria) this;
        }

        public Criteria andU_passWordEqualTo(String value) {
            addCriterion("u_passWord =", value, "u_passWord");
            return (Criteria) this;
        }

        public Criteria andU_passWordNotEqualTo(String value) {
            addCriterion("u_passWord <>", value, "u_passWord");
            return (Criteria) this;
        }

        public Criteria andU_passWordGreaterThan(String value) {
            addCriterion("u_passWord >", value, "u_passWord");
            return (Criteria) this;
        }

        public Criteria andU_passWordGreaterThanOrEqualTo(String value) {
            addCriterion("u_passWord >=", value, "u_passWord");
            return (Criteria) this;
        }

        public Criteria andU_passWordLessThan(String value) {
            addCriterion("u_passWord <", value, "u_passWord");
            return (Criteria) this;
        }

        public Criteria andU_passWordLessThanOrEqualTo(String value) {
            addCriterion("u_passWord <=", value, "u_passWord");
            return (Criteria) this;
        }

        public Criteria andU_passWordLike(String value) {
            addCriterion("u_passWord like", value, "u_passWord");
            return (Criteria) this;
        }

        public Criteria andU_passWordNotLike(String value) {
            addCriterion("u_passWord not like", value, "u_passWord");
            return (Criteria) this;
        }

        public Criteria andU_passWordIn(List<String> values) {
            addCriterion("u_passWord in", values, "u_passWord");
            return (Criteria) this;
        }

        public Criteria andU_passWordNotIn(List<String> values) {
            addCriterion("u_passWord not in", values, "u_passWord");
            return (Criteria) this;
        }

        public Criteria andU_passWordBetween(String value1, String value2) {
            addCriterion("u_passWord between", value1, value2, "u_passWord");
            return (Criteria) this;
        }

        public Criteria andU_passWordNotBetween(String value1, String value2) {
            addCriterion("u_passWord not between", value1, value2, "u_passWord");
            return (Criteria) this;
        }

        public Criteria andU_trueNameIsNull() {
            addCriterion("u_trueName is null");
            return (Criteria) this;
        }

        public Criteria andU_trueNameIsNotNull() {
            addCriterion("u_trueName is not null");
            return (Criteria) this;
        }

        public Criteria andU_trueNameEqualTo(String value) {
            addCriterion("u_trueName =", value, "u_trueName");
            return (Criteria) this;
        }

        public Criteria andU_trueNameNotEqualTo(String value) {
            addCriterion("u_trueName <>", value, "u_trueName");
            return (Criteria) this;
        }

        public Criteria andU_trueNameGreaterThan(String value) {
            addCriterion("u_trueName >", value, "u_trueName");
            return (Criteria) this;
        }

        public Criteria andU_trueNameGreaterThanOrEqualTo(String value) {
            addCriterion("u_trueName >=", value, "u_trueName");
            return (Criteria) this;
        }

        public Criteria andU_trueNameLessThan(String value) {
            addCriterion("u_trueName <", value, "u_trueName");
            return (Criteria) this;
        }

        public Criteria andU_trueNameLessThanOrEqualTo(String value) {
            addCriterion("u_trueName <=", value, "u_trueName");
            return (Criteria) this;
        }

        public Criteria andU_trueNameLike(String value) {
            addCriterion("u_trueName like", value, "u_trueName");
            return (Criteria) this;
        }

        public Criteria andU_trueNameNotLike(String value) {
            addCriterion("u_trueName not like", value, "u_trueName");
            return (Criteria) this;
        }

        public Criteria andU_trueNameIn(List<String> values) {
            addCriterion("u_trueName in", values, "u_trueName");
            return (Criteria) this;
        }

        public Criteria andU_trueNameNotIn(List<String> values) {
            addCriterion("u_trueName not in", values, "u_trueName");
            return (Criteria) this;
        }

        public Criteria andU_trueNameBetween(String value1, String value2) {
            addCriterion("u_trueName between", value1, value2, "u_trueName");
            return (Criteria) this;
        }

        public Criteria andU_trueNameNotBetween(String value1, String value2) {
            addCriterion("u_trueName not between", value1, value2, "u_trueName");
            return (Criteria) this;
        }

        public Criteria andU_emailIsNull() {
            addCriterion("u_email is null");
            return (Criteria) this;
        }

        public Criteria andU_emailIsNotNull() {
            addCriterion("u_email is not null");
            return (Criteria) this;
        }

        public Criteria andU_emailEqualTo(String value) {
            addCriterion("u_email =", value, "u_email");
            return (Criteria) this;
        }

        public Criteria andU_emailNotEqualTo(String value) {
            addCriterion("u_email <>", value, "u_email");
            return (Criteria) this;
        }

        public Criteria andU_emailGreaterThan(String value) {
            addCriterion("u_email >", value, "u_email");
            return (Criteria) this;
        }

        public Criteria andU_emailGreaterThanOrEqualTo(String value) {
            addCriterion("u_email >=", value, "u_email");
            return (Criteria) this;
        }

        public Criteria andU_emailLessThan(String value) {
            addCriterion("u_email <", value, "u_email");
            return (Criteria) this;
        }

        public Criteria andU_emailLessThanOrEqualTo(String value) {
            addCriterion("u_email <=", value, "u_email");
            return (Criteria) this;
        }

        public Criteria andU_emailLike(String value) {
            addCriterion("u_email like", value, "u_email");
            return (Criteria) this;
        }

        public Criteria andU_emailNotLike(String value) {
            addCriterion("u_email not like", value, "u_email");
            return (Criteria) this;
        }

        public Criteria andU_emailIn(List<String> values) {
            addCriterion("u_email in", values, "u_email");
            return (Criteria) this;
        }

        public Criteria andU_emailNotIn(List<String> values) {
            addCriterion("u_email not in", values, "u_email");
            return (Criteria) this;
        }

        public Criteria andU_emailBetween(String value1, String value2) {
            addCriterion("u_email between", value1, value2, "u_email");
            return (Criteria) this;
        }

        public Criteria andU_emailNotBetween(String value1, String value2) {
            addCriterion("u_email not between", value1, value2, "u_email");
            return (Criteria) this;
        }

        public Criteria andU_stateIsNull() {
            addCriterion("u_state is null");
            return (Criteria) this;
        }

        public Criteria andU_stateIsNotNull() {
            addCriterion("u_state is not null");
            return (Criteria) this;
        }

        public Criteria andU_stateEqualTo(Integer value) {
            addCriterion("u_state =", value, "u_state");
            return (Criteria) this;
        }

        public Criteria andU_stateNotEqualTo(Integer value) {
            addCriterion("u_state <>", value, "u_state");
            return (Criteria) this;
        }

        public Criteria andU_stateGreaterThan(Integer value) {
            addCriterion("u_state >", value, "u_state");
            return (Criteria) this;
        }

        public Criteria andU_stateGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_state >=", value, "u_state");
            return (Criteria) this;
        }

        public Criteria andU_stateLessThan(Integer value) {
            addCriterion("u_state <", value, "u_state");
            return (Criteria) this;
        }

        public Criteria andU_stateLessThanOrEqualTo(Integer value) {
            addCriterion("u_state <=", value, "u_state");
            return (Criteria) this;
        }

        public Criteria andU_stateIn(List<Integer> values) {
            addCriterion("u_state in", values, "u_state");
            return (Criteria) this;
        }

        public Criteria andU_stateNotIn(List<Integer> values) {
            addCriterion("u_state not in", values, "u_state");
            return (Criteria) this;
        }

        public Criteria andU_stateBetween(Integer value1, Integer value2) {
            addCriterion("u_state between", value1, value2, "u_state");
            return (Criteria) this;
        }

        public Criteria andU_stateNotBetween(Integer value1, Integer value2) {
            addCriterion("u_state not between", value1, value2, "u_state");
            return (Criteria) this;
        }

        public Criteria andR_idIsNull() {
            addCriterion("r_id is null");
            return (Criteria) this;
        }

        public Criteria andR_idIsNotNull() {
            addCriterion("r_id is not null");
            return (Criteria) this;
        }

        public Criteria andR_idEqualTo(Integer value) {
            addCriterion("r_id =", value, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idNotEqualTo(Integer value) {
            addCriterion("r_id <>", value, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idGreaterThan(Integer value) {
            addCriterion("r_id >", value, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_id >=", value, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idLessThan(Integer value) {
            addCriterion("r_id <", value, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idLessThanOrEqualTo(Integer value) {
            addCriterion("r_id <=", value, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idIn(List<Integer> values) {
            addCriterion("r_id in", values, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idNotIn(List<Integer> values) {
            addCriterion("r_id not in", values, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idBetween(Integer value1, Integer value2) {
            addCriterion("r_id between", value1, value2, "r_id");
            return (Criteria) this;
        }

        public Criteria andR_idNotBetween(Integer value1, Integer value2) {
            addCriterion("r_id not between", value1, value2, "r_id");
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
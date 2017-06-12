package org.ihansen.jsmta.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ihansen.jsmta.dao.interfaces.ICommonDAO;
import org.ihansen.jsmta.utils.Constant;
import org.ihansen.mbtgen.extend.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class CommonDAOImpl<T, O, C> implements ICommonDAO<T, O, C> {

    public final static String COUNT_BY_EXAMPLE = "countByExample";
    public final static String DELETE_BY_EXAMPLE = "deleteByExample";
    public final static String DELETE_BY_PRIMARYKEY = "deleteByPrimaryKey";
    public final static String INSERT_SELECTIVE = "insertSelective";
    public final static String SELECT_BY_EXAMPLE = "selectByExample";
    public final static String SET_PAGEHELPER = "setPageHelper";
    public final static String SELECT_BY_PRIMARYKEY = "selectByPrimaryKey";
    public final static String UPDATE_BY_EXAMPLE_SELECTIVE = "updateByExampleSelective";
    public final static String UPDATE_BY_PRIMARYKEY_SELECTIVE = "updateByPrimaryKeySelective";
    public final static String INSERT_BATCH = "insertBatch";


    @Autowired
    private O operate;

    @Override
    public int countByCondition(C conditon) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (conditon == null) {
            return 0;
        }
        Method method = operate.getClass().getMethod(COUNT_BY_EXAMPLE, conditon.getClass());
        int returnValue = (Integer) method.invoke(operate, conditon);
        return returnValue;
    }

    @Override
    public int deleteByCondition(C conditon) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (conditon == null) {
            return 0;
        }
        Method method = operate.getClass().getMethod(DELETE_BY_EXAMPLE, conditon.getClass());
        int returnValue = (Integer) method.invoke(operate, conditon);
        return returnValue;
    }

    @Override
    public int deleteById(long id) throws InvocationTargetException, IllegalAccessException {
        Method method = null;
        Method[] methods = operate.getClass().getMethods();
        for (Method method1 : methods) {
            if (DELETE_BY_PRIMARYKEY.equals(method1.getName())) {
                method = method1;
                break;
            }
        }
        if (method == null) {
            return 0;
        }
        int returnValue = (Integer) method.invoke(operate, id);
        return returnValue;
    }

    @Override
    public int add(T record) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (record == null) {
            return 0;
        }
        Method method = operate.getClass().getMethod(INSERT_SELECTIVE, record.getClass());
        int returnValue = (Integer) method.invoke(operate, record);
        return returnValue;
    }

    @Override
    public List<T> queryByCondition(C conditon) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (conditon == null) {
            return Collections.EMPTY_LIST;
        }
        Method method = operate.getClass().getMethod(SELECT_BY_EXAMPLE, conditon.getClass());
        List<T> results = (List<T>) method.invoke(operate, conditon);
        return results;
    }

    @Override
    public List<T> queryByCondition(C conditon, int start, int length) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (conditon == null) {
            return Collections.EMPTY_LIST;
        }
        PageHelper pageHelper = new PageHelper(start, length);
        conditon.getClass().getMethod(SET_PAGEHELPER, PageHelper.class).invoke(conditon, pageHelper);
        Method operateMethod = operate.getClass().getMethod(SELECT_BY_EXAMPLE, conditon.getClass());
        List<T> results = (List<T>) operateMethod.invoke(operate, conditon);
        return results;
    }

    @Override
    public T queryById(long id) throws InvocationTargetException, IllegalAccessException {
        Method method = null;
        Method[] methods = operate.getClass().getMethods();
        for (Method method1 : methods) {
            if (SELECT_BY_PRIMARYKEY.equals(method1.getName())) {
                method = method1;
                break;
            }
        }
        T record = null;
        if (method == null) {
            return record;
        }
        record = (T) method.invoke(operate, id);
        return record;
    }

    @Override
    public int updateByCondition(T record, C conditon) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (record == null || conditon == null) {
            return 0;
        }
        Method method = operate.getClass().getMethod(UPDATE_BY_EXAMPLE_SELECTIVE, record.getClass(), conditon.getClass());
        int returnValue = (Integer) method.invoke(operate, record, conditon);
        return returnValue;
    }

    @Override
    public int updateById(T record) throws Exception {
        if (record == null) {
            return 0;
        }
        Method method = operate.getClass().getMethod(UPDATE_BY_PRIMARYKEY_SELECTIVE, record.getClass());
        int returnValue = (Integer) method.invoke(operate, record);
        return returnValue;
    }

    @Override
    public int add(List<T> records) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (records == null || records.size() < 1) {
            return 0;
        }
        Method method = operate.getClass().getMethod(INSERT_BATCH, List.class);
        int returnValue = (Integer) method.invoke(operate, records);
        return returnValue;
    }

    @Override
    public T qrySingleByCondition(C conditon) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        T t = null;
        if (conditon == null) {
            return t;
        }
        List<T> ts = queryByCondition(conditon);
        if (ts != null && ts.size() > 0) {
            t = ts.get(0);
        }
        return t;
    }

    @Override
    public String getDataSourceName() throws NoSuchFieldException, IllegalAccessException {
        return (String) operate.getClass().getField(Constant.DATA_SOURCE_NAME).get(operate);
    }

}

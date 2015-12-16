package org.ihansen.jsmta.utils;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Bean的通用属性默认值设置
 * 
 * @author 吴帅
 * @CreationDate 2015年8月20日
 * @version 1.0
 */
public class BeanSetDefVal {
	/**
	 * 创建Bean的通用属性默认值设置
	 * 
	 * @author 吴帅
	 * @parameter @param bean
	 * @parameter @throws Exception
	 * @createDate 2015年8月20日 上午9:32:22
	 */
	public static void setCreateDefValue(Object bean) throws Exception {
		try {
			PropertyDescriptor[] props = Introspector.getBeanInfo(bean.getClass(), Object.class).getPropertyDescriptors();
			if (props != null) {
				for (int i = 0; i < props.length; i++) {
					String name = props[i].getName();// 获取bean中的属性
					Object value = props[i].getValue(name);// 获取属性的值
					if (value != null) {
						break;
					}
					if (name.equals("createDate") || name.equals("createdate")) {
						BeanUtils.setProperty(bean, name, new Date());
					}
					else if (name.equals("doneDate") || name.equals("donedate")) {
						BeanUtils.setProperty(bean, name, new Date());
					}
					else if (name.equals("state")) {//默认状态为U有效
						BeanUtils.setProperty(bean, name, "U");
					}
				}
			}
		}
		catch (Exception e) {
			throw new Exception("给bean设置默认值出错", e);
		}
	}

	/**
	 * 操作Bean的通用属性默认值设置
	 * 
	 * @author 吴帅
	 * @parameter @param bean
	 * @parameter @throws Exception
	 * @createDate 2015年8月20日 上午9:33:14
	 */
	public static void setDoneDefValue(Object bean) throws Exception {
		try {
			PropertyDescriptor[] props = Introspector.getBeanInfo(bean.getClass(), Object.class).getPropertyDescriptors();
			if (props != null) {
				for (int i = 0; i < props.length; i++) {
					String name = props[i].getName();// 获取bean中的属性
					Object value = props[i].getValue(name);// 获取属性的值
					if (name.equals("doneDate") || name.equals("donedate")) {
						BeanUtils.setProperty(bean, name, new Date());
					}
				}
			}
		}
		catch (Exception e) {
			throw new Exception("给bean设置默认值出错", e);
		}
	}
}

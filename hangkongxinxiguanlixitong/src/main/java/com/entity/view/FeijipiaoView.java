package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.FeijipiaoEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 飞机票
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("feijipiao")
public class FeijipiaoView extends FeijipiaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 飞机票类型的值
		*/
		private String feijipiaoValue;
		/**
		* 舱位的值
		*/
		private String cangweiValue;
		/**
		* 出发地的值
		*/
		private String chufadiValue;
		/**
		* 目的地的值
		*/
		private String mudidiValue;
		/**
		* 是否特价票的值
		*/
		private String tejiaValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public FeijipiaoView() {

	}

	public FeijipiaoView(FeijipiaoEntity feijipiaoEntity) {
		try {
			BeanUtils.copyProperties(this, feijipiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 飞机票类型的值
			*/
			public String getFeijipiaoValue() {
				return feijipiaoValue;
			}
			/**
			* 设置： 飞机票类型的值
			*/
			public void setFeijipiaoValue(String feijipiaoValue) {
				this.feijipiaoValue = feijipiaoValue;
			}
			/**
			* 获取： 舱位的值
			*/
			public String getCangweiValue() {
				return cangweiValue;
			}
			/**
			* 设置： 舱位的值
			*/
			public void setCangweiValue(String cangweiValue) {
				this.cangweiValue = cangweiValue;
			}
			/**
			* 获取： 出发地的值
			*/
			public String getChufadiValue() {
				return chufadiValue;
			}
			/**
			* 设置： 出发地的值
			*/
			public void setChufadiValue(String chufadiValue) {
				this.chufadiValue = chufadiValue;
			}
			/**
			* 获取： 目的地的值
			*/
			public String getMudidiValue() {
				return mudidiValue;
			}
			/**
			* 设置： 目的地的值
			*/
			public void setMudidiValue(String mudidiValue) {
				this.mudidiValue = mudidiValue;
			}
			/**
			* 获取： 是否特价票的值
			*/
			public String getTejiaValue() {
				return tejiaValue;
			}
			/**
			* 设置： 是否特价票的值
			*/
			public void setTejiaValue(String tejiaValue) {
				this.tejiaValue = tejiaValue;
			}
			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}











}

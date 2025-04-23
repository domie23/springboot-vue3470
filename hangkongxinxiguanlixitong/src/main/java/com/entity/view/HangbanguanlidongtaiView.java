package com.entity.view;

import com.entity.HangbanguanlidongtaiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 航班管理动态
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("hangbanguanlidongtai")
public class HangbanguanlidongtaiView extends HangbanguanlidongtaiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 动态类型的值
		*/
		private String hangbanguanlidongtaiValue;



	public HangbanguanlidongtaiView() {

	}

	public HangbanguanlidongtaiView(HangbanguanlidongtaiEntity hangbanguanlidongtaiEntity) {
		try {
			BeanUtils.copyProperties(this, hangbanguanlidongtaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 动态类型的值
			*/
			public String getHangbanguanlidongtaiValue() {
				return hangbanguanlidongtaiValue;
			}
			/**
			* 设置： 动态类型的值
			*/
			public void setHangbanguanlidongtaiValue(String hangbanguanlidongtaiValue) {
				this.hangbanguanlidongtaiValue = hangbanguanlidongtaiValue;
			}











}

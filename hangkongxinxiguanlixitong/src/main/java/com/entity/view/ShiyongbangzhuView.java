package com.entity.view;

import com.entity.ShiyongbangzhuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 使用帮助
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shiyongbangzhu")
public class ShiyongbangzhuView extends ShiyongbangzhuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 帮助类型的值
		*/
		private String shiyongbangzhuValue;



	public ShiyongbangzhuView() {

	}

	public ShiyongbangzhuView(ShiyongbangzhuEntity shiyongbangzhuEntity) {
		try {
			BeanUtils.copyProperties(this, shiyongbangzhuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 帮助类型的值
			*/
			public String getShiyongbangzhuValue() {
				return shiyongbangzhuValue;
			}
			/**
			* 设置： 帮助类型的值
			*/
			public void setShiyongbangzhuValue(String shiyongbangzhuValue) {
				this.shiyongbangzhuValue = shiyongbangzhuValue;
			}











}

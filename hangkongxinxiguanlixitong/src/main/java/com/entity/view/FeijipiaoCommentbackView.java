package com.entity.view;

import com.entity.FeijipiaoCommentbackEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 飞机票评价
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("feijipiao_commentback")
public class FeijipiaoCommentbackView extends FeijipiaoCommentbackEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 feijipiao
			/**
			* 航班编号
			*/
			private String feijipiaoUuidNumber;
			/**
			* 航空公司编号
			*/
			private String hangkonggongsiBianhao;
			/**
			* 航空公司名称
			*/
			private String hangkonggongsiName;
			/**
			* 飞机票名称
			*/
			private String feijipiaoName;
			/**
			* 飞机票照片
			*/
			private String feijipiaoPhoto;
			/**
			* 飞机票类型
			*/
			private Integer feijipiaoTypes;
				/**
				* 飞机票类型的值
				*/
				private String feijipiaoValue;
			/**
			* 座位
			*/
			private Integer zuoweiNumber;
			/**
			* 购买获得积分
			*/
			private Integer feijipiaoPrice;
			/**
			* 飞机票原价
			*/
			private Double feijipiaoOldMoney;
			/**
			* 现价
			*/
			private Double feijipiaoNewMoney;
			/**
			* 点击次数
			*/
			private Integer feijipiaoClicknum;
			/**
			* 舱位
			*/
			private Integer cangweiTypes;
				/**
				* 舱位的值
				*/
				private String cangweiValue;
			/**
			* 是否特价票
			*/
			private Integer tejiaTypes;
				/**
				* 是否特价票的值
				*/
				private String tejiaValue;
			/**
			* 飞机票介绍
			*/
			private String feijipiaoContent;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer feijipiaoDelete;

		//级联表 kehu
			/**
			* 客户姓名
			*/
			private String kehuName;
			/**
			* 客户手机号
			*/
			private String kehuPhone;
			/**
			* 客户身份证号
			*/
			private String kehuIdNumber;
			/**
			* 客户头像
			*/
			private String kehuPhoto;
			/**
			* 电子邮箱
			*/
			private String kehuEmail;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 总积分
			*/
			private Double kehuSumJifen;
			/**
			* 现积分
			*/
			private Double kehuNewJifen;
			/**
			* 会员等级
			*/
			private Integer huiyuandengjiTypes;
				/**
				* 会员等级的值
				*/
				private String huiyuandengjiValue;

	public FeijipiaoCommentbackView() {

	}

	public FeijipiaoCommentbackView(FeijipiaoCommentbackEntity feijipiaoCommentbackEntity) {
		try {
			BeanUtils.copyProperties(this, feijipiaoCommentbackEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}










				//级联表的get和set feijipiao

					/**
					* 获取： 航班编号
					*/
					public String getFeijipiaoUuidNumber() {
						return feijipiaoUuidNumber;
					}
					/**
					* 设置： 航班编号
					*/
					public void setFeijipiaoUuidNumber(String feijipiaoUuidNumber) {
						this.feijipiaoUuidNumber = feijipiaoUuidNumber;
					}

					/**
					* 获取： 航空公司编号
					*/
					public String getHangkonggongsiBianhao() {
						return hangkonggongsiBianhao;
					}
					/**
					* 设置： 航空公司编号
					*/
					public void setHangkonggongsiBianhao(String hangkonggongsiBianhao) {
						this.hangkonggongsiBianhao = hangkonggongsiBianhao;
					}

					/**
					* 获取： 航空公司名称
					*/
					public String getHangkonggongsiName() {
						return hangkonggongsiName;
					}
					/**
					* 设置： 航空公司名称
					*/
					public void setHangkonggongsiName(String hangkonggongsiName) {
						this.hangkonggongsiName = hangkonggongsiName;
					}

					/**
					* 获取： 飞机票名称
					*/
					public String getFeijipiaoName() {
						return feijipiaoName;
					}
					/**
					* 设置： 飞机票名称
					*/
					public void setFeijipiaoName(String feijipiaoName) {
						this.feijipiaoName = feijipiaoName;
					}

					/**
					* 获取： 飞机票照片
					*/
					public String getFeijipiaoPhoto() {
						return feijipiaoPhoto;
					}
					/**
					* 设置： 飞机票照片
					*/
					public void setFeijipiaoPhoto(String feijipiaoPhoto) {
						this.feijipiaoPhoto = feijipiaoPhoto;
					}

					/**
					* 获取： 飞机票类型
					*/
					public Integer getFeijipiaoTypes() {
						return feijipiaoTypes;
					}
					/**
					* 设置： 飞机票类型
					*/
					public void setFeijipiaoTypes(Integer feijipiaoTypes) {
						this.feijipiaoTypes = feijipiaoTypes;
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
					* 获取： 座位
					*/
					public Integer getZuoweiNumber() {
						return zuoweiNumber;
					}
					/**
					* 设置： 座位
					*/
					public void setZuoweiNumber(Integer zuoweiNumber) {
						this.zuoweiNumber = zuoweiNumber;
					}

					/**
					* 获取： 购买获得积分
					*/
					public Integer getFeijipiaoPrice() {
						return feijipiaoPrice;
					}
					/**
					* 设置： 购买获得积分
					*/
					public void setFeijipiaoPrice(Integer feijipiaoPrice) {
						this.feijipiaoPrice = feijipiaoPrice;
					}

					/**
					* 获取： 飞机票原价
					*/
					public Double getFeijipiaoOldMoney() {
						return feijipiaoOldMoney;
					}
					/**
					* 设置： 飞机票原价
					*/
					public void setFeijipiaoOldMoney(Double feijipiaoOldMoney) {
						this.feijipiaoOldMoney = feijipiaoOldMoney;
					}

					/**
					* 获取： 现价
					*/
					public Double getFeijipiaoNewMoney() {
						return feijipiaoNewMoney;
					}
					/**
					* 设置： 现价
					*/
					public void setFeijipiaoNewMoney(Double feijipiaoNewMoney) {
						this.feijipiaoNewMoney = feijipiaoNewMoney;
					}

					/**
					* 获取： 点击次数
					*/
					public Integer getFeijipiaoClicknum() {
						return feijipiaoClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setFeijipiaoClicknum(Integer feijipiaoClicknum) {
						this.feijipiaoClicknum = feijipiaoClicknum;
					}

					/**
					* 获取： 舱位
					*/
					public Integer getCangweiTypes() {
						return cangweiTypes;
					}
					/**
					* 设置： 舱位
					*/
					public void setCangweiTypes(Integer cangweiTypes) {
						this.cangweiTypes = cangweiTypes;
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
					* 获取： 是否特价票
					*/
					public Integer getTejiaTypes() {
						return tejiaTypes;
					}
					/**
					* 设置： 是否特价票
					*/
					public void setTejiaTypes(Integer tejiaTypes) {
						this.tejiaTypes = tejiaTypes;
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
					* 获取： 飞机票介绍
					*/
					public String getFeijipiaoContent() {
						return feijipiaoContent;
					}
					/**
					* 设置： 飞机票介绍
					*/
					public void setFeijipiaoContent(String feijipiaoContent) {
						this.feijipiaoContent = feijipiaoContent;
					}

					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
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

					/**
					* 获取： 逻辑删除
					*/
					public Integer getFeijipiaoDelete() {
						return feijipiaoDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setFeijipiaoDelete(Integer feijipiaoDelete) {
						this.feijipiaoDelete = feijipiaoDelete;
					}



















				//级联表的get和set kehu

					/**
					* 获取： 客户姓名
					*/
					public String getKehuName() {
						return kehuName;
					}
					/**
					* 设置： 客户姓名
					*/
					public void setKehuName(String kehuName) {
						this.kehuName = kehuName;
					}

					/**
					* 获取： 客户手机号
					*/
					public String getKehuPhone() {
						return kehuPhone;
					}
					/**
					* 设置： 客户手机号
					*/
					public void setKehuPhone(String kehuPhone) {
						this.kehuPhone = kehuPhone;
					}

					/**
					* 获取： 客户身份证号
					*/
					public String getKehuIdNumber() {
						return kehuIdNumber;
					}
					/**
					* 设置： 客户身份证号
					*/
					public void setKehuIdNumber(String kehuIdNumber) {
						this.kehuIdNumber = kehuIdNumber;
					}

					/**
					* 获取： 客户头像
					*/
					public String getKehuPhoto() {
						return kehuPhoto;
					}
					/**
					* 设置： 客户头像
					*/
					public void setKehuPhoto(String kehuPhoto) {
						this.kehuPhoto = kehuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getKehuEmail() {
						return kehuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setKehuEmail(String kehuEmail) {
						this.kehuEmail = kehuEmail;
					}

					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}

					/**
					* 获取： 总积分
					*/
					public Double getKehuSumJifen() {
						return kehuSumJifen;
					}
					/**
					* 设置： 总积分
					*/
					public void setKehuSumJifen(Double kehuSumJifen) {
						this.kehuSumJifen = kehuSumJifen;
					}

					/**
					* 获取： 现积分
					*/
					public Double getKehuNewJifen() {
						return kehuNewJifen;
					}
					/**
					* 设置： 现积分
					*/
					public void setKehuNewJifen(Double kehuNewJifen) {
						this.kehuNewJifen = kehuNewJifen;
					}

					/**
					* 获取： 会员等级
					*/
					public Integer getHuiyuandengjiTypes() {
						return huiyuandengjiTypes;
					}
					/**
					* 设置： 会员等级
					*/
					public void setHuiyuandengjiTypes(Integer huiyuandengjiTypes) {
						this.huiyuandengjiTypes = huiyuandengjiTypes;
					}


						/**
						* 获取： 会员等级的值
						*/
						public String getHuiyuandengjiValue() {
							return huiyuandengjiValue;
						}
						/**
						* 设置： 会员等级的值
						*/
						public void setHuiyuandengjiValue(String huiyuandengjiValue) {
							this.huiyuandengjiValue = huiyuandengjiValue;
						}



}

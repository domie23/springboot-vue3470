package com.entity.model;

import com.entity.FeijipiaoOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 飞机票购买订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FeijipiaoOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String feijipiaoOrderUuidNumber;


    /**
     * 飞机票
     */
    private Integer feijipiaoId;


    /**
     * 客户
     */
    private Integer kehuId;


    /**
     * 实付价格
     */
    private Double feijipiaoOrderTruePrice;


    /**
     * 购买的座位
     */
    private String buyZuoweiNumber;


    /**
     * 订购日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date buyZuoweiTime;


    /**
     * 订单类型
     */
    private Integer feijipiaoOrderTypes;


    /**
     * 支付类型
     */
    private Integer feijipiaoOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public String getFeijipiaoOrderUuidNumber() {
        return feijipiaoOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setFeijipiaoOrderUuidNumber(String feijipiaoOrderUuidNumber) {
        this.feijipiaoOrderUuidNumber = feijipiaoOrderUuidNumber;
    }
    /**
	 * 获取：飞机票
	 */
    public Integer getFeijipiaoId() {
        return feijipiaoId;
    }


    /**
	 * 设置：飞机票
	 */
    public void setFeijipiaoId(Integer feijipiaoId) {
        this.feijipiaoId = feijipiaoId;
    }
    /**
	 * 获取：客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 设置：客户
	 */
    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getFeijipiaoOrderTruePrice() {
        return feijipiaoOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setFeijipiaoOrderTruePrice(Double feijipiaoOrderTruePrice) {
        this.feijipiaoOrderTruePrice = feijipiaoOrderTruePrice;
    }
    /**
	 * 获取：购买的座位
	 */
    public String getBuyZuoweiNumber() {
        return buyZuoweiNumber;
    }


    /**
	 * 设置：购买的座位
	 */
    public void setBuyZuoweiNumber(String buyZuoweiNumber) {
        this.buyZuoweiNumber = buyZuoweiNumber;
    }
    /**
	 * 获取：订购日期
	 */
    public Date getBuyZuoweiTime() {
        return buyZuoweiTime;
    }


    /**
	 * 设置：订购日期
	 */
    public void setBuyZuoweiTime(Date buyZuoweiTime) {
        this.buyZuoweiTime = buyZuoweiTime;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getFeijipiaoOrderTypes() {
        return feijipiaoOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setFeijipiaoOrderTypes(Integer feijipiaoOrderTypes) {
        this.feijipiaoOrderTypes = feijipiaoOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getFeijipiaoOrderPaymentTypes() {
        return feijipiaoOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setFeijipiaoOrderPaymentTypes(Integer feijipiaoOrderPaymentTypes) {
        this.feijipiaoOrderPaymentTypes = feijipiaoOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

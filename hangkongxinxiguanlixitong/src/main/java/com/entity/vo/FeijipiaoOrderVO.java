package com.entity.vo;

import com.entity.FeijipiaoOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 飞机票购买订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("feijipiao_order")
public class FeijipiaoOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号
     */

    @TableField(value = "feijipiao_order_uuid_number")
    private String feijipiaoOrderUuidNumber;


    /**
     * 飞机票
     */

    @TableField(value = "feijipiao_id")
    private Integer feijipiaoId;


    /**
     * 客户
     */

    @TableField(value = "kehu_id")
    private Integer kehuId;


    /**
     * 实付价格
     */

    @TableField(value = "feijipiao_order_true_price")
    private Double feijipiaoOrderTruePrice;


    /**
     * 购买的座位
     */

    @TableField(value = "buy_zuowei_number")
    private String buyZuoweiNumber;


    /**
     * 订购日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "buy_zuowei_time")
    private Date buyZuoweiTime;


    /**
     * 订单类型
     */

    @TableField(value = "feijipiao_order_types")
    private Integer feijipiaoOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "feijipiao_order_payment_types")
    private Integer feijipiaoOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getFeijipiaoOrderUuidNumber() {
        return feijipiaoOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setFeijipiaoOrderUuidNumber(String feijipiaoOrderUuidNumber) {
        this.feijipiaoOrderUuidNumber = feijipiaoOrderUuidNumber;
    }
    /**
	 * 设置：飞机票
	 */
    public Integer getFeijipiaoId() {
        return feijipiaoId;
    }


    /**
	 * 获取：飞机票
	 */

    public void setFeijipiaoId(Integer feijipiaoId) {
        this.feijipiaoId = feijipiaoId;
    }
    /**
	 * 设置：客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 获取：客户
	 */

    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getFeijipiaoOrderTruePrice() {
        return feijipiaoOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setFeijipiaoOrderTruePrice(Double feijipiaoOrderTruePrice) {
        this.feijipiaoOrderTruePrice = feijipiaoOrderTruePrice;
    }
    /**
	 * 设置：购买的座位
	 */
    public String getBuyZuoweiNumber() {
        return buyZuoweiNumber;
    }


    /**
	 * 获取：购买的座位
	 */

    public void setBuyZuoweiNumber(String buyZuoweiNumber) {
        this.buyZuoweiNumber = buyZuoweiNumber;
    }
    /**
	 * 设置：订购日期
	 */
    public Date getBuyZuoweiTime() {
        return buyZuoweiTime;
    }


    /**
	 * 获取：订购日期
	 */

    public void setBuyZuoweiTime(Date buyZuoweiTime) {
        this.buyZuoweiTime = buyZuoweiTime;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getFeijipiaoOrderTypes() {
        return feijipiaoOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setFeijipiaoOrderTypes(Integer feijipiaoOrderTypes) {
        this.feijipiaoOrderTypes = feijipiaoOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getFeijipiaoOrderPaymentTypes() {
        return feijipiaoOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setFeijipiaoOrderPaymentTypes(Integer feijipiaoOrderPaymentTypes) {
        this.feijipiaoOrderPaymentTypes = feijipiaoOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

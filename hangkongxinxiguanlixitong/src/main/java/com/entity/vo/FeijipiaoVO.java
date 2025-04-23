package com.entity.vo;

import com.entity.FeijipiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 飞机票
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("feijipiao")
public class FeijipiaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 航班编号
     */

    @TableField(value = "feijipiao_uuid_number")
    private String feijipiaoUuidNumber;


    /**
     * 航空公司编号
     */

    @TableField(value = "hangkonggongsi_bianhao")
    private String hangkonggongsiBianhao;


    /**
     * 航空公司名称
     */

    @TableField(value = "hangkonggongsi_name")
    private String hangkonggongsiName;


    /**
     * 飞机票名称
     */

    @TableField(value = "feijipiao_name")
    private String feijipiaoName;


    /**
     * 飞机票照片
     */

    @TableField(value = "feijipiao_photo")
    private String feijipiaoPhoto;


    /**
     * 飞机票类型
     */

    @TableField(value = "feijipiao_types")
    private Integer feijipiaoTypes;


    /**
     * 座位
     */

    @TableField(value = "zuowei_number")
    private Integer zuoweiNumber;


    /**
     * 购买获得积分
     */

    @TableField(value = "feijipiao_price")
    private Integer feijipiaoPrice;


    /**
     * 飞机票原价
     */

    @TableField(value = "feijipiao_old_money")
    private Double feijipiaoOldMoney;


    /**
     * 现价
     */

    @TableField(value = "feijipiao_new_money")
    private Double feijipiaoNewMoney;


    /**
     * 点击次数
     */

    @TableField(value = "feijipiao_clicknum")
    private Integer feijipiaoClicknum;


    /**
     * 舱位
     */

    @TableField(value = "cangwei_types")
    private Integer cangweiTypes;


    /**
     * 是否特价票
     */

    @TableField(value = "tejia_types")
    private Integer tejiaTypes;


    /**
     * 飞机票介绍
     */

    @TableField(value = "feijipiao_content")
    private String feijipiaoContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "feijipiao_delete")
    private Integer feijipiaoDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：航班编号
	 */
    public String getFeijipiaoUuidNumber() {
        return feijipiaoUuidNumber;
    }


    /**
	 * 获取：航班编号
	 */

    public void setFeijipiaoUuidNumber(String feijipiaoUuidNumber) {
        this.feijipiaoUuidNumber = feijipiaoUuidNumber;
    }
    /**
	 * 设置：航空公司编号
	 */
    public String getHangkonggongsiBianhao() {
        return hangkonggongsiBianhao;
    }


    /**
	 * 获取：航空公司编号
	 */

    public void setHangkonggongsiBianhao(String hangkonggongsiBianhao) {
        this.hangkonggongsiBianhao = hangkonggongsiBianhao;
    }
    /**
	 * 设置：航空公司名称
	 */
    public String getHangkonggongsiName() {
        return hangkonggongsiName;
    }


    /**
	 * 获取：航空公司名称
	 */

    public void setHangkonggongsiName(String hangkonggongsiName) {
        this.hangkonggongsiName = hangkonggongsiName;
    }
    /**
	 * 设置：飞机票名称
	 */
    public String getFeijipiaoName() {
        return feijipiaoName;
    }


    /**
	 * 获取：飞机票名称
	 */

    public void setFeijipiaoName(String feijipiaoName) {
        this.feijipiaoName = feijipiaoName;
    }
    /**
	 * 设置：飞机票照片
	 */
    public String getFeijipiaoPhoto() {
        return feijipiaoPhoto;
    }


    /**
	 * 获取：飞机票照片
	 */

    public void setFeijipiaoPhoto(String feijipiaoPhoto) {
        this.feijipiaoPhoto = feijipiaoPhoto;
    }
    /**
	 * 设置：飞机票类型
	 */
    public Integer getFeijipiaoTypes() {
        return feijipiaoTypes;
    }


    /**
	 * 获取：飞机票类型
	 */

    public void setFeijipiaoTypes(Integer feijipiaoTypes) {
        this.feijipiaoTypes = feijipiaoTypes;
    }
    /**
	 * 设置：座位
	 */
    public Integer getZuoweiNumber() {
        return zuoweiNumber;
    }


    /**
	 * 获取：座位
	 */

    public void setZuoweiNumber(Integer zuoweiNumber) {
        this.zuoweiNumber = zuoweiNumber;
    }
    /**
	 * 设置：购买获得积分
	 */
    public Integer getFeijipiaoPrice() {
        return feijipiaoPrice;
    }


    /**
	 * 获取：购买获得积分
	 */

    public void setFeijipiaoPrice(Integer feijipiaoPrice) {
        this.feijipiaoPrice = feijipiaoPrice;
    }
    /**
	 * 设置：飞机票原价
	 */
    public Double getFeijipiaoOldMoney() {
        return feijipiaoOldMoney;
    }


    /**
	 * 获取：飞机票原价
	 */

    public void setFeijipiaoOldMoney(Double feijipiaoOldMoney) {
        this.feijipiaoOldMoney = feijipiaoOldMoney;
    }
    /**
	 * 设置：现价
	 */
    public Double getFeijipiaoNewMoney() {
        return feijipiaoNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setFeijipiaoNewMoney(Double feijipiaoNewMoney) {
        this.feijipiaoNewMoney = feijipiaoNewMoney;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getFeijipiaoClicknum() {
        return feijipiaoClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setFeijipiaoClicknum(Integer feijipiaoClicknum) {
        this.feijipiaoClicknum = feijipiaoClicknum;
    }
    /**
	 * 设置：舱位
	 */
    public Integer getCangweiTypes() {
        return cangweiTypes;
    }


    /**
	 * 获取：舱位
	 */

    public void setCangweiTypes(Integer cangweiTypes) {
        this.cangweiTypes = cangweiTypes;
    }
    /**
	 * 设置：是否特价票
	 */
    public Integer getTejiaTypes() {
        return tejiaTypes;
    }


    /**
	 * 获取：是否特价票
	 */

    public void setTejiaTypes(Integer tejiaTypes) {
        this.tejiaTypes = tejiaTypes;
    }
    /**
	 * 设置：飞机票介绍
	 */
    public String getFeijipiaoContent() {
        return feijipiaoContent;
    }


    /**
	 * 获取：飞机票介绍
	 */

    public void setFeijipiaoContent(String feijipiaoContent) {
        this.feijipiaoContent = feijipiaoContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getFeijipiaoDelete() {
        return feijipiaoDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setFeijipiaoDelete(Integer feijipiaoDelete) {
        this.feijipiaoDelete = feijipiaoDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

package com.entity.model;

import com.entity.FeijipiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 飞机票
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FeijipiaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
     * 是否特价票
     */
    private Integer tejiaTypes;


    /**
     * 飞机票介绍
     */
    private String feijipiaoContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer feijipiaoDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：航班编号
	 */
    public String getFeijipiaoUuidNumber() {
        return feijipiaoUuidNumber;
    }


    /**
	 * 设置：航班编号
	 */
    public void setFeijipiaoUuidNumber(String feijipiaoUuidNumber) {
        this.feijipiaoUuidNumber = feijipiaoUuidNumber;
    }
    /**
	 * 获取：航空公司编号
	 */
    public String getHangkonggongsiBianhao() {
        return hangkonggongsiBianhao;
    }


    /**
	 * 设置：航空公司编号
	 */
    public void setHangkonggongsiBianhao(String hangkonggongsiBianhao) {
        this.hangkonggongsiBianhao = hangkonggongsiBianhao;
    }
    /**
	 * 获取：航空公司名称
	 */
    public String getHangkonggongsiName() {
        return hangkonggongsiName;
    }


    /**
	 * 设置：航空公司名称
	 */
    public void setHangkonggongsiName(String hangkonggongsiName) {
        this.hangkonggongsiName = hangkonggongsiName;
    }
    /**
	 * 获取：飞机票名称
	 */
    public String getFeijipiaoName() {
        return feijipiaoName;
    }


    /**
	 * 设置：飞机票名称
	 */
    public void setFeijipiaoName(String feijipiaoName) {
        this.feijipiaoName = feijipiaoName;
    }
    /**
	 * 获取：飞机票照片
	 */
    public String getFeijipiaoPhoto() {
        return feijipiaoPhoto;
    }


    /**
	 * 设置：飞机票照片
	 */
    public void setFeijipiaoPhoto(String feijipiaoPhoto) {
        this.feijipiaoPhoto = feijipiaoPhoto;
    }
    /**
	 * 获取：飞机票类型
	 */
    public Integer getFeijipiaoTypes() {
        return feijipiaoTypes;
    }


    /**
	 * 设置：飞机票类型
	 */
    public void setFeijipiaoTypes(Integer feijipiaoTypes) {
        this.feijipiaoTypes = feijipiaoTypes;
    }
    /**
	 * 获取：座位
	 */
    public Integer getZuoweiNumber() {
        return zuoweiNumber;
    }


    /**
	 * 设置：座位
	 */
    public void setZuoweiNumber(Integer zuoweiNumber) {
        this.zuoweiNumber = zuoweiNumber;
    }
    /**
	 * 获取：购买获得积分
	 */
    public Integer getFeijipiaoPrice() {
        return feijipiaoPrice;
    }


    /**
	 * 设置：购买获得积分
	 */
    public void setFeijipiaoPrice(Integer feijipiaoPrice) {
        this.feijipiaoPrice = feijipiaoPrice;
    }
    /**
	 * 获取：飞机票原价
	 */
    public Double getFeijipiaoOldMoney() {
        return feijipiaoOldMoney;
    }


    /**
	 * 设置：飞机票原价
	 */
    public void setFeijipiaoOldMoney(Double feijipiaoOldMoney) {
        this.feijipiaoOldMoney = feijipiaoOldMoney;
    }
    /**
	 * 获取：现价
	 */
    public Double getFeijipiaoNewMoney() {
        return feijipiaoNewMoney;
    }


    /**
	 * 设置：现价
	 */
    public void setFeijipiaoNewMoney(Double feijipiaoNewMoney) {
        this.feijipiaoNewMoney = feijipiaoNewMoney;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getFeijipiaoClicknum() {
        return feijipiaoClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setFeijipiaoClicknum(Integer feijipiaoClicknum) {
        this.feijipiaoClicknum = feijipiaoClicknum;
    }
    /**
	 * 获取：舱位
	 */
    public Integer getCangweiTypes() {
        return cangweiTypes;
    }


    /**
	 * 设置：舱位
	 */
    public void setCangweiTypes(Integer cangweiTypes) {
        this.cangweiTypes = cangweiTypes;
    }
    /**
	 * 获取：是否特价票
	 */
    public Integer getTejiaTypes() {
        return tejiaTypes;
    }


    /**
	 * 设置：是否特价票
	 */
    public void setTejiaTypes(Integer tejiaTypes) {
        this.tejiaTypes = tejiaTypes;
    }
    /**
	 * 获取：飞机票介绍
	 */
    public String getFeijipiaoContent() {
        return feijipiaoContent;
    }


    /**
	 * 设置：飞机票介绍
	 */
    public void setFeijipiaoContent(String feijipiaoContent) {
        this.feijipiaoContent = feijipiaoContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFeijipiaoDelete() {
        return feijipiaoDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setFeijipiaoDelete(Integer feijipiaoDelete) {
        this.feijipiaoDelete = feijipiaoDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

package com.entity.model;

import com.entity.ShiyongbangzhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 使用帮助
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShiyongbangzhuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 帮助名称
     */
    private String shiyongbangzhuName;


    /**
     * 帮助图片
     */
    private String shiyongbangzhuPhoto;


    /**
     * 帮助类型
     */
    private Integer shiyongbangzhuTypes;


    /**
     * 使用帮助详情
     */
    private String shiyongbangzhuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show2 nameShow
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
	 * 获取：帮助名称
	 */
    public String getShiyongbangzhuName() {
        return shiyongbangzhuName;
    }


    /**
	 * 设置：帮助名称
	 */
    public void setShiyongbangzhuName(String shiyongbangzhuName) {
        this.shiyongbangzhuName = shiyongbangzhuName;
    }
    /**
	 * 获取：帮助图片
	 */
    public String getShiyongbangzhuPhoto() {
        return shiyongbangzhuPhoto;
    }


    /**
	 * 设置：帮助图片
	 */
    public void setShiyongbangzhuPhoto(String shiyongbangzhuPhoto) {
        this.shiyongbangzhuPhoto = shiyongbangzhuPhoto;
    }
    /**
	 * 获取：帮助类型
	 */
    public Integer getShiyongbangzhuTypes() {
        return shiyongbangzhuTypes;
    }


    /**
	 * 设置：帮助类型
	 */
    public void setShiyongbangzhuTypes(Integer shiyongbangzhuTypes) {
        this.shiyongbangzhuTypes = shiyongbangzhuTypes;
    }
    /**
	 * 获取：使用帮助详情
	 */
    public String getShiyongbangzhuContent() {
        return shiyongbangzhuContent;
    }


    /**
	 * 设置：使用帮助详情
	 */
    public void setShiyongbangzhuContent(String shiyongbangzhuContent) {
        this.shiyongbangzhuContent = shiyongbangzhuContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show2 nameShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

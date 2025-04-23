package com.entity.model;

import com.entity.HangbanguanlidongtaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 航班管理动态
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HangbanguanlidongtaiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 动态名称
     */
    private String hangbanguanlidongtaiName;


    /**
     * 动态图片
     */
    private String hangbanguanlidongtaiPhoto;


    /**
     * 动态类型
     */
    private Integer hangbanguanlidongtaiTypes;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 航班管理动态详情
     */
    private String hangbanguanlidongtaiContent;


    /**
     * 创建时间 show1 show2 nameShow
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
	 * 获取：动态名称
	 */
    public String getHangbanguanlidongtaiName() {
        return hangbanguanlidongtaiName;
    }


    /**
	 * 设置：动态名称
	 */
    public void setHangbanguanlidongtaiName(String hangbanguanlidongtaiName) {
        this.hangbanguanlidongtaiName = hangbanguanlidongtaiName;
    }
    /**
	 * 获取：动态图片
	 */
    public String getHangbanguanlidongtaiPhoto() {
        return hangbanguanlidongtaiPhoto;
    }


    /**
	 * 设置：动态图片
	 */
    public void setHangbanguanlidongtaiPhoto(String hangbanguanlidongtaiPhoto) {
        this.hangbanguanlidongtaiPhoto = hangbanguanlidongtaiPhoto;
    }
    /**
	 * 获取：动态类型
	 */
    public Integer getHangbanguanlidongtaiTypes() {
        return hangbanguanlidongtaiTypes;
    }


    /**
	 * 设置：动态类型
	 */
    public void setHangbanguanlidongtaiTypes(Integer hangbanguanlidongtaiTypes) {
        this.hangbanguanlidongtaiTypes = hangbanguanlidongtaiTypes;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：发布时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：航班管理动态详情
	 */
    public String getHangbanguanlidongtaiContent() {
        return hangbanguanlidongtaiContent;
    }


    /**
	 * 设置：航班管理动态详情
	 */
    public void setHangbanguanlidongtaiContent(String hangbanguanlidongtaiContent) {
        this.hangbanguanlidongtaiContent = hangbanguanlidongtaiContent;
    }
    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 使用帮助
 *
 * @author 
 * @email
 */
@TableName("shiyongbangzhu")
public class ShiyongbangzhuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShiyongbangzhuEntity() {

	}

	public ShiyongbangzhuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 帮助名称
     */
    @TableField(value = "shiyongbangzhu_name")

    private String shiyongbangzhuName;


    /**
     * 帮助图片
     */
    @TableField(value = "shiyongbangzhu_photo")

    private String shiyongbangzhuPhoto;


    /**
     * 帮助类型
     */
    @TableField(value = "shiyongbangzhu_types")

    private Integer shiyongbangzhuTypes;


    /**
     * 使用帮助详情
     */
    @TableField(value = "shiyongbangzhu_content")

    private String shiyongbangzhuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：帮助名称
	 */
    public String getShiyongbangzhuName() {
        return shiyongbangzhuName;
    }
    /**
	 * 获取：帮助名称
	 */

    public void setShiyongbangzhuName(String shiyongbangzhuName) {
        this.shiyongbangzhuName = shiyongbangzhuName;
    }
    /**
	 * 设置：帮助图片
	 */
    public String getShiyongbangzhuPhoto() {
        return shiyongbangzhuPhoto;
    }
    /**
	 * 获取：帮助图片
	 */

    public void setShiyongbangzhuPhoto(String shiyongbangzhuPhoto) {
        this.shiyongbangzhuPhoto = shiyongbangzhuPhoto;
    }
    /**
	 * 设置：帮助类型
	 */
    public Integer getShiyongbangzhuTypes() {
        return shiyongbangzhuTypes;
    }
    /**
	 * 获取：帮助类型
	 */

    public void setShiyongbangzhuTypes(Integer shiyongbangzhuTypes) {
        this.shiyongbangzhuTypes = shiyongbangzhuTypes;
    }
    /**
	 * 设置：使用帮助详情
	 */
    public String getShiyongbangzhuContent() {
        return shiyongbangzhuContent;
    }
    /**
	 * 获取：使用帮助详情
	 */

    public void setShiyongbangzhuContent(String shiyongbangzhuContent) {
        this.shiyongbangzhuContent = shiyongbangzhuContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shiyongbangzhu{" +
            "id=" + id +
            ", shiyongbangzhuName=" + shiyongbangzhuName +
            ", shiyongbangzhuPhoto=" + shiyongbangzhuPhoto +
            ", shiyongbangzhuTypes=" + shiyongbangzhuTypes +
            ", shiyongbangzhuContent=" + shiyongbangzhuContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}

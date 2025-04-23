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
 * 航班管理动态
 *
 * @author 
 * @email
 */
@TableName("hangbanguanlidongtai")
public class HangbanguanlidongtaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HangbanguanlidongtaiEntity() {

	}

	public HangbanguanlidongtaiEntity(T t) {
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
     * 动态名称
     */
    @TableField(value = "hangbanguanlidongtai_name")

    private String hangbanguanlidongtaiName;


    /**
     * 动态图片
     */
    @TableField(value = "hangbanguanlidongtai_photo")

    private String hangbanguanlidongtaiPhoto;


    /**
     * 动态类型
     */
    @TableField(value = "hangbanguanlidongtai_types")

    private Integer hangbanguanlidongtaiTypes;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 航班管理动态详情
     */
    @TableField(value = "hangbanguanlidongtai_content")

    private String hangbanguanlidongtaiContent;


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
	 * 设置：动态名称
	 */
    public String getHangbanguanlidongtaiName() {
        return hangbanguanlidongtaiName;
    }
    /**
	 * 获取：动态名称
	 */

    public void setHangbanguanlidongtaiName(String hangbanguanlidongtaiName) {
        this.hangbanguanlidongtaiName = hangbanguanlidongtaiName;
    }
    /**
	 * 设置：动态图片
	 */
    public String getHangbanguanlidongtaiPhoto() {
        return hangbanguanlidongtaiPhoto;
    }
    /**
	 * 获取：动态图片
	 */

    public void setHangbanguanlidongtaiPhoto(String hangbanguanlidongtaiPhoto) {
        this.hangbanguanlidongtaiPhoto = hangbanguanlidongtaiPhoto;
    }
    /**
	 * 设置：动态类型
	 */
    public Integer getHangbanguanlidongtaiTypes() {
        return hangbanguanlidongtaiTypes;
    }
    /**
	 * 获取：动态类型
	 */

    public void setHangbanguanlidongtaiTypes(Integer hangbanguanlidongtaiTypes) {
        this.hangbanguanlidongtaiTypes = hangbanguanlidongtaiTypes;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：航班管理动态详情
	 */
    public String getHangbanguanlidongtaiContent() {
        return hangbanguanlidongtaiContent;
    }
    /**
	 * 获取：航班管理动态详情
	 */

    public void setHangbanguanlidongtaiContent(String hangbanguanlidongtaiContent) {
        this.hangbanguanlidongtaiContent = hangbanguanlidongtaiContent;
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
        return "Hangbanguanlidongtai{" +
            "id=" + id +
            ", hangbanguanlidongtaiName=" + hangbanguanlidongtaiName +
            ", hangbanguanlidongtaiPhoto=" + hangbanguanlidongtaiPhoto +
            ", hangbanguanlidongtaiTypes=" + hangbanguanlidongtaiTypes +
            ", insertTime=" + insertTime +
            ", hangbanguanlidongtaiContent=" + hangbanguanlidongtaiContent +
            ", createTime=" + createTime +
        "}";
    }
}

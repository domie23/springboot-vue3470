package com.entity.vo;

import com.entity.HangbanguanlidongtaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 航班管理动态
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("hangbanguanlidongtai")
public class HangbanguanlidongtaiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 航班管理动态详情
     */

    @TableField(value = "hangbanguanlidongtai_content")
    private String hangbanguanlidongtaiContent;


    /**
     * 创建时间 show1 show2 nameShow
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
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

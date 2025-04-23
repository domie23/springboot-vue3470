package com.dao;

import com.entity.ShiyongbangzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShiyongbangzhuView;

/**
 * 使用帮助 Dao 接口
 *
 * @author 
 */
public interface ShiyongbangzhuDao extends BaseMapper<ShiyongbangzhuEntity> {

   List<ShiyongbangzhuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

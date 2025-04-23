package com.dao;

import com.entity.FeijipiaoCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FeijipiaoCommentbackView;

/**
 * 飞机票评价 Dao 接口
 *
 * @author 
 */
public interface FeijipiaoCommentbackDao extends BaseMapper<FeijipiaoCommentbackEntity> {

   List<FeijipiaoCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

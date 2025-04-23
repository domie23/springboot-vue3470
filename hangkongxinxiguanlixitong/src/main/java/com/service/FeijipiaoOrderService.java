package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FeijipiaoOrderEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 飞机票购买订单 服务类
 */
public interface FeijipiaoOrderService extends IService<FeijipiaoOrderEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}
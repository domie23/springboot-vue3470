
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 飞机票购买订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/feijipiaoOrder")
public class FeijipiaoOrderController {
    private static final Logger logger = LoggerFactory.getLogger(FeijipiaoOrderController.class);

    @Autowired
    private FeijipiaoOrderService feijipiaoOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private FeijipiaoService feijipiaoService;
    @Autowired
    private KehuService kehuService;
@Autowired
private FeijipiaoCommentbackService feijipiaoCommentbackService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("客户".equals(role))
            params.put("kehuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = feijipiaoOrderService.queryPage(params);

        //字典表数据转换
        List<FeijipiaoOrderView> list =(List<FeijipiaoOrderView>)page.getList();
        for(FeijipiaoOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FeijipiaoOrderEntity feijipiaoOrder = feijipiaoOrderService.selectById(id);
        if(feijipiaoOrder !=null){
            //entity转view
            FeijipiaoOrderView view = new FeijipiaoOrderView();
            BeanUtils.copyProperties( feijipiaoOrder , view );//把实体数据重构到view中

                //级联表
                FeijipiaoEntity feijipiao = feijipiaoService.selectById(feijipiaoOrder.getFeijipiaoId());
                if(feijipiao != null){
                    BeanUtils.copyProperties( feijipiao , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFeijipiaoId(feijipiao.getId());
                }
                //级联表
                KehuEntity kehu = kehuService.selectById(feijipiaoOrder.getKehuId());
                if(kehu != null){
                    BeanUtils.copyProperties( kehu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKehuId(kehu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FeijipiaoOrderEntity feijipiaoOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,feijipiaoOrder:{}",this.getClass().getName(),feijipiaoOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("客户".equals(role))
            feijipiaoOrder.setKehuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        feijipiaoOrder.setInsertTime(new Date());
        feijipiaoOrder.setCreateTime(new Date());
        feijipiaoOrderService.insert(feijipiaoOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FeijipiaoOrderEntity feijipiaoOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,feijipiaoOrder:{}",this.getClass().getName(),feijipiaoOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("客户".equals(role))
//            feijipiaoOrder.setKehuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<FeijipiaoOrderEntity> queryWrapper = new EntityWrapper<FeijipiaoOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FeijipiaoOrderEntity feijipiaoOrderEntity = feijipiaoOrderService.selectOne(queryWrapper);
        if(feijipiaoOrderEntity==null){
            feijipiaoOrderService.updateById(feijipiaoOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        feijipiaoOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<FeijipiaoOrderEntity> feijipiaoOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            FeijipiaoOrderEntity feijipiaoOrderEntity = new FeijipiaoOrderEntity();
//                            feijipiaoOrderEntity.setFeijipiaoOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            feijipiaoOrderEntity.setFeijipiaoId(Integer.valueOf(data.get(0)));   //飞机票 要改的
//                            feijipiaoOrderEntity.setKehuId(Integer.valueOf(data.get(0)));   //客户 要改的
//                            feijipiaoOrderEntity.setFeijipiaoOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            feijipiaoOrderEntity.setBuyZuoweiNumber(data.get(0));                    //购买的座位 要改的
//                            feijipiaoOrderEntity.setBuyZuoweiTime(sdf.parse(data.get(0)));          //订购日期 要改的
//                            feijipiaoOrderEntity.setFeijipiaoOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            feijipiaoOrderEntity.setFeijipiaoOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            feijipiaoOrderEntity.setInsertTime(date);//时间
//                            feijipiaoOrderEntity.setCreateTime(date);//时间
                            feijipiaoOrderList.add(feijipiaoOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("feijipiaoOrderUuidNumber")){
                                    List<String> feijipiaoOrderUuidNumber = seachFields.get("feijipiaoOrderUuidNumber");
                                    feijipiaoOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> feijipiaoOrderUuidNumber = new ArrayList<>();
                                    feijipiaoOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("feijipiaoOrderUuidNumber",feijipiaoOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<FeijipiaoOrderEntity> feijipiaoOrderEntities_feijipiaoOrderUuidNumber = feijipiaoOrderService.selectList(new EntityWrapper<FeijipiaoOrderEntity>().in("feijipiao_order_uuid_number", seachFields.get("feijipiaoOrderUuidNumber")));
                        if(feijipiaoOrderEntities_feijipiaoOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FeijipiaoOrderEntity s:feijipiaoOrderEntities_feijipiaoOrderUuidNumber){
                                repeatFields.add(s.getFeijipiaoOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        feijipiaoOrderService.insertBatch(feijipiaoOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = feijipiaoOrderService.queryPage(params);

        //字典表数据转换
        List<FeijipiaoOrderView> list =(List<FeijipiaoOrderView>)page.getList();
        for(FeijipiaoOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FeijipiaoOrderEntity feijipiaoOrder = feijipiaoOrderService.selectById(id);
            if(feijipiaoOrder !=null){


                //entity转view
                FeijipiaoOrderView view = new FeijipiaoOrderView();
                BeanUtils.copyProperties( feijipiaoOrder , view );//把实体数据重构到view中

                //级联表
                    FeijipiaoEntity feijipiao = feijipiaoService.selectById(feijipiaoOrder.getFeijipiaoId());
                if(feijipiao != null){
                    BeanUtils.copyProperties( feijipiao , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFeijipiaoId(feijipiao.getId());
                }
                //级联表
                    KehuEntity kehu = kehuService.selectById(feijipiaoOrder.getKehuId());
                if(kehu != null){
                    BeanUtils.copyProperties( kehu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKehuId(kehu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody FeijipiaoOrderEntity feijipiaoOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,feijipiaoOrder:{}",this.getClass().getName(),feijipiaoOrder.toString());
            FeijipiaoEntity feijipiaoEntity = feijipiaoService.selectById(feijipiaoOrder.getFeijipiaoId());
            if(feijipiaoEntity == null){
                return R.error(511,"查不到该飞机票");
            }
            // Double feijipiaoNewMoney = feijipiaoEntity.getFeijipiaoNewMoney();

            if(false){
            }
            else if(feijipiaoEntity.getFeijipiaoNewMoney() == null){
                return R.error(511,"飞机票价格不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            KehuEntity kehuEntity = kehuService.selectById(userId);
            if(kehuEntity == null)
                return R.error(511,"用户不能为空");
            if(kehuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");

        Double zhekou = 1.0;
        // 获取折扣
        Wrapper<DictionaryEntity> dictionary = new EntityWrapper<DictionaryEntity>()
                .eq("dic_code", "huiyuandengji_types")
                .eq("dic_name", "会员等级类型")
                .eq("code_index", kehuEntity.getHuiyuandengjiTypes())
                ;
        DictionaryEntity dictionaryEntity = dictionaryService.selectOne(dictionary);
        if(dictionaryEntity != null ){
            zhekou = Double.valueOf(dictionaryEntity.getBeizhu());
        }



        double balance = kehuEntity.getNewMoney() - feijipiaoEntity.getFeijipiaoNewMoney()*(feijipiaoOrder.getBuyZuoweiNumber().split(",").length)*zhekou;//余额
            buyJifen = new BigDecimal(feijipiaoEntity.getFeijipiaoPrice()).multiply(new BigDecimal(feijipiaoOrder.getBuyZuoweiNumber().split(",").length)).doubleValue();//所获积分
            if(balance<0)
                return R.error(511,"余额不够支付");
            feijipiaoOrder.setFeijipiaoOrderTypes(1); //设置订单状态为已支付
            feijipiaoOrder.setFeijipiaoOrderTruePrice(feijipiaoEntity.getFeijipiaoNewMoney()*(feijipiaoOrder.getBuyZuoweiNumber().split(",").length)*zhekou); //设置实付价格
            feijipiaoOrder.setKehuId(userId); //设置订单支付人id
            feijipiaoOrder.setFeijipiaoOrderUuidNumber(String.valueOf(new Date().getTime()));
            feijipiaoOrder.setFeijipiaoOrderPaymentTypes(1);
            feijipiaoOrder.setInsertTime(new Date());
            feijipiaoOrder.setCreateTime(new Date());
                feijipiaoOrderService.insert(feijipiaoOrder);//新增订单
            kehuEntity.setNewMoney(balance);//设置金额
            kehuEntity.setKehuSumJifen(kehuEntity.getKehuSumJifen() + buyJifen); //设置总积分
            kehuEntity.setKehuNewJifen(kehuEntity.getKehuNewJifen() + buyJifen); //设置现积分
                if(kehuEntity.getKehuSumJifen()  < 10000)
                    kehuEntity.setHuiyuandengjiTypes(1);
                else if(kehuEntity.getKehuSumJifen()  < 100000)
                    kehuEntity.setHuiyuandengjiTypes(2);
                else if(kehuEntity.getKehuSumJifen()  < 1000000)
                    kehuEntity.setHuiyuandengjiTypes(3);
            kehuService.updateById(kehuEntity);
            return R.ok();
    }

    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            FeijipiaoOrderEntity feijipiaoOrder = feijipiaoOrderService.selectById(id);
            Integer buyNumber = feijipiaoOrder.getBuyZuoweiNumber().split(",").length;
            Integer feijipiaoOrderPaymentTypes = feijipiaoOrder.getFeijipiaoOrderPaymentTypes();
            Integer feijipiaoId = feijipiaoOrder.getFeijipiaoId();
            if(feijipiaoId == null)
                return R.error(511,"查不到该飞机票");
            FeijipiaoEntity feijipiaoEntity = feijipiaoService.selectById(feijipiaoId);
            if(feijipiaoEntity == null)
                return R.error(511,"查不到该飞机票");
            Double feijipiaoNewMoney = feijipiaoEntity.getFeijipiaoNewMoney();
            if(feijipiaoNewMoney == null)
                return R.error(511,"飞机票价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            KehuEntity kehuEntity = kehuService.selectById(userId);
            if(kehuEntity == null)
                return R.error(511,"用户不能为空");
            if(kehuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");

            Double zhekou = 1.0;
            // 获取折扣
            Wrapper<DictionaryEntity> dictionary = new EntityWrapper<DictionaryEntity>()
                    .eq("dic_code", "huiyuandengji_types")
                    .eq("dic_name", "会员等级类型")
                    .eq("code_index", kehuEntity.getHuiyuandengjiTypes())
                    ;
            DictionaryEntity dictionaryEntity = dictionaryService.selectOne(dictionary);
            if(dictionaryEntity != null ){
                zhekou = Double.valueOf(dictionaryEntity.getBeizhu());
            }


            //判断是什么支付方式 1代表余额 2代表积分
            if(feijipiaoOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = feijipiaoEntity.getFeijipiaoNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                buyJifen = new BigDecimal(feijipiaoEntity.getFeijipiaoPrice()).multiply(new BigDecimal(buyNumber)).doubleValue();
                kehuEntity.setNewMoney(kehuEntity.getNewMoney() + money); //设置金额
                kehuEntity.setKehuSumJifen(kehuEntity.getKehuSumJifen() - buyJifen); //设置总积分
                if(kehuEntity.getKehuNewJifen() - buyJifen <0 )
                    return R.error("积分已经消费,无法退款！！！");
                kehuEntity.setKehuNewJifen(kehuEntity.getKehuNewJifen() - buyJifen); //设置现积分

                if(kehuEntity.getKehuSumJifen()  < 10000)
                    kehuEntity.setHuiyuandengjiTypes(1);
                else if(kehuEntity.getKehuSumJifen()  < 100000)
                    kehuEntity.setHuiyuandengjiTypes(2);
                else if(kehuEntity.getKehuSumJifen()  < 1000000)
                    kehuEntity.setHuiyuandengjiTypes(3);

            }




            feijipiaoOrder.setFeijipiaoOrderTypes(2);//设置订单状态为退款
            feijipiaoOrderService.updateById(feijipiaoOrder);//根据id更新
            kehuService.updateById(kehuEntity);//更新用户信息
            feijipiaoService.updateById(feijipiaoEntity);//更新订单中飞机票的信息
            return R.ok();
    }


    /**
     * 检票
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        FeijipiaoOrderEntity  feijipiaoOrderEntity = new  FeijipiaoOrderEntity();;
        feijipiaoOrderEntity.setId(id);
        feijipiaoOrderEntity.setFeijipiaoOrderTypes(3);
        boolean b =  feijipiaoOrderService.updateById( feijipiaoOrderEntity);
        if(!b){
            return R.error("检票出错");
        }
        return R.ok();
    }














    /**
     * 客户确认
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        FeijipiaoOrderEntity  feijipiaoOrderEntity = new  FeijipiaoOrderEntity();
        feijipiaoOrderEntity.setId(id);
        feijipiaoOrderEntity.setFeijipiaoOrderTypes(4);
        boolean b =  feijipiaoOrderService.updateById( feijipiaoOrderEntity);
        if(!b){
            return R.error("客户确认出错");
        }
        return R.ok();
    }



    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer feijipiaoCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            FeijipiaoOrderEntity feijipiaoOrder = feijipiaoOrderService.selectById(id);
        if(feijipiaoOrder == null)
            return R.error(511,"查不到该订单");
        if(feijipiaoOrder.getFeijipiaoOrderTypes() != 4)
            return R.error(511,"您不能评价");
        Integer feijipiaoId = feijipiaoOrder.getFeijipiaoId();
        if(feijipiaoId == null)
            return R.error(511,"查不到该飞机票");

        FeijipiaoCommentbackEntity feijipiaoCommentbackEntity = new FeijipiaoCommentbackEntity();
            feijipiaoCommentbackEntity.setId(id);
            feijipiaoCommentbackEntity.setFeijipiaoId(feijipiaoId);
            feijipiaoCommentbackEntity.setKehuId((Integer) request.getSession().getAttribute("userId"));
            feijipiaoCommentbackEntity.setFeijipiaoCommentbackText(commentbackText);
            feijipiaoCommentbackEntity.setInsertTime(new Date());
            feijipiaoCommentbackEntity.setReplyText(null);
            feijipiaoCommentbackEntity.setUpdateTime(null);
            feijipiaoCommentbackEntity.setCreateTime(new Date());
            feijipiaoCommentbackService.insert(feijipiaoCommentbackEntity);

            feijipiaoOrder.setFeijipiaoOrderTypes(5);//设置订单状态为已评价
            feijipiaoOrderService.updateById(feijipiaoOrder);//根据id更新
            return R.ok();
    }












}

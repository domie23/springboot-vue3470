
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.FeijipiaoEntity;
import com.entity.view.FeijipiaoView;
import com.service.DictionaryService;
import com.service.FeijipiaoService;
import com.service.KehuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.PoiUtil;
import com.utils.R;
import com.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 飞机票
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/feijipiao")
public class FeijipiaoController {
    private static final Logger logger = LoggerFactory.getLogger(FeijipiaoController.class);

    @Autowired
    private FeijipiaoService feijipiaoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private KehuService kehuService;


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
        params.put("feijipiaoDeleteStart",1);params.put("feijipiaoDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = feijipiaoService.queryPage(params);

        //字典表数据转换
        List<FeijipiaoView> list =(List<FeijipiaoView>)page.getList();
        for(FeijipiaoView c:list){
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
        FeijipiaoEntity feijipiao = feijipiaoService.selectById(id);
        if(feijipiao !=null){
            //entity转view
            FeijipiaoView view = new FeijipiaoView();
            BeanUtils.copyProperties( feijipiao , view );//把实体数据重构到view中

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
    public R save(@RequestBody FeijipiaoEntity feijipiao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,feijipiao:{}",this.getClass().getName(),feijipiao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<FeijipiaoEntity> queryWrapper = new EntityWrapper<FeijipiaoEntity>()
            .eq("feijipiao_uuid_number", feijipiao.getFeijipiaoUuidNumber())
            .eq("hangkonggongsi_bianhao", feijipiao.getHangkonggongsiBianhao())
            .eq("hangkonggongsi_name", feijipiao.getHangkonggongsiName())
            .eq("feijipiao_name", feijipiao.getFeijipiaoName())
            .eq("feijipiao_types", feijipiao.getFeijipiaoTypes())
            .eq("zuowei_number", feijipiao.getZuoweiNumber())
            .eq("feijipiao_price", feijipiao.getFeijipiaoPrice())
            .eq("feijipiao_clicknum", feijipiao.getFeijipiaoClicknum())
            .eq("cangwei_types", feijipiao.getCangweiTypes())
            .eq("chufadi_types", feijipiao.getChufadiTypes())
            .eq("mudidi_types", feijipiao.getMudidiTypes())
            .eq("feijipiao_chufashijian", feijipiao.getFeijipiaoChufashijian())
            .eq("feijipiao_daodashijian", feijipiao.getFeijipiaoDaodashijian())
            .eq("tejia_types", feijipiao.getTejiaTypes())
            .eq("shangxia_types", feijipiao.getShangxiaTypes())
            .eq("feijipiao_delete", feijipiao.getFeijipiaoDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FeijipiaoEntity feijipiaoEntity = feijipiaoService.selectOne(queryWrapper);
        if(feijipiaoEntity==null){
            feijipiao.setFeijipiaoClicknum(1);
            feijipiao.setShangxiaTypes(1);
            feijipiao.setFeijipiaoDelete(1);
            feijipiao.setCreateTime(new Date());
            feijipiaoService.insert(feijipiao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FeijipiaoEntity feijipiao, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,feijipiao:{}",this.getClass().getName(),feijipiao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<FeijipiaoEntity> queryWrapper = new EntityWrapper<FeijipiaoEntity>()
            .notIn("id",feijipiao.getId())
            .andNew()
            .eq("feijipiao_uuid_number", feijipiao.getFeijipiaoUuidNumber())
            .eq("hangkonggongsi_bianhao", feijipiao.getHangkonggongsiBianhao())
            .eq("hangkonggongsi_name", feijipiao.getHangkonggongsiName())
            .eq("feijipiao_name", feijipiao.getFeijipiaoName())
            .eq("feijipiao_types", feijipiao.getFeijipiaoTypes())
            .eq("zuowei_number", feijipiao.getZuoweiNumber())
            .eq("feijipiao_price", feijipiao.getFeijipiaoPrice())
            .eq("feijipiao_clicknum", feijipiao.getFeijipiaoClicknum())
            .eq("cangwei_types", feijipiao.getCangweiTypes())
            .eq("chufadi_types", feijipiao.getChufadiTypes())
            .eq("mudidi_types", feijipiao.getMudidiTypes())
            .eq("feijipiao_chufashijian", feijipiao.getFeijipiaoChufashijian())
            .eq("feijipiao_daodashijian", feijipiao.getFeijipiaoDaodashijian())
            .eq("tejia_types", feijipiao.getTejiaTypes())
            .eq("shangxia_types", feijipiao.getShangxiaTypes())
            .eq("feijipiao_delete", feijipiao.getFeijipiaoDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FeijipiaoEntity feijipiaoEntity = feijipiaoService.selectOne(queryWrapper);
        if("".equals(feijipiao.getFeijipiaoPhoto()) || "null".equals(feijipiao.getFeijipiaoPhoto())){
                feijipiao.setFeijipiaoPhoto(null);
        }
        if(feijipiaoEntity==null){
            feijipiaoService.updateById(feijipiao);//根据id更新
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
        ArrayList<FeijipiaoEntity> list = new ArrayList<>();
        for(Integer id:ids){
            FeijipiaoEntity feijipiaoEntity = new FeijipiaoEntity();
            feijipiaoEntity.setId(id);
            feijipiaoEntity.setFeijipiaoDelete(2);
            list.add(feijipiaoEntity);
        }
        if(list != null && list.size() >0){
            feijipiaoService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save(String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<FeijipiaoEntity> feijipiaoList = new ArrayList<>();//上传的东西
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
                            FeijipiaoEntity feijipiaoEntity = new FeijipiaoEntity();
//                            feijipiaoEntity.setFeijipiaoUuidNumber(data.get(0));                    //航班编号 要改的
//                            feijipiaoEntity.setHangkonggongsiBianhao(data.get(0));                    //航空公司编号 要改的
//                            feijipiaoEntity.setHangkonggongsiName(data.get(0));                    //航空公司名称 要改的
//                            feijipiaoEntity.setFeijipiaoName(data.get(0));                    //飞机票名称 要改的
//                            feijipiaoEntity.setFeijipiaoPhoto("");//详情和图片
//                            feijipiaoEntity.setFeijipiaoTypes(Integer.valueOf(data.get(0)));   //飞机票类型 要改的
//                            feijipiaoEntity.setZuoweiNumber(Integer.valueOf(data.get(0)));   //座位 要改的
//                            feijipiaoEntity.setFeijipiaoPrice(Integer.valueOf(data.get(0)));   //购买获得积分 要改的
//                            feijipiaoEntity.setFeijipiaoOldMoney(data.get(0));                    //飞机票原价 要改的
//                            feijipiaoEntity.setFeijipiaoNewMoney(data.get(0));                    //现价 要改的
//                            feijipiaoEntity.setFeijipiaoClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            feijipiaoEntity.setCangweiTypes(Integer.valueOf(data.get(0)));   //舱位 要改的
//                            feijipiaoEntity.setChufadiTypes(Integer.valueOf(data.get(0)));   //出发地 要改的
//                            feijipiaoEntity.setMudidiTypes(Integer.valueOf(data.get(0)));   //目的地 要改的
//                            feijipiaoEntity.setFeijipiaoChufashijian(data.get(0));                    //出发时间 要改的
//                            feijipiaoEntity.setFeijipiaoDaodashijian(data.get(0));                    //到达时间 要改的
//                            feijipiaoEntity.setTejiaTypes(Integer.valueOf(data.get(0)));   //是否特价票 要改的
//                            feijipiaoEntity.setFeijipiaoContent("");//详情和图片
//                            feijipiaoEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            feijipiaoEntity.setFeijipiaoDelete(1);//逻辑删除字段
//                            feijipiaoEntity.setCreateTime(date);//时间
                            feijipiaoList.add(feijipiaoEntity);


                            //把要查询是否重复的字段放入map中
                                //航班编号
                                if(seachFields.containsKey("feijipiaoUuidNumber")){
                                    List<String> feijipiaoUuidNumber = seachFields.get("feijipiaoUuidNumber");
                                    feijipiaoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> feijipiaoUuidNumber = new ArrayList<>();
                                    feijipiaoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("feijipiaoUuidNumber",feijipiaoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //航班编号
                        List<FeijipiaoEntity> feijipiaoEntities_feijipiaoUuidNumber = feijipiaoService.selectList(new EntityWrapper<FeijipiaoEntity>().in("feijipiao_uuid_number", seachFields.get("feijipiaoUuidNumber")).eq("feijipiao_delete", 1));
                        if(feijipiaoEntities_feijipiaoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FeijipiaoEntity s:feijipiaoEntities_feijipiaoUuidNumber){
                                repeatFields.add(s.getFeijipiaoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [航班编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        feijipiaoService.insertBatch(feijipiaoList);
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
        PageUtils page = feijipiaoService.queryPage(params);

        //字典表数据转换
        List<FeijipiaoView> list =(List<FeijipiaoView>)page.getList();
        for(FeijipiaoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FeijipiaoEntity feijipiao = feijipiaoService.selectById(id);
            if(feijipiao !=null){

                //点击数量加1
                feijipiao.setFeijipiaoClicknum(feijipiao.getFeijipiaoClicknum()+1);
                feijipiaoService.updateById(feijipiao);

                //entity转view
                FeijipiaoView view = new FeijipiaoView();
                BeanUtils.copyProperties( feijipiao , view );//把实体数据重构到view中

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
    public R add(@RequestBody FeijipiaoEntity feijipiao, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,feijipiao:{}",this.getClass().getName(),feijipiao.toString());
        Wrapper<FeijipiaoEntity> queryWrapper = new EntityWrapper<FeijipiaoEntity>()
            .eq("feijipiao_uuid_number", feijipiao.getFeijipiaoUuidNumber())
            .eq("hangkonggongsi_bianhao", feijipiao.getHangkonggongsiBianhao())
            .eq("hangkonggongsi_name", feijipiao.getHangkonggongsiName())
            .eq("feijipiao_name", feijipiao.getFeijipiaoName())
            .eq("feijipiao_types", feijipiao.getFeijipiaoTypes())
            .eq("zuowei_number", feijipiao.getZuoweiNumber())
            .eq("feijipiao_price", feijipiao.getFeijipiaoPrice())
            .eq("feijipiao_clicknum", feijipiao.getFeijipiaoClicknum())
            .eq("cangwei_types", feijipiao.getCangweiTypes())
            .eq("chufadi_types", feijipiao.getChufadiTypes())
            .eq("mudidi_types", feijipiao.getMudidiTypes())
            .eq("feijipiao_chufashijian", feijipiao.getFeijipiaoChufashijian())
            .eq("feijipiao_daodashijian", feijipiao.getFeijipiaoDaodashijian())
            .eq("tejia_types", feijipiao.getTejiaTypes())
            .eq("shangxia_types", feijipiao.getShangxiaTypes())
            .eq("feijipiao_delete", feijipiao.getFeijipiaoDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FeijipiaoEntity feijipiaoEntity = feijipiaoService.selectOne(queryWrapper);
        if(feijipiaoEntity==null){
            feijipiao.setFeijipiaoDelete(1);
            feijipiao.setCreateTime(new Date());
        feijipiaoService.insert(feijipiao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}

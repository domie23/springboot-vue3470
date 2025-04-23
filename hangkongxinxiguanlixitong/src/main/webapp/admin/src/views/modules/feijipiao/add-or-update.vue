<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                :style="{backgroundColor:addEditForm.addEditBoxColor}">
            <el-row>
                <input id="updateId" name="id" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="航班编号" prop="feijipiaoUuidNumber">
                       <el-input v-model="ruleForm.feijipiaoUuidNumber"
                                 placeholder="航班编号" clearable  :readonly="ro.feijipiaoUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="航班编号" prop="feijipiaoUuidNumber">
                           <el-input v-model="ruleForm.feijipiaoUuidNumber"
                                     placeholder="航班编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="航空公司编号" prop="hangkonggongsiBianhao">
                       <el-input v-model="ruleForm.hangkonggongsiBianhao"
                                 placeholder="航空公司编号" clearable  :readonly="ro.hangkonggongsiBianhao"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="航空公司编号" prop="hangkonggongsiBianhao">
                           <el-input v-model="ruleForm.hangkonggongsiBianhao"
                                     placeholder="航空公司编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="航空公司名称" prop="hangkonggongsiName">
                       <el-input v-model="ruleForm.hangkonggongsiName"
                                 placeholder="航空公司名称" clearable  :readonly="ro.hangkonggongsiName"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="航空公司名称" prop="hangkonggongsiName">
                           <el-input v-model="ruleForm.hangkonggongsiName"
                                     placeholder="航空公司名称" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="飞机票名称" prop="feijipiaoName">
                       <el-input v-model="ruleForm.feijipiaoName"
                                 placeholder="飞机票名称" clearable  :readonly="ro.feijipiaoName"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="飞机票名称" prop="feijipiaoName">
                           <el-input v-model="ruleForm.feijipiaoName"
                                     placeholder="飞机票名称" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="upload" v-if="type!='info' && !ro.feijipiaoPhoto" label="飞机票照片" prop="feijipiaoPhoto">
                        <file-upload
                            tip="点击上传飞机票照片"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.feijipiaoPhoto?ruleForm.feijipiaoPhoto:''"
                            @change="feijipiaoPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.feijipiaoPhoto" label="飞机票照片" prop="feijipiaoPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.feijipiaoPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="飞机票类型" prop="feijipiaoTypes">
                        <el-select v-model="ruleForm.feijipiaoTypes" :disabled="ro.feijipiaoTypes" placeholder="请选择飞机票类型">
                            <el-option
                                v-for="(item,index) in feijipiaoTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="飞机票类型" prop="feijipiaoValue">
                        <el-input v-model="ruleForm.feijipiaoValue"
                            placeholder="飞机票类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="座位" prop="zuoweiNumber">
                       <el-input v-model="ruleForm.zuoweiNumber"
                                 placeholder="座位 只能输数字 例:10 代表有1-10十个座位" clearable  :readonly="ro.zuoweiNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="座位" prop="zuoweiNumber">
                           <el-input v-model="ruleForm.zuoweiNumber"
                                     placeholder="座位" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="购买获得积分" prop="feijipiaoPrice">
                       <el-input v-model="ruleForm.feijipiaoPrice"
                                 placeholder="购买获得积分" clearable  :readonly="ro.feijipiaoPrice"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="购买获得积分" prop="feijipiaoPrice">
                           <el-input v-model="ruleForm.feijipiaoPrice"
                                     placeholder="购买获得积分" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="飞机票原价" prop="feijipiaoOldMoney">
                       <el-input v-model="ruleForm.feijipiaoOldMoney"
                                 placeholder="飞机票原价" clearable  :readonly="ro.feijipiaoOldMoney"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="飞机票原价" prop="feijipiaoOldMoney">
                           <el-input v-model="ruleForm.feijipiaoOldMoney"
                                     placeholder="飞机票原价" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="现价" prop="feijipiaoNewMoney">
                       <el-input v-model="ruleForm.feijipiaoNewMoney"
                                 placeholder="现价" clearable  :readonly="ro.feijipiaoNewMoney"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="现价" prop="feijipiaoNewMoney">
                           <el-input v-model="ruleForm.feijipiaoNewMoney"
                                     placeholder="现价" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="舱位" prop="cangweiTypes">
                        <el-select v-model="ruleForm.cangweiTypes" :disabled="ro.cangweiTypes" placeholder="请选择舱位">
                            <el-option
                                v-for="(item,index) in cangweiTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="舱位" prop="cangweiValue">
                        <el-input v-model="ruleForm.cangweiValue"
                            placeholder="舱位" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="出发地" prop="chufadiTypes">
                        <el-select v-model="ruleForm.chufadiTypes" :disabled="ro.chufadiTypes" placeholder="请选择出发地">
                            <el-option
                                v-for="(item,index) in chufadiTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="出发地" prop="chufadiValue">
                        <el-input v-model="ruleForm.chufadiValue"
                            placeholder="出发地" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="目的地" prop="mudidiTypes">
                        <el-select v-model="ruleForm.mudidiTypes" :disabled="ro.mudidiTypes" placeholder="请选择目的地">
                            <el-option
                                v-for="(item,index) in mudidiTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="目的地" prop="mudidiValue">
                        <el-input v-model="ruleForm.mudidiValue"
                            placeholder="目的地" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="出发时间" prop="feijipiaoChufashijian">
                       <!--<el-input v-model="ruleForm.feijipiaoChufashijian"-->
                                 <!--placeholder="出发时间" clearable  :readonly="ro.feijipiaoChufashijian"></el-input>-->
                       <el-time-select
                        v-model="ruleForm.feijipiaoChufashijian"
                         :picker-options="{
                            start: '00:00',
                            step: '00:01',
                            end: '23:59'
                            }"
                        value-format="HH:mm"
                        placeholder="出发时间"  :readonly="ro.feijipiaoChufashijian">
                      </el-time-select>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="出发时间" prop="feijipiaoChufashijian">
                           <el-input v-model="ruleForm.feijipiaoChufashijian"
                                     placeholder="出发时间" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="到达时间" prop="feijipiaoDaodashijian">
                       <!--<el-input v-model="ruleForm.feijipiaoDaodashijian"-->
                                 <!--placeholder="到达时间" clearable  :readonly="ro.feijipiaoDaodashijian"></el-input>-->
                       <el-time-select
                        v-model="ruleForm.feijipiaoDaodashijian"
                         :picker-options="{
                            start: '00:00',
                            step: '00:01',
                            end: '23:59'
                        }"
                        value-format="HH:mm"
                        placeholder="到达时间"  :readonly="ro.feijipiaoDaodashijian">
                      </el-time-select>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="到达时间" prop="feijipiaoDaodashijian">
                           <el-input v-model="ruleForm.feijipiaoDaodashijian"
                                     placeholder="到达时间" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="是否特价票" prop="tejiaTypes">
                        <el-select v-model="ruleForm.tejiaTypes" :disabled="ro.tejiaTypes" placeholder="请选择是否特价票">
                            <el-option
                                v-for="(item,index) in tejiaTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="是否特价票" prop="tejiaValue">
                        <el-input v-model="ruleForm.tejiaValue"
                            placeholder="是否特价票" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="飞机票介绍" prop="feijipiaoContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.feijipiaoContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.feijipiaoContent" label="飞机票介绍" prop="feijipiaoContent">
                            <span v-html="ruleForm.feijipiaoContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                ro:{
                    feijipiaoUuidNumber: false,
                    hangkonggongsiBianhao: false,
                    hangkonggongsiName: false,
                    feijipiaoName: false,
                    feijipiaoPhoto: false,
                    feijipiaoTypes: false,
                    zuoweiNumber: false,
                    feijipiaoPrice: false,
                    feijipiaoOldMoney: false,
                    feijipiaoNewMoney: false,
                    feijipiaoClicknum: false,
                    cangweiTypes: false,
                    chufadiTypes: false,
                    mudidiTypes: false,
                    feijipiaoChufashijian: false,
                    feijipiaoDaodashijian: false,
                    tejiaTypes: false,
                    feijipiaoContent: false,
                    shangxiaTypes: false,
                    feijipiaoDelete: false,
                },
                ruleForm: {
                    feijipiaoUuidNumber: new Date().getTime(),
                    hangkonggongsiBianhao: '',
                    hangkonggongsiName: '',
                    feijipiaoName: '',
                    feijipiaoPhoto: '',
                    feijipiaoTypes: '',
                    zuoweiNumber: '',
                    feijipiaoPrice: '',
                    feijipiaoOldMoney: '',
                    feijipiaoNewMoney: '',
                    feijipiaoClicknum: '',
                    cangweiTypes: '',
                    chufadiTypes: '',
                    mudidiTypes: '',
                    feijipiaoChufashijian: '',
                    feijipiaoDaodashijian: '',
                    tejiaTypes: '',
                    feijipiaoContent: '',
                    shangxiaTypes: '',
                    feijipiaoDelete: '',
                },
                feijipiaoTypesOptions : [],
                cangweiTypesOptions : [],
                chufadiTypesOptions : [],
                mudidiTypesOptions : [],
                tejiaTypesOptions : [],
                shangxiaTypesOptions : [],
                rules: {
                   feijipiaoUuidNumber: [
                              { required: true, message: '航班编号不能为空', trigger: 'blur' },
                          ],
                   hangkonggongsiBianhao: [
                              { required: true, message: '航空公司编号不能为空', trigger: 'blur' },
                          ],
                   hangkonggongsiName: [
                              { required: true, message: '航空公司名称不能为空', trigger: 'blur' },
                          ],
                   feijipiaoName: [
                              { required: true, message: '飞机票名称不能为空', trigger: 'blur' },
                          ],
                   feijipiaoPhoto: [
                              { required: true, message: '飞机票照片不能为空', trigger: 'blur' },
                          ],
                   feijipiaoTypes: [
                              { required: true, message: '飞机票类型不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   zuoweiNumber: [
                              { required: true, message: '座位不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   feijipiaoPrice: [
                              { required: true, message: '购买获得积分不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   feijipiaoOldMoney: [
                              { required: true, message: '飞机票原价不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   feijipiaoNewMoney: [
                              { required: true, message: '现价不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   feijipiaoClicknum: [
                              { required: true, message: '点击次数不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   cangweiTypes: [
                              { required: true, message: '舱位不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   chufadiTypes: [
                              { required: true, message: '出发地不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   mudidiTypes: [
                              { required: true, message: '目的地不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   feijipiaoChufashijian: [
                              { required: true, message: '出发时间不能为空', trigger: 'blur' },
                          ],
                   feijipiaoDaodashijian: [
                              { required: true, message: '到达时间不能为空', trigger: 'blur' },
                          ],
                   tejiaTypes: [
                              { required: true, message: '是否特价票不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   feijipiaoContent: [
                              { required: true, message: '飞机票介绍不能为空', trigger: 'blur' },
                          ],
                   shangxiaTypes: [
                              { required: true, message: '是否上架不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   feijipiaoDelete: [
                              { required: true, message: '逻辑删除不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=feijipiao_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.feijipiaoTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=cangwei_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.cangweiTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=chufadi_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.chufadiTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=mudidi_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.mudidiTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=tejia_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.tejiaTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=shangxia_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.shangxiaTypesOptions = data.data.list;
                    }
                });


        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `feijipiao/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`feijipiao/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.feijipiaoCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.feijipiaoCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            feijipiaoPhotoUploadChange(fileUrls){
                this.ruleForm.feijipiaoPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}</style>


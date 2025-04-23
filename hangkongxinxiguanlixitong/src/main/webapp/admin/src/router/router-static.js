import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import feijipiao from '@/views/modules/feijipiao/list'
    import feijipiaoCollection from '@/views/modules/feijipiaoCollection/list'
    import feijipiaoCommentback from '@/views/modules/feijipiaoCommentback/list'
    import feijipiaoOrder from '@/views/modules/feijipiaoOrder/list'
    import hangbanguanlidongtai from '@/views/modules/hangbanguanlidongtai/list'
    import shiyongbangzhu from '@/views/modules/shiyongbangzhu/list'
    import kehu from '@/views/modules/kehu/list'
    import config from '@/views/modules/config/list'
    import dictionaryCangwei from '@/views/modules/dictionaryCangwei/list'
    import dictionaryChufadi from '@/views/modules/dictionaryChufadi/list'
    import dictionaryFeijipiao from '@/views/modules/dictionaryFeijipiao/list'
    import dictionaryFeijipiaoCollection from '@/views/modules/dictionaryFeijipiaoCollection/list'
    import dictionaryFeijipiaoOrder from '@/views/modules/dictionaryFeijipiaoOrder/list'
    import dictionaryFeijipiaoOrderPayment from '@/views/modules/dictionaryFeijipiaoOrderPayment/list'
    import dictionaryHangbanguanlidongtai from '@/views/modules/dictionaryHangbanguanlidongtai/list'
    import dictionaryHuiyuandengji from '@/views/modules/dictionaryHuiyuandengji/list'
    import dictionaryMudidi from '@/views/modules/dictionaryMudidi/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryShiyongbangzhu from '@/views/modules/dictionaryShiyongbangzhu/list'
    import dictionaryTejia from '@/views/modules/dictionaryTejia/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryCangwei',
        name: '舱位',
        component: dictionaryCangwei
    }
    ,{
        path: '/dictionaryChufadi',
        name: '出发地',
        component: dictionaryChufadi
    }
    ,{
        path: '/dictionaryFeijipiao',
        name: '飞机票类型',
        component: dictionaryFeijipiao
    }
    ,{
        path: '/dictionaryFeijipiaoCollection',
        name: '收藏表类型',
        component: dictionaryFeijipiaoCollection
    }
    ,{
        path: '/dictionaryFeijipiaoOrder',
        name: '订单类型',
        component: dictionaryFeijipiaoOrder
    }
    ,{
        path: '/dictionaryFeijipiaoOrderPayment',
        name: '订单支付类型',
        component: dictionaryFeijipiaoOrderPayment
    }
    ,{
        path: '/dictionaryHangbanguanlidongtai',
        name: '航班管理动态类型',
        component: dictionaryHangbanguanlidongtai
    }
    ,{
        path: '/dictionaryHuiyuandengji',
        name: '会员等级类型',
        component: dictionaryHuiyuandengji
    }
    ,{
        path: '/dictionaryMudidi',
        name: '目的地',
        component: dictionaryMudidi
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryShiyongbangzhu',
        name: '使用帮助类型',
        component: dictionaryShiyongbangzhu
    }
    ,{
        path: '/dictionaryTejia',
        name: '是否特价票',
        component: dictionaryTejia
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/feijipiao',
        name: '飞机票',
        component: feijipiao
      }
    ,{
        path: '/feijipiaoCollection',
        name: '飞机票收藏',
        component: feijipiaoCollection
      }
    ,{
        path: '/feijipiaoCommentback',
        name: '飞机票评价',
        component: feijipiaoCommentback
      }
    ,{
        path: '/feijipiaoOrder',
        name: '飞机票购买订单',
        component: feijipiaoOrder
      }
    ,{
        path: '/hangbanguanlidongtai',
        name: '航班管理动态',
        component: hangbanguanlidongtai
      }
    ,{
        path: '/shiyongbangzhu',
        name: '使用帮助',
        component: shiyongbangzhu
      }
    ,{
        path: '/kehu',
        name: '客户',
        component: kehu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;

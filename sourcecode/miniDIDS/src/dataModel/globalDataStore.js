// https://vuex.vuejs.org/zh-cn/intro.html
// make sure to call Vue.use(Vuex) if using a module system
import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

const systemInfo = wx.getSystemInfoSync();

const globalDataStore = new Vuex.Store({
    //数据结构
    state: {
      systemInfo,                       // 系统info 初始化值
      hasBundId:false,                  // 是否创建 BundId
      bundInfo:{},                      // bundInfo信息
      cardNumber:"",                    // 公民身份证
      carInfo:{},                       // 车辆行驶证
    },
    //Actions
    mutations: {
      setHasBundId(state,hasBundId){
        state.hasBundId = hasBundId;
      },
      setBundInfo(state,bundInfo){
        state.bundInfo = bundInfo;
      },
      setCardNumber(state,cardNumber){
        state.cardNumber = cardNumber;
      },
      setCarInfo(state,carInfo){
        state.carInfo = carInfo;
      },
    }
})


export default globalDataStore;

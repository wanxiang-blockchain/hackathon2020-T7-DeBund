<template>
  <view class="index">
    <!-- <AtNoticebar marquee>
      您的文件已存储至IPFS,MultiHash值：QmQCTz1jiHFiv6UHCvAzPuNpuk6RVQR1PM8X3VHAHtA3FX
    </AtNoticebar> -->

    <view class="loginTop">
      {{ type === 'company' ? '预约单进度 - 楼宇进入' : '租赁单进度 - 共享办公'}}
    </view>

    <view class="loginMain">
      <AtSteps
        :items="type == 'company' ? items2 : items3"
        :current="value"
        :onChange="onChange.bind(this)"
      />

      <view class="codeBox">
        <image :src="stepCode" class="codeImg" v-if="type == 'company'"></image>
        <image :src="heTong" class="codeImg" v-else></image>
      </view>
      
      <view class="bookingInfo">
        <view class="info">{{value1}}</view>
        <view class="info">{{value2}}</view>
        <view class="info">{{value3}}</view>
        <view class="info" v-if="type === 'wework'">4小时: 合计80元整</view>
      </view>
    </view>

    <view class="loginEnd">
      <AtMessage />
      <view @tap="this.handleClick" class="btn">{{type === 'wework'? '我已支付' : '回到首页'}}</view>
    </view>

  </view>
</template>

<script>
// 按需引入, 更小的应用体积
import './index.less' 
import Taro, { navigateBack } from '@tarojs/taro'
import { AtInput, AtMessage, AtSteps, AtNoticebar} from 'taro-ui-vue'
import "taro-ui-vue/dist/style/components/form.scss";
import "taro-ui-vue/dist/style/components/message.scss";
import "taro-ui-vue/dist/style/components/steps.scss";
import "taro-ui-vue/dist/style/components/icon.scss";
import "taro-ui-vue/dist/style/components/noticebar.scss";
import globalStore from '../../../../dataModel/globalDataStore'
import stepCode from '../../../../static/images/stepCode.png'
import heTong from '../../../../static/images/heTong.png'

export default {
  components: {
    AtInput, 
    AtMessage,
    AtSteps,
    AtNoticebar,
  },
  data () {
    return {
      stepCode, heTong,
      type:'',
      value1: '中信大厦',
      value2: '上海虹口区天潼路328号中信大厦 18楼',
      value3: '2020-10-26 15:00-19:00',

      value: 1,
      isShowCode: false,
      items2:[
        { title: '预约发起', desc: '发起预约单', status: 'success'},
        { title: '审批并预授权', desc: '楼宇审批并预授权',status: 'success'},
        { title: '进入楼宇', desc: '使用下发二维码扫描进入楼宇' }
      ],
      items3:[
        { title: '预约发起', desc: '发起预约单', status: 'success'},
        { title: '支付租金', desc: '支付完成点击我已支付'},
        { title: '审批并预授权', desc: '楼宇审批并预授权'},
        { title: '进入楼宇', desc: '使用下发二维码扫描进入楼宇' }
      ]
    }
  },
  onLoad(options){
    this.value1 = options.value1;
    this.value2 = options.value2;
    this.value3 = options.value3;
    this.type = options.type;
  },
  onShow() {
    Taro.showLoading({ title: '正在审核...'})
    setTimeout(function () {
      Taro.hideLoading();
      // this.isShowCode = true;
    }, 2000)
  },
  methods: {
    onChange(val) {
      this.value = val;
    },

    handleClick (type) {
      if(this.type === 'company'){
        Taro.switchTab({
          url:'/pages/did_my/index'
        });
      } else {
        setTimeout(()=>{
          Taro.atMessage({
            message: '支付成功',
            type: 'success'
          });
          setTimeout(()=>{
            Taro.navigateTo({
              url:'/pages/did_function/children/stepNextCode/index'
            })
          }, 800)
        }, 800)
      }
    },
  },
}
</script>

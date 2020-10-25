<template>
  <view class="index">
    <view class="loginTop">
      添加资产凭证 - 汽车行驶证
    </view>

    <view class="loginMain">
        <view class="item">
          <AtInput 
            name='value1' 
            type='text'
            placeholder='车牌号码' 
            :value="value1"
            :onChange="handleChange1" 
          />
        </view>
        <view class="item">
          <AtInput
            name='value2'
            type='text'
            placeholder='发动机号码'
            :value="value2"
            :onChange="handleChange2"
          />
        </view>
        <view class="item">
          <AtInput
            name='value3'
            type='text'
            placeholder='车辆行驶证代号'
            :value="value3"
            :onChange="handleChange3"
          />
        </view>
    </view>

    <view class="loginEnd">
      <AtMessage />
      <view @tap="this.handleClick" class="btn">完成</view>
      <view class="text">
        <view>认证你填写的个人身份信息，没有你的授权，任何人都无法获取你的隐私信息。</view>
      </view>
    </view>

  </view>
</template>

<script>
// 按需引入, 更小的应用体积
import './index.less' 
import Taro, { navigateBack } from '@tarojs/taro'
import { AtInput, AtMessage} from 'taro-ui-vue'
import "taro-ui-vue/dist/style/components/form.scss";
import "taro-ui-vue/dist/style/components/message.scss";
import globalStore from '../../../../dataModel/globalDataStore'

export default {
  components: {
    AtInput, 
    AtMessage
  },
  data () {
    return {
      value1: '沪A001024',
      value2: 'NONRBUNDGREATE',
      value3: 'DEBUNDGREATE',
    }
  },
  onLoad(){
    console.log(globalStore.state.hasBundId)
  },
  methods: {
    handleChange1 (value) {
      this.value1 = value
    },
    handleChange2 (value) {
      this.value2 = value
    },
    handleChange3 (value) {
      this.value3 = value
    },
    handleClick (type) {
      if(this.value1 == "" || this.value2 == "" || this.value3 == "") {
        Taro.atMessage({
          message: '必填项为空',
          type: 'error'
        });
      } else {
        globalStore.commit('setCarInfo',{
          carId1: this.value1,
          carId2: this.value1,
          carId3: this.value3,
        })
        
        Taro.showLoading({ title: '正在验证...'})
        setTimeout(function () {
          Taro.hideLoading();
          Taro.atMessage({
            message: '资产信息添加成功',
            type: 'success'
          });
          setTimeout(()=>{
            Taro.switchTab({
              url:'/pages/did_my/index'
            });
          }, 1000)
        }, 1000)
      }
    },
  },
}
</script>

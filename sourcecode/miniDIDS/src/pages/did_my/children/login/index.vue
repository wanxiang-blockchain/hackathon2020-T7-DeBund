<template>
  <view class="index">
    <view class="loginTop">
      创建 DeBund ID 数字信用身份
    </view>

    <view class="loginMain">
        <view class="item">
          <AtInput 
            name='value1' 
            type='text'
            placeholder='身份名称' 
            :value="value1"
            :onChange="handleChange1" 
          />
        </view>
        <view class="item">
          <AtInput
            name='value2'
            type='password'
            placeholder='身份密码'
            :value="value2"
            :onChange="handleChange2"
          />
        </view>
        <view class="item">
          <AtInput
            name='value3'
            type='password'
            placeholder='确认密码'
            :value="value3"
            :onChange="handleChange3"
          />
        </view>
    </view>

    <view class="loginEnd">
      <AtMessage />
      <view @tap="this.handleClick" class="btn">下一步</view>
      <view class="text">
        <view>继续即代表你已阅读并同意</view>
        <view class="text1">服务条款</view>及
        <view class="text1">服务协议</view>
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
      value1: '郑斌斌',
      value2: '123456',
      value3: '123456',
    }
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
      } else if(this.value2 != this.value3) {
        Taro.atMessage({
          message: '密码不一致',
          type: 'error'
        });
      } else {
        globalStore.commit('setBundInfo',{
          bundId:'did:bund:AS413noETYf6iEZy6jC5mL1qqFG1PMQQjV',
          bundName: this.value1,
          bundPassword: this.value2,
        })
        globalStore.commit('setHasBundId',true)
        
        Taro.showLoading({ title: '正在创建...'})
        setTimeout(function () {
          Taro.hideLoading();
          Taro.atMessage({
            message: 'DeBund ID 创建成功',
            type: 'success'
          });
          setTimeout(()=>{
            Taro.navigateTo({
              url:'/pages/did_my/children/loginNextStep/index'
            });
          }, 500)
        }, 1000)
      }
    },
  },
}
</script>

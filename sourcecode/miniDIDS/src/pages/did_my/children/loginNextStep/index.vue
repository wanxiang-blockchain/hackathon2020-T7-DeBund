<template>
  <view class="index">
    <view class="loginTop">
      添加身份凭证 - 公民身份证
    </view>

    <view class="loginMain">
      <view class="item">
        <AtInput 
          name='value0' 
          type='text'
          placeholder='真实姓名' 
          :value="value0"
          :onChange="handleChange0" 
        />
      </view>
      <view class="item">
        <AtInput 
          name='value1' 
          type='text'
          placeholder='身份证' 
          :value="value1"
          :onChange="handleChange1" 
        />
      </view>
      <view class="item">
        <picker
          mode='selector'
          :range="selector"
          :value="selectorValue"
          @change="handleChange"
          @cancel="handleCancel"
        >
          <view style='display:flex;justify-content:space-between;'>
            <view style="display:flex;justify-content: flex-end;">
              <view>请选择KYC认证机构</view>
              <image :src="success" style="width:30rpx;height:30rpx;margin-left:10rpx;" v-if="isSuccess"></image>
            </view>
            <view style="color: #7e7e7e;">
              {{ selector[selectorValue] }}
            </view>
          </view>
        </picker>
      </view>
      <view class="item" v-if="isShowCamera">
        <camera device-position="front" flash="off" binderror="error"
          style="width: 400rpx; height: 400rpx; margin: 0 auto; border-radius:50%;"
          v-bind:class="{ success: isSuccess }"></camera>
      </view>
    </view>

    <view class="loginEnd">
      <AtMessage />
      <view @tap="this.handleClick" class="btn">下一步</view>
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
import success from '../../../../static/images/success.png';
import globalStore from '../../../../dataModel/globalDataStore'

export default {
  components: {
    AtInput, 
    AtMessage
  },
  data () {
    return {
      success,
      value0:'郑斌斌',
      value1: '652232199809080179',

      selector: ['商汤科技', 'CFCA', 'IdentityMind', 'PLAID'],
      selectorValue: 0,
      isShowCamera:false,
      isSuccess:false,
    }
  },
  methods: {
    handleChange0 (value) {
      this.value0 = value
    },
    handleChange1 (value) {
      this.value1 = value
    },
    handleChange (e) {
      this.selectorValue = e.detail.value;
      this.isShowCamera = true;
      setTimeout(()=>{
        this.isSuccess=true;
        Taro.atMessage({
          message: 'KYC验证成功',
          type: 'success'
        });
        setTimeout(()=>{
          this.isShowCamera = false;
        }, 500)
      },2500)
    },
    handleCancel(e) {
      console.log('handleCancel', e);
    },
    handleClick (type) {
      if(this.value0 == "" || this.value1 == "") {
        Taro.atMessage({
          message: '必填项为空',
          type: 'error'
        });
      } else {
        globalStore.commit('setCardNumber',this.value1)
        console.log("CardNumber: " + globalStore.state.cardNumber);
        Taro.atMessage({
          message: '公民身份证添加成功',
          type: 'success'
        });
        setTimeout(()=>{
          Taro.navigateTo({
            url:'/pages/did_my/children/loginEndStep/index'
          });
        }, 800)
      }
    },
  },
}
</script>

<template>
  <view class="index">
    <!-- <AtNoticebar marquee>
      欢迎使用 Taro UI Vue
    </AtNoticebar>
    <AtButton
      type="primary"
      :on-click="handleClick"
    >
      AtButton
    </AtButton>
    <AtToast :is-opened="show" :text="msg" :on-close="handleClose"></AtToast> -->
    
    <view class="loginTop">
      <image class="imgStyle" :src="myIdActive"></image>
      <view>请进行人脸识别登陆验证</view>
      <view>采集的信息将用于身份验证</view>
    </view>

    <view class="loginMain">
      <AtForm>
        <view class="item">
          <AtInput 
            name='name' 
            title='姓名' 
            type='text'
            placeholder='请输入姓名' 
            :value="name"
            :onChange="handleChange" 
          />
        </view>
        <view class="item">
          <AtInput 
            name='cardNumber' 
            title='身份证号码' 
            type='text'
            placeholder='请输入姓名' 
            :value="cardNumber"
            :onChange="handleChange" 
          />
        </view>

        <!-- 证件类型 -->
        <view class="item">
          <view class="cardType">
            <view class="cardTypeLine">
              <view class="line1">证件类型</view>
              <view class="line2" @tap="openAtActionSheet">
                <view>{{cardType}}</view>
                <view>选择</view>
              </view>
            </view>
            <AtActionSheet
              :isOpened="isOpened1"
              :on-close="handleClose"
            >
              <AtActionSheetItem
                  :on-click="clickBtn1"
              >
                身份证
              </AtActionSheetItem>
              <AtActionSheetItem
                  :on-click="clickBtn2"
              >
                护照
              </AtActionSheetItem>
            </AtActionSheet>
          </view>
        </view>

        <AtButton formType='submit' :onClick="onSubmit">提交</AtButton>
      </AtForm>
    </view>

    <view class="loginEnd">

    </view>

  </view>
</template>

<script>
// 按需引入, 更小的应用体积
import { AtButton, AtForm, AtInput, AtActionSheet, AtActionSheetItem } from 'taro-ui-vue'
import Taro from '@tarojs/taro'
import "taro-ui-vue/dist/style/components/form.scss";
import "taro-ui-vue/dist/style/components/button.scss"
import "taro-ui-vue/dist/style/components/action-sheet.scss";
// import "taro-ui-vue/dist/style/components/toast.scss"
// import "taro-ui-vue/dist/style/components/noticebar.scss"
import './index.less' 
import myIdActive from '../../../../static/images/myIdActive.png';
import globalStore from '../../../../dataModel/globalDataStore'

export default {
  components: {
    AtForm, 
    AtInput, 
    AtButton,
    AtActionSheet,
    AtActionSheetItem
    // AtToast,
    // AtNoticebar
  },
  data () {
    return {
      myIdActive,
      name:'',
      cardNumber:'',
      cardType:'身份证',
      isOpened1: false,
      // msg: 'Hello world!',
      // show: false
    }
  },
  onLoad(){
    console.log(globalStore.state.hasBundId)
  },
  methods: {
    handleChange (value = 'value') {
      this.name = value
    },
    onSubmit (event) {
      console.log(this.value)
    },
    handleClose() {
      this.isOpened1 = false
    },
    openAtActionSheet() {
      this.isOpened1 = true
    },
    showToast (name) {
      Taro.showToast({
        icon: 'none',
        title: name
      })
    },

    clickBtn1() {
      this.cardType = '身份证';
      this.handleClose();
    },
    clickBtn2() {
      this.cardType = '护照';
      this.handleClose();
    },
  },
}
</script>

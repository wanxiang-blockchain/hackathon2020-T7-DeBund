<template>
  <view class="index">
    <!-- 顶部布局 -->
    <view class="topBox">DID CARD</view>

    <!-- 卡片 -->
    <view class="cardList">
      <view class="cardItem">
        <view class="cardName">NFC</view>
      </view>
      <view class="cardItem">
        <view class="cardName">NFC</view>
      </view>
      <view class="cardItem">
        <view class="cardName">NFC</view>
      </view>
      <view class="cardLast"></view>
    </view>

    <!-- 信息 -->
    <view class="cardInfo">
      <view class="infoName">星汇大厦</view>
      <view class="infoText">邀约时间: 2020.10.10 12:00 - 12:30</view>
      <view class="infoText">邀约地点: 星汇大厦18楼 万向区块链</view>
      <view class="infoText">进入方式: NFC识别</view>
    </view>

    <!-- <view>
      <view class="cssAnimation">
        <view class="ooo" style="--col:16">
          <view class="title">总结</view>
          <view class="oo"> 
            <view 
              class="o" 
              v-for=" (item,oi) in Array(col*col)" 
              :key="oi"
              :o="shiftNumber(oi%col*(cgap-2*Math.floor(oi/col)/cgap+Math.floor(oi/col)),0,cgap,.15,1)"
              :style="{'--der':shiftNumber(oi%col-Math.floor(oi/col),-cgap,cgap,-1,1),
                      '--ndx':shiftNumber(oi/col,0,cgap,0,1),
                      '--size':shiftNumber((oi%col)*(cgap-2*Math.floor(oi/col))/cgap+Math.floor(oi/col),0,cgap,.15,1)    
              }"
            ></view>
          </view>
          <view class="footer">May 20 2019  郑斌斌</view>
        </view>
      </view>
    </view> -->

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
  </view>
</template>

<script>
// 按需引入, 更小的应用体积
import { AtButton, AtToast, AtNoticebar } from 'taro-ui-vue'
import "taro-ui-vue/dist/style/components/button.scss"
import "taro-ui-vue/dist/style/components/toast.scss"
import "taro-ui-vue/dist/style/components/noticebar.scss"
import './index.less' 
export default {
    components: {
    AtButton,
    AtToast,
    AtNoticebar
  },
  data () {
    return {
      // msg: 'Hello world!',
      // show: false,
      col:18,
      cgap:17,
    }
  },
  methods: {
    handleClick () {
      this.show = true
    },
    handleClose () {
      this.show = false
    },
    shiftNumber:(n,x0,y0,x1,y1,accuracy = 3)=>{
      return +(x1 + (n-x0)*(x1-y1)/(x0-y0)).toFixed(accuracy);
    }
  },
    }
</script>

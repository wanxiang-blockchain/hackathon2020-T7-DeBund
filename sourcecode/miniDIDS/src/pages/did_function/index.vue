<template>
  <view class="index">

    <view class="topBox">
      <view class="searchBox">
        <image class="searchImg" :src="search"></image>
      </view>
      <view class="btnLine">
        <view class="imgBox">
          <image class="imgBtn" :src="door"></image>
          <view>登记</view>
        </view>
        <view class="imgBox" @tap="goToList('company')">
          <image class="imgBtn" :src="booking"></image>
          <view>预约</view>
        </view>
        <view class="imgBox">
          <image class="imgBtn" :src="code"></image>
          <view>身份码</view>
        </view>
        <view class="imgBox">
          <image class="imgBtn" :src="vr"></image>
          <view>看房</view>
        </view>
        <view class="imgBox">
          <image class="imgBtn" :src="write"></image>
          <view>签约</view>   
        </view>
      </view>
    </view>

    <view class="mainBox">
      <view class="title">功能分类</view>
      <view class="menuButton">
        <view class="button">智能楼宇</view>
        <view class="button">在线签约</view>
      </view>
      <view class="cardList" @tap="goToList('wework')">
        <view class="cardItem">
          <view class="cardName">共享办公</view>
        </view>
        <view class="cardItem">
          <view class="cardName">车位预定</view>
        </view>
        <view class="cardItem">
          <view class="cardName">门禁系统</view>
        </view>
        <view class="cardLast"></view>
      </view>
    </view>

    <view class="tripBox">
      <view class="title">最近行程</view>
      <view class="tripList">
        <view class="tripItem" v-for="(item,id) in infoList" :key="id">
          <view class="infoTime">
            <view class="time1">{{item.time1}}</view>
            <view class="time2">{{item.time2}}</view>
            <view class="time">邀约时间</view>
          </view>
          <view class="infoPlace">
            <view class="place1">{{item.place1}}</view>
            <view class="place2">{{item.place2}}</view>
            <view class="place">邀约地点</view>
          </view>
        </view>
      </view>
    </view>

  </view>
</template>

<script>

import {  } from 'taro-ui-vue'
import './index.less' 
import Taro from '@tarojs/taro'
import scan from '../../static/images/scan.png';
import code from '../../static/images/code.png';
import nfc from '../../static/images/nfc.png';
import card from '../../static/images/card.png';
import ksm from '../../static/images/ksm.png';
import search from '../../static/images/search.png';
import door from '../../static/images/door.png';
import booking from '../../static/images/booking.png';
import vr from '../../static/images/vr.png';
import write from '../../static/images/write.png';

export default {
  components: {
    
  },
  data () {
    return {
      scan, code, nfc, card, ksm, search, door, booking, vr, write ,
      infoList:[
        {
          place1:'黑客马拉松',
          place2:'虹口金融大厦 19楼',
          time1:'15:00-19:00',
          time2:'2020-10-25',
        },
        {
          place1:'黑客马拉松',
          place2:'虹口金融大厦 19楼',
          time1:'15:00-19:00',
          time2:'2020-10-25',
        },
        {
          place1:'黑客马拉松',
          place2:'虹口金融大厦 19楼',
          time1:'15:00-19:00',
          time2:'2020-10-25',
        },
      ]
    }
  },
  methods: {
    onChange(stateName, value) {
      this[stateName] = value
    },
    onActionClick() {
      console.log('点击了搜索按钮')
    },
    goToList(type){
      Taro.navigateTo({
        url: `/pages/did_function/children/list/index?type=${type}`
      })
    }
  },
}
</script>

<template>
  <view class="index">
    <view class="topBox">
      <image class="imgStyle" :src="shanghai"></image>
      <view class="btnLine">
        <view class="imgBox">
          <image class="imgBtn" :src="scan"></image>
          <view>扫一扫</view>
        </view>
        <view class="imgBox">
          <image class="imgBtn" :src="code"></image>
          <view>身份码</view>
        </view>
        <view class="imgBox">
          <image class="imgBtn" :src="nfc"></image>
          <view>NFC</view>
        </view>
        <view class="imgBox">
          <image class="imgBtn" :src="card"></image>
          <view>证件</view>
        </view>
      </view>
      <view class="topText">北外滩欢迎您！</view>
    </view>

    <view class="swiperBox">
      <view class="introTitle">城市风采</view>
      <swiper
        class='test-h'
        indicatorColor='#999'
        indicatorActiveColor='#333'
        current="current"
        :duration="500"
        :interval="5000"
        :circular="true"
        :autoplay="true"
        :indicatorDots="false"
        style="height:450rpx">
        <swiper-item v-for="(item, idx) in imgUrls" :key="idx" style="width:690rpx; height:450rpx">
          <image :src="item" class="slide-image" style="width:690rpx; height:450rpx"/>
        </swiper-item>
      </swiper>
    </view>

    <view class="introBlock">
      <view class="introTitle">使用场景</view>
      <view class="introList">
        <view class="introItem" v-for="(item, id) in introList" v-bind:key="id">
          <view>
            <image class="img" :src="item.iconUrl"></image>
            <view class="name">{{item.name}}</view>
            <view class="description">{{item.description}}</view>
          </view>
        </view>
      </view>
    </view>


    <!-- <AtSearchBar
      style="background: transparent;"
      :value="value1"
      :onChange="onChange.bind(this, 'value1')"
      :onActionClick="onActionClick"
    /> -->
  </view>
</template>

<script>

import './index.less' 
import shanghai from '../../static/images/shanghai.jpg';
import scan from '../../static/images/scan.png';
import code from '../../static/images/code.png';
import nfc from '../../static/images/nfc.png';
import card from '../../static/images/card.png';
import ksm from '../../static/images/ksm.png';
import blog1 from '../../static/images/blog1.jpg';
import blog2 from '../../static/images/blog2.jpg';
import blog3 from '../../static/images/blog3.jpg';
import baiyulan from '../../static/images/baiyulan.png';
import qtum from '../../static/images/qtum.png';
import filecoin from '../../static/images/filecoin.png';

// import custom from '../../biz/custom'
// const { bizFuns, apiConfig, utils, imgUrl } = custom

export default {
  components: {
    
  },
  data () {
    return {
      shanghai, scan, code, nfc, card, ksm, blog1, blog2, blog3, baiyulan,qtum, filecoin,
      imgUrls: [baiyulan,blog1, blog2, blog3],
      introList:[
        {
          name: '商务拜访',
          description: '畅行无阻',
          iconUrl:ksm,
        },
         {
          name: '公司门卡',
          description: '畅行无阻',
          iconUrl:filecoin,
        },
         {
          name: '面试邀约',
          description: '畅行无阻',
          iconUrl:qtum,
        },
        {
          name: '快递外卖',
          description: '畅行无阻',
          iconUrl:filecoin,
        },
         {
          name: '地铁公交',
          description: '畅行无阻',
          iconUrl:ksm,
        },
         {
          name: '身份证明',
          description: '畅行无阻',
          iconUrl:qtum,
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
    }
  },
}
</script>

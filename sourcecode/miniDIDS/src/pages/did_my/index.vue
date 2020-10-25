<template>
  <view class="index">

    <!-- 顶部布局 --> 
    <view class="topBox">DEBUND DID</view>

    <!-- deBundId 已生成 -->
    <view class="avatarBlock" v-if="globalStore.state.hasBundId">
      <view class="avatar">
        <view class="avatarImg">
          <image class="imgStyle" :src="avatar"></image>
        </view>
        <view class="avatarInfo" @tap="goToCreate">
          <view class="name">
            <text>{{globalStore.state.bundInfo.bundName}}</text>
            <view class="idBox" @tap="goToID">
              <view class="nameId">DeBund ID</view>
              <image class="arrowStyle" :src="arrowWrite"></image>
            </view>
          </view>
          <view>欢迎进入数字身份世界</view>
        </view>
      </view>
      <view class="line">
        <view class="text1">上海北外滩</view>
        <view class="outLine">
          <view class="innerLine"></view>
        </view>
        <view class="text2">信用分 2100</view>
      </view>
    </view>

    <!-- deBundId 未生成 -->
    <view class="avatarBlock" v-else>
      <view class="avatar">
        <view class="avatarImg">
          <image class="imgStyle" :src="avatar" v-if="globalStore.state.hasBundId"></image>
        </view>
        <view class="avatarInfo" @tap="goToCreate">
          <view class="name">
            <text>创建 DeBund ID</text>
          </view>
          <view>数字身份世界需要你的加入</view>
        </view>
      </view>
      <view class="line">
        <view class="text1">上海北外滩</view>
        <view class="outLine">
          <view class="innerLine" style="width:10px;"></view>
        </view>
        <view class="text2">信用分 0</view>
      </view>
    </view>

    <view class="introBlock">
      <view class="introTitle">个人中心</view>
      <view class="introList">
        <view class="introItem" v-for="(item, id) in introList" v-bind:key="id">
          <image class="img" :src="item.iconUrl"></image>
          <view class="name">{{item.name}}</view>
          <view class="description">{{item.description}}</view>
        </view>
      </view>
    </view>

    <view class="endText">DID数字身份，敬请期待</view>

  </view>
</template>

<script>
import avatar from '../../static/images/avatar.jpg';
import ksm from '../../static/images/ksm.png';
import histroy from '../../static/images/history.png';
import book from '../../static/images/book.png';
import myId from '../../static/images/myId.png';
import card from '../../static/images/card.png';
import build from '../../static/images/build.png';
import ticket from '../../static/images/ticket.png';
import set from '../../static/images/set.png';
import arrowWrite from '../../static/images/arrowWrite.png';

import Taro from '@tarojs/taro'
import globalStore from '../../dataModel/globalDataStore'

export default {
  name: 'Index',
  components: {
    
  },
  data(){
    return {
      avatar, ksm, histroy, book, myId, card, build, set, ticket,arrowWrite,
      globalStore,
      introList:[
        {
          name: 'Face ID',
          description: '人脸生物采集',
          iconUrl:myId,
        },
        {
          name: '证件管理',
          description: '身份证、驾驶证、行驶证',
          iconUrl:card,
        },
         {
          name: '楼宇绑定',
          description: '绑定楼宇ID',
          iconUrl:build,
        },
         {
          name: '会展门票',
          description: '电子门票绑定',
          iconUrl:ticket,
        },
         {
          name: '记录查询',
          description: '邀约、赴约',
          iconUrl:book,
        },
         {
          name: '设置中心',
          description: '设置中心',
          iconUrl:set,
        },
      ]
    }
  },
  onShow(){
    console.log("hasBundId: " +globalStore.state.hasBundId)
    console.log("bundId: " +globalStore.state.bundInfo.bundId)
    console.log("CardNumber: " + globalStore.state.cardNumber);
    console.log("CarInfo: " + globalStore.state.carInfo);
  },
  methods: {
    goToID(){
      if(globalStore.state.hasBundId) {
        Taro.navigateTo({
          url: `/pages/did_my/children/northBundId/index?name=${globalStore.state.bundInfo.bundName}&id=${globalStore.state.bundInfo.bundId}`,
        })
      }
    },
    goToCreate(){
      if(!globalStore.state.hasBundId) {
        Taro.navigateTo({
          url:'/pages/did_my/children/login/index',
        })
      }
    }
  }
}
</script>

<style lang="less">
  page {
    background-color: #e7ebed;
    // background: linear-gradient(135deg, rgb(100, 227, 223) 0%, rgb(100, 187, 232) 22%, rgb(100, 115, 229) 75%, rgb(116, 100, 232) 100%);
  }
  .index {
    font-family: "Avenir", Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    padding: 0 30px;
    margin-top: 30px;
  }
  .topBox {
    margin-top: 100px; 
    text-align: left;
    font-size: 50px;
    font-weight: bold;
    color: black;
  }
  .avatarBlock {
    // width: 100%;
    // height: 280px;
    // background: rgb(0, 0, 0);
    // border-radius: 20px;
    // padding: 45px 0;
    // margin-top: 20px;

    width: 690px;
    height: 360px;
    background: linear-gradient(148deg,#212120 10%, #303033 90%);
    border-radius: 16px;
    margin-top: 20px;

    .avatar {
      width: 630px;
      height: 100px;
      padding: 50px 30px;
      display: flex;
      justify-content: flex-start;
      align-items: flex-end;
      .avatarImg {
        width: 100px;
        height: 100px;
        border-radius: 50%;
        background: white;
        .imgStyle {
          width: 100px;
          height: 100px;
          border-radius: 50%;
        }
      }
      .avatarInfo {
        width: 500px;
        margin-left: 30px;
        overflow: hidden;
        color: white;
        font-size: 23px;
        text-align: left;
        .name {
          font-weight: bold;
          font-size: 28px;
          margin-bottom: 5px;
          display: flex;
          justify-content: space-between;
          align-content: center;
          .nameId {
            font-size: 20px;
            border:0.5px solid rgb(116, 115, 115);
            border-radius: 5px;
            display: inline-block;
            margin-left: 15px;
            padding: 5px;
          }
        }
        .idBox{
          display: flex;
          align-content: center;
          .arrowStyle {
            width: 30px;
            height: 30px;
            padding: 5px 0;
          }
        }
      }
    }

    .line {
      width: 630px;
      margin: 0px 30px;
      .text1 {
        color: white;
        font-size: 25px;
        margin-bottom: 20px;
        text-align: right;
      }
      .text2 {
        color: white;
        font-size: 25px;
        margin-top: 20px;
      }
      .outLine {
        width: 630px;
        height: 10px;
        background: rgba(73,71,70,1);
        border-radius: 10px;
        .innerLine {
          width: 330px;
          height: 10px;
          background: linear-gradient(135deg, rgb(148, 151, 151) 0%, rgb(99, 99, 99) 25%,rgb(148, 151, 151) 50%, rgb(99, 99, 99) 75%, rgb(148, 151, 151) 100%);
          border-radius: 10px;
        }
      }
    }

    .fun {
      width: 570px;
      height: 140px;
      margin: 60px 60px 0 60px;
      display: flex;
      justify-content: space-around;
      .funImg {
        width: 150px;
        height: 140px;
        text-align: center;
        .img {
          width: 64px;
          height: 64px;
        }
        .funText {
          width: 150px;
          margin-top: 10px;
          color: white;
          font-size: 26px;
          font-weight: bold;
        }
      }
      .line {
        width:3px;
        height: 20px;
        background: gray;
        margin-top: 20px;
      }
    }
  }

  .introBlock {
    width: 100%;
    padding-top: 50px;
    .introTitle {
      margin: 20px;
      margin-left: 0;
      color: black;
      font-size: 30px;
      font-weight: bold;
      text-align: left;
    }
    .introList {
      width: 690px;
      padding: 30px 0;
      display: flex;
      flex-wrap:wrap;
      justify-content: space-between;
      .introItem {
        width: 336px;
        height: 168px;
        margin-bottom: 30px;
        // border: 1px solid red;
        border-radius: 10px;
        position: relative;;
        background: linear-gradient(135deg, rgb(148, 151, 151) 0%, rgb(99, 99, 99) 25%,rgb(148, 151, 151) 50%, rgb(99, 99, 99) 75%, rgb(148, 151, 151) 100%);
        .img {
          width: 80px;
          height: 80px;
          position: absolute;
          top: 16px;
          right: 20px;
        }
        .name {
          color: white;
          font-weight: bold;
          font-size: 32px;
          position: absolute;
          top: 50px;
          left: 30px;
        }
        .description {
          color: white;
          font-size: 24px;
          position: absolute;
          top: 110px;
          left: 30px;
        }
      }
    }
  }

  .endText {
    font-size: 24px;
    color: rgba(192,194,204,1);
  }
</style>

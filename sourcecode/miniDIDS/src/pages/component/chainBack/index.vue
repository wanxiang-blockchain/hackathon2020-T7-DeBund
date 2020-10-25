<template>
  <view class="containBox">
    <view class="wapper">
      <view class="inner">
        <view class="header">DeBund  存储内容</view>
        <view class="line" v-for="(item,id) in list" :key="id">
          <view class="key">{{item.key}}</view>
          <view class="value">{{item.value}}</view>
        </view>
        <view class="bottom">IPFS存储，全链路可信，全节点见证</view>
      </view>
    </view>
  </view>
</template>

<script>
import './index.less' 
import Taro, { navigateBack } from '@tarojs/taro'

export default {
  components: {
    
  },
  data () {
    return {
      list:[
        {
          key:'Debund Id',
          value:'xxxxxxxxxxxxxxxxxxxx'
        },
        {
          key:'Debund Id',
          value:'xxxxxxxxxxxxxxxxxxxx'
        },{
          key:'Debund Id',
          value:'xxxxxxxxxxxxxxxxxxxx'
        },{
          key:'Debund Id',
          value:'xxxxxxxxxxxxxxxxxxxx'
        },{
          key:'Debund Id',
          value:'xxxxxxxxxxxxxxxxxxxx'
        },
      ]
    }
  },
  onLoad(options){
    
  },
  onShow() {
    
  },
  methods: {
    
  },
}
</script>

<template>
  <view class="index">
    <view class="detailBox">
      <view class="avatar">
        <image :src="avatar" class="img"></image>
      </view>
      <view class="bundText">
        <view class="name">{{name}}</view>
        <view class="idText">{{id}}</view>
      </view>
    </view>
  </view>
</template>

<script>
import './index.less'
import Taro from '@tarojs/taro'
import avatar from '../../../../static/images/avatar.jpg';

export default {
  components: {
    
  },
  data () {
    return {
      avatar,
      name:'',
      id:''
    }
  },
  onLoad(options) {
    this.name = options.name;
    this.id = options.id;
  },
  methods: {
    
  },
}
</script>

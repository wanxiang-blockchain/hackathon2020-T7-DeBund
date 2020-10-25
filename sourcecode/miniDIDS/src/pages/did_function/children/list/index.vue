<template>
  <view class="index">

    <view class="companyList" v-if="type === 'company'">
      <view class="companyItem" v-for="(item,id) in list1" :key="id" @tap="goToBooking(item.name,item.place)">
        <view class="avatar">
          <image :src="item.img" class="img"></image>
        </view>
        <view class="bundText">
          <view class="name">{{item.name}}</view>
          <view class="place">{{item.place}}</view>
          <view class="toBooking">
            <view class="text1">去预约</view>
            <image :src="arrowBlack" class="arrowStyle"></image>
          </view>
        </view>
      </view>
    </view>

    <view class="companyList" v-else>
      <view class="companyItem" v-for="(item,id) in list2" :key="id" @tap="goToBooking(item.name, item.place, item.price)">
        <view class="avatar">
          <image :src="item.img" class="img"></image>
        </view>
        <view class="bundText">
          <view class="name">{{item.name}}</view>
          <view class="place">{{item.place}}</view>
          <view class="toBooking">
            <view class="text1">去租赁</view>
            <image :src="arrowBlack" class="arrowStyle"></image>
          </view>
          <view class="price">{{item.price}}</view>
        </view>
      </view>
    </view>
  </view>
</template>

<script>
import './index.less'
import Taro from '@tarojs/taro'
import baiyulan from '../../../../static/images/baiyulan.png';
import arrowBlack from '../../../../static/images/arrowBlack.png';
import blog3 from '../../../../static/images/blog3.jpg';
import baiyulan1 from '../../../../static/images/baiyulan1.png';
import baiyulan2 from '../../../../static/images/baiyulan2.png';
import baiyulan3 from '../../../../static/images/baiyulan3.png';

export default {
  components: {
    
  },
  data () {
    return {
      type:'',
      baiyulan, arrowBlack, blog3, baiyulan1, baiyulan2, baiyulan3,
      list1:[
        {
          img:baiyulan2,
          name:'中信集团',
          place:'上海市虹口区四川北路859号 19楼'
        },
        {
          img:baiyulan,
          name:'万向集团',
          place:'上海浦东新区陆家嘴西路99号 1楼'
        },
        {
          img:baiyulan3,
          name:'中国人民银行(上海总部)',
          place:'上海市浦东新区陆家嘴东路181号中国人民银行大厦 10楼'
        },
        {
          img:baiyulan1,
          name:'中国银行',
          place:'上海市浦东新区陆家嘴东路181号中国人民银行大厦'
        },
        {
          img:baiyulan,
          name:'中国农业银行',
          place:'上海虹口区天潼路328号中信大厦16楼'
        },
        {
          img:baiyulan,
          name:'建设银行',
          place:'上海虹口区天潼路328号中信大厦'
        },
      ],

      list2:[
        {
          img:blog3,
          name:'星荟中心',
          price:'¥20/小时',
          place:'上海市虹口区四川北路859号 3-4层'
        },
        {
          img:baiyulan3,
          name:'盛邦国际大厦',
          price:'¥20/小时',
          place:'上海市虹口区四川北路859号 2层'
        },
        {
          img:baiyulan1,
          name:'世界贸易大厦',
          price:'¥20/小时',
          place:'上海市虹口区四川北路859号 3-4层'
        },
        {
          img:baiyulan2,
          name:'星荟中心',
          price:'¥20/小时',
          place:'上海市虹口区四川北路859号 3-4层'
        },
        {
          img:blog3,
          name:'星荟中心',
          price:'¥20/小时',
          place:'上海市虹口区四川北路859号 3-4层'
        },
        {
          img:blog3,
          name:'星荟中心',
          price:'¥20/小时',
          place:'上海市虹口区四川北路859号 3-4层'
        },
      ]
    }
  },
  onLoad(options){
    this.type = options.type;
    Taro.setNavigationBarTitle({
      title: this.type === 'company' ? '公司列表' : '共享办公'
    })
  },
  methods: {
    goToBooking(name, place) {
      Taro.navigateTo({
        url:`/pages/did_function/children/booking/index?name=${name}&place=${place}&type=${this.type}`
      })
    }
  },
}
</script>

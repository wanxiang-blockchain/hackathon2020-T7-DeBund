<template>
  <view class="index">
    <view class="loginTop">
      {{type ==='company' 
         ? '创建预约单 - 楼宇进入'
         : '创建租赁单 - 共享办公'
      }}
    </view>

    <view class="loginMain" v-if="type ==='company'">
        <view class="item">
          <AtInput 
           :editable="false"
            name='value1' 
            title='公司名称'
            type='text'
            placeholder='填写公司名称' 
            :value="value1"
            :onChange="handleChange1" 
          />
        </view>
        <view class="item">
          <AtInput 
            :editable="false"
            name='value2' 
            title='公司地点'
            type='text'
            placeholder='填写公司地点' 
            :value="value2"
            :onChange="handleChange2" 
          />
        </view>
        <view class="item">
          <AtInput 
            name='value3' 
            title='预约时间'
            type='text'
            placeholder='填写预约时间' 
            :value="value3"
            :onChange="handleChange3" 
          />
        </view>
        <view class="item">
          <AtInput 
            name='value4' 
            title='DeBund ID'
            type='text'
            placeholder='身份ID' 
            :value="value4"
            :onChange="handleChange4" 
          />
        </view>
    </view>

    <view class="loginMain" v-else>
        <view class="item">
          <AtInput 
           :editable="false"
            name='value1' 
            title='办公地名称'
            type='text'
            placeholder='填写办公地名称' 
            :value="value1"
            :onChange="handleChange1" 
          />
        </view>
        <view class="item">
          <AtInput 
            :editable="false"
            name='value2' 
            title='办公地点'
            type='text'
            placeholder='填写办公地点' 
            :value="value2"
            :onChange="handleChange2" 
          />
        </view>
        <view class="item">
          <AtInput 
            name='value3' 
            title='租约时间'
            type='text'
            placeholder='填写租约时间' 
            :value="value3"
            :onChange="handleChange3" 
          />
        </view>
        <view class="item">
          <AtInput 
            name='value4' 
            title='DeBund ID'
            type='text'
            placeholder='身份ID' 
            :value="value4"
            :onChange="handleChange4" 
          />
        </view>
      </view>
      <view class="loginEnd">
        <AtMessage />
        <view @tap="this.handleClick" class="btn">马上申请</view>
        <view class="text">
          <view>身份数据自动填写入申请审批单</view>
        </view>
      </view>

  </view>
  <!-- <AtModal
    isOpened
    title='身份数据授权'
    cancelText='取消'
    confirmText='确认'
    :onClose="handleClose"
    :onCancel="handleCancel"
    :onConfirm="handleConfirm"
    content='身份数据授权自动填写入预约单'
  /> -->
</template>

<script>
// 按需引入, 更小的应用体积
import './index.less' 
import Taro, { navigateBack } from '@tarojs/taro'
import { AtInput, AtMessage, AtModal, AtModalHeader, AtModalContent, AtModalAction} from 'taro-ui-vue'
import "taro-ui-vue/dist/style/components/form.scss";
import "taro-ui-vue/dist/style/components/message.scss";
import "taro-ui-vue/dist/style/components/modal.scss";
import globalStore from '../../../../dataModel/globalDataStore'

export default {
  components: {
    AtInput, 
    AtMessage,
    AtModal,
  },
  data () {
    return {
      // isOpened:false,
      value1: '中信大厦',
      value2: '上海虹口区天潼路328号中信大厦 18楼',
      value3: '2020-10-26 15:00-19:00',
      value4:  globalStore.state.bundInfo.bundId,
      type:''
    }
  },
  onLoad(options){
    this.value1 = options.name;
    this.value2 = options.place;
    this.type = options.type;
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
    handleChange4 (value) {
      this.value4 = value
    },

    // handleClose () {
    //   this.isOpened = false;
    //   Taro.navigateBack();
    // },
    // handleCancel () {
    //   this.isOpened = false;
    //   Taro.navigateBack();
    // },
    // handleConfirm () {
    //   this.isOpened = false;
    //   this.bundId = globalStore.state.bundInfo.bundId;
    // },

    handleClick () {
      if (this.value1 == "" || this.value2 == "" || this.value3 == "" || this.value4 == "") {
        Taro.atMessage({
          message: '必填项为空',
          type: 'error'
        });
      } else {
        Taro.atMessage({
          message: this.type === 'company' ? '预约单发送成功':'租赁单发送成功',
          type: 'success'
        });
        setTimeout(()=>{
          Taro.navigateTo({
            url:`/pages/did_function/children/stepCode/index?value1=${this.value1}&value2=${this.value2}&value3=${this.value3}&type=${this.type}`
          });
        }, 600)
      }
    },
  },
}
</script>

import apiConfig from './apiConfig.js';
import codeConfig from './codeConfig.js';

//请求参数格式 返回prosmiset
let params = {
    method: 'POST',
    data: {},
    url: ''
}

// 封装ajax
function ajax(params,errorMsg){
    return new Promise((resolve,reject) => {
        let data = params.data || {};
        let url = params.url;
        let header = {
            'Content-type': 'application/json',
            'x-token': wx.getStorageSync('x-token'),
        };
        //login header里不需要 x-token这个key
        if (params.url.indexOf('login') > -1) {
            delete header['x-token'];
        }
        //获取当前页面路径地址
        let pages = getCurrentPages();
        let currentPage = pages[pages.length-1].route;
        data['user_uuid'] = wx.getStorageSync('userInfo').uuid;
        //正式请求
        wx.request({
            url: url,
            data: data,
            method: params.method ? params.method : 'POST',
            header,
            success: (res) => {
                console.log("请求成功");
                console.log(res);
                let msgCode = res.data.msgCode;
                if(res && res.header['x-token'] && params.url.indexOf('login') > -1) {
                    wx.setStorageSync("x-token", res.header['x-token'])
                }

                if(res.statusCode !== 200) {
                    wx.showToast({
                        title: '网络异常，请保证您的网络通常后重试。',
                        icon: 'none'
                    });
                    reject();
                }else if(msgCode % 1000 != 0) {
                    if(msgCode == 17020 || msgCode == 17040){
                        if(currentPage !== 'pages/home/main' && currentPage !== 'pages/home/stackPages/docList/main'){
                            wx.showToast({
                                title: '登录状态过期',
                                icon:'none',
                                duration:1000
                            });
                            goToLoginPage(); 
                        }
                        globalStore.commit('setIsLogin',false);
                    }else if(msgCode == 17010){
                        wx.showToast({
                            title: commonErrorDesc(url) || res.data.msg || '接口请求报错17010！',
                            icon:'none'
                        });
                    }else{
                        let returnDesc;
                        switch(msgCode) {
                            case 20123:
                            case 20115:
                                returnDesc = errorMsg;
                                break;
                            default:
                                let localDesc = codeConfig.codeNumber[msgCode];
                                returnDesc = localDesc ? localDesc : res.data.msg;
                                break;
                        }
                        
                        wx.showToast({
                            title: returnDesc || '接口请求失败！',
                            icon:'none'
                        });
                    }
                    reject();
                }else{  //登录接口成功，储存authorizeUuid
                    res.data['success'] = true;
                    resolve(res.data);
                }
            },
            fail: (error)=> {
                wx.showToast({
                    title: '网络异常，请保证您的网络通常后重试。' + error,
                    icon:'none'
                });
                reject(error);
            },
            complete: ()=> {
                console.log("请求完成");
            }
        });
    })
}

// 文件上传
function upload(url, filePath, data, name='file') {
    return new Promise((resolve, reject) => {
        let header = {
            'Content-type': 'application/json',
            'x-token': wx.getStorageSync('x-token')
        };
        wx.uploadFile({
            url: url,
            filePath: filePath,
            name: name,
            header,
            formData: data,
            success: (res) => {
                if(res.statusCode === 404 || res.statusCode === 500) {
                    wx.showToast({
                        title: '状态码404/500',
                        icon: 'none'
                    });
                    reject();
                } else {
                    let data = null;
                    try {
                        data = JSON.parse(res.data);
                    } catch (error) {
                        console.log(error);
                        wx.showToast({
                            title: "JSON 数据解析出错",
                            icon: 'none'
                        });
                        reject(error);
                        return;
                    }

                    if(data.msgCode % 1000 != 0) {
                        if(data.msgCode === 40101) {
                            goToLoginPage();
                        } else {
                            let returnDesc = data.msg;
                            wx.showToast({
                                title: returnDesc,
                                icon: 'none'
                            });
                        }
                        reject();
                    } else {
                        // res.data['success'] = true;
                        resolve(data);
                    }
                }
            },
            fail: (error) => {
                wx.showToast({
                    title: '网络异常，请保证您的网络通常后重试。' + error,
                    icon:'none'
                });
                reject(error);
            }
        })
    });
}

function commonErrorDesc(url) {
    if(!url) return "";
    if(url.endsWith("/sendVerificationCode"))
        return "验证码发送失败！"

    return "";
}

//去登录页面
function goToLoginPage() {
    wx.redirectTo({
        url:'/pages/login/main'
    })
}

//去应急页
function goToNoFoundPage(){
    wx.navigateTo({
        url:"/pages/login/stackPages/noFound/main"
    })
}

function wxLogin() {
    // 调用登录接口
    return new Promise((resolve, reject) => {
        wx.login({
            success: (loginRes) => {
                resolve(loginRes);
            }
        })
    });
}

//返回字符串
function calculatePrice(price, type) {
    let priceNumber = Number(price);
    if (type === 'showPrice') {
        priceNumber = priceNumber ? priceNumber / 100 : 0;
        //保留2位小数的字符串
        return priceNumber.toFixed(2);
    } else if (type === 'submitPrice') {
        priceNumber = priceNumber ? priceNumber * 100 : 0;
        //扩大100的整数
        return Math.round(priceNumber);
    }
}

//返回保留2位小数的Number类型
function showPrice(price) {
    return calculatePrice(price, 'showPrice');
}

//返回保留2位小数的Number类型
function submitPrice(price) {
    return calculatePrice(price, 'submitPrice');
}

//小程序API promise化
function wxPromisify(functionName, params) {
    return new Promise((resolve, reject) => {
      wx[functionName]({
        ...params,
        success: res => resolve(res),
        fail: res => reject(res)
      });
    });
}
function getSystemInfo(params={}){  //获取系统信息
    return wxPromisify('getSystemInfo',params);
}
function downloadFile(params={}){   //下载文件
    return wxPromisify('downloadFile',params);
}
function openDocument(params={}){   //打开文件
    return wxPromisify('openDocument',params);
}

// Toast 便捷方法
function showToast(title, icon = 'none',duration = 1500) {
    wx.showToast({
        title: title,
        icon: icon,
        duration:duration,
    })
}

//收藏文章
function collectionUpdate(item){
    //globalStore.state.userInfo.uuid
    let data = {
      method:"POST",
      data:{
        user_uuid:wx.getStorageSync('userInfo').uuid,
        collection_uuid:item.uuid,
      },
      url:item.isCollected === false ? apiConfig.request.cancelCollections:apiConfig.request.collections
    };
    return this.ajax(data).then(res => {
      try{
        //item.isCollected = !item.isCollected;
        return Promise.resolve();
      }catch(err){
        console.log(err)
        return Promise.reject();
      }
    })
}

let biz = {
    ajax,
    upload,
    wxLogin,
    showPrice,
    submitPrice,
    getSystemInfo,
    downloadFile,
    openDocument,
    showToast,
    goToLoginPage,
    collectionUpdate,
}
export default biz;
exports.module = biz;

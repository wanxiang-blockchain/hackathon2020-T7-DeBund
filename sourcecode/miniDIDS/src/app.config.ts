export default {
  pages: [
    'pages/did_home/index',

    'pages/did_function/index',
    'pages/did_function/children/list/index',
    'pages/did_function/children/booking/index',
    'pages/did_function/children/stepCode/index',
    'pages/did_function/children/stepNextCode/index',
    
    // 'pages/component/chainBack/index',

    'pages/did_my/index',
    'pages/did_my/children/northBundId/index',
    'pages/did_my/children/login/index',
    'pages/did_my/children/loginNextStep/index',
    'pages/did_my/children/loginEndStep/index',


  ],
  tabBar: {
    "color": "#999",
    "backgroundColor": "#ffffff",
    "selectedColor": "#333",
    "borderStyle": "black",
    "list": [
      {
        "text": "首页",
        "pagePath": 'pages/did_home/index',
        "iconPath": "static/images/sy.png",
        "selectedIconPath": "static/images/syActive.png"
      },
      {
        "text": "功能",
        "pagePath": 'pages/did_function/index',
        "iconPath": "static/images/tx.png",
        "selectedIconPath": "static/images/txActive.png"
      },
      {
        "text": "我的",
        "pagePath": 'pages/did_my/index',
        "iconPath": "static/images/my.png",
        "selectedIconPath": "static/images/myActive.png"
      }
    ]
  },
  window: {
    backgroundTextStyle: 'light',
    navigationBarBackgroundColor: '#e7ebed',
    navigationBarTitleText: 'WeChat',
    navigationBarTextStyle: 'black',
  }
}


//项目环境及api配置
let config = {
  forDevTest:false,
  env: "dev",      //  [dev,'integration','uat','simulation','production']
  apiUrlMap: {        // api 各个环境下的路径定义
    "dev": "",
  },
  imgPathMap: {       //Ngix 前端维护路径
    "dev": "",
  },
  imgDBPathMap: {     //文件服务器 运维维护路径（发布时许告知地址）
    "dev": "",
  }
};
//扩展属性
Object.assign(config, {
  apiPath: config.apiUrlMap[config.env],
  path: config.imgPathMap[config.env],
  dbPath: config.imgDBPathMap[config.env],
});

//api 地址列表
const apiPath = config.apiUrlMap[config.env];
config.request = {
  // sendCode: apiPath + "/api/pass/sendCode",                        //获取验证码
  // register: apiPath + "/api/register",                             //注册
  // login: apiPath + "/api/login",                                   //手机号登录
  // loginByVeriCode: apiPath + "/api/loginByVeriCode",               //验证码登录
  // getFavorites: apiPath + "/api/collections/getCollectionsByUseruuid",//收藏列表
  // logout: apiPath + "/api/logout",                                 //登出
  // categories: apiPath + "/api/categories",                         //分类列表
  // articles: apiPath + "/api/articles",                             //文章列表
  // collections : apiPath + "/api/collections",                      //收藏文件
  // cancelCollections : apiPath + "/api/collections/cancel",         //取消收藏文件
  // getArticleInfo: apiPath + "/api/articles/##uuid##",              //获取文章详情  
  // getProtocols: apiPath + "/api/protocols",                        //获取协议列表
};

export default config;

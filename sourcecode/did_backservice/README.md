**《distribute identity 服务概述》**

[TOC]


# 环境及代码框架

+ JDK 8
+ gradle 6.6.1
+ springboot 2.2.10


# 技术要点

+ 数据加解密
    - 保证数据隐私
+ 星际文件系统 IPFS (InterPlanetary File System)
    - 分布式文件存储
+ web3j
    - 与合约/链交互

# IPFS 使用说明

+ 从git上进行下载编译
~~~
git clone https://github.com/ipfs/go-ipfs.git
cd go-ipfs
make build (在linux上可能会出现二进制文件无法读取的情况，可以考虑在windows系统上使用编译好的tar包/zip包进行解压)
mv ipfs /user/local/bin
~~~

+ 初始化(后续已window命令示例)
~~~shell
./ipfs.exe init 
./ipfs.exe daemon 开启一个守护进程
~~~

+ 命令使用
~~~shell
./ipfs.exe add <path> -- 添加文件到IPFS
./ipfs.exe cat <ref>  -- 展示IPFS对象数据
./ipfs.exe get <ref> --下载IPFS对象
./ipfs.exe id --展示IPFS节点信息
./ipfs.exe swarm --管理P2P网络连接
./ipfs.exe version --展示当前节点版本号
~~~

+ 应用（此处以java客户端为例）
~~~java
public class IpfsDemo{
    
    public void IpfsDemo(){
        //创建实例
        IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");
        //添加文件到IPFS
        NamedStreamable.FileWrapper file = new NamedStreamable.FileWrapper(new File("hello.txt"));
        MerkleNode addResult = ipfs.add(file).get(0);
        //查询IPFS系统中的文件
        Multihash filePointer = Multihash.fromBase58("QmPZ9gcCEpqKTo6aq61g2nXGUhM4iCL3ewB6LDXZCtioEB");
        byte[] fileContents = ipfs.cat(filePointer);
    }   

}
~~~
*备注*：参考https://github.com/ipfs-shipyard/java-ipfs-http-client/tree/v1.3.3，ipfs-java依赖无法下载成功，故将源码导入到ipfs包下

# 接口清单

+ 用户注册
    - url ：/registry
    - 备注：所有数据均在客户端做加密处理，服务器调用授信机构进行认证
+ 证书注册
    - url ： /registryCertification
+ 用户登录
    - url：/login
+ 获取授信机构的公钥
    - url：/getCreditPubKey
    - 授信机构认证完成后，返回
+ 查询当前位置范围内的楼宇列表
    - url: /getRangeBuildingInfo/list
+ 查询指定楼宇的详情
    - url:/getBuildingInfo/detail
+ 发起预约
    - url :/createAppointment
+ 审核预约
    - url：/auditAppoint 
+ 预约列表
    - url:/getAppointmentInfo/list  
+ 停车位列表信息
    - url:/parkingInfo/list      
+ 保存门禁进出信息
    - url： /entrace/record
+ 通过ipfs上传签署合同的密文
    - url：/saveFile/ipfs     
+ 通过ipfs获取上传的文件
    - url：/getFile/ipfs
+ 签约合同，结果存入did bank
    - url ：/rentContract/sign
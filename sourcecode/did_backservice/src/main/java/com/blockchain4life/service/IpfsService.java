package com.blockchain4life.service;

import com.blockchain4life.bean.SaveFileToIpfsRequestInfo;
import com.blockchain4life.ipfs.api.IPFS;
import com.blockchain4life.ipfs.api.MerkleNode;
import com.blockchain4life.ipfs.api.NamedStreamable;
import com.blockchain4life.ipfs.multihash.Multihash;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;

/**
 * Description: 使用ipfs进行文件存储
 * User: chengran
 * Date: 2020-10-24
 */
@Service
@Slf4j
public class IpfsService {


    public String saveFileToIpfs(MultipartFile info) throws IOException {

        File file = getFileFromMultiPartFile(info);
        //调用本地节点进行文件存储
        IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");

        NamedStreamable.FileWrapper sendFile = new NamedStreamable.FileWrapper(file);
        MerkleNode addResult = ipfs.add(sendFile).get(0);
        return addResult.hash.toString();
    }

    public String getFileFromIpfs(String fileHash) throws IOException {
        IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");
        Multihash filePointer = Multihash.fromBase58(fileHash);
        byte[] fileContents = ipfs.cat(filePointer);
        return new String(fileContents);
    }


    public File getFileFromMultiPartFile(MultipartFile info) throws MalformedURLException {
        int n = 0;
        File f = null;
        // 创建文件
        f = new File(info.getOriginalFilename());
        try ( InputStream in  = info.getInputStream(); OutputStream os = new FileOutputStream(f)){
            // 得到文件流。以文件流的方式输出到新文件
            byte[] buffer = new byte[4096];
            while ((n = in.read(buffer,0,4096)) != -1){
                os.write(buffer,0,n);
            }
            // 读取文件第一行
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        // 操作完上的文件 需要删除在根目录下生成的文件
        return new File(f.toURI());
    }

}

package com.service;

import com.model.entity.FastDFSFile;
import com.model.vo.ResponseVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author qbanxiaoli
 * @description
 * @create 2018/10/19 9:54 PM
 */
public interface FastDFSFileService {

    /**
     * @param multipartFile 待上传文件
     * @return 请求响应
     * @author qbanxiaoli
     * @description 上传文件
     */
    ResponseVO<FastDFSFile> uploadImage(MultipartFile multipartFile);

    ResponseVO<FastDFSFile> uploadImageAndCrtThumbImage(MultipartFile multipartFile);

    ResponseVO<FastDFSFile> uploadFile(MultipartFile multipartFile);

    ResponseVO downloadFile(String fileUrl, HttpServletResponse response);

}

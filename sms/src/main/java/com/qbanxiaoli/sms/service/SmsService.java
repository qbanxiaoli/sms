package com.qbanxiaoli.sms.service;

import com.qbanxiaoli.common.model.vo.ResponseVO;
import com.qbanxiaoli.sms.model.dto.SmsFormDTO;
import com.qbanxiaoli.sms.model.vo.SendSmsResponseVO;

/**
 * @author Q版小李
 * @description
 * @create 2018/8/11 9:18
 */
public interface SmsService {

    /**
     * @param smsFormDTO 短信请求数据传输类
     * @return 请求响应
     * @author qbanxiaoli
     * @description 获取短信验证码
     */
    ResponseVO<SendSmsResponseVO> sendSms(SmsFormDTO smsFormDTO);

}

package com.qbanxiaoli.sms.model.dto;

import com.qbanxiaoli.common.validation.Phone;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author qbanxiaoli
 * @description
 * @create 2018/8/8 上午12:47
 */
@Data
@ApiModel("短信请求模型")
public class SmsFormDTO {

    @Phone
    @NotBlank(message = "{PHONE_NOT_NULL}")
    @ApiModelProperty(value = "手机号码", required = true)
    private String phone;

    @NotNull(message = "{BUSINESS_NOT_NULL}")
    @Range(min = 0, max = 2, message = "{BUSINESS_TYPE_BETWEEN}")
    @ApiModelProperty(value = "业务类型(0->注册，1->登陆，2->修改密码)", required = true)
    private Integer type;

    @NotBlank(message = "{PROJECT_NAME_NOT_NULL}")
    @ApiModelProperty(value = "项目名称", required = true)
    @Column(nullable = false, length = 30)
    private String projectName;

    @NotNull
    @ApiModelProperty(value = "发送者id", required = true)
    @Column(nullable = false)
    private Long userId;

}

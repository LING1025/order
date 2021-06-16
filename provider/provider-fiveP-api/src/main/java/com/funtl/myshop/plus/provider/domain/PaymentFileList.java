package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "客户汇款输入：附件列表")
public class PaymentFileList implements Serializable {
    @ApiModelProperty(value = "文件序号")
    private Long fileUploadAuto;

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "文件路径")
    private String path;

    @ApiModelProperty(value = "附件来源")
    private String typeName;

    @ApiModelProperty(value = "上传人员")
    private String cUsername;

    @ApiModelProperty(value = "上传时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date cdt;

    @ApiModelProperty(value = "授信单号")
    private Long docPostId;
}

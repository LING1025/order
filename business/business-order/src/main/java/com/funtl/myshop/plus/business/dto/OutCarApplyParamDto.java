package com.funtl.myshop.plus.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "用车申请：新增数据")
public class OutCarApplyParamDto implements Serializable {
    /**
     * 用车申请单号
     */
    @JsonIgnore
    private Long carApplicationAuto = 0L;

    @ApiModelProperty(value = "用车类别序号：1公务车 2主管用车")
    private Integer appType;

    @ApiModelProperty(value = "用车类别：1公务车 2主管用车")
    private String appTypeN;

//    @ApiModelProperty(value = "使用人部门序号")
//    private Long orgAuto;

    @ApiModelProperty(value = "使用人部门")
    private String orgName;

    @ApiModelProperty(value = "申请人序号")
    private Long appUser;

    @ApiModelProperty(value = "申请人")
    private String appUserN;

    @ApiModelProperty(value = "使用人序号")
    private Long userAuto;

    @ApiModelProperty(value = "使用人")
    private String username;

    /**
     * 申请时间
     */
    @JsonIgnore
    private Date cdt;

    @ApiModelProperty(value = "还车仓库序号")
    private Integer whType;

    @ApiModelProperty(value = "起始地")
    private String startAddr;

    @ApiModelProperty(value = "起始地纬度")
    private String startAddrLat;

    @ApiModelProperty(value = "起始地经度")
    private String startAddrLng;

    @ApiModelProperty(value = "目的地")
    private String endAddr;

    @ApiModelProperty(value = "目的地纬度")
    private String endAddrLat;

    @ApiModelProperty(value = "目的地经度")
    private String endAddrLng;

    @ApiModelProperty(value = "距离：公里")
    private Double distance;

    @ApiModelProperty(value = "使用时间：开始时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date planStartDT;

    @ApiModelProperty(value = "使用时间：结束时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date planEndDT;

    @ApiModelProperty(value = "是否假日用车：0否 1是")
    private Integer isHoliday;

    @ApiModelProperty(value = "用车时间:单位小时")
    private BigDecimal useCarTime;

    @ApiModelProperty(value = "牌照地区序号")
    private Integer areaType;

    @ApiModelProperty(value = "牌照地区")
    private String areaTypeN;

    @ApiModelProperty(value = "事由说明")
    private String licenceMemo;

    @ApiModelProperty(value = "支援驾驶: 0 否 1是")
    private Integer isDriver;

    /**
     * 状态
     * -1取消、0暂存、5驳回、10送件、20核准、30出车、40还车
     */
//    @ApiModelProperty(value = "状态:10送件")
//    private Integer status;

    @ApiModelProperty(value = "汽车序号")
    private Long carBaseAuto=0L;

    @ApiModelProperty(value = "排挡方式")
    private String bsTypeN;

    /*@ApiModelProperty(value = "车状态:1预定 2出车 3入车 4作废 5在库 6审核中 7驳回 8被申请")
    private Integer carStatus;

    @ApiModelProperty(value = "车牌号码")
    private String makNo;

    @ApiModelProperty(value = "燃油种类")
    private String oilName;

    @ApiModelProperty(value = "剩余电量")
    private BigDecimal residueDL;

    @ApiModelProperty(value = "续航里程")
    private BigDecimal mileage;

    @ApiModelProperty(value = "厂牌")
    private String brandName;

    @ApiModelProperty(value = "车型")
    private String clasenName;

    @ApiModelProperty(value = "车色")
    private String carColor;

    @ApiModelProperty(value = "排档")
    private String bsTypeN;

    @ApiModelProperty(value = "取车仓库")
    private String whTypeN1;

    @ApiModelProperty(value = "还车仓库")
    private String whTypeN2;*/

}

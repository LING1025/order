package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "用车审核：选取审核明细；用车申请、车辆领取、车辆归还：获取具体申请明细")
public class CheckOne implements Serializable {
    /**
     * 用车申请单号
     */
    @ApiModelProperty(value = "用车申请单号")
    private Long carApplicationAuto;

//    @ApiModelProperty(value = "用车类别序号：1公务车 2主管用车")
//    private Integer appType;

    @ApiModelProperty(value = "用车类别：1公务车 2主管用车")
    private String appTypeN;

//    @ApiModelProperty(value = "使用部门序号")
//    private Long orgAuto;

    @ApiModelProperty(value = "使用部门")
    private String orgName;

//    @ApiModelProperty(value = "申请人序号")
//    private Long appUser;

    @ApiModelProperty(value = "申请人")
    private String appUserN;

    @ApiModelProperty(value = "使用人序号")
    private Long userAuto;

    @ApiModelProperty(value = "使用人")
    private String username;

    /**
     * 申请时间
     */
//    @JsonIgnore
//    private Date cdt;

//    @ApiModelProperty(value = "还车仓库序号")
//    private Integer whType;

    @ApiModelProperty(value = "起始地")
    private String startAddr;

//    @ApiModelProperty(value = "起始地纬度")
//    private String startAddrLat;
//
//    @ApiModelProperty(value = "起始地经度")
//    private String startAddrLng;

    @ApiModelProperty(value = "目的地")
    private String endAddr;

//    @ApiModelProperty(value = "目的地纬度")
//    private String endAddrLat;
//
//    @ApiModelProperty(value = "目的地经度")
//    private String endAddrLng;

//    @ApiModelProperty(value = "距离：公里")
//    private Double distance;

    @ApiModelProperty(value = "使用时间：开始时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date planStartDT;

    @ApiModelProperty(value = "使用时间：结束时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date planEndDT;

//    @ApiModelProperty(value = "是否假日用车：0否 1是")
//    private Integer isHoliday;
//
//    @ApiModelProperty(value = "用车时间:单位小时")
//    private BigDecimal useCarTime;
//
//    @ApiModelProperty(value = "牌照地区序号")
//    private Integer areaType;

    @ApiModelProperty(value = "牌照地区")
    private String areaTypeN;

    @ApiModelProperty(value = "事由说明")
    private String licenceMemo;

    @ApiModelProperty(value = "汽车序号")
    private Long carBaseAuto;

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
    private String whTypeN2;

    @ApiModelProperty(value = "权限id")
    private Long roleId;

    @ApiModelProperty(value = "审核等级序号")
    private Integer appSeq;

    @ApiModelProperty(value = "是否发放钥匙 ：0否 1是")
    private Integer isGive;

    @ApiModelProperty(value = "是否领取钥匙 ：0否 1是")
    private Integer isGet;

    @ApiModelProperty(value = "钥匙是否归还：0否 1是")
    private Integer isBack;

    @ApiModelProperty(value = "仪表盘起始里程图片")
    private String startImg;

    @ApiModelProperty(value = "仪表盘归还里程图片")
    private String endImg;

    @ApiModelProperty(value = "车身照左侧")
    private String leftImg;

    @ApiModelProperty(value = "车身照右侧")
    private String rightImg;

    @ApiModelProperty(value = "车身照后部")
    private String behindImg;

    @ApiModelProperty(value = "起始里程拍照时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date time1;

    @ApiModelProperty(value = "归还里程拍照时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date time2;

    @ApiModelProperty(value = "车身左侧拍照时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date time3;

    @ApiModelProperty(value = "车身右侧拍照时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date time4;

    @ApiModelProperty(value = "车身后部拍照时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date time5;

    @ApiModelProperty(value = "起始里程拍照地址")
    private String address1;

    @ApiModelProperty(value = "归还里程拍照地址")
    private String address2;

    @ApiModelProperty(value = "车身左侧拍照地址")
    private String address3;

    @ApiModelProperty(value = "车身右侧拍照地址")
    private String address4;

    @ApiModelProperty(value = "车身后部拍照地址")
    private String address5;

    @ApiModelProperty(value = "途经地1")
    private String passAddr1;

    @ApiModelProperty(value = "途经地2")
    private String passAddr2;

    @ApiModelProperty(value = "途经地3")
    private String passAddr3;

    @ApiModelProperty(value = "途经地4")
    private String passAddr4;

    @ApiModelProperty(value = "途经地5")
    private String passAddr5;

    @ApiModelProperty(value = "随车人1")
    private String followName1;

    @ApiModelProperty(value = "随车人2")
    private String followName2;

    @ApiModelProperty(value = "随车人3")
    private String followName3;

    @ApiModelProperty(value = "随车人4")
    private String followName4;

}

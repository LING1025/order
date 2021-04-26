package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "用车申请：自动配车、用车审核：获取车辆列表")
public class OrgCarList implements Serializable {
    @ApiModelProperty(value = "汽车序号")
    private Long carBaseAuto;

    @ApiModelProperty(value = "车牌号码")
    private String makNo;

    /**
     * 车辆安装TBox后解除
     */

    @ApiModelProperty(value = "动力状态")
    private String carStatusN;

    @ApiModelProperty(value = "总里程KM")
    private Long totalDistance;

    @ApiModelProperty(value = "剩余电量 0 ~ 100%")
    private String residueDL;

    @ApiModelProperty(value = "续航里程KM")
    private Integer mileage;

    @ApiModelProperty(value = "发动机故障灯状态")
    private String tipStatus;

    @ApiModelProperty(value = "燃油种类")
    private String oilName;

    @ApiModelProperty(value = "排量")
    private Integer cc;

    @ApiModelProperty(value = "厂牌")
    private String brandName;

    @ApiModelProperty(value = "车型")
    private String clasenName;

    @ApiModelProperty(value = "车色")
    private String carColor;

    @ApiModelProperty(value = "排档")
    private String bsTypeN;

    @ApiModelProperty(value = "还车仓库序号")
    private Integer whType;

    @ApiModelProperty(value = "取车仓库")
    private String whTypeN1;

    @ApiModelProperty(value = "还车仓库")
    private String whTypeN2;
}

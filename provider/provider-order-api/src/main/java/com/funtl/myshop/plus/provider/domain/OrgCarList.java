package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "用车审核：更改车辆")
public class OrgCarList implements Serializable {
    @ApiModelProperty(value = "汽车序号")
    private Long carBaseAuto;

    @ApiModelProperty(value = "车牌号码")
    private String makNo;

    @ApiModelProperty(value = "燃油种类")
    private BigDecimal residueDL;

    @ApiModelProperty(value = "剩余电量")
    private BigDecimal mileage;

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

    @ApiModelProperty(value = "取车仓库")
    private String whTypeN1;

    @ApiModelProperty(value = "还车仓库")
    private String whTypeN2;
}

package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用车申请判断值,判断业务人员有没有申请拜访客户
 */
@Data
public class ApplyJudge implements Serializable {
    private Integer chiefId;

    private Integer isSalesDep;

    private Integer num;

    /**
     * 用车申请报错信息
     */
    private String errorN;
}

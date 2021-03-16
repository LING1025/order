package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用车请款人所属公司别
 */
@Data
public class RequestInc implements Serializable {
    /**
     * 用车请款人
     */
    private Long userAuto;

    /**
     * 用车请款人所属公司别
     */
    private Long IncAuto;

    /**
     * 使用部门
     */
    private Long useDep;
}

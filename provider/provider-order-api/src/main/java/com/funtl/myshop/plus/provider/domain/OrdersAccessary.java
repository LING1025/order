package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[OrdersAccessary]")
public class OrdersAccessary implements Serializable {
    /**
    * 配件序號
    */
    @Id
    @Column(name = "OrdersAccessary_Auto")
    private Long ordersAccessaryAuto;

    /**
    * 申購序號
    */
    @Column(name = "Orders_auto")
    private Long ordersAuto;

    /**
    * 項目
    */
    @Column(name = "ItemName")
    private String itemName;

    /**
    * 內容
    */
    @Column(name = "ItemMemo")
    private String itemMemo;

    /**
    * 金額
    */
    @Column(name = "Amt")
    private BigDecimal amt;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "CUser")
    private Integer cuser;

    @Column(name = "CDT")
    private Date cdt;

    @Column(name = "MUser")
    private Integer muser;

    @Column(name = "MDT")
    private Date mdt;

    /**
    * 施工位置
    */
    @Column(name = "Location")
    private String location;

    /**
    * 座位数
    */
    @Column(name = "Seat")
    private String seat;

    /**
    * 施工及价格变动说明
    */
    @Column(name = "Remark")
    private String remark;

    /**
    * 配件和厂商关联序号
    */
    @Column(name = "Accessories_TS_Auto")
    private Long accessoriesTsAuto;

    /**
    * 配件序号
    */
    @Column(name = "AccessoriesType_Auto")
    private Long accessoriesTypeAuto;

    /**
    * 厂商序号
    */
    @Column(name = "Supplier")
    private Long supplier;

    /**
    * 配件售价
    */
    @Column(name = "SellingAmt")
    private Integer sellingAmt;

    /**
    * 厂商进价
    */
    @Column(name = "PurchaseAmt")
    private Integer purchaseAmt;

    private static final long serialVersionUID = 1L;
}

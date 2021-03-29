package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[TradeItem]")
public class TradeItem implements Serializable {
    @Id
    @Column(name = "TradeItem_Auto")
    private Long tradeItemAuto;

    /**
    * 地區序號
    */
    @Column(name = "Area_Auto")
    private Long areaAuto;

    /**
    * 机构编号
    */
    @Column(name = "FID")
    private String fId;

    /**
    * 對象全称
    */
    @Column(name = "FName")
    private String fName;

    /**
    * 對象简称
    */
    @Column(name = "SName")
    private String sName;

    /**
    * 设立日期
    */
    @Column(name = "IncCDT")
    private Date incCDT;

    /**
    * 电话
    */
    @Column(name = "Tel")
    private String tel;

    /**
    * 传真
    */
    @Column(name = "Fax")
    private String fax;

    /**
    * 电子邮件
    */
    @Column(name = "Email")
    private String email;

    /**
    * 设立地址
    */
    @Column(name = "Addr")
    private String addr;

    /**
    * 郵遞區號
    */
    @Column(name = "ZipCode")
    private String zipCode;

    /**
    * 建立人
    */
    @Column(name = "CUser")
    private Integer cuser;

    /**
    * 建立時間
    */
    @Column(name = "CDT")
    private Date cdt;

    /**
    * 修改人
    */
    @Column(name = "Muser")
    private Integer muser;

    /**
    * 修改時間
    */
    @Column(name = "MDT")
    private Date mdt;

    @Column(name = "Ver")
    private Date ver;

    @Column(name = "Bank")
    private String bank;

    @Column(name = "Account")
    private String account;

    /**
    * 來源
    */
    @Column(name = "Source")
    private String source;

    /**
    * 省份
    */
    @Column(name = "AddrProvince")
    private Long addrProvince;

    /**
    * 市(縣)
    */
    @Column(name = "AddrCity")
    private Long addrCity;

    /**
    * 區
    */
    @Column(name = "AddrArea")
    private Long addrArea;

    @Column(name = "TaxID")
    private String taxId;

    @Column(name = "bankNo")
    private String bankNo;

    @Column(name = "CreditedName")
    private String creditedName;

    @Column(name = "CreditedTel")
    private String creditedTel;

    @Column(name = "OrgCode")
    private String orgCode;

    @Column(name = "MTEL")
    private String mTel;

    @Column(name = "IndustryCode")
    private String industryCode;

    @Column(name = "IsSendInv")
    private Integer isSendInv;

    @Column(name = "BankName")
    private Integer bankName;

    @Column(name = "CredentialNo")
    private String credentialNo;

    @Column(name = "ISCollection")
    private String isCollection;

    @Column(name = "RemakeType")
    private Integer remakeType;

    @Column(name = "IsEas")
    private Integer isEas;

    /**
    * 电访记录序号
    */
    @Column(name = "RecallRec_Auto")
    private Long recallRecAuto;

    @Column(name = "LastOrder_Auto")
    private Long lastOrderAuto;

    private static final long serialVersionUID = 1L;
}

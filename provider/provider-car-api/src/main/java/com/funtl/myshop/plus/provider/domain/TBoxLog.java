package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[TBoxLog]")
@RequiredArgsConstructor(staticName = "of")
@Accessors(chain = true)
public class TBoxLog implements Serializable {
    /**
    * 设备记录表Auto
    */
    @Id
    @Column(name = "TBoxLogAuto")
    private Long tBoxLogAuto;

    /**
    * 设备号
    */
    @Column(name = "deviceId")
    private String deviceId;

    /**
    * 记录AT指令
    */
    @Column(name = "logString")
    private String logString;

    /**
    * 车籍序号
    */
    @Column(name = "carBaseAuto")
    private Long carBaseAuto;

    /**
    * AT指令类型：01车辆实时定位
    */
    @Column(name = "type")
    private String type;

    /**
    * 创建时间
    */
    @Column(name = "createDateTime")
    private Date createDateTime;

    private static final long serialVersionUID = 1L;
}

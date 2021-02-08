package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.*;

import java.util.Date;
import java.util.List;

public interface CarApplicationService{

    /**
     * 获取用车申请：申请列表数据
     * @param useCarQueryParam
     * @return
     */
    List<UserCarList> selectUserCar(UseCarQueryParam useCarQueryParam);

    /**
     * 获取用车申请：签核明细数据
     * @param carApplicationAuto
     * @return
     */
    List<UseCarDoc> selectUseCarDoc(Long carApplicationAuto);

    /**
     * 根据车辆使用时间获取假日天数
     * @param startTime
     * @param endTime
     * @return
     */
    Holiday selectByTime(Date startTime,Date endTime);

    /**
     * 用车申请：送件
     * @param outCarApplyDto
     * @return
     */
    Integer applyInsert(OutCarApplyDto outCarApplyDto);

    /**
     * 用车审核：获取审核数据
     * @param checkQueryParam
     * @return
     */
    List<CheckList> selectCheckList(CheckQueryParam checkQueryParam);

    /**
     * 用车审核：选取审核明细
     * @param carApplicationAuto
     * @return
     */
    CheckOne selectCheckOne(Long carApplicationAuto);

    /**
     * 用车审核：核准、驳回
     * @param useCarCheckDto
     * @return
     */
    Integer useCarCheckInsert(UseCarCheckDto useCarCheckDto);

    /**
     * 查isSalesDep、ChiefId值
     * @param loginUserID
     * @return
     */
    ApplyJudge selectSC(Long loginUserID);

    /**
     * 判断业务人员有没有申请拜访客户
     * @param loginUserID,appDT
     * @return
     */
    ApplyJudge selectNum(Long loginUserID,Date appDT);

    /**
     * 判断查无签核流程设定!请联系系统管理员!
     * @param outCarApplyDto
     * @return
     */
    ApplyJudge selectErrorN(OutCarApplyDto outCarApplyDto);

    /**
     * 用车审核：更改车辆
     * @param carChangeDto
     * @return
     */
    Integer carChangeUpdate(CarChangeDto carChangeDto);

    /**
     * 车辆安排：获取申请列表
     * @param loginUserID
     * @return
     */
    List<CheckList> selectCarArrange(Long loginUserID);
}

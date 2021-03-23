package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.*;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.Date;
import java.util.List;

public interface CarApplicationMapper extends MyMapper<CarApplication> {
    List<UserCarList> selectUserCar(@Param("param") UseCarQueryParam useCarQueryParam);

    List<UseCarDoc> selectUseCarDoc(@Param("carApplicationAuto") Long carApplicationAuto);

    Holiday selectByTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    Integer applyInsert(@Param("param") OutCarApplyDto outCarApplyDto);

    List<CheckList> selectCheckList(@Param("param") CheckQueryParam checkQueryParam);

    CheckOne selectCheckOne(@Param("loginUserID") Long loginUserID,@Param("carApplicationAuto") Long carApplicationAuto);

    Integer useCarCheckInsert(@Param("param") UseCarCheckDto useCarCheckDto);

    ApplyJudge selectSC(@Param("loginUserID") Long loginUserID);

    ApplyJudge selectNum(@Param("loginUserID") Long loginUserID, @Param("appDT") Date appDT);

    ApplyJudge selectErrorN(@Param("param") OutCarApplyDto outCarApplyDto);

    Integer carChangeUpdate(@Param("param") CarChangeDto carChangeDto);

    List<CheckList> selectCarArrange(@Param("param") CheckQueryParam checkQueryParam);

    CheckOne selectArrangeOne(@Param("loginUserID") Long loginUserID, @Param("carApplicationAuto") Long carApplicationAuto);

    Integer giveKeyUpdate(@Param("param") GiveKeyDto giveKeyDto);

    Integer getKeyUpdate(@Param("param") GetKeyDto getKeyDto);

    Integer deleteByCarApplicationAuto(@Param("param") RepealApplyDto repealApplyDto);

    Integer giveBack(@Param("param") GiveBackKeyDto giveBackKeyDto);

    CheckOne selectApplyAndBack(@Param("loginUserID") Long loginUserID, @Param("carApplicationAuto") Long carApplicationAuto);
}

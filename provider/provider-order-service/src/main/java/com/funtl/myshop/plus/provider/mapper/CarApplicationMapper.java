package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.CheckQueryParam;
import com.funtl.myshop.plus.provider.dto.OutCarApplyDto;
import com.funtl.myshop.plus.provider.dto.UseCarCheckDto;
import com.funtl.myshop.plus.provider.dto.UseCarQueryParam;
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

    CheckOne selectCheckOne(@Param("carApplicationAuto") Long carApplicationAuto);

    Integer useCarCheckInsert(@Param("param") UseCarCheckDto useCarCheckDto);
}

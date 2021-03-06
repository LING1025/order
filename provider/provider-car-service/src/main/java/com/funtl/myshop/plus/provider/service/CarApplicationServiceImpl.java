package com.funtl.myshop.plus.provider.service;


import com.funtl.myshop.plus.provider.api.CarApplicationService;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.*;
import com.funtl.myshop.plus.provider.mapper.CarApplicationMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service(version = "1.0.0")
public class CarApplicationServiceImpl implements CarApplicationService {

    @Resource
    private CarApplicationMapper carApplicationMapper;


    @Override
    public List<UserCarList> selectUserCar(UseCarQueryParam useCarQueryParam) {
        return carApplicationMapper.selectUserCar(useCarQueryParam);
    }

    @Override
    public CheckOne selectApplyAndBack(Long loginUserID, Long carApplicationAuto) {
        return carApplicationMapper.selectApplyAndBack(loginUserID,carApplicationAuto);
    }

    @Override
    public List<UseCarDoc> selectUseCarDoc(Long carApplicationAuto) {
        return carApplicationMapper.selectUseCarDoc(carApplicationAuto);
    }

    @Override
    public Holiday selectByTime(Date startTime, Date endTime) {
        return carApplicationMapper.selectByTime(startTime,endTime);
    }

    @Override
    public Integer applyInsert(OutCarApplyDto outCarApplyDto) {
        return carApplicationMapper.applyInsert(outCarApplyDto);
    }

    @Override
    public List<CheckList> selectCheckList(CheckQueryParam checkQueryParam) {
        return carApplicationMapper.selectCheckList(checkQueryParam);
    }

    @Override
    public CheckOne selectCheckOne(Long loginUserID,Long carApplicationAuto) {
        return carApplicationMapper.selectCheckOne(loginUserID,carApplicationAuto);
    }

    @Override
    public Integer useCarCheckInsert(UseCarCheckDto useCarCheckDto) {
        return carApplicationMapper.useCarCheckInsert(useCarCheckDto);
    }

    @Override
    public ApplyJudge selectSC(Long loginUserID) {
        return carApplicationMapper.selectSC(loginUserID);
    }

    @Override
    public ApplyJudge selectNum(Long loginUserID,Date appDT) {
        return carApplicationMapper.selectNum(loginUserID,appDT);
    }

    @Override
    public ApplyJudge selectErrorN(OutCarApplyDto outCarApplyDto) {
        return carApplicationMapper.selectErrorN(outCarApplyDto);
    }

    @Override
    public Integer carChangeUpdate(CarChangeDto carChangeDto) {
        return carApplicationMapper.carChangeUpdate(carChangeDto);
    }

    @Override
    public List<CheckList> selectCarArrange(CheckQueryParam checkQueryParam) {
        return carApplicationMapper.selectCarArrange(checkQueryParam);
    }

    @Override
    public CheckOne selectArrangeOne(Long loginUserID, Long carApplicationAuto) {
        return carApplicationMapper.selectArrangeOne(loginUserID,carApplicationAuto);
    }

    @Override
    public Integer giveKeyUpdate(GiveKeyDto giveKeyDto) {
        return carApplicationMapper.giveKeyUpdate(giveKeyDto);
    }

    @Override
    public Integer getKeyUpdate(GetKeyDto getKeyDto) {
        return carApplicationMapper.getKeyUpdate(getKeyDto);
    }

    @Override
    public CarApplication selectByCarApplicationAuto(Long carApplicationAuto) {
        return carApplicationMapper.selectByPrimaryKey(carApplicationAuto);
    }

    @Override
    public Integer deleteByCarApplicationAuto(RepealApplyDto repealApplyDto) {
        return carApplicationMapper.deleteByCarApplicationAuto(repealApplyDto);
    }

    @Override
    public Integer giveBack(GiveBackKeyDto giveBackKeyDto) {
        return carApplicationMapper.giveBack(giveBackKeyDto);
    }

    @Override
    public Integer takePhoto(CarApplication carApplication) {
        return carApplicationMapper.updateByPrimaryKeySelective(carApplication);
    }

    @Override
    public Integer updateById(CarApplication carApplication) {
        return carApplicationMapper.updateByPrimaryKeySelective(carApplication);
    }


}

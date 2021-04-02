package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.ChooseCheckList;
import com.funtl.myshop.plus.provider.domain.OutBound;
import com.funtl.myshop.plus.provider.domain.OutInfo;
import com.funtl.myshop.plus.provider.mapper.OutBoundMapper;
import com.funtl.myshop.plus.provider.api.OutBoundService;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(version = "1.0.0")
public class OutBoundServiceImpl implements OutBoundService{

    @Resource
    private OutBoundMapper outBoundMapper;


    @Override
    public Long insert(OutBound outBound) {
        Integer i = outBoundMapper.insertUseGeneratedKeys(outBound);
        return i == 1 ? outBound.getOutBoundAuto():0;
    }

    @Override
    public List<ChooseCheckList> selectByUserAuto(Long userAuto) {
        return outBoundMapper.selectByUserAuto(userAuto);
    }

    @Override
    public Integer deleteByAuto(Long outBoundAuto) {
        return outBoundMapper.deleteByPrimaryKey(outBoundAuto);
    }

    @Override
    public OutBound selectTradeAuto(Long tradeItemAuto) {
        return outBoundMapper.selectTradeAuto(tradeItemAuto);
    }

    @Override
    public OutInfo selectOutInfo(Long loginAuto, Long tradeItemAuto,Long outBoundAuto) {
        return outBoundMapper.selectOutInfo(loginAuto,tradeItemAuto,outBoundAuto);
    }

    @Override
    public Integer update(OutBound outBound) {
        return outBoundMapper.updateByPrimaryKeySelective(outBound);
    }
}

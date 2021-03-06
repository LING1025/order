package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.commons.utils.PageInfoUtils;
import com.funtl.myshop.plus.provider.domain.AddressList;
import com.funtl.myshop.plus.provider.domain.CrmArrangeList;
import com.funtl.myshop.plus.provider.dto.CrmArrangeDto;
import com.funtl.myshop.plus.provider.dto.CrmArrangeQueryParam;
import com.funtl.myshop.plus.provider.mapper.VisitPlanMapper;
import com.funtl.myshop.plus.provider.domain.VisitPlan;
import com.funtl.myshop.plus.provider.api.VisitPlanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(version = "1.0.0")
public class VisitPlanServiceImpl implements VisitPlanService{

    @Resource
    private VisitPlanMapper visitPlanMapper;

    @Override
    public List<AddressList> selectByType(Integer type,Long code) {
        return visitPlanMapper.selectByType(type,code);
    }

    @Override
    public Long insert(VisitPlan visitPlan) {
        Integer i = visitPlanMapper.insertUseGeneratedKeys(visitPlan);
        return i == 1 ? visitPlan.getVisitId() : 0;
    }

    @Override
    public Integer update(VisitPlan visitPlan) {
        return visitPlanMapper.updateByPrimaryKeySelective(visitPlan);
    }

    @Override
    public VisitPlan selectMaxVisitAuto() {
        PageHelper.startPage(1,1);
        Example example = new Example(VisitPlan.class);
        example.orderBy("visitAuto").desc();
        return visitPlanMapper.selectOneByExample(example);
    }

    @Override
    public List<CrmArrangeList> selectCrmArrangeDto(CrmArrangeQueryParam crmArrangeQueryParam) {
        return visitPlanMapper.selectCrmArrangeDto(crmArrangeQueryParam);
    }

    @Override
    public VisitPlan selectByVisitIdAndAuto(Long visitId,Integer visitAuto) {
        Example example = new Example(VisitPlan.class);
        example.createCriteria().andEqualTo("visitId",visitId).andEqualTo("visitAuto",visitAuto);
        return visitPlanMapper.selectOneByExample(example);
    }

    @Override
    public VisitPlan selectByVisitId(Long visitId) {
        Example example = new Example(VisitPlan.class);
        example.createCriteria().andEqualTo("visitId",visitId).andNotEqualTo("status",-1);
        return visitPlanMapper.selectOneByExample(example);
    }
}

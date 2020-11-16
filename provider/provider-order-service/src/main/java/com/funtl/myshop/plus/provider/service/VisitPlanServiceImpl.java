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
    public Integer insert(VisitPlan visitPlan) {
        return visitPlanMapper.insertSelective(visitPlan);
    }

    @Override
    public VisitPlan selectMaxVisitAuto() {
        PageHelper.startPage(1,1);
        Example example = new Example(VisitPlan.class);
        example.orderBy("visitAuto").desc();
        return visitPlanMapper.selectOneByExample(example);
    }

    @Override
    public PageInfo<CrmArrangeDto> selectCrmArrangeDto(CrmArrangeQueryParam crmArrangeQueryParam) {
//        PageHelper.startPage(crmArrangeQueryParam.getPageNum(),crmArrangeQueryParam.getPageSize());
        PageInfo<CrmArrangeList> pageInfo = new PageInfo<>(visitPlanMapper.selectCrmArrangeDto(crmArrangeQueryParam));
        PageInfo<CrmArrangeDto> result = PageInfoUtils.pageInfo2PageInfoDTO(pageInfo,CrmArrangeDto.class);
        return result;
    }
}

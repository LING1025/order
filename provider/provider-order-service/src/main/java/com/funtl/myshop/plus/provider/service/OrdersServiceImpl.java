package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.commons.utils.PageInfoUtils;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.*;
import com.funtl.myshop.plus.provider.mapper.OrdersMapper;
import com.funtl.myshop.plus.provider.api.OrdersService;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class OrdersServiceImpl implements OrdersService{

    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public List<MasterList> selectByRoleIds(Long rolesAuto, Long userAuto) {
        return ordersMapper.selectByRoleIds(rolesAuto,userAuto);
    }

    @Override
    public List<MasterList> selectCrossList(Long rolesAuto, Long userAuto) {
        return ordersMapper.selectCrossList(rolesAuto,userAuto);
    }

    @Override
    public OrdersList selectOrdersList(Long ordersAuto) {
        return ordersMapper.selectOrdersList(ordersAuto);
    }

    @Override
    public List<SupplierList> selectSupplierList(Long ordersAuto) {
        return ordersMapper.selectSupplierList(ordersAuto);
    }

    @Override
    public OrdersBackList selectOrdersBackList(Long ordersAuto) {
        return ordersMapper.selectOrdersBackList(ordersAuto);
    }

    @Override
    public MsgDto selectMsg(Long ordersAuto) {
        return ordersMapper.selectMsg(ordersAuto);
    }

    @Override
    public List<LeasebackList> selectLeasebackList(LeasebackQueryParam leasebackQueryParam) {
        return ordersMapper.selectLeasebackList(leasebackQueryParam);
    }

    @Override
    public Leasebacks selectLeasebacks(Long ordersAuto) {
        return ordersMapper.selectLeasebacks(ordersAuto);
    }

    @Override
    public PageInfo<SupplierNamesDto> selectSupplierNames(SupplierQueryParam supplierQueryParam) {
        PageInfo<SupplierNames> pageInfo = new PageInfo<>(ordersMapper.selectSupplierNames(supplierQueryParam));
        PageInfo<SupplierNamesDto> result = PageInfoUtils.pageInfo2PageInfoDTO(pageInfo,SupplierNamesDto.class);
        return result;
    }

    @Override
    public PageInfo<FNamesDto> selectFNamesDto(FNamesQueryParam fNamesQueryParam) {
        PageInfo<FNames> pageInfo = new PageInfo<>(ordersMapper.selectFNamesDto(fNamesQueryParam));
        PageInfo<FNamesDto> result = PageInfoUtils.pageInfo2PageInfoDTO(pageInfo,FNamesDto.class);
        return result;
    }

    @Override
    public List<OrdersPayList> selectOrdersPayList(Long userAuto) {
        return ordersMapper.selectOrdersPayList(userAuto);
    }

}

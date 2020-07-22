package com.funtl.myshop.plus.commons.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;

/**
 * <p>
 * Description: github Pagehelper工具
 * </p>
 *
 */
public class PageInfoUtils {

    public static  <P, D> PageInfo<D> pageInfo2PageInfoDTO(PageInfo<P> pageInfoPO, Class<D> dClass) {
        Page<D> page = new Page<>(pageInfoPO.getPageNum(), pageInfoPO.getPageSize());
        page.setTotal(pageInfoPO.getTotal());
        for (P p : pageInfoPO.getList()) {
            D d = null;
            try {
                d = dClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            BeanUtils.copyProperties(p, d);
            page.add(d);
        }
        return new PageInfo<>(page);
    }

    /**
     * 将PageInfo对象泛型中的Po对象转化为Vo对象
     * @param pageInfoPo PageInfo<Po>对象</>
     * @param <P> Po类型
     * @param <V> Vo类型
     * @return
     */
    public static <P, V> PageInfo<V> PageInfo2PageInfoVo(PageInfo<P> pageInfoPo) {
        // 创建Page对象，实际上是一个ArrayList类型的集合
        Page<V> page = new Page<>(pageInfoPo.getPageNum(), pageInfoPo.getPageSize());
        page.setTotal(pageInfoPo.getTotal());
        return new PageInfo<>(page);
    }

}

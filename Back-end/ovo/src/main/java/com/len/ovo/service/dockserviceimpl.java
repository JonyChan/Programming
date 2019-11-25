package com.len.ovo.service;

import com.len.ovo.domain.dock;
import com.len.ovo.repository.dockrepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//实现service接口
//控制业务逻辑的实现

@Component("userService")

//控制管理逻辑
@Transactional
public class dockserviceimpl implements dockservice {
    private dockrepository dr;

    dockserviceimpl(dockrepository dr) {

        this.dr = dr;
    }

    //创建一个dock
    @Override
    public dock save(dock d) {
        return dr.save(d);
    }


    //四种不同情况的搜索的实现
    @Override
    public List<dock> findByDockpnSort(String dockpn, Sort sort) {
        return dr.findByDockpnSort(dockpn, sort);
    }

    @Override
    public List<dock> findByCompatibilitypnSort(String compatibilitypn, Sort sort) {
        return dr.findByCompatibilitypnSort(compatibilitypn, sort);
    }

    @Override
    public List<dock> findByDockpnOrCompatibilitypn(String dockpn, String compatibilitypn) {
        return dr.findByDockpnOrCompatibilitypn(dockpn, compatibilitypn);
    }

    @Override
    public List<dock> findAll(Sort sort) {
        return dr.findAll(sort);
    }


    @Override
    public int updateDock(String dockpn, String compatibilitypn, String footnoteid, long id) {
        return dr.updateDock(dockpn, compatibilitypn, footnoteid,id);
//        return 0;
    }


    @Override
    public void deleteById(Long id) {
        dr.deleteById(id);
    }

}

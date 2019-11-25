package com.len.ovo.service;

import com.len.ovo.domain.dock;
import org.springframework.data.domain.Sort;

import java.util.List;
//service当中的借口类
public interface dockservice {
    dock save(dock d);
    /****************************read*****************************************/
    List<dock> findByDockpnSort(String dockpn, Sort sort);
    List<dock> findByCompatibilitypnSort(String compatibilitypn, Sort sort);

    List<dock> findByDockpnOrCompatibilitypn(String dockpn, String compatibilitypn);

    List<dock> findAll(Sort sort);
    /*****************************update****************************************/
    int updateDock(String dockpn, String compatibilitypn, String footnoteid, long id);
    /*****************************delete****************************************/

    void deleteById(Long id);

}


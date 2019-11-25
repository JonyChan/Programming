package com.len.ovo.repository;

import com.len.ovo.domain.dock;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//Jpa封装后的dao层
//控制操作数据库的动作
//例如：增删改查

public interface dockrepository extends JpaRepository<dock,Long> {

    @Override
    dock save(dock d);

//四种不同情况的搜索

//  一  search for dockpn（只输入dockpn搜索的情况下）（双开搜索）
    @Query("select d from dock d where d.dockpn like %?1%")
    List<dock> findByDockpnSort(String dockpn, Sort sort);

//  二    search for compatibilitypn（只输入compatibilityPN搜索的情况下）
    @Query("select d from dock d where d.compatibilitypn like %?1%")
    List<dock> findByCompatibilitypnSort(String compatibilitypn, Sort sort);

//  三  serch for dockpn and compatibilitypn（两个字段同时搜索）
    @Query("select d from dock d where d.dockpn = :dockpn or d.compatibilitypn = :compatibilitypn")
    List<dock> findByDockpnOrCompatibilitypn(@Param("dockpn") String dockpn,
                                         @Param("compatibilitypn") String compatibilitypn);

//  四  也可以是两个字段都未输入时候的
    @Override
    List<dock> findAll(Sort sort);

//    根据ID修改数据库中的某些字段
    @Modifying
    @Query("update dock d set d.dockpn = ?1, d.compatibilitypn = ?2, d.footnoteid = ?3 where d.id = ?4")
    int updateDock(String dockpn, String compatibilitypn, String footnoteid, long id);
    /****************************delete*****************************************/
//根据ID删除
    @Modifying
    @Query("delete from dock d where d.id = ?1")
    void deleteById(long id);

}

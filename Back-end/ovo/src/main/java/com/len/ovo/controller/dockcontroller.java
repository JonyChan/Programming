package com.len.ovo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.len.ovo.domain.dock;
import com.len.ovo.service.dockservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

//相当于Servlet层，即MVC中的control层
//实现与前端的交互
//前端直接调用该文件的接口，运行过后，再将结果发到前端去展示。

@RestController
//相当于部署到服务器上，是后面的URL的一部分
@RequestMapping("/dock")

public class dockcontroller {
//    注入
    @Autowired
    private dockservice ds;

//    与前端交互的位置以及POST的方式与前端进行数据信息传递
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Transactional
    @ResponseBody

//    为了取出前端存放在json中的数据
    public JSONObject save(@RequestBody JSONObject jsonParam){
        JSONObject reJson = new JSONObject();
//       从json中独取出来表单信息
        String dockpn = (String) jsonParam.get("dockPn");
        String compatibilitypn = (String) jsonParam.get("compatibilityPn");
        String footnoteid = (String) jsonParam.get("footNoteId");
//        创建一个新的dock对象，并赋值。
        dock d = new dock();
        d.setFootnoteid(footnoteid);
        d.setCompatibilitypn(compatibilitypn);
        d.setDockpn(dockpn);
        ds.save(d);
        System.out.println(d);

        reJson.put("errorCode", 0);
        reJson.put("data", true);
        return reJson;
    }

//这个是三种搜索情况与前端的交互，首先前端需要调用这些接口，去执行后端的代码，然后把执行的结果放到前端去展示。
    /*****************************Read***** ********************************/
    @RequestMapping(value = "/findByDockpnSort/{dockpn}", method = RequestMethod.GET)
    public List<dock> findByDockpnSort(@PathVariable String dockpn) {
        Sort sort = new Sort(Sort.Direction.DESC, "dockpn");
        return ds.findByDockpnSort(dockpn, sort);
    }

    @RequestMapping(value = "/findByCompatibilitypnSort/{compatibilitypn}", method = RequestMethod.GET)
    public List<dock> findByCompatibilitypnSort(@PathVariable String compatibilitypn) {
        Sort sort = new Sort(Sort.Direction.DESC, "dockpn");
        return ds.findByCompatibilitypnSort(compatibilitypn, sort);
    }


    @RequestMapping(value = "/findByDockpnOrCompatibilitypn/{dockpn}/{compatibilitypn}", method = RequestMethod.GET)
    public List<dock> findByDockpnOrCompatibilitypn(@PathVariable String dockpn,
                                                    @PathVariable String compatibilitypn) {
        return ds.findByDockpnOrCompatibilitypn(dockpn, compatibilitypn);
    }

//   第四种搜索情况，也是展示列表
//    前端调用此接口，连接数据库，返回数据库中存储的数据，并展示在前端
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public JSONObject findAll() {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        JSONObject reJson = new JSONObject();
        JSONArray array = new JSONArray();
        List<dock> list = ds.findAll(sort);
        if (list.size() > 0) {
            for (dock dock : list) {
                JSONObject json = new JSONObject();
                json.put("id", dock.getId());
                json.put("dockPn", dock.getDockpn());
                json.put("description", dock.getDockdescription());
                json.put("compatibilityPn", dock.getCompatibilitypn());
                json.put("cpnDescription", dock.getCompatibilitydescription());
                json.put("footNoteId", dock.getFootnoteid());
                json.put("footNoteText", dock.getFootnotetext());
                array.add(json);
            }
        }
        reJson.put("errorCode", 0);
        reJson.put("message", "success");
        reJson.put("data", array);
        return reJson;
    }

//根据ID去修改每一列footnodeid
//    先从json对象获取ID等一系列需要修改的信息
//    然后再执行方法修改
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public JSONObject update(@RequestBody JSONObject jsonParam) {
        JSONObject reJson = new JSONObject();
        String dockpn = (String) jsonParam.get("dockPn");
        String compatibilitypn = (String) jsonParam.get("compatibilityPn");
        String footnoteid = (String) jsonParam.get("footNoteId");
        long id = (Integer) jsonParam.get("id");
        System.out.println(jsonParam.toString());

        ds.updateDock(dockpn, compatibilitypn,footnoteid,id);
        reJson.put("errorCode", 0);
        reJson.put("data", true);
        return reJson;
    }


    @ResponseBody
//    转发方式与前端一致
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    @Transactional
    public JSONObject deleteById(@RequestBody JSONObject jsonParam) {
        JSONObject reJson = new JSONObject();
//        此json返回的是一个含有ID含有符号的字符串
//        分割字符串，提取ID，并逐个删除
        String ids = (String) jsonParam.get("ids");
        String[] a = ids.split(",");
        for (String s : a) {
            int ss = Integer.valueOf(s);
            ds.deleteById((long) ss);
        }
            reJson.put("errorCode", 0);
            reJson.put("data", true);
            return reJson;
    }
}
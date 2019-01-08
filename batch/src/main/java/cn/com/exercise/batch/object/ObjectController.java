package cn.com.exercise.batch.object;

import cn.com.exercise.batch.entity.UserEntity;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("object")
public class ObjectController {

    @Autowired
    private ObjectService objectService;

    @RequestMapping(value = "batchAdd")
    @ResponseBody
    public Integer batchAdd(String userEntity){
        List<UserEntity> list = JSON.parseArray(userEntity,UserEntity.class);
        return objectService.batchAdd(list);
    }

    @RequestMapping(value = "batchUpdateOneVariable")
    @ResponseBody
    public Integer batchUpdateOneVariable(String getStr,String getUser){
        List idList = JSON.parseObject(getStr,List.class);
        UserEntity user = JSON.parseObject(getUser,UserEntity.class);
        return objectService.batchUpdateOneVariable(user,idList);
    }

    @RequestMapping(value = "batchDelete")
    @ResponseBody
    public Integer batchDelete(String idStr){
        List idList = JSON.parseObject(idStr,List.class);
        return objectService.batchDelete(idList);
    }

    @RequestMapping(value = "batchSelect")
    @ResponseBody
    public Object batchSelect(String list, String entity){
        List nameList = JSON.parseObject(list,List.class);
        UserEntity user = JSON.parseObject(entity,UserEntity.class);
        return objectService.batchSelect(user,nameList);
    }

}

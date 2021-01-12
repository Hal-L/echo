package exam_online.controller;

import KnowledgePoints.myInterface.interFalse.exam_online.service.PaperManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PaperManageController {

    @Autowired
    private PaperManageService paperManageService;

    @GetMapping("/paper/{paperId}")
    public Map findPaperById(@PathVariable("paperId")Integer paperId){
        Map map = new HashMap();
        try{
            map = paperManageService.findById(paperId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}

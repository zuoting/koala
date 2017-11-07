package cn.lt.pianke.web;

import cn.lt.pianke.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 刘婷 on 2017/5/8.
 */
@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "messages/{user_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Map getAuthorInfo(@PathVariable("user_id") int user_id) {
        Map map =new HashMap();
        List comments=messageService.getComments(user_id);
        map.put("comments",comments);
        List timelineComments=messageService.getTimelineComments(user_id);
        map.put("timelineComments",timelineComments);
        List letters=messageService.getLetters(user_id);
        map.put("letters",letters);
        List likeTos=messageService.getLikeTo(user_id);
        map.put("likeTos",likeTos);
        List fans=messageService.getFans(user_id);
        map.put("fans",fans);

        return map;
    }
}

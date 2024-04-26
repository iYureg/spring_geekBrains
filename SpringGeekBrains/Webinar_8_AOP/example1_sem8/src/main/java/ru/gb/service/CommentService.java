package ru.gb.service;

import org.springframework.stereotype.Component;
import ru.gb.aspect.ToLog;
import ru.gb.model.Comment;


@Component
public class CommentService {


    @ToLog
    public String publishComment(Comment comment) {
        System.out.println("Опубликован комментарий: " + comment.getText() + " от: " + comment.getAuthor());
        return "SUCCESS";
    }
}

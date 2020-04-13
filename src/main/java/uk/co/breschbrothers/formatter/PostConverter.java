package uk.co.breschbrothers.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import uk.co.breschbrothers.daos.PostDao;
import uk.co.breschbrothers.entity.Post;

@Component
public class PostConverter implements Converter<String, Post> {

    @Autowired
    private PostDao postDao;


    @Override
    public Post convert(String s) {
        return postDao.findById(Integer.parseInt(s));
    }
}

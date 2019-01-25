package com.learn.imagedataservice.repositories;

import com.learn.imagedataservice.entities.Image;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by chillyb on 16/01/19.
 */
public interface ImageRepository extends CrudRepository<Image, Long> {
}

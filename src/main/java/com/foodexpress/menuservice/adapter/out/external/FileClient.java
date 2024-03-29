package com.foodexpress.menuservice.adapter.out.external;

import com.foodexpress.menuservice.domain.File;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient("file-service")
public interface FileClient {

    @PostMapping
    List<File> uploadMenuImages(List<MultipartFile> uploadImages, @RequestParam String menuId);

}

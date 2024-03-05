package com.foodexpress.menuservice.application.port.out;

import com.foodexpress.menuservice.domain.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadMenuImagePort {

    List<File> uploadMenuImage(List<MultipartFile> menuImages, String menuId);

}

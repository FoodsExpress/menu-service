package com.foodexpress.menuservice.adapter.out.external;

import com.foodexpress.menuservice.application.port.out.UploadMenuImagePort;
import com.foodexpress.menuservice.common.ExternalAdapter;
import com.foodexpress.menuservice.domain.File;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@ExternalAdapter
@RequiredArgsConstructor
public class UploadMenuImagePortAdapter implements UploadMenuImagePort {

    private final FileClient fileClient;

    public List<File> uploadMenuImage(List<MultipartFile> menuImages, String menuId) {
        return fileClient.uploadMenuImages(menuImages, menuId);
    }

}

package com.foodexpress.menuservice.application.port.in.file;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class UploadFileCommand {

    private String menuId;
    private List<MultipartFile> uploadFiles;

    public static UploadFileCommand of(List<MultipartFile> menuPhotos, String menuId) {
        UploadFileCommand command = new UploadFileCommand();
        command.menuId = menuId;
        command.uploadFiles = menuPhotos;
        return command;
    }

}

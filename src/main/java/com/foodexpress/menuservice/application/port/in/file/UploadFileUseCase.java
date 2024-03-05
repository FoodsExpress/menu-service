package com.foodexpress.menuservice.application.port.in.file;

import com.foodexpress.menuservice.domain.File;

import java.util.List;

public interface UploadFileUseCase {

    List<File> uploadFile(UploadFileCommand command);

}
